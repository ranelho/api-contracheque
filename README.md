# Documentação da API

Este documento descreve a definição da API usando OpenAPI (Swagger).

## Informações Gerais

- **Título:** OpenAPI definition
- **Versão:** v0

## Servidores

### Servidor de Desenvolvimento

- **URL:** [{$HOST}/contracheque/api](http://{$HOST}/contracheque/api)
- **Descrição:** URL do servidor gerado automaticamente para ambiente local.

## Endpoints

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

Este documento foi gerado automaticamente a partir da definição da API utilizando o OpenAPI (Swagger).

Se precisar de mais informações ou tiver dúvidas, entre em contato com o desenvolvedor da API.
