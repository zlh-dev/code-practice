package cn.code.common;

import cn.code.constant.ResultEnum;
import lombok.Builder;
import lombok.Data;

/**
 * 统一结果类
 *
 * @author zlh-dev
 * @date 2020/04/19 13:25
 */
@Data
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
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 通用返回成功
     */
    public static Result success() {
        return Result.builder()
                .success(true)
                .code(ResultEnum.SUCCESS.getCode())
                .msg(ResultEnum.SUCCESS.getMessage())
                .build();
    }

    /**
     * 自定义成功信息
     *
     * @param msg 消息
     * @return {@link Result}
     */
    public static Result success(String msg) {
        return Result.builder()
                .success(true)
                .code(ResultEnum.SUCCESS.getCode())
                .msg(msg)
                .build();
    }

    /**
     * 自定义成功携带数据
     *
     * @param data 数据
     * @return {@link Result}
     */
    public static Result success(Object data) {
        return Result.builder()
                .success(true)
                .code(ResultEnum.SUCCESS.getCode())
                .msg(ResultEnum.SUCCESS.getMessage())
                .data(data)
                .build();
    }


    /**
     * 自定义成功信息和携带数据
     *
     * @param msg  消息
     * @param data 数据
     * @return {@link Result}
     */
    public static Result success(String msg, Object data) {
        return Result.builder()
                .success(true)
                .code(ResultEnum.SUCCESS.getCode())
                .msg(msg)
                .data(data)
                .build();
    }

    /**
     * 通用返回失败，未知错误
     */
    public static Result fail() {
        return Result.builder()
                .success(false)
                .code(ResultEnum.UNKNOWN_ERROR.getCode())
                .msg(ResultEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }

    /**
     * 自定义失败信息
     *
     * @param msg 消息
     * @return {@link Result}
     */
    public static Result fail(String msg) {
        return Result.builder()
                .success(false)
                .code(ResultEnum.UNKNOWN_ERROR.getCode())
                .msg(msg)
                .build();
    }

    /**
     * 自定义成功携带数据
     *
     * @param data 数据
     * @return {@link Result}
     */
    public static Result fail(Object data) {
        return Result.builder()
                .success(false)
                .code(ResultEnum.UNKNOWN_ERROR.getCode())
                .msg(ResultEnum.UNKNOWN_ERROR.getMessage())
                .data(data)
                .build();
    }

    /**
     * 自定义失败信息和携带数据
     *
     * @param msg  消息
     * @param data 数据
     * @return {@link Result}
     */
    public static Result fail(String msg, Object data) {
        return Result.builder()
                .success(false)
                .code(ResultEnum.UNKNOWN_ERROR.getCode())
                .msg(msg)
                .data(data)
                .build();
    }

}