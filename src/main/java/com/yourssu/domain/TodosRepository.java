package com.yourssu.domain;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.yourssu.tools.SQL;

import java.util.List;
import java.util.Optional;

public interface TodosRepository extends JpaRepository<Todos, Integer> {

    @Transactional
    @Modifying
    @Query(value = SQL.TODOs.UPDATE_TODO_STATE, nativeQuery = true)
    void updateTodoState(String todo_state, int todo_id);

    @Query(value = SQL.TODOs.GET_TODO_OF_USER, nativeQuery = true)
    List<Object[]> findTodosOfUser(String email);

    @Query(value = SQL.TODOs.GET_TODO_OF_ALL_USER, nativeQuery = true)
    List<Object[]> findTodosOfAllUsers();

    Optional<Todos> findById(Integer id);

    List<Todos> findAll();

    List<Todos> findByEmail(String email);

    List<Todos> findByContentContaining(String keyword);
}
