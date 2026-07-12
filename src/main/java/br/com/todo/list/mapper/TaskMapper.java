package br.com.todo.list.mapper;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import br.com.todo.list.dto.create.TaskCreateDTO;
import br.com.todo.list.dto.response.TaskResponseDTO;
import br.com.todo.list.enums.Status;
import br.com.todo.list.model.Task;

@Component
public class TaskMapper {
    public static TaskResponseDTO toResponse(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getTitulo(),
                task.getDescricao(),
                task.getStatus(),
                task.getPrioridade(),
                task.getDataCriacao(),
                task.getDataConclusao(),
                task.getDataFinalizacao());
    }

    public static Task toEntity(TaskCreateDTO dto) {
        Task task = new Task();
        task.setTitulo(dto.getTitulo());
        task.setDescricao(dto.getDescricao());
        task.setPrioridade(dto.getPrioridade());
        task.setDataFinalizacao(dto.getDataFinalizacao());
        task.setDataConclusao(null);
        // valores fixos definidos aqui, não no construtor do DTO
        task.setStatus(Status.PENDENTE);
        task.setDataCriacao(LocalDate.now());
        return task;
    }
}
