
# bdsClients
CRUD completo de web services REST para acessar um recurso de clientes.
Projeto apresentado ao final do 1º capítulo do BootCamp DevSuperior.

 - Busca paginada de recursos 
 - Busca de recurso por id 
 - Inserir novo recurso 
 - Atualizar recurso 
 - Deletar recurso
 
O usa um ambiente de testes (manual) configurado acessando o **banco de dados H2**, usa **Maven** como gerenciador de dependência, e **Java 11** como linguagem.

#### Busca paginada de clientes
    GET /clients?page=0&linesPerPage=6&direction=ASC&orderBy=name

#### Busca de cliente por id
    GET /clients/1

#### Inserção de novo cliente

    POST /clients
    {
	    "name": "Maria Silva",
	    "cpf": "12345678901",
	    "income": 6500.0,
	    "birthDate": "1994-07-20T10:30:00Z",
	    "children": 2
    }

#### Atualização de cliente

    PUT /clients/1
    {
	    "name": "Maria Silvaaa",
	    "cpf": "12345678901",
	    "income": 6500.0,
	    "birthDate": "1994-07-20T10:30:00Z",
	    "children": 2
    }

#### Deleção de cliente

    DELETE /clients/1
