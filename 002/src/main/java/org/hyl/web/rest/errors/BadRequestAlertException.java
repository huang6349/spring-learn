package org.hyl.web.rest.errors;

public class BadRequestAlertException extends RuntimeException {

    public BadRequestAlertException(String message) {
        super(message);
    }
}
