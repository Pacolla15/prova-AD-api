# PROMPTS: Grupo ____

**Integrantes:**

1. Victor Ruis Marques
2. Nicolas Galdino Araujo
3. Lasier Cauã Silveira Darski

**Prova:** API em MVC

**Usamos IA?** (X) Sim  ( ) Não

**Qual ferramenta e modelo (se usaram):** ChatGPT

> Quem não usou IA: troque "prompt" por "passo". Em cada bloco abaixo, descreva o que vocês fizeram naquele passo, na ordem em que aconteceu, e preencha os outros campos do mesmo jeito.

## Registro, na ordem

Copie o bloco abaixo para cada prompt. Escreva o prompt exatamente como foi enviado.

### Prompt 1

**O prompt (cópia exata):** Olá, precisamos que faça uma API, segue informações:
 A situação

A escola quer uma API para controlar a reserva de suas salas: laboratórios, auditório, salas de aula. Cada sala tem um código, um nome e uma capacidade, e a escola precisa saber quais estão reservadas e quais estão livres.

 O que a API precisa fazer

- Cadastrar uma sala, listar todas, buscar uma pelo id e excluir.

- Reservar uma sala e liberar uma sala.

- Responder cada situação com o status HTTP certo: sucesso, criado, sem conteúdo, não encontrado, conflito e dados inválidos.

 As regras da escola

- Toda sala cadastrada começa livre.

- O **código é único**: não pode haver duas salas com o mesmo código.

- **Código e nome são obrigatórios**, e a **capacidade precisa ser maior que zero**.

- Uma sala que já está reservada **não pode ser reservada de novo**.

- Só pode ser liberada uma sala que **está reservada**.

- Uma sala reservada **não pode ser excluída**.

- Pedir, reservar, liberar ou excluir uma sala que não existe é um caso de "não encontrado".

 O que o projeto precisa ter

- O projeto **`Escola-base`**, que o professor entrega, e que vocês usam como ponto de partida. Ele já traz Spring Web, Spring Data JPA, validação e banco **H2 em memória**, e já sobe sem nenhuma classe de vocês. Não precisa criar projeto. O arquivo `README.md` dele explica como rodar.

- Organização em camadas, **cada uma no seu pacote, criado por vocês** dentro de `src/main/java/escola`: `model`, `repository`, `service` e `controller`. O projeto base não traz essas pastas prontas.

- As regras da escola ficam na **Service**. O **Controller** só recebe a requisição, chama a Service e devolve a resposta HTTP. O Controller não conversa direto com o Repository.

- As rotas seguem o padrão REST. Vocês escolhem os nomes.

dê os passos do que fazer para a criação dessa API completa (inclui a criação de arquivos extras)

> 

**O que a IA devolveu (uma ou duas linhas):** A IA devolveu uma explicação passo a passo da criação da API, criando arquivos e códigos. Ela também forneceu explicações sobre cada parte

**O que fizemos com a resposta:** (X) usamos como veio  ( ) alteramos  ( ) descartamos

**Por quê (o que conferimos, o que mudamos):** A princípio todo o prompt está correto e de acordo com o solicitado. Pedimos o passo a passo e ela entregou exatamente isso com explicações, não tinha por que alterar.

### Prompt 2

**O prompt (cópia exata):** não é possível testar esta API nesta máquina, por favor execute testes e retorne o resultado deles .



| Passo | O que fazer                                                            |    |
| :---- | :--------------------------------------------------------------------- | :- |
| 1     | Cadastrar a sala de código LAB-01, nome Lab Informatica, capacidade 30 |    |
| 2     | Cadastrar outra sala com o mesmo código LAB-01                         |    |
| 3     | Cadastrar uma sala sem nome                                            |    |
| 4     | Reservar a sala 1                                                      |    |
| 5     | Reservar a sala 1 de novo                                              |    |
| 6     | Excluir a sala 1 (que está reservada)                                  |    |
| 7     | Liberar a sala 1                                                       |    |
| 8     | Liberar a sala 1 de novo                                               |    |
| 9     | Excluir a sala 1                                                       |    |
| 10    | Buscar a sala 1                                                        |    |

> 

**O que a IA devolveu (uma ou duas linhas):** Ela testou a API, neste caso, as rotas, e retornou todos os resultados esperados

**O que fizemos com a resposta:** ( ) usamos como veio  ( ) alteramos  (X) descartamos

**Por quê (o que conferimos, o que mudamos):** Este foi um prompt de teste da API, não tinha o que ser usado ou modificado, pois não tinha como realisar o teste na máquina.



## Como conferimos

Passo	Requisição	Rota	Resultado previsto
1	POST	/api/salas	201
 Criada
2	POST	/api/salas	409
 Código duplicado
3	POST	/api/salas	400
 Nome obrigatório
4	PATCH	/api/salas/1/reservar	200
 Reservada
5	PATCH	/api/salas/1/reservar	409
 Já reservada
6	DELETE	/api/salas/1	409
 Não pode excluir
7	PATCH	/api/salas/1/liberar	200
 Liberada
8	PATCH	/api/salas/1/liberar	409
 Já está livre
9	DELETE	/api/salas/1	204
 Excluída
10	GET	/api/salas/1	404
 Não encontrada

veio tudo como esperado e correto.

## Onde a IA errou, ou onde nós erramos

não houve erros, 

## Respostas finais, sem consultar a IA

Respondam com as suas palavras, nos últimos 5 minutos. Não copiem de lugar nenhum.

**Pergunta 1:**

**Pergunta 2:**

**Pergunta 3:**
