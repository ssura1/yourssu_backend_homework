package com.yourssu.todos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TodoUserResponseDto {

    private int todo_id;
    private String content;
    private String todo_state;

    public TodoUserResponseDto(Object[] objects) {
        this.todo_id = Integer.parseInt(objects[0].toString());
        this.content = objects[1].toString();
        this.todo_state = objects[2].toString();
    }

    public HashMap<String, Object> convertMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("todo_id", todo_id);
        map.put("content", content);
        map.put("todo_state", todo_state);
        return map;
    }
}
