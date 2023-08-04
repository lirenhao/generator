package ${package.Controller};

import ${package.Service}.${table.serviceName};
import cn.hutool.core.util.StrUtil;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

/**
 * ${table.comment} 计划任务
 *
 * @Auther ${author}
 * @Date ${date}
 */
@Component
@Slf4j
public class ${table.controllerName} {

    private final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Resource
    private ${table.serviceName} ${entity?uncap_first?replace("Entity", "")}Service;

    /**
     * 处理${table.comment}的数据
     */
    @XxlJob("handle${entity}Data")
    public void handle${entity}Data(){
        String param = XxlJobHelper.getJobParam();
        LocalDate startDate = LocalDate.now().minusDays(1);
        LocalDate endDate = LocalDate.now().minusDays(1);
        if (StrUtil.isNotEmpty(param)) {
            String[] params = param.split(":");
            startDate = LocalDate.parse(params[0], df);
            endDate = LocalDate.parse(params[1], df);
        }
        if (endDate.compareTo(startDate) < 0) {
            log.warn("handle${entity}Data开始日期[{}]不能大于结束日期[{}]", startDate, endDate);
            return;
        }
        log.info("handle${entity}Data({}, {})-start", startDate, endDate);
        int num = (int) ChronoUnit.DAYS.between(startDate, endDate);
        LocalDate finalStartDate = startDate;
        IntStream.range(0, num + 1).forEach(i -> {
            LocalDate bizDate = finalStartDate.plusDays(i);
            ${entity?uncap_first?replace("Entity", "")}Service.handleData(bizDate);
        });
        log.info("handle${entity}Data({}, {})-end", startDate, endDate);
    }
}
