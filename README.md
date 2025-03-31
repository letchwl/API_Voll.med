# API REST - Clínica Médica

Este projeto é uma API REST desenvolvida com **Spring Boot, Spring Web, Spring Data JPA, Java e PostgreSQL**, que permite a gestão de médicos e pacientes de uma clínica. A API suporta operações **CRUD** (Create, Read, Update e Delete) para ambas as entidades.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**

## Funcionalidades

- Cadastro de médicos
- Listagem de médicos
- Atualização de dados de um médico
- Remoção de médico
- Cadastro de pacientes
- Listagem de pacientes
- Atualização de dados de um paciente
- Remoção de paciente

## Configuração do Banco de Dados

No arquivo `application.properties` ou `application.yml`, configure as credenciais do PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Endpoints

### Médicos

- **GET** `/medicos` - Lista todos os médicos
- **POST** `/medicos` - Cadastra um novo médico
- **PUT** `/medicos` - Atualiza um médico
- **DELETE** `/medicos/{id}` - Remove um médico

### Pacientes

- **GET** `/pacientes` - Lista todos os pacientes
- **POST** `/pacientes` - Cadastra um novo paciente
- **PUT** `/pacientes` - Atualiza um paciente
- **DELETE** `/pacientes/{id}` - Remove um paciente

## Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. Acesse o diretório do projeto:
   ```bash
   cd nome-do-projeto
   ```
3. Configure o banco de dados no `application.properties`.
4. Execute o projeto com Maven:
   ```bash
   mvn spring-boot:run
   ```

A API estará disponível em: `http://localhost:8080`

## Como Testar a API

Você pode testar os endpoints utilizando ferramentas como **Insomnia** ou **Postman**.

### Exemplo de JSON para Cadastro de Médicos:

```json
{
  "nome": "Mariana Souza",
  "email": "mariana.souza@clinicamed.com",
  "telefone": "11987654321",
  "crm": "456321",
  "especialidade": "CARDIOLOGIA",
  "endereco": {
    "logradouro": "Avenida Paulista",
    "bairro": "Centro",
    "cep": "01311000",
    "cidade": "São Paulo",
    "uf": "SP",
    "numero": "100"
  }
}
```

### Exemplo de JSON para Cadastro de Pacientes:

```json
{
  "nome": "Carlos Eduardo",
  "email": "carlos.eduardo@email.com",
  "telefone": "21987654321",
  "cpf": "987.654.321-00",
  "endereco": {
    "logradouro": "Rua das Flores",
    "bairro": "Jardins",
    "cep": "04567000",
    "cidade": "Rio de Janeiro",
    "uf": "RJ",
    "numero": "50",
    "complemento": "Apartamento 302"
  }
}
```

### Exemplo de JSON para Atualizar Dados:

```json
{
// ID DO PACIENTE/MEDICO QUE DESEJA ATUALIZAR
  "id": 5,
// CAMPO QUE DESEJA MODIFICAR EX: cpf, email, nome, ETC.
  "nome": "Fernando Lima"
}
```

## Autor

Desenvolvido por Letch.

