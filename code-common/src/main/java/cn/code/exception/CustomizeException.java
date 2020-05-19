package cn.code.exception;

import cn.code.constant.ResultEnum;

/**
 * 自定义异常
 *
 * @author zlh-dev
 * @date 2020/04/19 13:43
 */
public class CustomizeException extends RuntimeException {

    public CustomizeException(String message) {
        super(message);
    }

    public CustomizeException(ResultEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
    }

    @Override
    public String toString() {
        return "customizeException{" + "message=" + this.getMessage() + '}';
    }
}