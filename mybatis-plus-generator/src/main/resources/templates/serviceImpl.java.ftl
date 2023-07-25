package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${package.DTO}.${entity?replace("Entity", "")}DeleteDTO;
import ${package.DTO}.${entity?replace("Entity", "")}InsertDTO;
import ${package.DTO}.${entity?replace("Entity", "")}QueryDTO;
import ${package.DTO}.${entity?replace("Entity", "")}UpdateDTO;
import ${package.VO}.${entity?replace("Entity", "")}VO;
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kejian.zhiliao.evaluate.backend.common.enumeration.DeletedEnum;

/**
 * ${table.comment!?replace("表", "")} 服务实现类
 *
 * @author ${author}
 * @date ${date}
 */
@Service
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Override
    public IPage<${entity?replace("Entity", "")}VO> getPage(${entity?replace("Entity", "")}QueryDTO query, Page<${entity}> page) {
        return this.page(page, new LambdaQueryWrapper<${entity}>()
                .eq(${entity}::getDeleted, DeletedEnum.FALSE.value())
                .eq(StrUtil.isNotBlank(query.getId()), ${entity}::getId, query.getId())
                .like(StrUtil.isNotBlank(query.getName()), ${entity}::getName, query.getName())
                .orderByDesc(${entity}::getSort)
                .orderByDesc(${entity}::getCreateTime)
        ).convert(data -> {
        ${entity?replace("Entity", "")}VO result = new ${entity?replace("Entity", "")}VO();
            BeanUtil.copyProperties(data, result);
            return result;
        });
    }

    @Override
    public ${entity?replace("Entity", "")}VO getInfo(String id) {
        ${entity} entity = this.getOne(new LambdaQueryWrapper<${entity}>()
                .eq(${entity}::getId, id)
                .eq(${entity}::getDeleted, DeletedEnum.FALSE.value())
                .last("limit 1"));
        if (ObjectUtil.isNull(entity)) {
            return null;
        }
        ${entity?replace("Entity", "")}VO result = new ${entity?replace("Entity", "")}VO();
        BeanUtil.copyProperties(entity, result);
        return result;
    }

    @Override
    public void add(${entity?replace("Entity", "")}InsertDTO record) {
        ${entity} entity = new ${entity}();
        BeanUtil.copyProperties(record, entity);
        this.save(entity);
    }

    @Override
    public void updateById(${entity?replace("Entity", "")}UpdateDTO record) {
        ${entity} entity = new ${entity}();
        BeanUtil.copyProperties(record, entity);
        this.updateById(entity);
    }

    @Override
    public void deleteById(${entity?replace("Entity", "")}DeleteDTO record) {
        this.removeById(record.getId());
    }
}
