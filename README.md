# Microsserviço de Autenticação JWT com Spring Boot

Este é um microsserviço de autenticação JWT desenvolvido em Java com Spring Boot e Maven. Ele fornece autenticação de usuário e geração de tokens JWT para acesso seguro a recursos protegidos.

## Configuração do Banco de Dados PostgreSQL

Este microsserviço utiliza o banco de dados PostgreSQL para armazenar os dados dos usuários e outras informações necessárias.

### Pré-requisitos

- Certifique-se de ter o PostgreSQL instalado em sua máquina ou em algum servidor acessível.
- Tenha o usuário e senha do banco de dados PostgreSQL disponíveis para configurar a conexão.

### Configuração

1. Acesse o arquivo `application.properties` em `src/main/resources` e configure as propriedades relacionadas ao banco de dados:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

2. Certifique-se de que o PostgreSQL está em execução e acessível.

3. O Spring Boot será responsável por criar automaticamente as tabelas necessárias no banco de dados com base nas entidades definidas no projeto.

## Executando o Microsserviço

Você pode executar o microsserviço de autenticação JWT utilizando o Maven. Abra um terminal na raiz do projeto e execute o seguinte comando:

```
mvn spring-boot:run
```

Isso iniciará o microsserviço e você poderá acessá-lo em `http://localhost:8080`.

## Rotas Disponíveis

O microsserviço fornece as seguintes rotas:

- `POST /auth/login`: Rota para autenticar um usuário e gerar um token JWT.
- `POST /user/register`: Rota para registrar um novo usuário.
