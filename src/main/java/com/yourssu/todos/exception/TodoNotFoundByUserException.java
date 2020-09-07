package com.yourssu.todos.exception;

public class TodoNotFoundByUserException extends TodoException{

    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "해당 이메일로 등록된 작업이 존재하지 않습니다.";

    public TodoNotFoundByUserException() {
        super(MESSAGE);
    }
}
