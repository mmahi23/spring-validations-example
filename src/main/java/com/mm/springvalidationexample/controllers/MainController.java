package com.mm.springvalidationexample.controllers;

import com.mm.springvalidationexample.models.GhUser;
import com.mm.springvalidationexample.models.User;
import com.mm.springvalidationexample.service.UserLocatorService;
import com.mm.springvalidationexample.validators.UsersCustomValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class MainController {

    @Autowired
    private UsersCustomValidator customValidator;

    @Autowired
    private UserLocatorService userService;

    @GetMapping(path = "/health")
    public String getUsers(){
        return "Service is up!";
    }

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @InitBinder
    void customerValidater(WebDataBinder binder){
        binder.setValidator(customValidator);
    }

    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String postUsers(@Valid @RequestBody User userInfo) throws InterruptedException, ExecutionException {

        CompletableFuture<GhUser> request1 = userService.getUserInfo("mmahi23");
        CompletableFuture<GhUser> request2 = userService.getUserInfo("rmootha");

        CompletableFuture.allOf(request1, request2).join();

        logger.info(String.valueOf(request1.get().getId()));
        logger.info(String.valueOf(request2.get().getId()));

        return "hello";
    }
}
