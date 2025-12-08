CREATE TABLE tb_comunicacao (
        id BIGSERIAL PRIMARY KEY,
        email_destinatario VARCHAR(255),
        tel_destinatario VARCHAR(50),
        mensagem TEXT,
        data_hora_envio TIMESTAMP NOT NULL,
        data_hora_agendamento TIMESTAMP NOT NULL,
        data_hora_modificacao TIMESTAMP NOT NULL,
        status VARCHAR(50) NOT NULL
)