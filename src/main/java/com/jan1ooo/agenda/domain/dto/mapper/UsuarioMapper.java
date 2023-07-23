package com.jan1ooo.agenda.domain.dto.mapper;

import com.jan1ooo.agenda.domain.dto.UsuarioDto;
import com.jan1ooo.agenda.domain.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioDto usuarioDto){
        if(usuarioDto == null){
            return null;
        }
        Usuario usuario = new Usuario();
        if(usuarioDto.getId_usuario() != null){
            usuario.setId_usuario(usuarioDto.getId_usuario());
        }
        usuario.setUsuario(usuarioDto.getUsuario());
        usuario.setSenha(usuarioDto.getSenha());
        usuario.setNome(usuarioDto.getNome());
        return usuario;
    }

    public UsuarioDto toDto(Usuario usuario){
        if(usuario == null){
            return null;
        }
        return new UsuarioDto(usuario.getId_usuario(), usuario.getUsuario(), usuario.getNome(), usuario.getNome());
    }
}
