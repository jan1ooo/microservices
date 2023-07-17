package com.jan1ooo.agenda.api.controller;

import com.jan1ooo.agenda.domain.entity.Paciente;
import com.jan1ooo.agenda.domain.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/paciente")
public class PacienteController {

    private final PacienteService service;

    @PostMapping
    public ResponseEntity<Paciente> save(@RequestBody Paciente paciente){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(paciente));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update(@PathVariable Long id, @RequestBody Paciente paciente){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.update(id, paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
