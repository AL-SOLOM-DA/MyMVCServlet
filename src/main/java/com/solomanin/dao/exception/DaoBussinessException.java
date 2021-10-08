package com.solomanin.dao.exception;

public class DaoBussinessException extends DaoException{
    public DaoBussinessException(String message) {
        super(message);
    }

    public DaoBussinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
