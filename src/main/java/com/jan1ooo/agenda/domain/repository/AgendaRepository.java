package com.jan1ooo.agenda.domain.repository;

import com.jan1ooo.agenda.domain.dto.AgendaDto;
import com.jan1ooo.agenda.domain.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    AgendaDto findByHorario(LocalDateTime horario);
}
