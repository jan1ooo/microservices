package com.jan1ooo.agenda.domain.service;

import com.jan1ooo.agenda.domain.dto.UsuarioDto;
import com.jan1ooo.agenda.domain.dto.mapper.UsuarioMapper;
import com.jan1ooo.agenda.domain.entity.Usuario;
import com.jan1ooo.agenda.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Optional<Usuario> optUsuario = repository.findByUsuario(usuario);
        if(usuario.isEmpty()){
            throw new UsernameNotFoundException("Usuario não encontrado");
        }

        Usuario user = optUsuario.get();
        return new User(user.getUsuario(), user.getSenha(), new ArrayList<>());
    }

    public List<UsuarioDto> findAll(){
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public UsuarioDto usuario(UsuarioDto usuario){
        usuario.setSenha(passwordEncoder.encode(usuario.getUsuario()));
        return mapper.toDto(repository.save(mapper.toEntity(usuario)));
    }
 }
