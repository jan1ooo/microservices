package com.jan1ooo.agenda.domain.entity.agenda;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jan1ooo.agenda.domain.entity.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name = "agenda")
@Data
@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_agenda;

    private String descricao;

    @Column(name = "data_hora", unique = true)
    @Future
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime horario;

    @Column(name = "data_criacao")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
}
