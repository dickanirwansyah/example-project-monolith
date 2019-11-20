package com.dicka.appinventory.validation.validator;

import com.dicka.appinventory.validation.UsernameIsExistingValidation;
import com.dicka.appinventory.validation.UsernameValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.ANNOTATION_TYPE,
        ElementType.TYPE,
        ElementType.METHOD,
        ElementType.FIELD
})
@Constraint(validatedBy = {
        UsernameIsExistingValidation.class
})
@Documented
public @interface UsernameIsExistingValidator {

    String message()
            default "this username is already exists in database !";

    Class<?>[] groups()
            default {};

    Class<? extends Payload>[] payload()
            default {};

    String[] path()
            default {};
}
