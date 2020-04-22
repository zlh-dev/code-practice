package cn.code.commons.common;

import cn.code.commons.constant.ResultEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 统一结果类
 *
 * @author zlh-dev
 * @date 2020/04/19 13:25
 */
@Getter
@Setter
@Builder
public class Result {

    /**
     * 返回结果
     */
    private Boolean success;

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 通用返回成功
     */
    public static Result success() {
        return Result.builder()
                .code(ResultEnum.SUCCESS.getCode())
                .message(ResultEnum.SUCCESS.getMessage())
                .build();
    }

    /**
     * 通用返回失败，未知错误
     */
    public static Result error() {
        return Result.builder()
                .code(ResultEnum.UNKNOWN_ERROR.getCode())
                .message(ResultEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }

    /**
     * 设置结果，形参为结果枚举
     */
    public static Result result(ResultEnum result) {
        return Result.builder()
                .code(result.getCode())
                .message(result.getMessage())
                .build();
    }

}