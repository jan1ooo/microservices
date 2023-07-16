CREATE TABLE paciente (
    id_paciente SERIAL PRIMARY KEY,
    nome VARCHAR(50),
    sobrenome VARCHAR(100),
    cpf VARChAR(15),
    email VARCHAR(100)
);