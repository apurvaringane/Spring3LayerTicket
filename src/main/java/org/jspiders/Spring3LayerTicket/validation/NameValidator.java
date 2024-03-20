package org.jspiders.Spring3LayerTicket.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<Name,String> {
    @Override
    public boolean isValid(String eventName, ConstraintValidatorContext constraintValidatorContext) {


        if (eventName == null) {
            return false;
        }
        return eventName.length() >= 5 && eventName.matches("^[a-zA-Z]*$");
    }

}
