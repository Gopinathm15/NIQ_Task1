package com.demo.niq.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
    private String code;
    private String message;

    public ErrorMessage(String code) {
        this.code = code;
    }
}
