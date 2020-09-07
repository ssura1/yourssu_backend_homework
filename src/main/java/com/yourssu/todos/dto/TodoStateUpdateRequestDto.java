package com.yourssu.todos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TodoStateUpdateRequestDto {

    private int todo_id;
    private String todo_state;
}
