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
}
