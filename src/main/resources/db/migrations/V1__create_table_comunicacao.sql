CREATE TABLE tb_comunicacao (
        id BIGSERIAL PRIMARY KEY,
        data TIMESTAMP NOT NULL,
        tipo_de_mensagem VARCHAR(50) NOT NULL,
        email_destinatario VARCHAR(255),
        tel_destinatario VARCHAR(50),
        mensagem TEXT,
        status VARCHAR(50) NOT NULL
)