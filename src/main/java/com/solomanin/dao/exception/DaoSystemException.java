package com.solomanin.dao.exception;

public class DaoSystemException extends DaoException{
    public DaoSystemException(String message) {
        super(message);
    }

    public DaoSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
