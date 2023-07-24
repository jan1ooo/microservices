package com.jan1ooo.agenda.controller;

import com.jan1ooo.agenda.domain.entity.paciente.PacienteDto;
import com.jan1ooo.agenda.domain.service.PacienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Tag(name = "Paciente", description = "API Paciente")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/paciente")
public class PacienteController {

    private final PacienteService service;

    @PostMapping
    public ResponseEntity<PacienteDto> save(@RequestBody PacienteDto paciente){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(paciente));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDto> update(@PathVariable Long id, @RequestBody PacienteDto paciente){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.update(id, paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
