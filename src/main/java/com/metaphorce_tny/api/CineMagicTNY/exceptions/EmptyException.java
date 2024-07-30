package com.metaphorce_tny.api.CineMagicTNY.exceptions;
import org.springframework.http.HttpStatus;


public class EmptyException extends Exception {
    private HttpStatus status;
    private String errorCode;

    public EmptyException(String mensaje){
        super(mensaje);
        System.out.println(status);
        System.out.println(errorCode);
    }
    
}
