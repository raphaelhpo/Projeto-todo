package br.com.todo.list.mapper;

import org.springframework.stereotype.Component;

import br.com.todo.list.dto.create.TaskCreateDTO;
import br.com.todo.list.dto.response.TaskResponseDTO;
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

    public static Task toEntity(TaskCreateDTO taskCreateDto) {
        return new Task(
                taskCreateDto.getTitulo(),
                taskCreateDto.getDescricao(),
                taskCreateDto.getStatus(),
                taskCreateDto.getPrioridade(),
                taskCreateDto.getDataCriacao(),
                taskCreateDto.getDataConclusao(),
                taskCreateDto.getDataFinalizacao());
    }
}
