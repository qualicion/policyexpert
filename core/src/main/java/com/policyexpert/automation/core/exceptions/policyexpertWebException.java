package com.policyexpert.automation.core.exceptions;

public class policyexpertWebException extends RuntimeException {

    public policyexpertWebException(String message) {
        super(message);
    }

    public policyexpertWebException(String message, Throwable cause) {
        super(message, cause);
    }
}
