package com.jan1ooo.agenda.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private Long id_usuario;
    @NotNull
    private String nome;
    @NotNull
    private String usuario;
    @NotNull
    private String senha;

}
