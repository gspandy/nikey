package com.api.controllers;

import net.paoding.rose.web.ControllerErrorHandler;
import net.paoding.rose.web.Invocation;

/**
 * Created by arvin on 2015/6/24.
 * 异常处理类
 */
public class ErrorHandler implements ControllerErrorHandler {
    public Object onError(Invocation inv, Throwable ex) throws Throwable {
        if(ex instanceof  NullPointerException){
            return "@NullPointerException";
        }
        return "@error";
    }
}
