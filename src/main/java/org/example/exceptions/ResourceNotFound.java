package org.example.exceptions;

public class ResourceNotFound extends Exception {
    public ResourceNotFound() {
        super();
    }

    public ResourceNotFound(String message) {
        super(message);
    }
}