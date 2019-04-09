package com.billions.framework.annotion;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Validators {
    Valid[] value() default {};
}
