package com.epam.esm.exception;

public class UserNotFoundException extends CustomServiceException {

    private static final int USER_NOT_FOUND_CODE = 105;
    private static final String USER_NOT_FOUND_MESSAGE = "error.userNotFound";

    public UserNotFoundException(String message) {
        super(message);
    }

    @Override
    public int getErrorCode() {
        return USER_NOT_FOUND_CODE;
    }

    @Override
    public String getErrorMessage() {
        return USER_NOT_FOUND_MESSAGE;
    }
}
