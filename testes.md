# Testes no POSTMAN

#### Cadastrar clientes
[X] POST: http://localhost:8080/cliente 

{
    "nome": "",
    "cpf": "",
    "rg": "",
    "email": ""
}

#

#### Cadastrar pedidos
[X] POST: http://localhost:8080/pedido

{
    "data_emissao": "",
    "status_pedido": "",
    "valor_total": ,
    "fk_cliente": 
}

#

#### Cadastrar funcionários e autorização
[X] POST: http://localhost:8080/funcionario

{
    "matricula": ,
    "nome": "",
    "cpf": "",
    "rg": "",
    "salario": "",
    "data_nascimento": "",
    "email": "",
    "senha": "",
    "habilitado": 1
}

[X] POST/PUT: http://localhost:8080/autorizacao/**MATRICULA**
{
    "authority": "ROLE_",
}

#

#### Demitir funcionários
[X] DELETE: http://localhost:8080/funcionario/**MATRICULA**

#

#### Reajustar salário
[X] PUT: http://localhost:8080/funcionario/**MATRICULA**

{
    "salario": 
}