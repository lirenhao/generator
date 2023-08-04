package ${package.Service};

import java.time.LocalDate;

/**
 * ${table.comment} 数据处理
 *
 * @Auther ${author}
 * @Date ${date}
 */
public interface ${table.serviceName} {

    /**
    * 处理业务日期的数据
    *
    * @param bizDate 日期
    */
    void handleData(LocalDate bizDate);
}
