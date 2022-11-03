package ${package.DTO};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ${table.comment!?replace("表", "")}删除对象
 *
 * @author ${author}
 * @date ${date}
 */
@Data
@ApiModel("${table.comment!?replace("表", "")}删除对象")
public class ${entity?replace("Entity", "")}DeleteDTO {

    @NotBlank(message = "${table.comment!?replace("表", "")}ID不能为空")
    @ApiModelProperty(value = "${table.comment!?replace("表", "")}ID")
    private String id;
}
