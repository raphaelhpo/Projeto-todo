package br.com.todo.list.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.todo.list.model.Task;

@Repository
public interface TodoListRepository extends JpaRepository<UUID, Task> {

}
