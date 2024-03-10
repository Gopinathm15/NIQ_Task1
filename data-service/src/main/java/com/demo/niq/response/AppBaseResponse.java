package com.demo.niq.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AppBaseResponse<T> {

    private String status;
    private int code;
    private T data;
    private List<ErrorMessage> errorMessages = new ArrayList<>();

    public AppBaseResponse() {
        this.code = 200;
        this.status = "SUCCESS";
    }

    public AppBaseResponse(T data) {
        this.code = 200;
        this.status = "SUCCESS";
        this.data = data;
    }

    public void addErrorMessage(ErrorMessage errorMessage) {
        errorMessages.add(errorMessage);
    }

}