package ${package.ServiceImpl};

import ${package.Mapper}.${table.mapperName};
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

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
        return null;
    }
}
