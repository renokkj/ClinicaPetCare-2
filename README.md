# Clínica Veterinária Pet Care

Sistema web desenvolvido em Java para gerenciamento de uma clínica veterinária, permitindo o controle de tutores, pets, consultas e prontuários de forma organizada e prática.

O projeto foi desenvolvido com foco na aplicação de conceitos de Programação Orientada a Objetos, arquitetura MVC e padrões de projeto estudados durante a disciplina.

---

# Tecnologias utilizadas

- Java 17
- Jakarta Servlet
- JSP + JSTL
- Apache Tomcat
- MySQL
- Maven
- HTML5
- CSS3

---

# Arquitetura

O sistema segue o padrão MVC (Model-View-Controller), separando:

- Model → entidades e regras de negócio
- View → páginas JSP
- Controller → controle das requisições e navegação

---

# Estrutura do projeto

```text
clinicavet
│
├── api
├── builder
├── command
│   ├── consulta
│   ├── home
│   ├── pet
│   └── tutor
├── controller
├── dao
├── dao.impl
├── decorator
├── exception
├── factory
├── model
├── service
├── service.triagem
├── util
└── tests
```

---

# Funcionalidades

## Tutores
- Cadastro
- Edição
- Exclusão
- Visualização de detalhes

## Pets
- Cadastro completo
- Controle de status vacinal
- Informações clínicas
- Triagem automática
- Integração com prontuário

## Consultas
- Cadastro de consultas
- Controle de status
- Visualização detalhada
- Atendimento com serviços adicionais

## Prontuário
- Histórico clínico
- Medicação contínua
- Restrições alimentares
- Controle de prioridade
- Atualização automática

## API REST

Endpoint disponível:

```text
/api/pets
```

Funcionalidades:
- listar pets cadastrados
- buscar pet por ID
- resposta em JSON
- tratamento de erros HTTP
- retorno com status e timestamp

Exemplo de resposta:

```json
{
  "status":"success",
  "timestamp":"2026-05-28T23:30:00",
  "total":2,
  "data":[
    {
      "id":1,
      "nome":"Thor",
      "especie":"Cachorro"
    }
  ]
}
```

# Padrões de projeto utilizados

## Command Pattern
Responsável por separar as ações do sistema em comandos independentes.

Exemplos:
- BuscarPetPorIdCommand
- AtualizarPetCommand
- BuscarConsultaPorIdCommand

---

## Factory Pattern
Aplicado no `CommandFactory` para centralizar a criação dos comandos.

---

## Builder Pattern
Aplicado no `PetBuilder` para facilitar a construção de objetos Pet.

---

## Decorator Pattern
Utilizado para composição dinâmica dos atendimentos veterinários.

Permite adicionar serviços extras à consulta, como:
- exames
- vacinação

Principais classes:
- Atendimento
- AtendimentoDecorator
- ConsultaBasica
- ExameDecorator
- VacinacaoDecorator

---

# Camada de serviços

As regras de negócio foram separadas em classes específicas de serviço.

Principais serviços:
- PetService
- TriagemAutomaticaService

---

# Testes

O projeto possui testes unitários utilizando JUnit.

Exemplos:
- AtendimentoDecoratorTest
- TriagemAutomaticaServiceTest

---

# Interface

O sistema possui:
- dashboard inicial
- status coloridos
- confirmação de exclusão
- layout responsivo
- organização em cards

---

# Objetivo acadêmico

Projeto desenvolvido como atividade acadêmica da M2, aplicando conceitos de:
- Programação Orientada a Objetos
- Arquitetura MVC
- Persistência de dados
- Padrões de projeto
- Desenvolvimento Web com Java

---
