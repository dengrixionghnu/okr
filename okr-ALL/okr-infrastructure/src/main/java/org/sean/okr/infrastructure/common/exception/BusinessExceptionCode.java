package org.sean.okr.infrastructure.common.exception;

/**
 * @author sean
 * @Description
 * @create 2020-10-21 21:02
 */
public enum BusinessExceptionCode implements ErrorMessage {
    SERVICE_ERROR("100001","服务器异常"),
    PERMISSION_DENIED("1000002","权限被拒绝"),
    NOT_EXIST("100003","记录不存在"),
    METHOD_ARGUMENT_NOT_VALID("100004","参数校验异常"),
    BAD_REQUEST("100005","请求参数异常"),
    METHOD_NOT_ALLOWED("100006","不支持当前方法")




    ;


    private String code;
    private String message;

    BusinessExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
