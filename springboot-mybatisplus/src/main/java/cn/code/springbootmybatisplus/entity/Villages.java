package cn.code.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 村级（村委会居委会）
 *
 * @author 张灵辉
 * @date 2020/03/27 23:28
 */
@Data
@Builder
@Accessors(chain = true)
@ApiModel(value = "Villages对象", description = "村级（村委会居委会）")
public class Villages {

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
     * 乡级区划代码
     */
    @TableField
    @ApiModelProperty(value = "乡级区划代码")
    private Long streetCode;

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
