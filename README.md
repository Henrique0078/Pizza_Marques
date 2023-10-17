# Pizza_Marques
Relatório de Parâmetros da API

A seguir, apresento um relatório que descreve os parâmetros das principais operações disponíveis na API, divididas em dois grupos: "Autenticação" e "Pedido". Cada operação inclui o método HTTP, a URL e os parâmetros relevantes em JSON quando aplicável.

Autenticação
RegistrarUsuario
Método: POST
URL: http://localhost:9090/authentication/registerUsuario
Parâmetros:

json
Copy code
{
    "emailUsuario": "Henrique",
    "senha_usuario": "123"
}
RegistrarCliente
Método: POST
URL: http://localhost:9090/authentication/registerCliente
Parâmetros:

json
Copy code
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
SignIn
Método: GET
URL: http://localhost:9090/authentication/signIn
Parâmetros:

json
Copy code
{
    "emailUsuario": "Henrique",
    "senha_usuario": "123"
}
Pedido
FazerPedido
Método: POST
URL: http://localhost:9090/pedido/fazerPedido
Parâmetros:

json
Copy code
{
    "id_cliente_pedido": 1,
    "status_pedido": "Realizado"
}
FazerPedidoPizza
Método: POST
URL: http://localhost:9090/pedido/fazerPedidoPizza
Parâmetros:

json
Copy code
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
FazerPedidoBebida
Método: POST
URL: http://localhost:9090/pedido/fazerPedidoBebida
Parâmetros:

json
Copy code
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
CancelarPedido
Método: PUT
URL: http://localhost:9090/pedido/cancelarPedido/{id}
Parâmetros:

O ID do pedido deve ser fornecido como parte da URL.
ListarPedido
Método: GET
URL: http://localhost:9090/pedido/listarPedido/{id}
Parâmetros:

O ID do pedido deve ser fornecido como parte da URL.
ListarPedidoBebida
Método: GET
URL: http://localhost:9090/pedido/listarPedidoBebida/{id}
Parâmetros:

O ID do pedido deve ser fornecido como parte da URL.
ListarPedidoPizza
Método: GET
URL: http://localhost:9090/pedido/listarPedidoPizza/{id}
Parâmetros:

O ID do pedido deve ser fornecido como parte da URL.
Este relatório descreve os principais endpoints da API, seus métodos HTTP e os parâmetros necessários para realizar operações de autenticação e pedidos. Certifique-se de substituir os valores fictícios nos exemplos de parâmetros pelos dados reais ao usar a API.
