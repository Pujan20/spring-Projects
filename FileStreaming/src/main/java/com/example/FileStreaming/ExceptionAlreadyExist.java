package com.example.FileStreaming;

@SuppressWarnings("serial")
public class ExceptionAlreadyExist extends Exception {

    public ExceptionAlreadyExist() {
        super();
    }

    public ExceptionAlreadyExist(String message) {
        super(message);
    }

    public ExceptionAlreadyExist(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionAlreadyExist(Throwable cause) {
        super(cause);
    }
}

