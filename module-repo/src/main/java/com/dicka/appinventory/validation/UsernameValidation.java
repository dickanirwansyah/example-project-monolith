package com.dicka.appinventory.validation;

import com.dicka.appinventory.validation.validator.UsernameValidator;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UsernameValidation implements ConstraintValidator<UsernameValidator, String> {


    @Override
    public void initialize(UsernameValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(String usernameValue, ConstraintValidatorContext context) {
       if (usernameValue == null)
           return true;

       /** check length **/
       if (usernameValue.length() < 6)
           return false;

       /** check regex **/
       if (usernameValue.matches("\\b[a-zA-Z][a-zA-Z0-9\\-._]{3,}\\b"))
            return false;

        return true;
    }
}
