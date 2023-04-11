package com.natalie.demoApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> exceptionHandler(RuntimeException exception){
        Map<String,String> errorMsgMap = new HashMap<>();
        errorMsgMap.put("Error Message: ", exception.getMessage());
        return errorMsgMap;
    }
}
