package com.jan1ooo.agenda.domain.service;

import com.jan1ooo.agenda.domain.dto.AgendaDto;
import com.jan1ooo.agenda.domain.dto.PacienteDto;
import com.jan1ooo.agenda.domain.dto.mapper.AgendaMapper;
import com.jan1ooo.agenda.domain.repository.AgendaRepository;
import com.jan1ooo.agenda.exception.BusinessException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AgendaService {
    private final AgendaRepository repository;
    private final PacienteService service;
    private final AgendaMapper mapper;

    public List<AgendaDto> findAll(){
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public AgendaDto findById(@Positive Long id){
        return mapper.toDto(repository.findById(id).get());
    }

    public AgendaDto save(@Valid AgendaDto agendaDto){
        Optional<PacienteDto> optPaciente = Optional.ofNullable(service.findById(agendaDto.getPaciente().getId_paciente()));
        if(optPaciente.isEmpty()){
            throw new BusinessException("Paciente não encontrado");
        }

        Optional<AgendaDto> optHorario = Optional.ofNullable(repository.findByHorario(agendaDto.getHorario()));
        if(optHorario.isPresent()){
            throw new BusinessException("Já existe agendamento para este horario");
        }

        agendaDto.setPaciente(optPaciente.get());
        agendaDto.setDataCriacao(LocalDateTime.now());
        return mapper.toDto(repository.save(mapper.toEntity(agendaDto)));
    }

}
