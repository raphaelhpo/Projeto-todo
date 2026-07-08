package br.com.todo.list.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.todo.list.dto.create.TaskCreateDTO;
import br.com.todo.list.dto.response.TaskResponseDTO;
import br.com.todo.list.service.TodoListService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("todolist/")
public class TodoListViewController {
    TodoListService service;

    private TodoListViewController(TodoListService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        return "main";
    }

    @GetMapping("tasks")
    public String listar(Model model) {
        List<TaskResponseDTO> tasks = service.consultarTodasTasks();
        model.addAttribute("tasks", tasks);
        model.addAttribute("taskForm", new TaskCreateDTO());
        return "tasks/listar";
    }

    // exibe o formulário
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("taskForm", new TaskCreateDTO());
        return "tasks/form";
    }

    // recebe os dados do formulário
    @PostMapping("/criar")
    public String criar(@ModelAttribute TaskCreateDTO task) {
        service.criarTask(task);
        return "redirect:/tasks";
    }

}
