package br.com.todo.list.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.persistence.Id;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("todolist/")
public class TodoListController {

    @PostMapping("task/criar")
    public void criarTask(@RequestBody String entity) {

    }

    @GetMapping("task/consultar")
    public void visualizarTasks(@RequestParam String... strings) {

    }

    @GetMapping("task/consultar")
    public void visualizarTask(@RequestParam String param) {

    }

    @PutMapping("path/{id}")
    public void editarTask(@PathVariable String id, @RequestBody String entity) {

    }

    @DeleteMapping()
    public void excluirTask(@PathVariable String id) {

    }

}
