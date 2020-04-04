package cn.code.springbootmybatisplus.common.constant;

/**
 * API通用返回码
 *
 * @author 张灵辉
 * @date 2020/04/03 23:31
 */
public enum ApiErrorCode {

    /**
     * 成功
     */
    SUCCESS(200, "成功"),

    /**
     * 请求异常
     */
    REQUEST_ERROR(400, "请求异常"),

    /**
     * 服务器内部错误
     */
    ERROR(500, "服务器内部错误");

    private int code;
    private String value;

    ApiErrorCode(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public static Integer getCode(Integer code) {
        ApiErrorCode[] apiErrorCodes = values();
        for (ApiErrorCode apiErrorCode : apiErrorCodes) {
            if (apiErrorCode.code().equals(code)) {
                return apiErrorCode.code();
            }
        }
        return null;
    }

    public static String getValue(Integer code) {
        ApiErrorCode[] apiErrorCodes = values();
        for (ApiErrorCode apiErrorCode : apiErrorCodes) {
            if (apiErrorCode.code().equals(code)) {
                return apiErrorCode.value();
            }
        }
        return null;
    }

    public Integer code() {
        return code;
    }

    public String value() {
        return value;
    }
}
