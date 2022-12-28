/* CRIANDO TABELAS */

CREATE TABLE usuarios(
    id                SERIAL PRIMARY KEY,
    nome              VARCHAR(50) NOT NULL,
    email             VARCHAR(50) UNIQUE,
    senha             VARCHAR(50) NOT NULL,
    administrador     BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE jogos(
    id                  SERIAL PRIMARY KEY,
    nome                VARCHAR(50) NOT NULL,
    preco               DECIMAL(3,2) NOT NULL,
    desconto            DECIMAL(3,2) NOT NULL,
    desenvolvedora      VARCHAR(50) NOT NULL,
    distribuidora       VARCHAR(50) NOT NULL,
    classificacao       INT NOT NULL
);


CREATE TABLE usuarios_jogos(
    id_usuario  INT NOT NULL,
    id_jogo     INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_jogo) REFERENCES jogos(id)
);
