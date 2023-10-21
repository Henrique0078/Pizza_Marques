# Como iniciar a API
Para iniciar a API voce deve fazer o clone dela em sua maquina e então criar o banco de dados disponivel abaixo.</br>
Após criar o banco de dados, entre no codigo da API e no seguinte arquivo: `src\main\resources\application.properties` </br>
Voce deve alterar o usuario, senha e caso tenha configurado outra porta para o banco de dados trocar a porta na url tambem.</br>
</br>Caso apareça algum erro após iniciar a API configurada, tente alterar o parametro `server.port` e inicie novamente.


# Relatório de Parâmetros da API

Neste documento, descrevemos os principais endpoints da API, seus métodos HTTP e os parâmetros necessários para realizar operações relacionadas à "Autenticação" e "Pedido".
</br>No final do Relatório consta o Banco de dados necessario para o funcionamento da API

<h2>Sumário</h2>
<ul>
    <li><a href="https://github.com/Henrique0078/Pizza_Marques/tree/main#autenticação">Autenticação</a></li>
    <ul>
        <li><a href="https://github.com/Henrique0078/Pizza_Marques/blob/main/README.md#registrar-usuario">Registrar Usuário</a></li>
        <li><a href="https://github.com/Henrique0078/Pizza_Marques/blob/main/README.md#registrar-cliente">Registrar Cliente</a></li>
        <li><a href="https://github.com/Henrique0078/Pizza_Marques/blob/main/README.md#signin">SignIn</a></li>
        <li><a href="https://github.com/Henrique0078/Pizza_Marques/blob/main/README.md#salterar-cliente">Alterar Cliente</a></li>
    </ul>
    <li><a href="https://github.com/Henrique0078/Pizza_Marques/blob/main/README.md#pedido">Pedido</a></li>
    <ul>
        <li><a href="https://github.com/Henrique0078/Pizza_Marques/blob/main/README.md#fazer-pedido">Fazer Pedido</a></li>
        <li><a href="https://github.com/Henrique0078/Pizza_Marques/blob/main/README.md#cancelar-pedido">Cancelar Pedido</a></li>
        <li><a href="https://github.com/Henrique0078/Pizza_Marques/blob/main/README.md#listar-pedido">Listar Pedido</a></li>
    </ul>
    <li><a href="https://github.com/Henrique0078/Pizza_Marques/blob/main/README.md#banco-de-dados">Banco de Dados</a></li>
</ul>


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

### Alterar Cliente
- **Método:** PUT
- **URL:** `http://localhost:9090/authentication/alterarCliente`

**Parâmetros:**

```json
{
  "cpfCliente": "50936978",
  "logradouro_cliente": "Rua da Amostra, 123",
  "complemento_cliente": "Apartamento 456",
  "estado_cliente": "São Paulo",
  "cidade_cliente": "São Paulo",
  "numero_casa_cliente": "123"
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
  "status_pedido": "Em andamento",
  "pedidoBebida": [
    {
      "quantidade_pedido_bebida": 2,
      "tamanho_pedido_bebida": "Médio",
      "idBebida": {
        "id_bebida": 1
      }
    }
  ],
  "pedidoPizza": [
    {
      "quantidade_pedido_pizza": 1,
      "tamanho_pedido_pizza": "Grande",
      "idPizza": {
        "id_pizza": 2
      }
    },
    {
      "quantidade_pedido_pizza": 1,
      "tamanho_pedido_pizza": "Grande",
      "idPizza": {
        "id_pizza": 3
      }
    }
  ]
}

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

Este relatório fornece detalhes sobre como utilizar a API, incluindo os métodos HTTP e os parâmetros necessários para cada operação.
</br>Lembre-se de substituir os valores fictícios nos exemplos de parâmetros pelos dados reais ao usar a API.

## Banco de dados:
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
  `logradouro_cliente` VARCHAR(45) NULL,
  `complemento_cliente` VARCHAR(45) NULL,
  `estado_cliente` VARCHAR(32) NULL,
  `cidade_cliente` VARCHAR(45) NULL,
  `numero_casa_cliente` VARCHAR(6) NULL,
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
  `preco_total_pedido` float NOT NULL,
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

insert into pizza values 
(1, "Pepperoni", 42.99),
(2, "Queijo", 25.99),
(3, "Bacon", 37.99),
(4, "A moda da casa", 37.99),
(5, "Vegetariana", 35.99),
(6, "Marguerita", 33.99),
(7, "Calabresa", 25.99),
(8, "Frango", 40.99),
(9, "4-Queijos", 42.99);

insert into bebidas values
(1, "Refrigerante Lata", 5.90),
(2, "Refrigerante 1.5L", 10.90),
(3, "Refrigerante 2 Litros", 15.90),
(4, "Suco em lata", 5.90),
(5, "Heineken", 10,90),
(6, "Agua", 4.00);

```
