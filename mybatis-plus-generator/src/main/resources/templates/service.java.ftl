package ${package.Service};

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import ${param.dtoPath}.${entity?replace("Entity", "")}DeleteDTO;
import ${param.dtoPath}.${entity?replace("Entity", "")}InsertDTO;
import ${param.dtoPath}.${entity?replace("Entity", "")}QueryDTO;
import ${param.dtoPath}.${entity?replace("Entity", "")}UpdateDTO;
import ${param.voPath}.${entity?replace("Entity", "")}VO;

/**
 * ${table.comment!?replace("表", "")} 服务类
 *
 * @author ${author}
 * @data ${date}
 */
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
    * 获取分页列表
    *
    * @param query 查询参数
    * @param page 分页参数
    * @return Page<${entity?replace("Entity", "")}VO>
    **/
    IPage<${entity?replace("Entity", "")}VO> getPage(${entity?replace("Entity", "")}QueryDTO query, Page<${entity}> page);

    /**
    * 获取详情
    *
    * @param id ID
    * @return ${entity?replace("Entity", "")}VO
    **/
    ${entity?replace("Entity", "")}VO getInfo(String id);

    /**
    * 新建
    *
    * @param record 新建参数
    **/
    void add(${entity?replace("Entity", "")}InsertDTO record);

    /**
    * 更新
    *
    * @param record 修改参数
    **/
    void updateById(${entity?replace("Entity", "")}UpdateDTO record);

    /**
    * 删除
    *
    * @param record 删除参数
    **/
    void deleteById(${entity?replace("Entity", "")}DeleteDTO record);
}
