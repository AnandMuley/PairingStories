package com.abm.pairingstories.domain.exceptions;

public class NoStoryFoundException extends Exception {

    public NoStoryFoundException() {
        super("No story found");
    }

    public NoStoryFoundException(String message) {
        super(message);
    }

    public NoStoryFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
