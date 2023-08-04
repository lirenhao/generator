package ${package.Mapper};

import ${package.Entity}.${entity};
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * ${table.comment} Dao 接口
 *
 * @Auther ${author}
 * @Date ${date}
 */
<#if mapperAnnotationClass??>
@${mapperAnnotationClass.simpleName}
</#if>
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends JpaRepository<${entity}, String>, JpaSpecificationExecutor<${entity}> {

    @Transactional
    void deleteByBizDate(LocalDate bizDate);
}
</#if>
