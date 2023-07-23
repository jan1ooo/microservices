package com.jan1ooo.agenda.domain.repository;

import com.jan1ooo.agenda.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);
}
