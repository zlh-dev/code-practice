package cn.code.exception;

import cn.code.common.Result;
import cn.code.constant.ResultEnum;
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
        return Result.fail();
    }

    /**
     * 指定异常处理方法
     **/
    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public Result error(IndexOutOfBoundsException e) {
        log.error(e.getMessage());
        return Result.builder()
                .code(ResultEnum.REQUEST_ERROR.getCode())
                .msg("http请求异常")
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
                .msg(e.getMessage())
                .build();
    }
}