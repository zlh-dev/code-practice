package cn.code.commons.constant;

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
    SUCCESS(20000, "成功"),
    /**
     * 未知的错误
     */
    UNKNOWN_ERROR(20001, "未知错误"),
    /**
     * 参数错误
     */
    PARAM_ERROR(20002, "参数错误");

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