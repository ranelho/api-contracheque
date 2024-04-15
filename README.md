# Documentação da API

---
Este documento descreve a definição da API usando OpenAPI (Swagger).

## Informações Gerais

- **Título:** OpenAPI definition
- **Versão:** v0

## Servidores

### Servidor de Desenvolvimento

- **URL:** [{$HOST}/contracheque/api](http://{$HOST}/contracheque/api)
- **Descrição:** URL do servidor gerado automaticamente para ambiente local.

## Endpoints

---
### Gerar Contracheque Base64

Endpoint para gerar um contracheque em formato Base64.

- **URL:** `/v1/contracheque/funcionario`
- **Método:** POST
- **Tags:** `contracheque-rest-controller`
- **Operation ID:** `gerarContrachequeBase64`
- **Corpo da Requisição:**
    - Tipo: JSON
    - Schema:
      ```json
      {
        "mesAno": "string",
        "matricula": "string"
      }
      ```
    - Obrigatório: Sim
- **Respostas:**
    - Código 200:
        - Descrição: OK
        - Tipo de Conteúdo: `string`

---
### Gerar Contracheque PDF

Endpoint para gerar um contracheque em formato PDF.

- **URL:** `/v1/contracheque/funcionario/pdf`
- **Método:** POST
- **Tags:** `contracheque-rest-controller`
- **Operation ID:** `gerarContrachequePdf`
- **Corpo da Requisição:**
    - Tipo: JSON
    - Schema:
      ```json
      {
        "mesAno": "string",
        "matricula": "string"
      }
      ```
    - Obrigatório: Sim
- **Respostas:**
    - Código 200:
        - Descrição: OK
        - Tipo de Conteúdo: `array` de bytes (formato `byte`)

## Esquemas

### ContrachequeRequest

Esquema para a requisição de geração de contracheque.

- **Tipo:** Objeto
- **Propriedades:**
    - `mesAno`: Tipo string
    - `matricula`: Tipo string

---
### Docker
<p>Build do projeto configurado no Dockerfile</p>

```
FROM maven:3.8.5-openjdk-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
EXPOSE 8082
ENTRYPOINT java -jar app.jar
```
<p>Criar imagem na raiz do projeto [rh-contracheque (é o nome da imagem)]</p>

``` 
docker build --tag rh-contracheque .
```
<p>Subir imagem [8082:8082 (porta exposta na qual a api vai subir)]</p>

```
docker run --name rh-contracheque -p 8082:8082 rh-contracheque
```  
### COMANDO ÚTEIS

```
# parar container
docker container stop rh-contracheque

#iniciar conatainer
docker container start rh-contracheque

#remover container
docker container rm rh-contracheque

#deletar image
docker image rm rh-contracheque
```

---

