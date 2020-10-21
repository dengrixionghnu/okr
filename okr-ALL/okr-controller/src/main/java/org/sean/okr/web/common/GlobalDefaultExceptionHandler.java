package org.sean.okr.web.common;

import com.alibaba.cola.dto.Response;
import com.google.gson.Gson;
import org.sean.okr.infrastructure.common.exception.ArgumentInvalidResult;
import org.sean.okr.infrastructure.common.exception.BusinessException;
import org.sean.okr.infrastructure.common.exception.BusinessExceptionCode;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sean
 * @Description
 * @create 2020-10-21 21:11
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    public static final Gson GSON = new Gson();
    /**
     * 默认服务器异常的处理
     *
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Response defaultErrorHandler(HttpServletRequest request, Exception exception) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrCode(BusinessExceptionCode.SERVICE_ERROR.getCode());
        response.setErrMessage(BusinessExceptionCode.SERVICE_ERROR.getMessage());
        return response;
    }

    /**
     * 业务异常统一处理
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    public Response businessErrorHandler(HttpServletRequest request, BusinessException exception) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrCode(exception.getCode());
        response.setErrMessage(exception.getMessage());
        return response;
    }

    /**
     * 参数校验异常处理
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Response MethodArgumentNotValidHandler(HttpServletRequest request,
                                                  MethodArgumentNotValidException exception) {

        //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
        List<ArgumentInvalidResult> result = new ArrayList<>();
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            ArgumentInvalidResult invalidArgument = new ArgumentInvalidResult();
            invalidArgument.setMessage(error.getDefaultMessage());
            invalidArgument.setField(error.getField());
            result.add(invalidArgument);
        }

        Response response = new Response();
        response.setSuccess(false);
        response.setErrCode(BusinessExceptionCode.METHOD_ARGUMENT_NOT_VALID.getCode());
        response.setErrMessage(GSON.toJson(result));
        return response;
    }


    /**
     * 缺少请求参数异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Response handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrCode(BusinessExceptionCode.BAD_REQUEST.getCode());
        response.setErrMessage(e.getMessage());
        return response;
    }


    /**
     * 参数解析失败异常
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrCode(BusinessExceptionCode.BAD_REQUEST.getCode());
        response.setErrMessage(e.getMessage());
        return response;
    }


    /**
     * 参数绑定异常
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public Response handleBindException(BindException e) {

        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);
        Response response = new Response();
        response.setSuccess(false);
        response.setErrCode(BusinessExceptionCode.BAD_REQUEST.getCode());
        response.setErrMessage(message);
        return response;
    }



    /**
     * 405 - Method Not Allowed
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrCode(BusinessExceptionCode.METHOD_NOT_ALLOWED.getCode());
        response.setErrMessage(BusinessExceptionCode.METHOD_NOT_ALLOWED.getMessage());
        return response;
    }

}
