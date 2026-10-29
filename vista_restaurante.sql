-- Banco do sistema Restaurante Vista
-- Rode este arquivo inteiro no MySQL Workbench (raio ⚡) ou no terminal:
--   mysql -u root -p < vista_restaurante.sql

CREATE DATABASE IF NOT EXISTS vista_restaurante
  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE vista_restaurante;

-- Pratos do cardápio
CREATE TABLE IF NOT EXISTS cardapio (
  id_cardapio INT AUTO_INCREMENT PRIMARY KEY,
  nom_prato   VARCHAR(100)  NOT NULL,
  prec_prato  DECIMAL(10,2) NOT NULL
);

-- Comandas (uma por mesa)
CREATE TABLE IF NOT EXISTS comanda (
  id_comanda INT AUTO_INCREMENT PRIMARY KEY,
  status     VARCHAR(30) NOT NULL,
  num_mesa   INT         NOT NULL
);

-- Itens pedidos em cada comanda
CREATE TABLE IF NOT EXISTS pedido (
  id_pedido   INT AUTO_INCREMENT PRIMARY KEY,
  prato       VARCHAR(100)  NOT NULL,
  quantidade  INT           NOT NULL,
  observacao  VARCHAR(255),
  valor       DECIMAL(10,2) NOT NULL,
  id_comanda  INT           NOT NULL,
  id_cardapio INT           NOT NULL
);

-- Pratos de exemplo (troque à vontade)
INSERT INTO cardapio (nom_prato, prec_prato) VALUES
  ('Filé à parmegiana',        68.90),
  ('Risoto de cogumelos',      59.00),
  ('Salmão grelhado',          74.50),
  ('Picanha na chapa',         89.90),
  ('Spaghetti à carbonara',    52.00),
  ('Salada Caesar',            38.00),
  ('Petit gâteau',             29.90),
  ('Suco natural',             12.00),
  ('Refrigerante lata',         8.00),
  ('Água mineral',              6.00);
