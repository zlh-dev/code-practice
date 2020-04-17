package cn.code.mybatisplus.common;

import cn.code.mybatisplus.common.constant.ApiErrorCode;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 返回结果集封装
 *
 * @author zlh-dev
 * @date 2020/04/03 23:25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "返回结果集封装")
public class Result implements Serializable {

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 携带数据
     */
    private Object data;

    /**
     * 默认成功信息
     *
     * @return {@link Result}
     */
    public static Result success() {
        return Result.builder()
                .code(ApiErrorCode.SUCCESS.code())
                .message(ApiErrorCode.SUCCESS.value())
                .build();
    }

    /**
     * 自定义成功信息
     *
     * @param message 消息
     * @return {@link Result}
     */
    public static Result success(String message) {
        return Result.builder()
                .code(ApiErrorCode.SUCCESS.code())
                .message(message)
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
                .code(ApiErrorCode.SUCCESS.code())
                .message(ApiErrorCode.SUCCESS.value())
                .data(data)
                .build();
    }

    /**
     * 自定义成功信息和携带数据
     *
     * @param message 消息
     * @param data    数据
     * @return {@link Result}
     */
    public static Result success(String message, Object data) {
        return Result.builder()
                .code(ApiErrorCode.SUCCESS.code())
                .message(message)
                .data(data)
                .build();
    }

    /**
     * 默认失败信息
     *
     * @return {@link Result}
     */
    public static Result fail() {
        return Result.builder()
                .code(ApiErrorCode.ERROR.code())
                .message(ApiErrorCode.ERROR.value())
                .build();
    }

    /**
     * 自定义失败信息
     *
     * @param message 消息
     * @return {@link Result}
     */
    public static Result fail(String message) {
        return Result.builder()
                .code(ApiErrorCode.ERROR.code())
                .message(message)
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
                .code(ApiErrorCode.ERROR.code())
                .message(ApiErrorCode.ERROR.value())
                .data(data)
                .build();
    }

    /**
     * 自定义失败信息和携带数据
     *
     * @param message 消息
     * @param data    数据
     * @return {@link Result}
     */
    public static Result fail(String message, Object data) {
        return Result.builder()
                .code(ApiErrorCode.ERROR.code())
                .message(message)
                .data(data)
                .build();
    }

}