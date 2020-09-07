package com.yourssu.todos.exception;

public class TodoListNotFoundException extends TodoException{

    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "등록된 작업 목록이 존재하지 않습니다.";

    public TodoListNotFoundException() {
        super(MESSAGE);
    }
}
