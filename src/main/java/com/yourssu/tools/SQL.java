package com.yourssu.tools;

public class SQL {

    public class TODOs {
        public static final String UPDATE_TODO_STATE = "UPDATE todos SET todo_state = ? WHERE todo_id = ?";
        public static final String GET_TODO_OF_USER = "SELECT todo_id, content, todo_state FROM todos WHERE email=?";
        public static final String GET_TODO_OF_ALL_USER = "SELECT * FROM todos;";
    }
}
