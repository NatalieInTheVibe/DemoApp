package com.natalie.demoApp.exception;

public class RuntimeException extends java.lang.RuntimeException {
    public RuntimeException(Long id){
        super("Can not find the item with id " + id);
    }
}
