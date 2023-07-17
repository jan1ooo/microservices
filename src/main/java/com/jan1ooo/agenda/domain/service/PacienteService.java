package com.jan1ooo.agenda.domain.service;

import com.jan1ooo.agenda.domain.entity.Paciente;
import com.jan1ooo.agenda.domain.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return repository.save(paciente);
    }

    public Paciente findById(Long id){
        return repository.findById(id).get();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
