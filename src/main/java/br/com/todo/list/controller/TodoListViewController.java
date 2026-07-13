package br.com.todo.list.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.todo.list.dto.create.TaskCreateDTO;
import br.com.todo.list.dto.update.TaskUpdateDTO;
import br.com.todo.list.service.TodoListService;

@Controller
@RequestMapping("todolist")
public class TodoListViewController {
    TodoListService service;

    private TodoListViewController(TodoListService service) {
        this.service = service;
    }

    // Create task
    @PostMapping("/criar")
    public String postPageCriar(@ModelAttribute TaskCreateDTO task) {
        service.criarTask(task);
        return "redirect:/todolist";
    }

    // Read Tasks
    @GetMapping
    public String home(Model model) {
        model.addAttribute("tasks", service.consultarTodasTasks());
        model.addAttribute("taskForm", new TaskCreateDTO());
        return "lista_tasks";
    }

    // Update Tasks
    @PostMapping("/editar/{id}")
    public String postUpdateTask(@PathVariable UUID id, @ModelAttribute TaskUpdateDTO task) {
        service.editarTask(id, task);
        return "redirect:/todolist";
    }

    // Delete task
    @PostMapping("/deletar/{id}")
    public String deletarTask(@PathVariable UUID id) {
        service.deletarTask(id);
        return "redirect:/todolist";
    }

    // Finalizar taks
    @PostMapping("/concluir/{id}")
    public String postMethodName(@PathVariable UUID id) {
        service.concluirTask(id);
        return "redirect:/todolist";
    }
}
