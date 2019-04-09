package com.billions.framework.handle;


import com.billions.framework.common.base.Cause;
import com.billions.framework.common.base.Module;
import com.billions.framework.common.code.RespObject;
import com.billions.framework.common.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Value("${spring.application.name}")
    private String module;

    @ExceptionHandler(Exception.class)
    public Object handle(HttpServletRequest request,
                         Exception exception) {
        LOGGER.error("exception {} url [{}]", exception.getClass(), request.getRequestURL());
        if (LOGGER.isDebugEnabled()) {
            request.getParameterMap().forEach((k, v) ->
                    LOGGER.debug("k->{},v->{}", k, v[0])
            );
        }
        GlobalException ge;
        if (!(exception instanceof GlobalException)) {
            LOGGER.error("exception {}:{}", exception.getMessage(), exception.getStackTrace());
            ge = new GlobalException(Module.which(module), Cause.unknown, exception);
        } else {
            ge = (GlobalException) exception;
        }
        return new RespObject(ge);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Object handle(MethodArgumentNotValidException e) {
        log.error("系统异常 | 参数拦截器异常:{}", e);
        String defaultMess = "系统异常";
        List<ObjectError> errList = e.getBindingResult().getAllErrors();
        if(!errList.isEmpty()){
            defaultMess = errList.get(0).getDefaultMessage();
        }
        return new RespObject((Module.which(module).getSn() * GlobalException.CARRY) +  Cause.params_fail.getCode(),defaultMess);
    }
}
