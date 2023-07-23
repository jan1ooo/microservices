package com.jan1ooo.agenda.domain.entity.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgendaRequest {

    private Long id_agenda;

    @NotBlank
    @Column(unique = true)
    private String descricao;

    @Column(unique = true)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime horario;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dataCriacao;

    private Long paciente;
}
