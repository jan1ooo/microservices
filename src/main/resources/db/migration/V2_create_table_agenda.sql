CREATE TABLE agenda(
    id_agenda SERIAL PRIMARY KEY,
    descricao VARCHAR(255),
    data_hora TIMESTAMP,
    data_criacao TIMESTAMP,
    paciente_id INTEGER,
    CONSTRAINT fk_agenda_paciente FOREIGN KEY (paciente_id) REFERENCES paciente(id_paciente)
);