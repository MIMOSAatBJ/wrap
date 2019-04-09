package com.billions.framework.annotion;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 该注解用于controller方法，使其返回按自定义数据返回
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface EscapeWrapper {
}
