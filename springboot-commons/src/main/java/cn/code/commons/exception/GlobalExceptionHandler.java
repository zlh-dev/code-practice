package cn.code.commons.exception;

import cn.code.commons.common.Result;
import cn.code.commons.constant.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

/**
 * 全局异常处理程序
 *
 * @author zlh-dev
 * @date 2020/04/19 13:40
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 通用异常处理方法
     *
     * @param e e
     * @return {@link Result}
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        log.error(e.getMessage());
        // 通用异常结果
        return Result.error();
    }

    /**
     * 指定异常处理方法
     **/
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Result error(NullPointerException e) {
        log.error(e.getMessage());
        return Result.builder()
                .code(ResultEnum.PARAM_ERROR.getCode())
                .message("空指针异常")
                .build();
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public Result error(IndexOutOfBoundsException e) {
        log.error(e.getMessage());
        return Result.builder()
                .code(ResultEnum.PARAM_ERROR.getCode())
                .message("http请求异常")
                .build();
    }

    /**
     * -------- 自定义定异常处理方法 --------
     **/
    @ExceptionHandler(CustomizeException.class)
    @ResponseBody
    public Result error(CustomizeException e) {
        log.error(e.getMessage());
        return Result.builder()
                .code(500)
                .message(e.getMessage())
                .build();
    }
}