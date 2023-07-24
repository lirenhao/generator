package ${package.Controller};

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kejian.zhiliao.evaluate.backend.common.data.Rest;
import com.kejian.zhiliao.evaluate.backend.common.data.RestBody;
import com.kejian.zhiliao.evaluate.backend.manager.controller.base.BaseController;
import ${package.DTO}.${entity?replace("Entity", "")}DeleteDTO;
import ${package.DTO}.${entity?replace("Entity", "")}InsertDTO;
import ${package.DTO}.${entity?replace("Entity", "")}QueryDTO;
import ${package.DTO}.${entity?replace("Entity", "")}UpdateDTO;
import ${package.VO}.${entity?replace("Entity", "")}VO;
import ${package.Service}.${table.serviceName};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * ${table.comment!?replace("表", "")} 前端控制器
 *
 * @author ${author}
 * @date ${date}
 */
@Api(tags = "${table.comment!?replace("表", "")}")
@RestController
@RequestMapping("/admin/${entity?replace("Entity", "")?replace("([a-z])([A-Z]+)", "$1/$2", "r")?lower_case}")
public class ${table.controllerName} extends BaseController {

    @Resource
    private ${table.serviceName} ${entity?uncap_first?replace("Entity", "")}Service;

    @ApiOperation("分页列表")
    @GetMapping("/page")
    public Rest<IPage<${entity?replace("Entity", "")}VO>> getPage(@Valid ${entity?replace("Entity", "")}QueryDTO record) {
        return RestBody.okData(${entity?uncap_first?replace("Entity", "")}Service.getPage(record, getPage()));
    }

    @ApiOperation("详情")
    @GetMapping("/info")
    public Rest<${entity?replace("Entity", "")}VO> getInfo(@ApiParam(value = "ID", required = true) String id) {
        return RestBody.okData(${entity?uncap_first?replace("Entity", "")}Service.getInfo(id));
    }

    @ApiOperation("新增")
    @PostMapping("/add")
    public Rest<String> add(@Valid @RequestBody ${entity?replace("Entity", "")}InsertDTO record) {
        ${entity?uncap_first?replace("Entity", "")}Service.add(record);
        return RestBody.okData("创建成功");
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    public Rest<String> update(@Valid @RequestBody ${entity?replace("Entity", "")}UpdateDTO record) {
        ${entity?uncap_first?replace("Entity", "")}Service.updateById(record);
        return RestBody.okData("修改成功");
    }

    @ApiOperation("删除")
    @PostMapping("/delete")
    public Rest<String> delete(@Valid @RequestBody ${entity?replace("Entity", "")}DeleteDTO record) {
        ${entity?uncap_first?replace("Entity", "")}Service.deleteById(record);
        return RestBody.okData("删除成功");
    }
}
