package com.bal.asha.nurture.server.common.exception;

public class NurtureServerException extends RuntimeException {

    public NurtureServerException(String message, Exception e) {
        super(message, e);
    }

    public NurtureServerException(String message) {
        super(message);
    }
}
