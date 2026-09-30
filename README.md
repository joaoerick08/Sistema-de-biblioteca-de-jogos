# Sistema de Biblioteca de Jogos (sisbibliotecadejogos)

API REST para gerenciamento de biblioteca de jogos e estúdios desenvolvida em Java com Spring Boot e H2.

- João Erick Moura da silva - 2525050008


## Tecnologias
- Backend: Java 21 | Spring Boot 4.1.1 (Web, Data JPA) | H2 Database | Lombok
- Front-end: Angular

##  Como Executar

### Backend (API)
1. Clone o repositório ou abra o projeto em uma IDE.
2. Execute a classe `SisbibliotecadejogosApplication.java`.
3. A API sobe em `http://localhost:8080`.
4. Console do H2: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:bibliotecadb`, User: `sa`).
5. O banco já vem com um estúdio e uma categoria de exemplo pré-cadastrados automaticamente (via `data.sql`), então já dá pra criar jogos direto sem precisar cadastrar nada na mão antes.

### Front-end (Angular)
1. Entre na pasta do front: `cd biblioteca-jogos-front`
2. Instale as dependências: `npm install`
3. Suba o servidor de desenvolvimento: `ng serve`
4. Acesse `http://localhost:4200` no navegador.

> ⚠️ O backend precisa estar rodando (passo acima) para o front conseguir carregar e salvar os jogos.

## Endpoints Principais

### Estúdios (`/estudios`)
- `GET /estudios` - Listar todos
- `GET /estudios/{id}` - Buscar por ID
- `POST /estudios` - Criar (Body: `{"nome": "Nintendo", "pais": "Japão"}`)
- `PUT /estudios/{id}` - Atualizar
- `DELETE /estudios/{id}` - Deletar

### Categorias (`/categorias`)
- `GET /categorias` - Listar todas
- `GET /categorias/{id}` - Buscar por ID
- `POST /categorias` - Criar (Body: `{"nome": "RPG"}`)
- `PUT /categorias/{id}` - Atualizar
- `DELETE /categorias/{id}` - Deletar

### Jogos (`/jogos`)
- `GET /jogos` - Listar todos
- `GET /jogos/{id}` - Buscar por ID
- `POST /jogos` - Criar (Body: `{"nome": "Elden Ring", "anoLancamento": 2022, "pontuacao": 9.5, "avaliacaoPessoal": "Excelente", "estudio": {"id": 1}, "categorias": [{"id": 1}]}`)
- `PUT /jogos/{id}` - Atualizar
- `DELETE /jogos/{id}` - Deletar
