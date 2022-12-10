/* CRIANDO TABELAS */

CREATE TABLE usuarios(
    id      SERIAL PRIMARY KEY,
    nome        VARCHAR(50) NOT NULL,
    email       VARCHAR(50) UNIQUE,
    senha       VARCHAR(50) NOT NULL,
    data_nascimento     DATE NOT NULL,
    administrador     BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE requisitos(
    id     SERIAL PRIMARY KEY,
    sistema_op      VARCHAR(20) NOT NULL,
    ram             DECIMAL(3,2) NOT NULL,
    armazenamento   DECIMAL(3,2) NOT NULL
);

CREATE TABLE generos(
    id      SERIAL PRIMARY KEY,
    nome    VARCHAR(50) NOT NULL
);

CREATE TABLE classificacoes(
    id      SERIAL PRIMARY KEY,
    idade_minima    INT NOT NULL
);

CREATE TABLE jogos(
    id      SERIAL PRIMARY KEY,
    nome    VARCHAR(50) NOT NULL,
    preco   DECIMAL(3,2) NOT NULL,
    desconto   DECIMAL(3,2) NOT NULL,
    descricao   VARCHAR(200) NOT NULL,
    data_lancamento DATE NOT NULL,
    id_requisito    INT NOT NULL,
    desenvolvedora  VARCHAR(50) NOT NULL,
    distribuidora   VARCHAR(50) NOT NULL,
    id_classificacao    INT NOT NULL,
    FOREIGN KEY (id_requisito) REFERENCES requisitos(id),
    FOREIGN KEY (id_classificacao) REFERENCES classificacoes(id)
);


CREATE TABLE jogos_generos(
    id_jogo     INT NOT NULL,
    id_genero   INT NOT NULL,
    FOREIGN KEY (id_jogo) REFERENCES jogos(id),
    FOREIGN KEY (id_genero) REFERENCES generos(id)
);

CREATE TABLE usuarios_jogos(
    id_usuario  INT NOT NULL,
    id_jogo     INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_jogo) REFERENCES jogos(id)
);

/* INSERINDO DADOS*/

INSERT INTO classificacoes(idade_minima) 
VALUES (0), (10), (12), (14), (16), (18);




