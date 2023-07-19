package com.jan1ooo.agenda.api.controller;

import com.jan1ooo.agenda.domain.dto.AgendaDto;
import com.jan1ooo.agenda.domain.service.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/agenda")
public class AgendaController {
    private final AgendaService service;

    @GetMapping
    public ResponseEntity<List<AgendaDto>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendaDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<AgendaDto> create(@RequestBody AgendaDto agenda){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(agenda));
    }
}
