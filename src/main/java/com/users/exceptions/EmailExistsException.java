package com.users.exceptions;

/**
 * @author atsikhamirau on 21.02.2019
 */
public class EmailExistsException extends Exception {

    public EmailExistsException() {
    }

    public EmailExistsException(String message) {
        super(message);
    }
}
