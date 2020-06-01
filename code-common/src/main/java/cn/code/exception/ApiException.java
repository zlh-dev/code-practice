package cn.code.exception;


import cn.code.common.IErrorCode;
import lombok.Getter;

/**
 * 自定义API异常
 *
 * @author zlh-dev
 * @date 2020/05/23 14:36
 */
@Getter
public class ApiException extends RuntimeException {
    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}