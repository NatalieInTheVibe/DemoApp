package com.natalie.demoApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MemberNotFoundHandler {

    @ResponseBody
    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> exceptionHandler(MemberNotFoundException exception){
        Map<String,String> errorMsgMap = new HashMap<>();
        errorMsgMap.put("Error Message: ", exception.getMessage());
        return errorMsgMap;
    }
}
