🧪 Teste Técnico — Backend Java Júnior
📌 Contexto

Você foi contratado para desenvolver uma API simples de gerenciamento de tarefas (To-Do List).
A aplicação deve seguir boas práticas de backend, organização em camadas e uso de Spring Boot.

✅ Parte 1 — Modelagem
Crie uma entidade chamada Task com os seguintes campos:

id (Long)
title (String)
description (String)
completed (Boolean)
createdAt (LocalDateTime)


✅ Parte 2 — API REST
Implemente os seguintes endpoints:
🔹 Criar tarefa\
POST /tasks

🔹 Listar todas tarefas\
GET /tasks

🔹 Buscar tarefa por ID\
GET /tasks/{id}

🔹 Atualizar tarefa\
PUT /tasks/{id}

🔹 Deletar tarefa\
DELETE /tasks/{id}


✅ Parte 3 — Regras de negócio

O campo title não pode ser vazio
Quando a tarefa é criada:

completed deve iniciar como false
createdAt deve ser preenchido automaticamente


Retornar 404 quando a tarefa não existir


✅ Parte 4 — Estrutura esperada
Organize o projeto em camadas:
controller
service
repository
model (entity)
dto (opcional)


✅ Parte 5 — Banco de Dados
Use:

H2 (em memória) OU
MySQL