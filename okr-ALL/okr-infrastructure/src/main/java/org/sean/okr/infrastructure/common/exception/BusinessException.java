package org.sean.okr.infrastructure.common.exception;

/**
 * @author sean
 * @Description 业务异常
 * @create 2020-10-21 20:56
 */
public class BusinessException extends RuntimeException{
    private String code;
    private String message;

    public BusinessException(ErrorMessage error) {
        this.code = error.getCode();
        this.message = error.getMessage();
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
