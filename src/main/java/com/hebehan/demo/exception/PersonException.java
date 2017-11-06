package com.hebehan.demo.exception;

public class PersonException extends RuntimeException {
    private Integer code;

    public PersonException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
