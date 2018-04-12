package com.chaychan.adapter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ChayChan
 * @description: TODO
 * @date 2018/3/21  10:48
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface ItemProviderTag {
    int viewType();
    int layout();
}
