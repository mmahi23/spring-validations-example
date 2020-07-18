package com.mm.springvalidationexample.controllers;

import com.mm.springvalidationexample.models.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MainController {

    @GetMapping(path = "/users")
    public String getUsers(){
        return "hello";
    }

    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String postUsers(@Valid @RequestBody User userInfo){
        return "hello";
    }
}
