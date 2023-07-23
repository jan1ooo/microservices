package com.jan1ooo.agenda.domain.entity.mapper;

import com.jan1ooo.agenda.domain.entity.paciente.PacienteDto;
import com.jan1ooo.agenda.domain.entity.paciente.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public Paciente toEntity(PacienteDto pacienteDto){
        if(pacienteDto == null){
            return null;
        }

        Paciente paciente = new Paciente();
        if(pacienteDto.getId_paciente() != null){
            paciente.setId_paciente(pacienteDto.getId_paciente());
        }
        paciente.setNome(pacienteDto.getNome());
        paciente.setSobrenome(pacienteDto.getSobrenome());
        paciente.setCpf(pacienteDto.getCpf());
        paciente.setEmail(pacienteDto.getEmail());
        return paciente;
    }

    public PacienteDto toDto(Paciente paciente){
        if(paciente == null){
            return null;
        }

        return new PacienteDto(paciente.getId_paciente(), paciente.getNome(), paciente.getSobrenome(), paciente.getCpf(), paciente.getEmail());
    }
}
