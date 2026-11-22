package com.design.patterns.enterprise.retry;

public final class TransientServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TransientServiceException(String message) {
        super(message);
    }
}
