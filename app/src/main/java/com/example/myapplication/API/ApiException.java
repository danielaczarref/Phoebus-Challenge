package com.example.myapplication.API;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends Exception {

    private final int codeHTTP;
    private final String resCode;

    public ApiException (int codeHTTP, String resCode, String desc, Throwable throwable) {
        super(desc, throwable);
        this.codeHTTP = codeHTTP;
        this.resCode = resCode;
    }

    public ApiException(String msg, Throwable throwable) {
        this(-1, "", msg, throwable);
    }
}
