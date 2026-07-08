package br.com.todo.list.dto.create;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.todo.list.enums.Prioridade;
import br.com.todo.list.enums.Status;
import br.com.todo.list.model.Task;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TaskCreateDTO {
    @NotBlank
    private String titulo;
    @NotNull
    private String descricao;
    @JsonIgnore
    private Status status;
    private Prioridade prioridade = Prioridade.MEDIA;
    @JsonIgnore
    private LocalDate dataCriacao;
    @JsonIgnore
    private LocalDate dataConclusao;
    private LocalDate dataFinalizacao;

    public TaskCreateDTO(String titulo,
            String descricao,
            Status status,
            Prioridade prioridade,
            LocalDate dataFinalizacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = Status.PENDENTE;
        this.prioridade = prioridade;
        this.dataCriacao = LocalDate.now();
        this.dataFinalizacao = dataFinalizacao;
    }

    public Task toEntity() {
        return new Task(titulo, descricao, status, prioridade, dataCriacao, dataConclusao, dataFinalizacao);
    }
}
