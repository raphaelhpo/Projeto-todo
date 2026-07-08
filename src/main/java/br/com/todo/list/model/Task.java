package br.com.todo.list.model;

import java.time.LocalDate;
import java.util.UUID;

import br.com.todo.list.enums.Prioridade;
import br.com.todo.list.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String titulo;
    private String descricao;
    private Status status;
    private Prioridade prioridade;
    private LocalDate dataCriacao;
    private LocalDate dataConclusao;
    private LocalDate dataFinalizacao;

    public Task() {
    }

    public Task(String titulo,
            String descricao,
            Status status,
            Prioridade prioridade,
            LocalDate dataCriacao,
            LocalDate dataConclusao,
            LocalDate dataFinalizacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.prioridade = prioridade;
        this.dataCriacao = dataCriacao;
        this.dataConclusao = dataConclusao;
        this.dataFinalizacao = dataFinalizacao;
    }
}
