package com.diyo.TicketBookingSystem.exception;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NullPointerException.class, ArithmeticException.class})
    public  String handlerNullPointerException(){
        return "";
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public  String handlerArrayIndexOutOfBoundsException(){
        return "";
    }
}
