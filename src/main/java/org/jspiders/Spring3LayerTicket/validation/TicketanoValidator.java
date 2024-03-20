package org.jspiders.Spring3LayerTicket.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TicketanoValidator implements ConstraintValidator<Ticketano,String> {
    @Override
    public boolean isValid(String ticketRef, ConstraintValidatorContext constraintValidatorContext) {



        if (ticketRef == null) {
            return false;
        }
        return ticketRef.matches("^MTB\\d{5}$");
    }
}
