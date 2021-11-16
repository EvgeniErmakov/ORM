package com.epam.esm.exception;

public class OrderNotFoundException extends CustomServiceException {

    private static final int ORDER_NOT_FOUND_ERROR_CODE = 107;
    private static final String ORDER_NOT_FOUND_MESSAGE = "error.orderNotFound";

    public OrderNotFoundException(String message) {
        super(message);
    }

    @Override
    public int getErrorCode() {
        return ORDER_NOT_FOUND_ERROR_CODE;
    }

    @Override
    public String getErrorMessage() {
        return ORDER_NOT_FOUND_MESSAGE;
    }
}
