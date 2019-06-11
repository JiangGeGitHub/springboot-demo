package com.example.demo.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/*
*
* 通过使用注解@ControllerAdvice，类RestExceptionHandler就可以实现全局异常的拦截处理功能。
* */
@ControllerAdvice
public class RestExceptionHandler{
    private static Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);


    /*
自定义的方法handleResourceNotFoundException旨在拦截NotFoundException异常，一旦拦截成功后，
我们可以进行各种处理操作，并且返回自己想要的结果。
其中，注解@ExceptionHandler表示要拦截的异常；注解@ResponseStatus可以指定HTTP响应的状态码;
当然，注解@ResponseBody也必不可少。
     */


    @ExceptionHandler(value = ExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result handleResourceNotFoundException(ExistException e)
    {
        logger.error(e.getMessage(), e);
        return new Result(e.getMessage(), e.getCode());
    }
}