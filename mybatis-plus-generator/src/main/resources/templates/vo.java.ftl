package ${package.VO};

<#list table.importPackages as pkg>
import ${pkg};
</#list>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ${table.comment!?replace("表", "")}VO对象
 *
 * @author ${author}
 * @date ${date}
 */
@Data
@ApiModel("${table.comment!?replace("表", "")}VO对象")
public class ${entity?replace("Entity", "")}VO {
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
