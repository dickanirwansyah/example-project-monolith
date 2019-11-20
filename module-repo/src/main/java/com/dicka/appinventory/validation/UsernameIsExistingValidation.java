package com.dicka.appinventory.validation;

import com.dicka.appinventory.repository.UsersRepository;
import com.dicka.appinventory.validation.validator.UsernameIsExistingValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UsernameIsExistingValidation implements ConstraintValidator<UsernameIsExistingValidator, String> {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void initialize(UsernameIsExistingValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(String usernameValue, ConstraintValidatorContext context) {
        if (usernameValue == null)
            return true;

        if (usersRepository.findUsersByUsername(usernameValue).isPresent())
            return false;

        return true;
    }
}
