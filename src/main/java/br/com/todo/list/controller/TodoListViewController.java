package br.com.todo.list.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.todo.list.dto.create.TaskCreateDTO;
import br.com.todo.list.service.TodoListService;

@Controller
@RequestMapping("todolist")
public class TodoListViewController {
    TodoListService service;

    private TodoListViewController(TodoListService service) {
        this.service = service;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("tasks", service.consultarTodasTasks());
        model.addAttribute("taskForm", new TaskCreateDTO());
        return "lista_tasks";
    }

    @PostMapping("/criar")
    public String postPageCriar(@ModelAttribute TaskCreateDTO task) {
        service.criarTask(task);
        return "redirect:/todolist";
    }
}
