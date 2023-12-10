[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=11339428&assignment_repo_type=AssignmentRepo)
# Trabalho de PPOO - Sistema de Recomendação

Veja as Instruções do Trabalho no Campus Virtual da disciplina.

Preencha os campos abaixo de acordo com as intruções dadas.

## Definição do Grupo

**Nome do grupo**: Adventure World

**Tema escolhido**: Parques de Diversão

**Integrantes** (preencha abaixo):

- João Pedro Alves Carneiro Valadão
- Paulo Henrique Teixeira Pompeu
- Bruno Henrique Ferreira Rocha Faria


## DIAGRAMA UML

```mermaid
classDiagram
    App -- Central
    Central -- Menu
    Menu *-- ModuloADM
    Menu *-- ModuloCompraIngressos
    Menu *-- ModuloRelatorio
    ModuloADM *-- EscolhaAtividade
    ModuloADM *-- EscolhaEvento
    ModuloADM *-- EscolhaLocal
    ModuloCompraIngressos *-- DetalhesEvento
    Central *-- Cidade
    Central *-- Visita
    Central *-- Parque
    Visita <|-- AcessoAtracao
    Visita <|-- PassaporteVip
    ModuloCompraIngressos --> JanelaBase
    ContabilizadorIngressos --> JanelaBase
    GraficoIngressos -- JanelaBase
    DadosIngressoVisita -- ContabilizadorIngressos
    DadosIngressoParque -- ContabilizadorIngressos
    DadosIngressoComprador -- ContabilizadorIngressos
```

## Checklist para a Primeira Entrega

**Preencha a coluna _Respostas_** na tabela abaixo **antes de fazer a primeira entrega**.

- Obs.: a coluna _Id_ indica a seção das Instruções do trabalho.

|  Id   |  Descrição                                                         | Respostas | 
|-------|--------------------------------------------------------------------|-----------|
| 2.1.1 | O sistema permite cadastrar eventos?                               |   (sim)   |
| 2.1.1 | O sistema permite listar eventos?                                  |   (sim)   |
| 2.1.1 | O sistema permite remover eventos?                                 |   (sim)   |
| 2.1.2 | O sistema permite cadastrar locais?                                |   (sim)   |
| 2.1.2 | O sistema permite listar locais?                                   |   (sim)   |
| 2.1.2 | O sistema permite remover locais?                                  |   (sim)   |
| 2.1.3 | O sistema permite cadastrar atividades?                            |   (sim)   |
| 2.1.3 | O sistema permite listar atividades?                               |   (sim)   |
| 2.1.3 | O sistema permite remover atividades?                              |   (sim)   |
| 3.1.3 | O código implementado tem bom design de classes?                   |   (sim)   |
| 3.1.4 | O código implementado respeita divisão de camadas?                 |   (sim)   |
| 3.1.5 | O código faz uso de herança? Tem superclasse e subclasses?         |   (sim)   |
| 3.1.6 | Foi feito diagrama de classes UML?                                 | (mermaid) |
| 3.1.7 | Código enviado compila sem erros na versão 17 ou superior do Java? |   (sim)   |
| 3.1.7 | Implementação usa pacote `br.ufla.gac106.s2023_1.nomeDoGrupo`?     |   (sim)   |
| 3.1.7 | Foi adicionada alguma biblioteca (arquivo `.jar`)?                 |   (não)   |
| 3.1.7 | Código está legível, organizado e bem comentado?                   |   (sim)   | 

## Checklist para a Entrega Final

**Preencha a coluna _Respostas_** na tabela abaixo **antes da entrega final**.

- Obs.: a coluna _Id_ indica a seção das Instruções do trabalho.

|  Id   |  Descrição                                                                  | Respostas | 
|-------|-----------------------------------------------------------------------------|-----------|
| 2.1   | Sistema trata todos os itens do Módulo de Administração (primeira entrega)? | (sim) |
| 2.1.0 | O sistema salva os dados cadastrados em arquivo?                            | (sim) |
| 2.2.1 | Módulo de compras de ingresso exibe listagem dos eventos cadastrados?       | (sim) |
| 2.2.2 | Sistema exibe detalhes (dados cadastrais) de um evento selecionado?         | (sim) |
| 2.2.2 | Sistema exibe atividades de um evento selecionado, incluindo número de ingressos disponíveis | (não) |
| 2.2.3 | Sistema permite que usuário escolha a quantidade de ingressos por tipo?     | (sim) |
| 2.2.3 | Sistema trata os três tipos de ingresso, com preços diferentes?             | (não) |
| 2.2.3 | Sistema usa herança para tratar os tipos de ingresso?                       | (sim) |
| 2.2.4 | Sistema confere se quantidade de ingressos solicitada está disponível?      | (não) |
| 2.2.4 | Ao finalizar compra a quantidade de ingressos e preço total são exibidos?   | (sim) |
| 2.2.5 | Sistema gera arquivo PDF com os ingressos comprados?                        | (sim) |
| 2.2.6 | Informações necessárias sobre ingressos disponíveis são persistidas em arquivo?  | (sim) |
| 2.2.7 | Módulo de relatórios exibe gráfico por evento?                              | (sim) |
| 2.2.7 | Módulo de relatórios exibe gráfico por atividade?                           | (sim) |
| 3.1.3 | O código implementado tem bom design de classes?                            | (não) |
| 3.1.4 | O código implementado respeita divisão de camadas?                          | (não) |
| 3.1.5 | O código faz uso de herança? Tem superclasse e subclasses?                  | (sim) |
| 3.1.6 | Foi feito diagrama de classes UML?                                          | (mermaid) |
| 3.1.7 | Código enviado compila sem erros na versão 17 ou superior do Java?          | (sim) |
| 3.1.7 | Implementação usa pacote `br.ufla.gac106.s2023_1.nomeDoGrupo`?              | (sim) |
| 3.1.7 | Foi adicionada alguma biblioteca (arquivo `.jar`)?                          | (não) |
| 3.1.7 | Código está legível, organizado e bem comentado?                            | (sim) |
| 3.1.8 | Código faz uso de variável polimórfica?                                     | (não) |
| 3.1.8 | Código faz uso de polimorfismo de método?                                   | (sim) |
| 3.1.9 | Há tratamento de exceção para entradas inválidas do usuário?                | (sim) |
| 3.1.9 | Há tratamento de exceção para programa não fechar por erro de execução?     | (sim) |
| 3.1.10| Código inicial fornecido pelo professor foi alterado (incluindo pacote)?    | (sim) |
| 3.1.11| Módulo de compra de ingressos possui interface gráfica?                     | (sim) |
| 3.1.11| Módulo de relatórios possui interface gráfica?                              | (sim) |
| 3.1.11| Módulo de administração possui interface gráfica? (opcional)                | (sim) |
| 3.1.12| Há implementação de algum Padrão de Projeto? (opcional)                     | (não) |


## Auto-avaliação sobre o Trabalho Prático

1. Todos os integrantes contribuíram com o desenvolvimento do trabalho, inclusive na implementação?

> Sim

2. O que acham que foi mais complexo fazer no trabalho?

> O final da segunda parte do trabalho, muito por conta da grande quantidade de trabalhos de outras diciplinas. A falta de tempo foi o maior desafio.

3. E o que acham que foi mais interessante no trabalho?

> Aprender a usar e implementar códigos maiores com uma complexidade e interação maior

4. Qual nota dariam para o trabalho de vocês

> 72,5%

5. Teriam alguma sugestão de mudança nas instruções do trabalho se estivessem começando a fazê-lo agora?

> Dependendo do tema, as intruções não são tão claras quanto ao contexto a ser aplicado no código
