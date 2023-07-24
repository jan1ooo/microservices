package com.jan1ooo.agenda.domain.service;

import com.jan1ooo.agenda.domain.entity.agenda.AgendaDto;
import com.jan1ooo.agenda.domain.entity.mapper.AgendaMapper;
import com.jan1ooo.agenda.domain.entity.request.AgendaRequest;
import com.jan1ooo.agenda.domain.repository.AgendaRepository;
import com.jan1ooo.agenda.exception.BusinessException;
import com.jan1ooo.agenda.exception.RecordNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

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
        try {
            Long id = agendaRequest.getPaciente();

            if (service.findById(id) == null) {
                throw new BusinessException("Não existe este paciente");
            }
            agendaRequest.setDataCriacao(LocalDateTime.now());
            return mapper.toDto(repository.save(mapper.toEntity(mapper.requestToDto(agendaRequest))));
        }
        catch (DataIntegrityViolationException e){
            throw new BusinessException("Já existe agendamento neste horário");
        }
        catch (InvalidDataAccessApiUsageException e){
            throw new BusinessException("ID do paciente é Obrigatório");
        }
        catch (ConstraintViolationException e){
            throw new BusinessException("Data de agendamento precisa ser futura");
        }
    }

}
