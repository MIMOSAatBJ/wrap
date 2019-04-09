package com.billions.framework.aspect;

import com.billions.framework.common.base.Cause;
import com.billions.framework.common.base.Module;
import com.billions.framework.common.code.RespObject;
import com.billions.framework.common.exception.GlobalException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResponseWrapper {

    private final Logger logger = LoggerFactory.getLogger(ResponseWrapper.class);

    @Around("execution(* com.billions.api.*.*.*(..)) && !@annotation(com.billions.framework.annotion.EscapeWrapper)")
    protected Object wrapper(ProceedingJoinPoint joinPoint) {
        RespObject br = null;
        try {
            Object data = joinPoint.proceed();
            br = new RespObject(RespObject.SUCCESS_CODE, RespObject.SUCCESS_MSG, data);
        } catch (Throwable e) {
            logger.error("exception when wrapper data:{}", e.getMessage());
            throw new GlobalException(Module.admin, Cause.unknown, e);
        }
        return br;
    }

}
