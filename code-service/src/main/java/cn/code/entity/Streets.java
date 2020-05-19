package cn.code.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 乡级（乡镇街道）
 *
 * @author zlh-dev
 * @date 2020/03/27 23:27
 */
@Data
@Builder
@Accessors(chain = true)
@ApiModel(value = "Streets对象", description = "乡级（乡镇街道）")
public class Streets {

    /**
     * 统计用区划代码
     */
    @TableId
    @ApiModelProperty(value = "统计用区划代码")
    private Long code;

    /**
     * 名称
     */
    @TableField
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 县级区划代码
     */
    @TableField
    @ApiModelProperty(value = "县级区划代码")
    private Long areaCode;

    /**
     * 地级区划代码
     */
    @TableField
    @ApiModelProperty(value = "地级区划代码")
    private Long cityCode;

    /**
     * 省级区划代码
     */
    @TableField
    @ApiModelProperty(value = "省级区划代码")
    private Long provinceCode;

    /**
     * 删除标记
     */
    @TableLogic
    @ApiModelProperty(value = "删除标记")
    private Boolean deleted;


}
