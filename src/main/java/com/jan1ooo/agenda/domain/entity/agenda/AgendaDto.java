package com.jan1ooo.agenda.domain.entity.agenda;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jan1ooo.agenda.domain.entity.paciente.PacienteDto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendaDto {

    private Long id_agenda;

    @NotBlank
    @Column(unique = true)
    private String descricao;

    @Column(unique = true)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime horario;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime dataCriacao;

    private PacienteDto paciente;
}
