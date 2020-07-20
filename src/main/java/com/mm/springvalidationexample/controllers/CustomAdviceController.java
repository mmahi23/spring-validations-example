package com.mm.springvalidationexample.controllers;

import com.mm.springvalidationexample.models.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomAdviceController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorModel methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ErrorModel handleAllExceptions(Exception ex, WebRequest request) {
        ErrorModel error = new ErrorModel();
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage("Unhandled Error");
        List<FieldError> errors = new ArrayList<>();
        error.setFieldErrors(errors);
        error.addFieldError("",ex.getCause().toString());
        return  error;
    }

    private ErrorModel processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
        ErrorModel error = new ErrorModel();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("validation error");
        List<FieldError> errors = new ArrayList<>();
        error.setFieldErrors(errors);
        for (org.springframework.validation.FieldError fieldError: fieldErrors) {
            error.addFieldError(fieldError.getField(), fieldError.getCode());
        }
        return error;
    }

}
