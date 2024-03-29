package br.unitins.topicos1.application;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;

public class Result {
    
    private String message;
    private boolean success;

    public Result (String message) {

        this.success = true;
        this.message = message;
    }

    public Result (Set<? extends ConstraintViolation<?>> violations) {

        this.success = false;
        this.message = violations.stream()
                            .map(constraintViolation -> constraintViolation.getMessage())
                            .collect(Collectors.joining(", "));
    }

    public String getMessage() {
        return message;
    }
    public boolean isSuccess() {
        return success;
    }
}
