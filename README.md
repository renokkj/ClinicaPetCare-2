# ClinicaPetCare

Sistema web para gerenciamento de clínica veterinária desenvolvido em Java Web utilizando arquitetura MVC, padrões de projeto GoF e integração com banco de dados MySQL.

---

# Objetivo do Projeto

O projeto foi desenvolvido para a disciplina de Padrões de Projeto (PP), aplicando conceitos de:

- Programação Orientada a Objetos
- Design Patterns
- SOLID
- Arquitetura MVC
- REST API
- Testes Automatizados
- Persistência em Banco de Dados

---

# Tecnologias Utilizadas

- Java 17
- Jakarta EE
- JSP / JSTL
- Maven
- Apache Tomcat 10
- MySQL
- JUnit 5
- Mockito
- Git / GitHub

---

# Arquitetura Utilizada

- MVC (Model View Controller)
- DAO (Data Access Object)

---

# Design Patterns Implementados

## Command Pattern
Utilizado para centralizar ações do sistema e reduzir acoplamento entre controller e regras de negócio.

---

## Factory Pattern
Responsável pela criação dinâmica de comandos do sistema.

---

## Decorator Pattern
Utilizado para adicionar serviços veterinários dinamicamente aos atendimentos, como:

- Vacinação
- Exames
- Medicação
- Internação

Sem modificar a classe principal do atendimento.

---

# Funcionalidades

## Tutor
- Cadastro
- Edição
- Exclusão
- Listagem

---

## Pet
- Cadastro
- Edição
- Exclusão
- Listagem
- Associação com tutor

---

## Prontuário
- Criação automática
- Histórico
- Restrições
- Medicações
- Observações

---

## Triagem Automática
O sistema possui automação de triagem veterinária.

A triagem:
- Atualiza informações automaticamente
- Atualiza prontuário
- Recalcula prioridade do atendimento
- Registra horário da última avaliação

---

# Relacionamentos

## 1:N
Tutor → Pets

---

## 1:1
Pet → Prontuário

---

# REST API

O sistema possui endpoint REST retornando JSON.

## Endpoint:

```http

