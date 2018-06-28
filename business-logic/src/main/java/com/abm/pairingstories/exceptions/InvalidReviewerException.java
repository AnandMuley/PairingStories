package com.abm.pairingstories.exceptions;

public class InvalidReviewerException extends Exception {

    public final static String defaultMessage = "Invalid reviewer code";

    public InvalidReviewerException() {
        super(defaultMessage);
    }

    public InvalidReviewerException(String message) {
        super(message);
    }
}
