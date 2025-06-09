# Backend - Sistema de Gerenciamento de Máquinas Virtuais

Este diretório contém o código-fonte do backend do Sistema de Gerenciamento de Máquinas Virtuais. O backend é responsável por toda a lógica de negócio, persistência de dados e exposição da API para o frontend. Ele é construído com Spring Boot e utiliza PostgreSQL como banco de dados.

---

## 📋 Visão Geral

O backend é a espinha dorsal do sistema, gerenciando as operações CRUD (Criar, Ler, Atualizar, Deletar) para máquinas virtuais e tarefas de monitoramento. Ele expõe uma API RESTful para comunicação com o frontend Angular, garantindo a integridade e a segurança dos dados.

---

## 🚀 Funcionalidades Implementadas

- *Criação de Máquinas Virtuais*  
  Endpoint para provisionar novas VMs com configurações personalizadas.

- *Listagem de Máquinas Virtuais*  
  Endpoint para recuperar todas as VMs existentes com seus status e detalhes.

- *Edição de Máquinas Virtuais*  
  Endpoint para modificar as configurações de VMs existentes.

- *Exclusão de Máquinas Virtuais*  
  Endpoint para remover VMs do sistema.

- *Monitoramento de Tarefas*  
  Endpoint para acompanhar o progresso e status de operações assíncronas relacionadas às VMs.

---

## 🛠 Tecnologias Utilizadas

- *Spring Boot* – Framework para aplicações Java.
- *Java 17+* – Linguagem de programação.
- *Maven* – Gerenciador de build e dependências.
- *Spring Data JPA* – Abstração para persistência.
- *PostgreSQL* – Banco de dados relacional robusto.

---

## ✅ Pré-requisitos

- *JDK 17 ou superior*  
  👉 [Download JDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

- *Maven 3.8.x ou superior*  
  👉 [Download Maven](https://maven.apache.org/download.cgi)

- *PostgreSQL 14.x ou superior*  
  👉 [Download PostgreSQL](https://www.postgresql.org/download/)

---

## 🗃 Configuração do Banco de Dados (PostgreSQL)

1. *Instale o PostgreSQL* (se ainda não tiver instalado).

2. *Crie um usuário e um banco de dados:*

bash
psql -U postgres # Clone o repositório
git clone https://github.com/seu-usuario/seu-repositorio.git

# Compile e instale as dependências
mvn clean install

# Execute a aplicação
mvn spring-boot:run
