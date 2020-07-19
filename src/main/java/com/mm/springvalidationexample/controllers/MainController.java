package com.mm.springvalidationexample.controllers;

import com.mm.springvalidationexample.models.User;
import com.mm.springvalidationexample.validators.UsersCustomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MainController {

    @Autowired
    private UsersCustomValidator customValidator;

    @GetMapping(path = "/users")
    public String getUsers(){
        return "hello";
    }

    @InitBinder
    void customerValidater(WebDataBinder binder){
        binder.setValidator(customValidator);
    }

    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String postUsers(@Valid @RequestBody User userInfo){
        return "hello";
    }
}
