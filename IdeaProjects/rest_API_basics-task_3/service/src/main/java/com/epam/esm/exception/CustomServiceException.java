package com.epam.esm.exception;

public abstract class CustomServiceException extends RuntimeException {

    protected CustomServiceException(String message) {
        super(message);
    }

    public abstract int getErrorCode();

    public abstract String getErrorMessage();

}
