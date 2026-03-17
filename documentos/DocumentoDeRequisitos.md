# 1. Introdução

## 1.1 Propósito do documento de requisitos

Este documento tem como propósito definir e descrever os requisitos funcionais e não funcionais de um sistema de gestão de clubes de futebol organizados como Sociedade Anônima do Futebol (SAF).

Além disso, o documento será utilizado como referência no planejamento, implementação, testes e manutenção do sistema, para assim garantir que todas as necessidades referentes ao sistema sejam satisfeitas.  

O público-alvo deste documento envolve:

- Desenvolvedores responsáveis pela implementação do sistema;
- Dono dos clubes, gestores e diretores financeiros;
- Analistas de Desempenho do clubes.

## 1.2 Escopo do Produto

O (nome da aplicação) tem como objetivo auxiliar na organização e manipulação das informações financeiras de clubes de futebol estruturados como Sociedade Anônima do Futebol (SAF).

O sistema será utilizado para:

- Cadastrar e gerenciar clubes, usuários, jogadores;
- Registrar transações financeiras (receitas e despesas)
- Registrar e acompanhar informações de partidas, incluindo, cálculo da bilheteria e premiações;
- Gerar relatórios detalhados sobre desempenho financeiro e esportivo;

O sistema não contempla integrações com APIs externas de federações, portais de estatísticas de futebol ou sistemas bancários.

## 1.3 Definições, acrônimos e abreviações

As principais definições, abreviações e acrônimos utilizadas neste documento serão listadas a seguir.  

| Termo | Definição |
|---|---|
| **SAF** | Sociedade Anônima do Futebol. Modelo jurídico que permite que clubes de futebol sejam transformados em empresas com fins lucrativos. |
| **CT** | Centro de Treinamento. Local utilizado pelos jogadores para realizar treinamentos e preparação para as partidas. |
| **JVM** | Java Virtual Machine. Máquina virtual necessária para executar aplicações desenvolvidas em Java. |
| **Bilheteria** | Receita gerada pela venda de ingressos em uma partida de futebol. |
| **Saldo** | Diferença entre o total de receitas e o total de despesas registradas no sistema. |

## 1.4 Referências

(nehuma ainda)

## 1.5 Visão do Restante do Documento

Esse documento está organizado em seções, cada uma responsável para descrever partes específicas do sistema proposto. São elas:

A seção 2 apresenta a descrição geral do sistema, indicando os aspectos principais, como perspectivas, funcionalidades, restrições, suposições e dependências do produto. Com isso é possível ter uma visão mais específica do objetivo da aplicação.  

A seção 3 descreve com maior detalhamento os requisitos do sistema, de como ele se comunicará com o mundo exterior; lista as funções e recursos específicos. Com isso será ter uma visão geral e entender com mais clareza o funcionamento do sistema.

# 2. Descrição Geral

## 2.1 Perspectiva do Produto

O sistema é uma aplicação computacional desenvolvida em Java. Ele tem como objetivo auxiliar na organização e no acompanhamento das informações financeiras de Clubes de Futebol organizados com SAF. A aplicação funcionará como uma ferramenta de apoio, permitindo que o usuário registre diferentes tipos de operações financeiras e acompanhe esses dados ao longo do tempo.  

Através da interface o usuário poderá cadastrar transações, registrar informações sobre partidas realizadas, acompanhar receitas de diversas categorias e visualizar relatórios que apresentam o desempenho financeiro do clube.

## 2.2 Funcionalidades

O sistema deverá fornecer um conjunto de funcionalidades que permitam ao usuário registrar, consultar e gerar relatórios relacionadas à parte financeira dos clubes que serão geridos.  

Com isso, o sistema deve permitir:

- Cadastro de usuários com diferentes níveis de permissão;
- Cadastro, edição e exclusão de clubes de futebol;
- Cadastro de jogadores, vinculando-o ao clube;
- Registro de transações financeiras com jogadores: compra, venda e empréstimo;
- Registro de despesas operacionais: contas de energia, água, gramados, uniformes, saúde, salários, entre outros;
- Registrar informações sobre as partidas realizadas pelo time;
- Registro de transações financeiras com jogadores: compra, venda e empréstimo;
- Registro de despesas operacionais: contas de energia, água, gramados, uniformes, saúde, salários, entre outros;
- Cálculo automático do saldo financeiro do clube a cada nova transação;
- Geração de relatórios financeiros e esportivos com visualização gráfica;
- Visualizar o histórico de auditoria de registros e alterações realizadas no sistema;
- Exportação e importação de dados por meio de serialização.

## 2.3 Características do usuário

O sistema é voltado principalmente para usuários responsáveis pela gestão administrativa e financeira de clubes de futebol organizados como Sociedade Anônima do Futebol.  

**Administrador (nível 1):**
Possui acesso total ao sistema. É responsável por cadastrar outros usuários, gerenciar clubes e ter acesso irrestrito a todos os módulos do sistema. Geralmente corresponde ao presidente ou diretor-executivo do clube.

**Gestor Financeiro (nível 2):**
Tem acesso às funcionalidades de registro e edição de transações financeiras, partidas, jogadores e geração de relatórios referentes à parte financeira. Não pode cadastrar usuários com nível igual ou superior ao seu. Corresponde ao diretor financeiro ou gerente administrativo.

**Operador (nível 3):**
Possui acesso limitado, podendo apenas registrar e consultar partidas. Pode também gerar relatórios referentes às partidas. Corresponde a analistas de futebol.

Todos usuários devem possuir conhecimentos básicos de informática, sendo capazes de utilizar sistemas computacionais, bem como experiência na área de finanças e gestão de clubes.

## 2.4 Restrições Gerais

**[RG01] Restrição de Login**  
O acesso ao sistema deve ser restrito a usuários autenticados por meio de login e senha. Nenhuma funcionalidade do sistema pode ser acessada sem autenticação prévia.

**[RG02] Persistência de Dados**  
Todos os registros e informações do sistema devem ser armazenados de maneira permanente, a fim de garantir a existência dos dados mesmo fora da execução do sistema.

**[RG03] Controle de Acesso por Hierarquia**
Cada funcionalidade do sistema segue uma ordem hierárquica de acesso. Um usuário não pode acessar, criar ou modificar recursos para os quais não possui permissão.

**[RG04] Plataforma de Execução**
O sistema deve ser executável em qualquer sistema operacional compatível com a JVM (Java Virtual Machine).

**[RG05] Acesso de Usuário Único por Sessão**
O sistema operará em modo monousuário por sessão, sem suporte a acesso simultâneo de múltiplos usuários em tempo real.

## 2.5 Suposições e Dependências

Assume-se que os usuários possuem conhecimento básico sobre conceitos de gestão financeira relacionados ao futebol, sendo capazes de registrar corretamente receitas, despesas, bilheteria, bônus de partidas, premiações.  

Assume-se também que os usuários possuem conhecimento básico em sistemas computacionais, visto que dados de serão inseridos manualmente por eles, não dependendo de integrações automáticas.  

O sistema depende da disponibilidade de um ambiente computacional capaz de executar aplicações desenvolvidas na linguagem Java, sendo necessários sistemas operacionais que suportam Máquina Virtual Java (JVM), como Linux, Windows ou MacOs.  

# 3. Requisitos Específicos

## 3.1 Requisitos Funcionais

- **[RF] Autenticação de Usuário**  
O sistema deve permitir autenticação de usuários por meio de login e senha. (E)

  - **[RF.1] Acesso Restrito às funcionalidades**
  O sistema deve permitir acesso às funcionalidades as quais o usuário tem permissão. (E)

**[RF] Encerramento de Sessão**
O sistema deve permitir que o usuário encerre sua sessão (logout) a qualquer momento. **(E)**

- **[RF] Cadastro de Clubes**  
O sistema deve permitir cadastrar um ou mais clubes de futebol. (E)

- **[RF] Alterações em Clubes**  
O sistema deve permitir editar as informações de um clube já cadastrado no sistema. (E)

- **[RF] Exclusão de Clubes**  
O sistema deve permitir excluir o cadastro de um clube, desvinculando-o do sistema. (E)
  
  - **[RF.1] Exclusão em Cascata do Clube**
  O sistema deve excluir todas as informações associadas ao clube que foi excluido. (O)

- **[RF] Cadastro de Usuários**
O sistema deve permitir cadastro de um ou mais usuários. (E)

  - **[RF.1] Niveis diferentes de Usuário**  
  O sistema deve permitir a criação de usuários com diferentes permissão. (E)

    - **[RF.1.1] Hierarquia de Níveis**
    O sistema deve permitir apenas a criação de um usuário com o nível inferior ao do uuário atual. (O) ??????

- **[RF] Alterações em Usuários**  
O sistema deve permitir editar as informações de um usuário já cadastrado no sistema. (E)

- **[RF] Exclusão de Usuários**  
O sistema deve permitir excluir o cadastro de um usuário, desvinculando-o do sistema. (E)
    - **[RF.1] Exclusão de dados de usuário**  
        O sistema deve excluir os dados referentes a um usuário que foi excluído do sistema. (O)

- **[RF] Cadastro de jogador**  
O sistema deve permitir comprar jogadores. (E)
  
  - **[RF.1] Registro de Compra**  
    O sistema deve registrar o valor, data e informações do jogador a ser comprado. (E) ????

- **[RF] Vendas de jogador**  
O sistema deve permitir vender jogadores. (E)
  
  - **[RF.1] Registro de Venda**  
    O sistema deve registrar o valor, data, informações do jogador a ser vendido e clube de destino. (E) ????

- **[RF] Empréstimo de jogador**  
O sistema deve permitir o empréstimo de jogadores a outros clubes. (E)

  - **[RF.1] Registro de Empréstimo**  
  O sistema deve registrar o valor, data do empréstimo, tempo de empréstimo, informações do jogador a ser emprestado e clube de destino. (E)????

- **[RF] Empréstimo de jogador com opção/obrigação de compra (Alterar o nome?)**  
O sistema deve permitir o empréstimo de jogadores ao(s) próprio(s) clube(s). (E)

  - **[RF.1] Registro de Empréstimo**  
  O sistema deve registrar o valor, data do empréstimo, tempo de empréstimo, informações do jogador que virá ao clube por empréstimo. (E) ????

- **[RF] Registro de Despesas**  
O sistema deve permitir o registro de despesas que não estão relacionadas com jogadores. (E)

  - **[RF.1] Registro de Despesas com Gramados**  
  O sistema deve permitir o registro de gastos com gramados, considerando gramados do CT e do Estádio. (E)

  - **[RF.2] Registro de Despesas com Uniformes**  
  O sistema deve permitir o registro de gastos com uniformes, considerando os uniformes de jogos, treino e goleiro. (Alterar?????) (E)

  - **[RF.3] Registro de Despesas com Saúde**  
  O sistema deve permitir o registro de gastos na área da saúde (COMPLETAR????). (E)

- **[RF] Edição de Despesas**  
O sistema deve permitir a alteração de alguma(s) informações sobre qualquer despesa registrada. (E)

- **[RF] Exclusão de Despesas**  
O sistema deve permitir a exclusão de qualquer despesa registrada. (E)

  - **[RF] Recalcular Despesas**  
  O sistema deve refazer o cálculo do saldo após a exclusão de alguma despesa. (O)

- **[RF] Histórico de Despesas**  
O sistema deve permitir a visualização de todas as despesas registradas. (E) (estender com os relatorios)

- **[RF] Validação de Despesas**  
O sistema deve validar se as informações sobre as informações de [RF08] e [RF] estão corretas. (VALOR TEM Q SER POSITIVO POR EXEMPLO). (E)

- **[RF] Registro de Receitas**  (deixar especificas para cada situacao???)
O sistema deve permitir o registro de receitas que não estão relacionadas com jogadores. (E)

  - **[RF.1] Registro de Receitas com Bilheteria (*** acho q dá pra tirar esse pq a receita da bilheteria está envolvida com o registro de partidas**)**  
  O sistema deve permitir o registro de receita vindas de jogos de futebol. (E)

  - **[RF.2] Registro de Receitas com Patrocínio**  
  O sistema deve permitir o registro de receitas vindas de patrocínios (MAIS DE UM PATROCINIO?) ligadas ao time. (E)

  - **[RF.3] Registro de Receitas com Vendas de Uniforme**  
  O sistema deve permitir o registro de receitas vindas de vendas de uniforme. (E)
  
  - **[RF.4] Registro de Receitas com Planos Sócio-Torcedor (TALVEZ COLOCAR ISSO?)**  
  O sistema deve permitir a receita vinda do plano sócio-torcedor (AO FIM DO MÊS?). (E)

  - **[RF.5] Registro de Receitas com Títulos de Competições (TALVEZ COLOCAR ISSO?)**  
  O sistema deve permitir a receita vindo de algum título de competição, registrando o nome da competição e valor recebido. (E)  

- **[RF] Edição de Receitas**  
O sistema deve permitir a alteração de alguma(s) informações sobre qualquer receita registrada. (E)

- **[RF] Exclusão de Receitas**  
O sistema deve permitir a exclusão de qualquer receita registrada. (E)

  - **[RF] Exclusão de dados de Receitas**
  O sistema deve apagar os dados referentes às receitas excluidas. (O)

- **[RF] Histórico de Receitas**  
O sistema deve permitir a visualização de todas as receitas registradas. (E)

- **[RF] Validação de Receitas**  
O sistema deve validar se as informações sobre as informações de [RF13] e [RF14] estão corretas. (VALOR TEM Q SER POSITIVO POR EXEMPLO) (O)

- **[RF] Registro de Partidas de Futebol**  
O sistema deve permitir registrar informações das partidas jogadas. (E)

- **[RF.1] Registro de Partidas**  
O sistema deve permitir registrar data, público total. (E)

  - **[RF.1] Registro de Valor de Ingresso**
  O sistema deve permitir registrar o valor do ingresso da partida. (E)

  - **[RF.1.1] Cálculo de Bilheteria**
  O sistema deve calcular o valor de bilheteria baseado no valor de ingresso e no público total. (O) (se puder, colocar a equacao com o calculo)

- **[RF] Edição de Partidas**  
O sistema deve permitir a alteração de alguma(s) informações sobre qualquer partida registrada. (E)

- **[RF] Exclusão de Partidas**  
O sistema deve permitir a exclusão de qualquer partida registrada. (E)

  - **[RF] Exclusão de dados de Partida**  
  O sistema deve apagar os dados referentes às partidas excluidas. (O)

    - **[RF] Recálculo (????) de Saldo de Partidas**
    O sistema deve recalcular o saldo atual após a exclusão de uma partida do sistema. (O)

- **[RF] Histórico de Partidas**  
O sistema deve permitir a visualização de todas as partidas registradas. (E)

- **[RF] Validação de Partidas**  
O sistema deve validar se as informações sobre as informações de [RF18] e [RF19] estão corretas e sem interferências. (O) (VALOR TEM Q SER POSITIVO POR EXEMPLO)

  - **[RF.1] Impedir Conflitos de Horário**  
  O sistema deve impedir que o registro de partidas [RF18.2] e edição de partidas [RF19] marquem os jogos para o mesmo dia. (O)

- **[RF] Cálculo de Saldo**  
O sistema deve calcular o saldo do clube a cada interação com o sistema automaticamente. (O)

- **[RF.1] Atualização de Saldo**  
O sistema atualiza o saldo do clube a cada Cálculo de Saldo [RF23] automaticamente. (O)

- **[RF] Relatórios de Receita**  
O sistema deve gerar relatórios (com gráficos) de receitas. (E)

- **[RF] Relatórios de Despesas**  
O sistema deve gerar relatórios (com gráficos) de despesas. (E)

- **[RF] Relatórios Financeiros Geral**  
O sistema deve gerar relatórios (com gráficos) de saldo. (E)

- **[RF] Relatórios de Partidas**  
O sistema deve gerar relatórios (com gráficos) de partidas. (E)

- **[RF] Busca de Receitas**  
O sistema deve permitir a busca por receita específica. (PENSEI EM RF16 (listagem) e o user busca a receita pelo ID). (E)

- **[RF] Busca de Despesas**  
O sistema deve permitir a busca por despesa específica (E)(SEGUE O DE CIMA)

- **[RF] Busca de Partidas**  
O sistema deve permitir a busca por partida específica. (E)(SEGUE O DE CIMA)

(ACHEI INTERESSANTE BOTAR ESSES HISTÓRICOS ABAIXO – requisitos de auditoria que já vimos em aula)

- **[RF] Histórico de Registros**  
O sistema deve registrar o histórico de registros feitos pelo usuário, quanto a [RF04.1], [RF05.1], [RF06.1], [RF07.1], [RF08], [RF13], [RF18].

  - **[RF.1] Registro de Histórico de Registro**  
  O sistema deve registrar o tipo de registro (Compra, Venda, Empréstimo pra fora, Empréstimo pro clube, Despesa, Receita , Partida // ID do tipo de registro // User – apagar dps isso) e quem fez isso.

- **[RF] Histórico de Alterações**  
O sistema deve registrar o histórico de alterações feitos pelo usuário, quanto a [RF09], [RF14] e [RF19].

  - **[RF.1] Registro de Histórico de Alteração**  
  O sistema deve registrar o tipo de alteração (Compra, Venda, Empréstimo pra fora, Empréstimo pro clube, Despesa, Receita , Partida // ID do tipo de registro // User - apagar dps isso) e quem fez isso.

- **[RF] Exportação de Informações ( SERIALIZABLE)**  
O sistema deve exportar e armazenar o Histórico de Despesas, Histórico de Receitas, Histórico de Partidas, Histórico de Registros e Histórico de Alterações do sistema. (ARQUIVO?)

- **[RF] Carregar Informações ( SERIALIZABLE)**  
O sistema deve importar e carregar o Histórico de Despesas, Histórico de Receitas, Histórico de Partidas, Histórico de Registros e Histórico de Alterações do sistema. (ARQUIVO?)
