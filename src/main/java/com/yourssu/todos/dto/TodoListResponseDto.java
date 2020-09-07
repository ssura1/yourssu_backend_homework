package com.yourssu.todos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@NoArgsConstructor
@Getter
public class TodoListResponseDto {

    private int todo_id;
    private String email;
    private String content;
    private String todo_state;

    public TodoListResponseDto(Object[] objects) {
        this.todo_id = Integer.parseInt(objects[0].toString());
        this.email = objects[1].toString();
        this.content = objects[2].toString();
        this.todo_state = objects[3].toString();
    }

    public HashMap<String, Object> convertMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("todo_id", todo_id);
        map.put("email", email);
        map.put("content", content);
        map.put("todo_state", todo_state);
        return map;
    }
}
