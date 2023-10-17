# Relatório de Parâmetros da API

Neste documento, descrevemos os principais endpoints da API, seus métodos HTTP e os parâmetros necessários para realizar operações relacionadas à "Autenticação" e "Pedido".

## Autenticação

### RegistrarUsuario

- **Método:** POST
- **URL:** `http://localhost:9090/authentication/registerUsuario`

**Parâmetros:**

```json
{
    "emailUsuario": "Henrique",
    "senha_usuario": "123"
}
