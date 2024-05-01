package com.suarezr.orders_msvc.common.exceptions;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException(){

    }
    public ForbiddenException(String message) {
        super(message);
    }
}
  