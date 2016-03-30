package com.kaishengit.exception;

public class DataException extends RuntimeException {
    public DataException(){}
    public DataException(Throwable e){
        super(e);
    }
    public DataException(Throwable e,String message){
        super(message,e);
    }
}
