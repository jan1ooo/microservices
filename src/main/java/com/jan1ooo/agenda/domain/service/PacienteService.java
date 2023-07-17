package com.jan1ooo.agenda.domain.service;

import com.jan1ooo.agenda.domain.entity.Paciente;
import com.jan1ooo.agenda.domain.repository.PacienteRepository;
import com.jan1ooo.agenda.exception.BusinessException;
import com.jan1ooo.agenda.exception.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PacienteService {

    @Autowired
    private final PacienteRepository repository;

    public List<Paciente> findAll(){
        return repository.findAll();
    }

    public Paciente save(Paciente paciente){
        boolean existeCpf = false;

        Optional<Paciente> optPaciente = repository.findByCpf(paciente.getCpf());

        if (optPaciente.isPresent()) {
            if (!optPaciente.get().getId_paciente().equals(paciente.getId_paciente())) {
                existeCpf = true;
            }
        }
        if (existeCpf) {
            throw new BusinessException("Cpf já cadastrado!");
        }
        return repository.save(paciente);
    }

    public Paciente findById(Long id){
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Paciente update(Long id, Paciente paciente){
        return repository.findById(id)
                .map(recordFound -> {
                    recordFound.setNome(paciente.getNome());
                    recordFound.setSobrenome(paciente.getSobrenome());
                    recordFound.setEmail(paciente.getEmail());
                    return repository.save(recordFound);
                })
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(Long id){
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
