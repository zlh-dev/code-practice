package cn.code.exception;

import cn.code.common.IErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 *
 * @author zlh-dev
 * @date 2020/05/23 14:36
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}