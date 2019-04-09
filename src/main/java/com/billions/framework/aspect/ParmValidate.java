package com.billions.framework.aspect;

import com.billions.framework.annotion.Valid;
import com.billions.framework.annotion.Validators;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class ParmValidate {

    private final Logger logger = LoggerFactory.getLogger(ParmValidate.class);

    @Before("execution(* com.billions.api.*.*.*(..)) && @annotation(com.billions.framework.annotion.Validators)")
    protected Object wrapper(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        method.getParameters();
        Valid valid = method.getDeclaredAnnotation(Valid.class);
        if (valid != null) {

        }
        Validators validators = method.getDeclaredAnnotation(Validators.class);
        if (validators != null && validators.value().length != 0) {

        }
        return joinPoint;
    }

}
