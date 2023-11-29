package com.example.practice_todo.p_todoapi.p_repository;

import com.example.practice_todo.p_todoapi.p_entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository
        extends JpaRepository<Todo,String> {
}
