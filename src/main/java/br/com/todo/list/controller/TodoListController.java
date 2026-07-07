package br.com.todo.list.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.todo.list.dto.create.TaskCreateDTO;
import br.com.todo.list.dto.response.TaskResponseDTO;
import br.com.todo.list.service.TodoListService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("todolist/")
public class TodoListController {
    TodoListService service;

    private TodoListController(TodoListService service) {
        this.service = service;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarTask(@RequestBody @Valid TaskCreateDTO task) {
        try {
            service.criarTask(task);
            return ResponseEntity.status(HttpStatus.CREATED).body(HttpStatus.CREATED.toString());
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException("Erro ao inserir dados.", e.getCause());
        }
    }

    @GetMapping("/consultar")
    public ResponseEntity<List<TaskResponseDTO>> visualizarTasks() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.consultarTodasTasks());
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException("Erro ao consultar dados.", e.getCause());
        }
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<TaskResponseDTO> visualizarTask(@RequestParam UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.consultarTask(id));
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException("Erro ao inserir dados.", e.getCause());
        }
    }

    @PutMapping("/concluir/task/{id}")
    public void concluirTask(@PathVariable String id) {

    }

    @PutMapping("/atualizar/status/task/{id}")
    public void atualizarStatusTask(@PathVariable String id) {
    }

    @DeleteMapping()
    public void excluirTask(@PathVariable String id) {

    }

}
