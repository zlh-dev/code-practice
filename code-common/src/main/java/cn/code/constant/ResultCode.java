package cn.code.constant;

import cn.code.common.IErrorCode;
import lombok.AllArgsConstructor;

/**
 * 枚举了一些常用API操作码
 *
 * @author zlh-dev
 * @date 2020/05/23 14:35
 */
@AllArgsConstructor
public enum ResultCode implements IErrorCode {
    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 失败
     */
    FAILED(500, "操作失败"),
    /**
     * 验证失败
     */
    VALIDATE_FAILED(404, "参数检验失败"),
    /**
     * 未经授权
     */
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    /**
     * 禁止
     */
    FORBIDDEN(403, "没有相关权限");

    private final long code;
    private final String message;

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}