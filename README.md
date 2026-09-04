# Sistema de Biblioteca de Jogos (sisbibliotecadejogos)

API REST para gerenciamento de biblioteca de jogos, estúdios e categorias desenvolvida em Java com Spring Boot e H2.

- João Erick Moura da silva - 2525050008


##  Tecnologias
- Java 21 | Spring Boot 4.1.1 (Web, Data JPA) | H2 Database | Lombok

##  Como Executar
1. Clone o repositório ou abra o projeto em uma IDE.
2. Execute a classe `SisbibliotecadejogosApplication.java`.
3. Console do H2: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:bibliotecadb`, User: `sa`).
4. para dar post em jogos, primeiro adicione um estudio e uma categoria e passe a id nele para o jogo

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
