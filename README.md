# FDS-TF-Sistema-de-Vendas

Este repositório contém o código-fonte para o backend e frontend do projeto final da Disciplina de Fundamentos de Desenvolvimento de Software.

## Backend

### Pré-requisitos

- Java Development Kit (JDK) 17 ou superior
- Maven

### Configuração

1. **Clone o repositório:**

    ```bash
    git clone https://github.com/LGMarques9963/FDS-TF-Sistema-de-Vendas.git
    cd FDS-TF-Sistema-de-Vendas/backend
    ```

2. **Execute o seguinte comando para construir e executar o backend:**

    ```bash
    mvn install
    mvn spring-boot:run
    ```

    O backend estará disponível em `http://localhost:8080`.

## Frontend

### Pré-requisitos

- Node.js (com npm)

### Configuração

1. **Navegue até o diretório do frontend:**

    ```bash
    cd FDS-TF-Sistema-de-Vendas/frontend
    ```

2. **Instale as dependências:**

    ```bash
    npm install
    ```

3. **Execute o seguinte comando para iniciar o servidor de desenvolvimento:**

    ```bash
    npm run serve
    ```

    O frontend estará disponível em `http://localhost:8081`.

### Build para Produção

Para construir o frontend para produção, execute o seguinte comando:

```bash
npm run build
```

Os arquivos de build serão gerados no diretório `dist/`.

## Teste do Backend

Para testar o backend, importe a coleçao TF-Sistema-Vendas.postman_collection.json para o Postman e execute as requisições
