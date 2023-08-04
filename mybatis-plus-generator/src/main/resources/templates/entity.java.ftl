package ${package.Entity};

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ${table.comment}
 *
 * @Auther ${author}
 * @Date ${date}
 */
@Data
@Entity
@Table(name = "${schemaName}${table.name}")
public class ${entity} {
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>

    <#if field.comment!?length gt 0>
    /**
    * ${field.comment}
    */
    </#if>
    <#if field.propertyName == "id">
    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid.hex")
    <#else>
    @Column(name = "${field.name}")
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#list>
<#------------  END 字段循环遍历  ---------->
}
