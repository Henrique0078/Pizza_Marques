# Relatório de Parâmetros da API

Neste documento, descrevemos os principais endpoints da API, seus métodos HTTP e os parâmetros necessários para realizar operações relacionadas à "Autenticação" e "Pedido".

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
