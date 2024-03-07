# Portfolio Rafael Calixta

## Sobre o projeto

Esse aplicação é baseada no desafio de vaga back-end [Anota Aí](https://github.com/githubanotaai/new-test-backend-nodejs). <br>
Obs: eu não estou participando da vaga, estou resolvendo apenas com o intuito de praticar os meus conhecimentos de forma voltada à realidade do mercado de trabalho. Aceito feedbacks ☕

## Tecnologias Utilizadas
- Java
- Springboot
- AWS Simple Queue Service
- Mongo DB
- AWS Simple Storage Service

## Como Executar o Projeto
Pré-requisitos: Java 17

1. Clone o repositório:
```bash
# clonar repositório
git clone https://github.com/racalixta/desafio-anota-ai

```

2. Instale as dependências com o Maven

3. Crie uma configuração com suas variáveis de ambiente de tempo de execução com suas credenciais da AWS em application.properties
```java
  aws.region=us-east-1
  aws.accessKeyId=${AWS_KEY_ID}
  aws.secretKey=${AWS_SECRET}
```

### Valores de configuração
```java
  AWS_KEY_ID=VALUE;AWS_SECRET=VALUE2
```

## API Endpoints

A API fornecerá os seguintes endpoints:

### API PRODUCT
```java
  POST /api/product - Create a new product
  GET /api/product - Retrieve all products
  PUT /api/product/{id} - Updates a product
  DELETE /api/product/{id} - Delete a product
```

### Body

```json
  {
    "title": "Produto para postar no tópico",
    "description": "",
    "ownerId": "4444444",
    "categoryId": "659d558b0304df732ddd4587",
    "price": 10000
  }
```

### API CATEGORY
```java
  POST /api/category - Create a new category
  GET /api/category - Retrieve all categories
  PUT /api/category/{id} - Updates a category
  DELETE /api/category/{id} - Delete a category
```

### Body

```json
  {
    "id": "393948882828",
    "title": "Teste",
    "description": "",
    "ownerId": "4444444"
  }
```

## Autor 
Rafael Calixta <br>
[LinkedIn](https://www.linkedin.com/in/rafael-calixta/) <br>
[Portfolio](https://portfolio-racalixta.vercel.app/) <br>
