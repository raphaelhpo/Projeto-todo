package br.com.todo.list.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.todo.list.dto.create.TaskCreateDTO;
import br.com.todo.list.dto.response.TaskResponseDTO;
import br.com.todo.list.dto.update.TaskUpdateDTO;
import br.com.todo.list.enums.Status;
import br.com.todo.list.mapper.TaskMapper;
import br.com.todo.list.model.Task;
import br.com.todo.list.repository.TodoListRepository;

@Service
public class TodoListService {
    TodoListRepository repository;

    private TodoListService(TodoListRepository repository) {
        this.repository = repository;
    }

    public void editarTask(UUID uuid, TaskUpdateDTO taskDto) {
        this.consultarTask(uuid);
        repository.save(TaskMapper.toEntity(taskDto));
    }

    public TaskResponseDTO criarTask(TaskCreateDTO taskDto) {
        Task taskCriada = repository.save(TaskMapper.toEntity(taskDto));
        return TaskMapper.toResponse(taskCriada);
    }

    // Função provisória
    public List<TaskResponseDTO> consultarTodasTasks() {
        List<TaskResponseDTO> response = repository.findAll().stream()
                .map(task -> TaskMapper.toResponse(task))
                .collect(Collectors.toList());
        return response;
    }

    public TaskResponseDTO consultarTask(UUID uuid) {
        return repository.findById(uuid)
                .map(task -> TaskMapper.toResponse(task))
                .orElseThrow(() -> new RuntimeException("Task do UUID Não encontrado."));
    }

    public TaskResponseDTO concluirTask(UUID uuid) {
        Task task = repository.findById(uuid).orElseThrow(() -> new RuntimeException("Task do UUID Não encontrado."));
        if (task.getStatus().equals(Status.CONCLUIDA)) {
            throw new RuntimeException("Task já concluída.");
        } else {
            task.setStatus(Status.CONCLUIDA);
            repository.save(task);
        }
        return TaskMapper.toResponse(task);
    }

    public void deletarTask(UUID uuid) {
        repository.deleteById(uuid);
    }
}
