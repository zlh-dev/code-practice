package cn.code.constant;

import lombok.Getter;

/**
 * 结果类枚举
 *
 * @author zlh-dev
 * @date 2020/04/19 13:21
 */

@Getter
public enum ResultEnum {
    /**
     * 成功
     */
    SUCCESS(200, "success"),

    /**
     * 请求异常
     */
    REQUEST_ERROR(400, "request_error"),

    /**
     * 未知的错误
     */
    UNKNOWN_ERROR(200, "unknown_error");

    /**
     * 响应状态码
     */
    private final Integer code;

    /**
     * 响应信息
     */
    private final String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}