package com.elmaalmi.billal.library.controller;

import com.elmaalmi.billal.library.exception.NotFoudException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AdviceController {
    @ExceptionHandler(NotFoudException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleResourceNotFoundException(NotFoudException e) {
        ModelAndView modelAndView = new ModelAndView("error/404");
        modelAndView.addObject("message",e.getMessage());
        System.out.println("Not found Exception");
        return modelAndView;
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleResourceException(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error/error");
        modelAndView.addObject("message",e.getMessage());
        System.out.println("Exception ");
        return modelAndView;
    }
}
