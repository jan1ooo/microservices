package com.jan1ooo.agenda.domain.entity.paciente;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Table(name = "paciente")
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paciente;
    private String nome;
    private String sobrenome;
    @Column(unique = true)
    @CPF
    private String cpf;
    @Email
    @NotBlank
    private String email;
}
