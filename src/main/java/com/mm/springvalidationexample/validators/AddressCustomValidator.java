package com.mm.springvalidationexample.validators;

import com.mm.springvalidationexample.models.AddressDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Locale;

@Component
public class AddressCustomValidator implements Validator {

    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean supports(Class<?> aClass) {
        return AddressDetail.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AddressDetail detail = (AddressDetail)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine1", messageSource.getMessage("NotEmpty", null, Locale.US));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine2", messageSource.getMessage("NotEmpty", null, Locale.US));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", messageSource.getMessage("NotEmpty", null, Locale.US));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", messageSource.getMessage("NotEmpty", null, Locale.US));
        if(detail.getPostalCode() <= 0)
            errors.rejectValue("postalCode", messageSource.getMessage("NotEmpty", null, Locale.US));
    }
}
