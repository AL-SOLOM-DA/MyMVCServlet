package com.solomanin.dao.exception;

public class NoSuchEntityException extends DaoBussinessException{
    public NoSuchEntityException(String message) {
        super(message);
    }

    public NoSuchEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
