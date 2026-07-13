package br.com.todo.list.dto.update;

import java.time.LocalDate;
import java.util.UUID;

import br.com.todo.list.enums.Prioridade;
import br.com.todo.list.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskUpdateDTO {
    private UUID id;
    private String titulo;
    private String descricao;
    private Status status;
    private Prioridade prioridade;
    private LocalDate dataCriacao;
    private LocalDate dataConclusao;
    private LocalDate dataFinalizacao;
}
