package com.yourssu.todos.controller;

import com.yourssu.todos.dto.TodoInsertRequestDto;
import com.yourssu.todos.dto.TodoStateUpdateRequestDto;
import com.yourssu.todos.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.yourssu.tools.WriteToClient;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/todo/all/v2")
    public void findAll(HttpServletResponse response) {
        org.json.simple.JSONObject jsonObject = todoService.findAll();
        WriteToClient.send(response, jsonObject);
    }

    @GetMapping("/todo/list/{email}/v2")
    public void findByEmail(@PathVariable String email, HttpServletResponse response) {
        org.json.simple.JSONObject jsonObject = todoService.findByEmail(email);
        WriteToClient.send(response, jsonObject);
    }

    @GetMapping("/todo/search/{keyword}")
    public void searchTodos(@PathVariable String keyword, HttpServletResponse response) {
        org.json.simple.JSONObject jsonObject = todoService.searchTodo(keyword);
        WriteToClient.send(response, jsonObject);
    }

    @GetMapping("/todo/all")
    public void getAllTodoList(HttpServletResponse response) {
        org.json.simple.JSONObject jsonObject = todoService.findTodosOfAllUsers();
        WriteToClient.send(response, jsonObject);
    }

    @GetMapping("/todo/{id}")
    public void getTodoById(@PathVariable Integer id, HttpServletResponse response) {
        org.json.simple.JSONObject jsonObject = todoService.findTodoById(id);
        WriteToClient.send(response, jsonObject);
    }

    @GetMapping("/todo/first/{email}")
    public void findFirst(@PathVariable String email, HttpServletResponse response) {
        WriteToClient.send(response, todoService.findFirst(email));
    }

    @GetMapping("/todo/desc")
    public void findDesc(HttpServletResponse response) {
        WriteToClient.send(response, todoService.findAllBySortDesc());
    }

    @GetMapping("/todo/{page}/{itemCount}")
    public void findByPaging(@PathVariable Integer page, @PathVariable Integer itemCount, HttpServletResponse response) {
        WriteToClient.send(response, todoService.findByPage(page, itemCount));
    }

    @GetMapping("/api/v1/todo/{keyword}/{email}/{page}/{itemCount}")
    public void searchBySpec(@PathVariable String keyword, @PathVariable String email, @PathVariable Integer page, @PathVariable Integer itemCount, HttpServletResponse response) {
        WriteToClient.send(response, todoService.searchSpec(keyword, email, page, itemCount));
    }
}
