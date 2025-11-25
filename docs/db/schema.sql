CREATE DATABASE IF NOT EXISTS epi_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;
USE epi_db;

CREATE TABLE colaborador (
  id_colaborador BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nome           VARCHAR(120) NOT NULL,
  cpf            CHAR(11)     NOT NULL,
  cargo          VARCHAR(80)  NULL,
  setor          VARCHAR(80)  NULL,
  data_admissao  DATE         NULL,
  status_ativo   TINYINT(1)   NOT NULL DEFAULT 1,
  PRIMARY KEY (id_colaborador)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_unicode_ci;

CREATE TABLE epi (
  id_epi     BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nome_epi   VARCHAR(120) NOT NULL,
  tipo_epi   VARCHAR(80)  NOT NULL,
  descricao  VARCHAR(255) NULL,
  tamanho    VARCHAR(20)  NULL,
  validade   DATE         NULL,
  situacao   VARCHAR(20)  NOT NULL DEFAULT 'ATIVO',
  PRIMARY KEY (id_epi)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_unicode_ci;

CREATE TABLE emprestimo (
  id_emprestimo           BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  id_colaborador          BIGINT UNSIGNED NOT NULL,
  id_epi                  BIGINT UNSIGNED NOT NULL,
  data_emprestimo         DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  data_prevista_devolucao DATE     NULL,
  data_devolucao          DATETIME NULL,
  status                  VARCHAR(20) NOT NULL DEFAULT 'EMPRESTADO',
  observacao              VARCHAR(255) NULL,
  PRIMARY KEY (id_emprestimo),

  CONSTRAINT fk_emprestimo_colaborador
    FOREIGN KEY (id_colaborador)
    REFERENCES colaborador (id_colaborador)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,

  CONSTRAINT fk_emprestimo_epi
    FOREIGN KEY (id_epi)
    REFERENCES epi (id_epi)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_unicode_ci;

INSERT INTO colaborador (nome, cpf, cargo, setor, data_admissao, status_ativo)
VALUES
('João Silva', '12345678901', 'Técnico de Segurança', 'Segurança', '2023-05-10', 1),
('Maria Oliveira', '98765432100', 'Auxiliar Operacional', 'Operações', '2022-11-20', 1);

INSERT INTO epi (nome_epi, tipo_epi, descricao, tamanho, validade, situacao)
VALUES
('Capacete de Segurança', 'Capacete', 'Capacete classe B com suspensão interna', 'M', '2026-12-31', 'ATIVO'),
('Luva Anticorte', 'Luva', 'Luva nível 5 resistente a cortes', 'G', '2026-08-15', 'ATIVO');

INSERT INTO emprestimo
(id_colaborador, id_epi, data_emprestimo, data_prevista_devolucao, data_devolucao, status, observacao)
VALUES
(1, 1, NOW(), '2025-12-25', NULL, 'ABERTO', 'Uso em vistoria de segurança'),
(2, 2, NOW(), '2025-12-25', NULL, 'ABERTO', 'Entrega para operação diária');
