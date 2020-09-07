package com.yourssu.todos.dto;

import com.yourssu.domain.TodoState;
import com.yourssu.domain.Todos;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoInsertRequestDto {

    private String email;
    private String content;

    public Todos toEntity() {
        return Todos.builder()
                .email(email)
                .content(content)
                .todo_state(TodoState.TODO)
                .build();
    }
}
