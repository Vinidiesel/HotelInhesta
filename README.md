# HotelInhesta
Api para um sistema de hotel.

http://ec2-18-228-11-203.sa-east-1.compute.amazonaws.com:8080

## Tecnologias utilizadas
### Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven

### Implantação em produção
- Back end: AWS EC2
- Banco de dados: AWS RDS

## Requisitos

- Java JDK 11 ou superior
- Maven (ou Gradle) instalado
- MySQL

## Uso

```bash
# clonar repositório
git clone https://github.com/Vinidiesel/HotelInhesta.git

# entrar na pasta do projeto back end
cd HotelInhesta

# entrar na pasta target do projeto
cd target

# executar o projeto com as variáveis do banco de dados
java -Dspring.profiles.active=prod -DDATASOURCE_URL=(URL_DO_MYSQL) -DDATASOURCE_USERNAME=(USER_DO_MYSQL) -DDATASOURCE_PASSWORD=(SENHA_DO_MYSQL) -jar api-0.0.1-SNAPSHOT.jar
```
1. A API estará disponível em: `http://localhost:8080`
2. Acesse a documentação Swagger em: http://localhost:8080/swagger-ui/index.html

## Endpoints

Aqui estão os principais endpoints da API:

| Endpoint                        | Descrição                                   | Método HTTP | Parâmetros                  |
| ------------------------------- | ------------------------------------------- | ----------- | --------------------------- |
| `/api/recurso`                  | Retorna todos os recursos disponíveis      | GET         | Nenhum                      |
| `/api/recurso/{id}`             | Retorna um recurso específico por ID       | GET         | `id` (int)                  |
| `/api/recurso`                  | Cria um novo recurso                        | POST        | Corpo do recurso            |
| `/api/recurso/{id}`             | Atualiza um recurso existente por ID       | PUT         | `id` (int), Corpo do recurso |
| `/api/recurso/{id}`             | Exclui um recurso específico por ID        | DELETE      | `id` (int)                  |
| `/api/login`             | Faz o login do usuario        | POST      | Corpo do recurso                 |
| `/api/reserva/checkIn`             | Faz um Check-In no sitema do hotel        | POST      | Corpo do recurso                   |
| `/api/reserva/checkOut`             | Faz um Check-Out no sitema do hotel        | POST      | Corpo do recurso                   |

## Exemplos

### Exemplo de Requisição GET usando cURL:

```bash
curl -X GET http://localhost:8080/recurso
```
### Exemplo de Requisição POST usando cURL:

```bash
curl -X POST http://localhost:8080/recurso
```
### Exemplo de Requisição PUT usando cURL:

```bash
curl -X PUT http://localhost:8080/recurso
```
### Exemplo de Requisição DELETE usando cURL:

```bash
curl -X DELETE http://localhost:8080/recurso
```

## Contribuição

Se você deseja contribuir com este projeto, siga os passos abaixo:

1. Crie um Fork deste repositório.
2. Faça as alterações no seu Fork.
3. Envie um Pull Request para este repositório, explicando as mudanças propostas.

## Licença

Declare a licença da API para que os usuários saibam quais são as permissões e restrições para o uso da mesma. Por exemplo:

```
Este projeto está licenciado sob a Licença MIT - consulte o arquivo LICENSE.md para obter detalhes.
```
