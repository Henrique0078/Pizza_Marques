# Relatório de Parâmetros da API

Neste documento, descrevemos os principais endpoints da API, seus métodos HTTP e os parâmetros necessários para realizar operações relacionadas à "Autenticação" e "Pedido".
</br>No final do Relatório consta o Banco de dados necessario para o funcionamento da API

## Autenticação

### Registrar Usuario

- **Método:** POST
- **URL:** `http://localhost:9090/authentication/registerUsuario`

**Parâmetros:**

```json
{
    "emailUsuario": "Henrique",
    "senha_usuario": "123"
}
```

### Registrar Cliente
- **Método:** POST
- **URL:** `http://localhost:9090/authentication/registerCliente`

**Parâmetros:**

```json
{
    "nm_cliente": "Henrique",
    "cpfCliente": "50",
    "logradouro_cliente": "rua",
    "complemento_cliente": "opa",
    "estado_cliente": "sp",
    "cidade_cliente": "sp",
    "numero_casa_cliente": "50",
    "id_usuario_cliente": 1
}
```

### SignIn
- **Método:** GET
- **URL:** `http://localhost:9090/authentication/signIn`

**Parâmetros:**

```json
{
    "emailUsuario": "Henrique",
    "senha_usuario": "123"
}
```

## Pedido

### Fazer Pedido
- **Método:** POST
- **URL:** `http://localhost:9090/pedido/fazerPedido`

**Parâmetros:**

```json
{
    "id_cliente_pedido": 1,
    "status_pedido": "Realizado"
}
```

### Fazer Pedido de Pizza
- **Método:** POST
- **URL:** `http://localhost:9090/pedido/fazerPedidoPizza`

**Parâmetros:**

```json
[
    {
        "idPedido": 1,
        "quantidade_pedido_pizza": 1,
        "valor_total_pedido_pizza": 0.0,
        "tamanho_pedido_pizza": "Grande",
        "idPizza": 1
    },
    {
        "idPedido": 1,
        "quantidade_pedido_pizza": 3,
        "valor_total_pedido_pizza": 0.0,
        "tamanho_pedido_pizza": "Grande",
        "idPizza": 2
    }
]
```

### Fazer Pedido de Bebida
- **Método:** POST
- **URL:** `http://localhost:9090/pedido/fazerPedidoBebida`

**Parâmetros:**

```json
[
    {
        "idPedido": 1,
        "quantidade_pedido_bebida": 10,
        "valor_total_pedido_bebida": 0.0,
        "idBebida": 1
    },
    {
        "idPedido": 1,
        "quantidade_pedido_bebida": 5,
        "valor_total_pedido_bebida": 0.0,
        "idBebida": 2
    }
]
```

### Cancelar Pedido
- **Método:** PUT
- **URL:** `http://localhost:9090/pedido/cancelarPedido/{id}`

**Parâmetros:**

```json
O ID do pedido deve ser fornecido como parte da URL.
```

### Listar Pedido
- **Método:** GET
- **URL:** `http://localhost:9090/pedido/listarPedido/{id}`

**Parâmetros:**

```json
O ID do pedido deve ser fornecido como parte da URL.
```

### Listar Pedido de Bebida
- **Método:** GET
- **URL:** `http://localhost:9090/pedido/listarPedidoBebida/{id}`

**Parâmetros:**

```json
O ID do pedido deve ser fornecido como parte da URL.
```

### Listar Pedido de Pizza
- **Método:** GET
- **URL:** `http://localhost:9090/pedido/listarPedidoPizza/{id}`

**Parâmetros:**

```json
O ID do pedido deve ser fornecido como parte da URL.
```

Este relatório fornece detalhes sobre como utilizar a API, incluindo os métodos HTTP e os parâmetros necessários para cada operação. Lembre-se de substituir os valores fictícios nos exemplos de parâmetros pelos dados reais ao usar a API.

**Banco de dados:**
```Banco de dados
-- MySQL Script generated by MySQL Workbench
-- Tue Oct 17 20:03:07 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `email_usuario` VARCHAR(45) NOT NULL,
  `senha_usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nm_cliente` VARCHAR(45) NOT NULL,
  `cpf_cliente` VARCHAR(11) NOT NULL,
  `logradouro_cliente` VARCHAR(45) NOT NULL,
  `complemento_cliente` VARCHAR(45) NULL,
  `estado_cliente` VARCHAR(32) NOT NULL,
  `cidade_cliente` VARCHAR(45) NOT NULL,
  `numero_casa_cliente` VARCHAR(6) NOT NULL,
  `id_usuario_cliente` INT NOT NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `fk_id_usuario_idx` (`id_usuario_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_id_usuario`
    FOREIGN KEY (`id_usuario_cliente`)
    REFERENCES `mydb`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pedido` (
  `id_pedido` INT NOT NULL AUTO_INCREMENT,
  `id_cliente_pedido` INT NOT NULL,
  `data_pedido` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status_pedido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_pedido`),
  INDEX `fk_cliente_id_idx` (`id_cliente_pedido` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_id`
    FOREIGN KEY (`id_cliente_pedido`)
    REFERENCES `mydb`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pizza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pizza` (
  `id_pizza` INT NOT NULL AUTO_INCREMENT,
  `desc_pizza` VARCHAR(45) NOT NULL,
  `preco_unitario_pizza` FLOAT NOT NULL,
  PRIMARY KEY (`id_pizza`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`bebida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`bebida` (
  `id_bebida` INT NOT NULL AUTO_INCREMENT,
  `desc_bebida` VARCHAR(45) NOT NULL,
  `preco_unitario_bebida` FLOAT NOT NULL,
  PRIMARY KEY (`id_bebida`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pedido_pizza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pedido_pizza` (
  `id_pedido_pizza` INT NOT NULL AUTO_INCREMENT,
  `quantidade_pedido_pizza` INT NOT NULL,
  `valor_total_pedido_pizza` FLOAT NOT NULL,
  `tamanho_pedido_pizza` VARCHAR(8) NOT NULL,
  `id_pedido_pz` INT NOT NULL,
  `id_pizza_ped_pz` INT NOT NULL,
  PRIMARY KEY (`id_pedido_pizza`),
  INDEX `fk_id_pizza_idx` (`id_pizza_ped_pz` ASC) VISIBLE,
  INDEX `fk_id_pedido_idx` (`id_pedido_pz` ASC) VISIBLE,
  CONSTRAINT `fk_id_pizza`
    FOREIGN KEY (`id_pizza_ped_pz`)
    REFERENCES `mydb`.`pizza` (`id_pizza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_pedido_pz`
    FOREIGN KEY (`id_pedido_pz`)
    REFERENCES `mydb`.`pedido` (`id_pedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pedido_bebida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pedido_bebida` (
  `id_pedido_bebida` INT NOT NULL AUTO_INCREMENT,
  `quantidade_pedido_bebida` INT NOT NULL,
  `valor_total_pedido_bebida` FLOAT NOT NULL,
  `id_pedido_bb` INT NOT NULL,
  `id_bebida_ped_bb` INT NOT NULL,
  PRIMARY KEY (`id_pedido_bebida`),
  INDEX `fk_id_pedido_idx` (`id_pedido_bb` ASC) VISIBLE,
  INDEX `fk_id_bebida_idx` (`id_bebida_ped_bb` ASC) VISIBLE,
  CONSTRAINT `fk_id_pedido_bb`
    FOREIGN KEY (`id_pedido_bb`)
    REFERENCES `mydb`.`pedido` (`id_pedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_bebida`
    FOREIGN KEY (`id_bebida_ped_bb`)
    REFERENCES `mydb`.`bebida` (`id_bebida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

```
