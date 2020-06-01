package cn.code.common;

/**
 * 封装API的错误码
 *
 * @author zlh-dev
 * @date 2020/05/23 14:33
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}