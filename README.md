# Real Estate Management System

Este é um sistema de gerenciamento imobiliário desenvolvido com Spring Boot que permite o gerenciamento de propriedades, agentes, listagens e usuários.

## 🛠 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Docker
- Maven

## 📋 Funcionalidades

- Gerenciamento de Propriedades
- Gerenciamento de Agentes
- Gerenciamento de Listagens
- Gerenciamento de Usuários
- Sistema de Busca de Propriedades

## 🚀 Como Executar

### Pré-requisitos

- Java 17
- Docker e Docker Compose
- Maven

### Passos para Execução

1. Clone o repositório:
```bash
git clone [URL_DO_REPOSITÓRIO]
cd project1
```

2. Execute o Docker Compose para iniciar o banco de dados:
```bash
docker-compose up -d
```

3. Execute a aplicação usando Maven:
```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`

## 📌 Endpoints da API

### Usuários
- `POST /api/users` - Criar novo usuário
- `GET /api/users` - Listar usuários
- `GET /api/users/{id}` - Buscar usuário por ID
- `PUT /api/users/{id}` - Atualizar usuário
- `DELETE /api/users/{id}` - Deletar usuário

### Propriedades
- `POST /api/properties` - Criar nova propriedade
- `GET /api/properties` - Listar propriedades
- `GET /api/properties/{id}` - Buscar propriedade por ID
- `PUT /api/properties/{id}` - Atualizar propriedade
- `DELETE /api/properties/{id}` - Deletar propriedade

### Agentes
- `POST /api/agents` - Criar novo agente
- `GET /api/agents` - Listar agentes
- `GET /api/agents/{id}` - Buscar agente por ID
- `PUT /api/agents/{id}` - Atualizar agente
- `DELETE /api/agents/{id}` - Deletar agente

### Listagens
- `POST /api/listings` - Criar nova listagem
- `GET /api/listings` - Listar listagens
- `GET /api/listings/{id}` - Buscar listagem por ID
- `PUT /api/listings/{id}` - Atualizar listagem
- `DELETE /api/listings/{id}` - Deletar listagem

## 🔧 Configuração

As configurações da aplicação podem ser encontradas em `src/main/resources/application.properties`.

## 📄 Licença

Este projeto está sob a licença MIT.

## ✨ Contribuição

1. Faça o fork do projeto
2. Crie sua feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request
