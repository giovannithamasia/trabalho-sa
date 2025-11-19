-- ===========================================
-- MySQL 5.7+ / 8.0
-- Banco: epi_db
-- Tabelas: colaborador, epi, emprestimo
-- Campos ENUM substituídos por VARCHAR
-- ===========================================

CREATE DATABASE IF NOT EXISTS epi_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;
USE epi_db;

-- ---------------------------
-- Tabela: colaborador
-- ---------------------------
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

-- ---------------------------
-- Tabela: epi
-- ---------------------------
CREATE TABLE epi (
  id_epi     BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nome_epi   VARCHAR(120) NOT NULL,
  tipo_epi   VARCHAR(80)  NOT NULL,   -- ex.: capacete, luva, bota
  descricao  VARCHAR(255) NULL,
  tamanho    VARCHAR(20)  NULL,       -- ex.: P, M, G, 38, 39
  validade   DATE         NULL,
  situacao   VARCHAR(20)  NOT NULL DEFAULT 'ATIVO',  -- substitui ENUM
  PRIMARY KEY (id_epi)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_unicode_ci;

-- ---------------------------
-- Tabela: emprestimo
-- ---------------------------
CREATE TABLE emprestimo (
  id_emprestimo           BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  id_colaborador          BIGINT UNSIGNED NOT NULL,
  id_epi                  BIGINT UNSIGNED NOT NULL,
  data_emprestimo         DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  data_prevista_devolucao DATE     NULL,
  data_devolucao          DATETIME NULL,
  status                  VARCHAR(20) NOT NULL DEFAULT 'EMPRESTADO',  -- substitui ENUM
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
