package com.jan1ooo.agenda.domain.dto.mapper;

import com.jan1ooo.agenda.domain.dto.AgendaDto;
import com.jan1ooo.agenda.domain.dto.PacienteDto;
import com.jan1ooo.agenda.domain.dto.request.AgendaRequest;
import com.jan1ooo.agenda.domain.entity.Agenda;
import com.jan1ooo.agenda.domain.entity.Paciente;
import com.jan1ooo.agenda.domain.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AgendaMapper {
    private final PacienteMapper mapper;
    private final PacienteRepository repository;

    public Agenda toEntity(AgendaDto agendaDto){
        if(agendaDto == null){
            return null;
        }
        Agenda agenda = new Agenda();
        if(agendaDto.getId_agenda() != null){
            agenda.setId_agenda(agenda.getId_agenda());
        }
        agenda.setDescricao(agendaDto.getDescricao());
        agenda.setHorario(agendaDto.getHorario());
        agenda.setDataCriacao(agendaDto.getDataCriacao());
        agenda.setPaciente(mapper.toEntity(agendaDto.getPaciente()));
        return agenda;
    }

    public AgendaDto toDto(Agenda agenda){
        if(agenda == null){
            return null;
        }
        return new AgendaDto(agenda.getId_agenda(), agenda.getDescricao(), agenda.getHorario(), agenda.getDataCriacao(), mapper.toDto(agenda.getPaciente()));
    }

    public AgendaDto requestToDto(AgendaRequest agendaRequest){
        if(agendaRequest == null){
            return null;
        }

        PacienteDto pat = mapper.toDto(repository.findById(agendaRequest.getPaciente()).get());

        return new AgendaDto(
                agendaRequest.getId_agenda(),
                agendaRequest.getDescricao(),
                agendaRequest.getHorario(),
                agendaRequest.getDataCriacao(),
                pat);
    }
}
