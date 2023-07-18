package com.jan1ooo.agenda.domain.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendaDto {

    private Long id_agenda;

    @NotBlank
    private String descricao;

    @NotBlank
    @Column(unique = true)
    private LocalDateTime horario;

    @NotBlank
    private LocalDateTime dataCriacao;

    @NotBlank
    private PacienteDto paciente;
}
