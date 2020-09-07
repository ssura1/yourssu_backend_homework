package com.yourssu.todos.exception;

public abstract class TodoException extends Exception{

    private static final long serialVersionUID = 1L;

    public TodoException(String MESSAGE) {
        super(MESSAGE);
    }
}
