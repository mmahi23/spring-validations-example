package com.mm.springvalidationexample.models;

import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.List;

@Data
public class ErrorModel {

    private int status;
    private String message;
    private List<FieldError> fieldErrors;

    public void addFieldError(String path, String message) {
        FieldError error = new FieldError(path, path, message);
        fieldErrors.add(error);
    }

}
