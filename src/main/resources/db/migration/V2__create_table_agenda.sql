CREATE TABLE agenda(
    id_agenda SERIAL PRIMARY KEY,
    descricao VARCHAR(255),
    data_hora TIMESTAMP UNIQUE,
    data_criacao TIMESTAMP,
    paciente_id INTEGER NOT NULL,
    CONSTRAINT fk_agenda_paciente FOREIGN KEY (paciente_id) REFERENCES paciente(id_paciente)
);