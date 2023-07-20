package com.jan1ooo.agenda.domain.service;

import com.jan1ooo.agenda.domain.dto.AgendaDto;
import com.jan1ooo.agenda.domain.dto.PacienteDto;
import com.jan1ooo.agenda.domain.dto.mapper.AgendaMapper;
import com.jan1ooo.agenda.domain.dto.request.AgendaRequest;
import com.jan1ooo.agenda.domain.repository.AgendaRepository;
import com.jan1ooo.agenda.exception.BusinessException;
import com.jan1ooo.agenda.exception.RecordNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
@RequiredArgsConstructor
public class AgendaService {
    private final AgendaRepository repository;
    private final PacienteService service;
    private final AgendaMapper mapper;

    public List<AgendaDto> findAll(){
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public AgendaDto findById(@Positive Long id){
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }

    public AgendaDto save(@Valid AgendaRequest agendaRequest){
        return mapper.requestToDto(agendaRequest);
    }

}
