package com.jan1ooo.agenda.domain.service;

import com.jan1ooo.agenda.domain.entity.paciente.PacienteDto;
import com.jan1ooo.agenda.domain.entity.mapper.PacienteMapper;
import com.jan1ooo.agenda.domain.repository.PacienteRepository;
import com.jan1ooo.agenda.exception.BusinessException;
import com.jan1ooo.agenda.exception.RecordNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PacienteService {

    @Autowired
    private final PacienteRepository repository;

    @Autowired
    private final PacienteMapper mapper;

    public List<PacienteDto> findAll(){
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public PacienteDto save(@Valid @NotNull PacienteDto paciente){
        boolean existeCpf = false;

        Optional<PacienteDto> optPaciente = Optional.ofNullable(mapper.toDto(repository.findByCpf(paciente.getCpf())));

        try{
            if (optPaciente.isPresent()) {
                if (!optPaciente.get().getId_paciente().equals(paciente.getId_paciente())) {
                    existeCpf = true;
                }
            }
            if (existeCpf) {
                throw new BusinessException("Cpf já cadastrado!");
            }

            if(paciente.getNome() == null || paciente.getSobrenome() == null) {
                throw new BusinessException("Faltando informação");
            }
            return mapper.toDto(repository.save(mapper.toEntity(paciente)));
        }
        catch (ConstraintViolationException e){
            throw new BusinessException("CPF ou Email Inválido");
        }
    }

    public PacienteDto findById(Long id){
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }

    public PacienteDto update(Long id, PacienteDto paciente){
        return repository.findById(id)
                .map(recordFound -> {
                    recordFound.setNome(paciente.getNome());
                    recordFound.setSobrenome(paciente.getSobrenome());
                    recordFound.setEmail(paciente.getEmail());
                    return mapper.toDto(repository.save(recordFound));
                })
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(Long id){
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
