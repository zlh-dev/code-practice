package cn.code.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
@TableName("file_managed")
@ApiModel(value = "文件管理类")
public class FileInfo {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 文件名
     */
    @ApiModelProperty(value = "文件名")
    @TableField(value = "name", insertStrategy = FieldStrategy.NOT_EMPTY)
    private String name;

    /**
     * 文件类型
     */
    @ApiModelProperty(value = "文件类型")
    @TableField(value = "type", insertStrategy = FieldStrategy.NOT_EMPTY)
    private String type;

    /**
     * 文件路径
     */
    @ApiModelProperty(value = "文件路径")
    @TableField(value = "path", insertStrategy = FieldStrategy.NOT_EMPTY)
    private String path;

    /**
     * 文件大小
     */
    @ApiModelProperty(value = "文件大小")
    @TableField(value = "size", numericScale = "4")
    private Double size;

    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期")
    @TableField(value = "creation_date")
    private LocalDateTime creationDate;

    /**
     * 修改日期
     */
    @ApiModelProperty(value = "修改日期")
    @TableField(value = "modified_date")
    private LocalDateTime modifiedDate;

    /**
     * 文件拥有者
     */
    @ApiModelProperty(value = "文件拥有者")
    @TableField(value = "owner", insertStrategy = FieldStrategy.NOT_EMPTY)
    private String owner;

    /**
     * 删除标识
     */
    @ApiModelProperty(value = "删除标识")
    @TableLogic(value = "false", delval = "true")
    private Boolean deleted;


}

