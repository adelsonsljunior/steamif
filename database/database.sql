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
    preco               NUMERIC NOT NULL,
    desconto            NUMERIC NOT NULL,
    desenvolvedora      VARCHAR(50) NOT NULL,
    distribuidora       VARCHAR(50) NOT NULL,
    genero              VARCHAR(50) NOT NULL,
    classificacao       INT NOT NULL
);


CREATE TABLE jogos_usuarios(
    id_usuario  INT NOT NULL,
    id_jogo     INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_jogo) REFERENCES jogos(id)
);

/*Inserindio dados no banco*/

/*USUARIOS ADMS*/
INSERT INTO usuarios (nome, email, senha, administrador) 
VALUES ('Adelson', 'adelson@ifal.com', '12345', TRUE),
    ('Felipe', 'felipe@ifal.com','12345', TRUE),
    ('Cayo', 'cayo@ifal.com', '12345', TRUE);

/*JOGOS*/

INSERT INTO jogos (nome, preco, desconto, desenvolvedora, distribuidora, classificacao, genero)
VALUES ('Elder Ring', 100, 0, 'FROMSOFTWARE', 'XBOX', 16, 'RPG'),
    ('Naruto Shippuden', 100, 0, 'CYBERCONECT2', 'PLAYSTATION', 14, 'AÇÃO'),
    ('Cuphead', 100, 0, 'STUDIO MHDR', 'XBOX', 16, 'PLATAFORMA'),
    ('The Witcher', 100, 0, 'CD PROJECT', 'PLAYSTATION', 18, 'RPG'),
    ('Hollow Knight', 100, 0, 'TEAM CHERRY', 'PLAYSTATION', 18, 'PLATAFORMA'),
    ('God of War', 100, 0, 'SANTA MONICA', 'PLAYSTATION', 18, 'RPG');


INSERT INTO usuarios_jogos (id_usuario, id_jogo)
VALUES (1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (1, 5),
    (1, 6);

