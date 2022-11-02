package ${package.Mapper};

import ${superMapperClassPackage};
import ${package.Entity}.${entity};
<#if mapperAnnotationClass??>
import ${mapperAnnotationClass.name};
</#if>

/**
 * ${table.comment!?replace("表", "")} Mapper 接口
 *
 * @author ${author}
 * @date ${date}
 */
<#if mapperAnnotationClass??>
@${mapperAnnotationClass.simpleName}
</#if>
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

}
</#if>
