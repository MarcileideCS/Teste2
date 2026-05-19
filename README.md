# Agenda com Spring Boot

API REST simples para gerenciar contatos (agenda) com CRUD completo.

## Tecnologias

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

## Como executar

1. Tenha Java 17+ e Maven instalados.
2. No diretório do projeto, rode:

```bash
mvn spring-boot:run
```

3. A aplicação sobe em:

```text
http://localhost:8080
```

4. Console do H2:

```text
http://localhost:8080/h2-console
```

Use o JDBC URL:

```text
jdbc:h2:mem:agenda
```

## Endpoints

Base URL:

```text
/api/contatos
```

- `GET /api/contatos` lista todos os contatos
- `GET /api/contatos/{id}` busca contato por id
- `POST /api/contatos` cria contato
- `PUT /api/contatos/{id}` atualiza contato
- `DELETE /api/contatos/{id}` remove contato

## Exemplo de JSON

```json
{
	"nome": "Maria Souza",
	"email": "maria@email.com",
	"telefone": "11999999999",
	"observacao": "Colega do trabalho"
}
```