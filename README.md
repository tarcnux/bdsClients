# bdsClients
CRUD completo de web services REST para acessar um recurso de clientes.
Projeto apresentado ao final do 1º capítulo do BootCamp DevSuperior.

 - Busca paginada de recursos 
 - Busca de recurso por id 
 - Inserir novo recurso 
 - Atualizar recurso 
 - Deletar recurso
 
O CRUD usa um ambiente de testes (manual) configurado acessando o **banco de dados H2**, usa **Maven** como gerenciador de dependência, e **Java 11** como linguagem.
    
##  :dizzy: Como Executar

- ### **Pré-requisitos**

  - É **necessário** possuir o **[Java 11](https://www.java.com/)** e **[Spring Boot](https://spring.io/)** instalados no computador.
  - É **necessário** possuir o **[Git](https://git-scm.com/)** instalado e configurado no computador.
  - É **recomendável** utilizar **[IDE Eclipse com Spring Tools Suite 4](https://spring.io/tools)** .
 

1. Faça um clone do repositório:

```sh
  #  Crie um novo Workspace, uma pasta chamada: ws-github-teste
  $ md ws-github-workspace
  $ cd ws-github-workspace
  $ git clone https://github.com/tarcnux/bdsClients.git
```

2. Executando a Aplicação:

```

  #  Abra o Spring Tool Suite (STS)
  #  Selecione o Workspace: ws-github-workspace
  #  Import projects - Maven - Existing Maven Projects
  #  Root Directory: bdsClients
  #  Clicar com o botão direito em src/main/java
  #  Procurar por "Run As" e ir na opção "5 Spring Boot App"

```
[![Run in Postman](https://run.pstmn.io/button.svg)](https://god.postman.co/run-collection/47964252a765c6979f48)

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

## :memo: Licença

Esse projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---
<sub>Projeto desenvolvido com a tutoria de [Nelio Alves](https://github.com/acenelio) da [DevSuperior](https://github.com/devsuperior).</sub>
