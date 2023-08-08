package ${package.ServiceImpl};

import ${package.Mapper}.${table.mapperName};
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;
import org.springframework.data.mongodb.core.aggregation.ConvertOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * ${table.comment} 数据处理实现类
 *
 * @Auther ${author}
 * @Date ${date}
 */
@Service
public class ${table.serviceImplName} implements ${table.serviceName} {

    @Resource
    private MongoTemplate mongoTemplate;
    @Resource
    private ${table.mapperName} ${entity?uncap_first?replace("Entity", "")}Dao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void handleData(LocalDate bizDate) {
        ${entity?uncap_first?replace("Entity", "")}Dao.deleteByBizDate(bizDate);
        List<${entity}> list = get${entity}s(bizDate);
        ${entity?uncap_first?replace("Entity", "")}Dao.saveAll(list);
    }

    private List<${entity}> get${entity}s(LocalDate bizDate) {
        Criteria criteria = Criteria.where("start_time")
                .gte(LocalDateTime.of(bizDate, LocalTime.of(0, 0, 0)).plusHours(8))
                .lt(LocalDateTime.of(bizDate.plusDays(1), LocalTime.of(0, 0, 0)).plusHours(8));
        // 构建聚合
        Aggregation aggregation = newAggregation(
                match(criteria),
                project().and("start_time").dateAsFormattedString("%Y-%m-%d").as("biz_date")
                    .and("app_id").as("app_id")
                    .and("device_id").as("device_id")
                    .and("").as(""),
                group("app_id", "biz_date", "device_id", "").count().as("total_count"),
                project("app_id", "biz_date", "device_id", "").andExclude("_id")
        );
        // 执行聚合操作
        AggregationResults<Document> results = mongoTemplate.aggregate(aggregation, "flow_tracking", Document.class);
        List<Document> result = results.getMappedResults();
        return result.stream()
                .map(item -> {
                    ${entity} entity = new ${entity}();
                    <#list table.fields as field>
                    <#if !field.keyFlag && field.name != "create_time" && field.name != "biz_date">
                    entity.set${field.propertyName?cap_first}(item.get${field.propertyType}("${field.name}"));
                    </#if>
                    </#list>
                    entity.setBizDate(bizDate);
                    entity.setCreateTime(LocalDateTime.now());
                    return entity;
                }).collect(Collectors.toList());
    }
}
