# Sistema de Biblioteca de Jogos (sisbibliotecadejogos)

API REST para gerenciamento de biblioteca de jogos, estúdios e categorias desenvolvida em Java com Spring Boot e MongoDB, com front-end em Angular.

- João Erick Moura da silva - 2525050008


##  Tecnologias
- Backend: Java 21 | Spring Boot 4.1.1 (Web, Data MongoDB) | MongoDB | Lombok
- Front-end: Angular

##  Como Executar

### Pré-requisito: MongoDB
O backend usa MongoDB. Escolha uma das opções:
- **Local (padrão):** tenha o MongoDB Community Server rodando em `localhost:27017`. O banco `bibliotecadb` é criado automaticamente.
- **MongoDB Atlas (nuvem):** defina a variável de ambiente `MONGODB_URI` com a sua string de conexão antes de subir a aplicação.

### Backend (API)
1. Clone o repositório ou abra o projeto em uma IDE.
2. Com o MongoDB rodando, execute a classe `SisbibliotecadejogosApplication.java`.
3. A API sobe em `http://localhost:8080`.
4. Na primeira execução, a aplicação cadastra automaticamente alguns estúdios (FromSoftware, Nintendo, CD Projekt Red) e categorias (RPG, Aventura, Ação) de exemplo, então já dá pra criar jogos sem cadastrar nada na mão antes. Os dados ficam salvos no MongoDB entre uma execução e outra.

### Front-end (Angular)
1. Entre na pasta do front: `cd biblioteca-jogos-front`
2. Instale as dependências: `npm install`
3. Suba o servidor de desenvolvimento: `ng serve`
4. Acesse `http://localhost:4200` no navegador.

> ⚠️ O MongoDB e o backend precisam estar rodando (passos acima) para o front conseguir carregar e salvar os jogos.

## 📑 Endpoints Principais

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
- `POST /jogos` - Criar (Body: `{"nome": "Elden Ring", "anoLancamento": 2022, "pontuacao": 9.5, "avaliacaoPessoal": "Excelente", "estudio": {"id": "<id do estúdio>"}, "categorias": [{"id": "<id da categoria>"}]}`)
- `PUT /jogos/{id}` - Atualizar
- `DELETE /jogos/{id}` - Deletar

> Os `id`s são gerados pelo MongoDB (ObjectId, texto). Consulte-os com `GET /estudios` e `GET /categorias`.
