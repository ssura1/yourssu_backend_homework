package com.yourssu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;

@NoArgsConstructor
@Getter
@Entity
public class Todos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todo_id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TodoState todo_state;

    @Builder
    public Todos(String email, String content, TodoState todo_state) {
        this.email = email;
        this.content = content;
        this.todo_state = todo_state;
    }

    public HashMap<String, Object> convertMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("email", email);
        hashMap.put("content", content);
        hashMap.put("state", todo_state);
        return hashMap;
    }
}
