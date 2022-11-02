package ${package.Entity};

<#list table.importPackages as pkg>
import ${pkg};
</#list>
import com.kejian.framework.energy.model.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ${table.comment!?replace("表", "")}
 *
 * @author ${author}
 * @date ${date}
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("${schemaName}${table.name}")
@ApiModel("${table.comment!?replace("表", "")}")
public class ${entity} extends BaseEntity {
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>

    <#if field.comment!?length gt 0>
    /**
    * ${field.comment}
    */
    @ApiModelProperty("${field.comment}")
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#list>
<#------------  END 字段循环遍历  ---------->
}
