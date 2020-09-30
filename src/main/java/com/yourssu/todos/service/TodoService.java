package com.yourssu.todos.service;

import com.yourssu.domain.Todos;
import com.yourssu.domain.TodosRepository;
import com.yourssu.todos.dto.TodoInsertRequestDto;
import com.yourssu.todos.dto.TodoListResponseDto;
import com.yourssu.todos.dto.TodoStateUpdateRequestDto;
import com.yourssu.todos.dto.TodoUserResponseDto;
import com.yourssu.todos.exception.TodoListNotFoundException;
import com.yourssu.todos.exception.TodoNotFoundByUserException;
import com.yourssu.tools.ObjectMaker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodosRepository todosRepository;

    public TodoService(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public org.json.simple.JSONObject insertTodo(TodoInsertRequestDto requestDto) {
        org.json.simple.JSONObject jsonObject = ObjectMaker.getSimpleJSONObject();
        try {
            todosRepository.save(requestDto.toEntity());
            jsonObject.put("result", true);
            jsonObject.put("message", "작업 추가에 성공했습니다.");
        } catch(Exception exception) {
            jsonObject = ObjectMaker.getSimpleJSONObjectWithException(exception);
        }
        return jsonObject;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public org.json.simple.JSONObject updateTodoState(TodoStateUpdateRequestDto requestDto) {
        org.json.simple.JSONObject jsonObject = ObjectMaker.getSimpleJSONObject();
        try {
            todosRepository.updateTodoState(requestDto.getTodo_state(), requestDto.getTodo_id());
            jsonObject.put("result", true);
            jsonObject.put("message", "작업의 처리 상태가 변경되었습니다.");
        } catch(Exception exception) {
            jsonObject = ObjectMaker.getSimpleJSONObjectWithException(exception);
        }
        return jsonObject;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public org.json.simple.JSONObject getTodoListOfUser(String email) {
        org.json.simple.JSONObject jsonObject = ObjectMaker.getSimpleJSONObject();
        try {
            List<TodoUserResponseDto> list = todosRepository.findTodosOfUser(email).stream().map(TodoUserResponseDto::new).collect(Collectors.toList());
            if(list.size() == 0) {
                throw new TodoNotFoundByUserException();
            }
            jsonObject.put("result", true);
            jsonObject.put("message", "해당 이메일의 작업 목록 가져오기 성공");
            org.json.simple.JSONArray jsonArray = ObjectMaker.getSimpleJSONArray();
            for(TodoUserResponseDto responseDto : list) {
                org.json.simple.JSONObject jTemp = ObjectMaker.getSimpleJSONObject();
                jTemp.putAll(responseDto.convertMap());
                jsonArray.add(jTemp);
            }
            jsonObject.put("todo", jsonArray);
        } catch(TodoNotFoundByUserException exception) {
            jsonObject = ObjectMaker.getSimpleJSONObjectWithException(exception);
        }
        return jsonObject;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public org.json.simple.JSONObject findAll() {
        org.json.simple.JSONObject jsonObject = ObjectMaker.getSimpleJSONObject();
        try {
            List<Todos> list = todosRepository.findAll();
            if(list.size() == 0) throw new TodoListNotFoundException();
            jsonObject.put("result", true);
            org.json.simple.JSONArray jsonArray = ObjectMaker.getSimpleJSONArray();
            for(Todos todo : list) {
                org.json.simple.JSONObject jTemp = ObjectMaker.getSimpleJSONObject();
                jTemp.putAll(todo.convertMap());
                jsonArray.add(jTemp);
            }
            jsonObject.put("todos", jsonArray);
        } catch(TodoListNotFoundException exception) {
            jsonObject = ObjectMaker.getSimpleJSONObjectWithException(exception);
        }
        return jsonObject;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public org.json.simple.JSONObject findTodosOfAllUsers() {
        org.json.simple.JSONObject jsonObject = ObjectMaker.getSimpleJSONObject();
        try {
            List<TodoListResponseDto> list = todosRepository.findTodosOfAllUsers().stream().map(TodoListResponseDto::new).collect(Collectors.toList());
            if(list.size() == 0) {
                throw new TodoListNotFoundException();
            }
            jsonObject.put("result", true);
            jsonObject.put("message", "모든 작업 목록 가져오기 성공");
            org.json.simple.JSONArray jsonArray = ObjectMaker.getSimpleJSONArray();
            for(TodoListResponseDto responseDto : list) {
                org.json.simple.JSONObject jTemp = ObjectMaker.getSimpleJSONObject();
                jTemp.putAll(responseDto.convertMap());
                jsonArray.add(jTemp);
            }
            jsonObject.put("todo", jsonArray);
        } catch(TodoListNotFoundException exception) {
            jsonObject = ObjectMaker.getSimpleJSONObjectWithException(exception);
        }
        return jsonObject;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public org.json.simple.JSONObject findTodoById(Integer id) {
        org.json.simple.JSONObject jsonObject = ObjectMaker.getSimpleJSONObject();
        try {
            Optional<Todos> todos = todosRepository.findById(id);
            if(todos.isPresent()) {
                Todos todo = todos.get();
                jsonObject.put("result", true);
                jsonObject.put("email", todo.getEmail());
                jsonObject.put("content", todo.getContent());
                jsonObject.put("state", todo.getTodo_state());
            }
            else {
                throw new Exception("NO TODO WITH THIS ID");
            }
        } catch(Exception exception) {
            jsonObject = ObjectMaker.getSimpleJSONObjectWithException(exception);
        }
        return jsonObject;
    }
}
