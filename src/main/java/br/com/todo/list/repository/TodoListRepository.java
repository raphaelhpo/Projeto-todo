package br.com.todo.list.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.todo.list.model.Task;

public interface TodoListRepository extends JpaRepository<Task, UUID> {

}
