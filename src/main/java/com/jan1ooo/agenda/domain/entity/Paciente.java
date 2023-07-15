package com.jan1ooo.agenda.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "paciente")
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paciente;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
}
