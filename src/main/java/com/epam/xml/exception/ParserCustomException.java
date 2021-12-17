package com.epam.xml.exception;

public class ParserCustomException extends Exception{

    public ParserCustomException() {
        super();
    }

    public ParserCustomException(String message) {
        super(message);
    }

    public ParserCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParserCustomException(Throwable cause) {
        super(cause);
    }
}
