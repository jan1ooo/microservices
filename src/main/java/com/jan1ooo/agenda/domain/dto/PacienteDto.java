package com.jan1ooo.agenda.domain.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDto {

    private Long id_paciente;
    @NotBlank(message = "Nome do Paciente é Obrigatório")
    private String nome;
    @NotBlank(message = "Sobrenome do Paciente é Obrigatório")
    private String sobrenome;
    @Column(unique = true)
    @CPF
    @NotBlank(message = "CPF do Paciente é Obrigatório")
    private String cpf;
    @NotBlank
    @Email
    private String email;
}
