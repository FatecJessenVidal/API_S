sucesso

## Laboratório de Projeto de Banco de Dados

- Introdução do projeto

  - Nosso projeto consiste numa API que se utiliza Inteligência Artificial para fazer interações com uma base de dados preexistente (IMDB).

- Objetivos

  - O objetivo central do projeto é fazer recomendações inteligentes de filmes baseado no perfil individual de cada usuário.
  - A disciplina tem como objetivo o estudo do DevOps a partir da implementação das práticas no projeto.

- Tecnologias utilizadas

  - Python - Escolhemos trabalhar com a linguagem de programação Python devido à sua grande popularidade em sistemas que utilizam Inteligência Artificial. Um outro motivo para a escolha do Python foi visando uma maior integração com os alunos do primeiro semestre, uma vez que muitos deles estão tendo contato com a programação pela primeira vez e isso ajudaria a dar um melhor suporte para eventuais dúvidas.
  - Flask - Várias funcionalidades úteis na aplicação com Python, sendo a principal delas as rotas de acesso.
  - Fuzzy - Biblioteca de Inteligência Artificial que permitiu fazer as análises e recomendações.
  - Postgresql - Banco de dados relacional que guarda a massa de filmes.
  - SQLAlchemy - Comunicação do Python com o Postgresql.
  - Docker - Foi utilizado visando eliminar qualquer problema de incompatibilidade entre os membros da equipe, pois o projeto fica exatamente igual para todos independentemente de onde ele é acessado.
  - Cloud AWS - Utilizado para hospedar e disponibilizar a API online para o cliente.
  - Sistemas de versionamento de código - Git e Github para uma melhor integração e organização dos códigos da disciplina.
  - Github Projects - Organização e controle de tasks pelo Scrum Master e PO e acesso claro de prazos e requisitos pelos outros membros da equipe.
  - Robot - Biblioteca de testes para Python.
  
### Quick Start

**Setup do projeto**
```
npm install
```

**Compila para desenvolvimento**
```
npm run serve
```

**Compila e builda para produção**
```
npm run build
```

### Cronograma de entregas

- [x] **Sprint 1** - Cloud & Database Automation
- [X] **Sprint 2** - CI
- [X] **Sprint 3** - Testing
- [X] **Sprint 4** - Integração Testing & CI
- [ ] **Sprint 5** - Integração Front/Back e Testes no Front
- [ ] **Sprint 6** - Planejamento pendente

------------



### Primeira entrega - Sprint 1 (Cloud & Database Automation)

- FlyWay como database automation;
- Deploy do código backend para a Cloud AWS;
- Configuração do nginx para uso posterior;

### Segunda entrega - Sprint 2 (CI)

- Deploy configurado com Jenkins para pipeline e AWS Code Deploy para deploy de código ao servidor;
- Primeira versão do frontend com layout estático;
- Mudanças na arquitetura do backend para acomodar o front;

### Terceira entrega - Sprint 3 (Testing)

- Configuração do PyTests no projeto;
- Criação de testes de integração;
- Otimizações no backend para melhor performance junto da API do IMDB;
- Segunda versão do frontend com layout melhorado;

### Quarta entrega - Sprint 4 (Integração Testing & CI)

- Alterações no docker-compose em preparo para separação de ambientes;
- Separação de ambientes em "Test" e "Production", permitindo que o desenvolvedor tenha um ambiente seguro para desenvolver e testar a aplicação sem acidentalmente interferir na aplicação sendo servida;
- Utilização do FlyWay para criação de um schema com dados pré-definidos para ser usado no ambiente de testes;
- Troca do PyTests por Robot para melhor execução dos testes de integração;
- Integração dos testes e deploy do ambiente de testes na pipeline Jenkins;

#### Vídeo de Apresentação da Entrega

https://drive.google.com/file/d/17PsqBPnBGSps0Zv4Hh_iG-TAsI4xWZZ6

