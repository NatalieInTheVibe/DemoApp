package com.natalie.demoApp.exception;

public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException(Integer mbrNo){
        super("Can not find the member with id " + mbrNo);
    }
}
