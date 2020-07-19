package com.mm.springvalidationexample.validators;

import com.mm.springvalidationexample.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Locale;

@Component
public class UsersCustomValidator implements Validator {

    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
        //return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        User requestBody = (User)o;

        //ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","user.name.error");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name",messageSource.getMessage("user.name.error",null, Locale.US));

//        if(requestBody.getName().isEmpty())
//            errors.rejectValue("name","Name cannot be empty");

    }
}
