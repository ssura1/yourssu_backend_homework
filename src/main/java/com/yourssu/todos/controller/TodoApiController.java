package com.yourssu.todos.controller;

import com.yourssu.todos.dto.TodoInsertRequestDto;
import com.yourssu.todos.dto.TodoStateUpdateRequestDto;
import com.yourssu.todos.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.yourssu.tools.WriteToClient;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
public class TodoApiController {

    private final TodoService todoService;

    @PostMapping("/todo/save")
    public void saveTodo(@RequestBody TodoInsertRequestDto requestDto, HttpServletResponse response) {
        org.json.simple.JSONObject jsonObject = todoService.insertTodo(requestDto);
        WriteToClient.send(response, jsonObject);
    }

    @PutMapping("/todo/update")
    public void updateStatus(@RequestBody TodoStateUpdateRequestDto requestDto, HttpServletResponse response) {
        org.json.simple.JSONObject jsonObject = todoService.updateTodoState(requestDto);
        WriteToClient.send(response, jsonObject);
    }

    @GetMapping("/todo/list/{email}")
    public void getTodoListByEmail(@PathVariable String email, HttpServletResponse response) {
        org.json.simple.JSONObject jsonObject = todoService.getTodoListOfUser(email);
        WriteToClient.send(response, jsonObject);
    }

    @GetMapping("/todo/all")
    public void getAllTodoList(HttpServletResponse response) {
        org.json.simple.JSONObject jsonObject = todoService.findTodosOfAllUsers();
        WriteToClient.send(response, jsonObject);
    }
}
