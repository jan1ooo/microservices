package com.jan1ooo.agenda.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jan1ooo.agenda.domain.dto.PacienteDto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
