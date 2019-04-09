package com.billions.framework.annotion;

import com.billions.framework.ext.Expression;

import java.lang.annotation.*;

/**
 * 验证器
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Valid {
    /**
     * 需要验证的字段
     *
     * @return
     */
    String field();

    /**
     * 验证正则的key
     *
     * @return
     */
    Expression[] regex();
}
