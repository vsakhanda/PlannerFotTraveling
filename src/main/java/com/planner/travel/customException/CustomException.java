package com.planner.travel.customException;

public class CustomException extends RuntimeException {
    private String message;
    private Integer code;

    public CustomException(String message, Integer code) {
        super(message);
        this.message = message;
        this.code = code;
    }
}
