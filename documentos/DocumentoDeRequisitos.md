## 1\. Introdução

### 1.1 Propósito do documento de requisitos

Este documento tem como propósito definir e descrever os requisitos funcionais e não funcionais de um sistema de gestão de clubes de futebol organizados como Sociedade Anônima do Futebol (SAF).

Além disso, o documento será utilizado como referência no planejamento, implementação, testes e manutenção do sistema, para assim garantir que todas as necessidades referentes ao sistema sejam satisfeitas.

O público-alvo deste documento envolve:

- Desenvolvedores responsáveis pela implementação do sistema;  
- Dono dos clubes, gestores e diretores financeiros;  
- Analistas de desempenho dos clubes.

### 1.2 Escopo do Produto

O (nome da aplicação) tem como objetivo auxiliar na organização e manipulação das informações financeiras de clubes de futebol estruturados como Sociedade Anônima do Futebol (SAF).

O sistema será utilizado para:

- Cadastrar e gerenciar clubes, usuários e jogadores;  
- Registrar transações financeiras (receitas e despesas);  
- Registrar e acompanhar informações de partidas, incluindo cálculo da bilheteria e premiações;  
- Gerar relatórios detalhados sobre desempenho financeiro e esportivo.

O sistema não contempla integrações com APIs externas de federações, portais de estatísticas de futebol ou sistemas bancários. Todos os dados são inseridos manualmente pelos usuários.

### 1.3 Definições, acrônimos e abreviações

As principais definições, abreviações e acrônimos utilizados neste documento serão listados a seguir.

| Termo | Definição |
| :---- | :---- |
| **SAF** | Sociedade Anônima do Futebol. Modelo jurídico que permite que clubes de futebol sejam transformados em empresas com fins lucrativos. |
| **CT** | Centro de Treinamento. Local utilizado pelos jogadores para realizar treinamentos e preparação para as partidas. |
| **JVM** | Java Virtual Machine. Máquina virtual necessária para executar aplicações desenvolvidas em Java. |
| **Bilheteria** | Receita gerada pela venda de ingressos em uma partida de futebol. |
| **Saldo** | Diferença entre o total de receitas e o total de despesas registradas no sistema. |
| **RF** | Requisito Funcional. Descreve uma funcionalidade que o sistema deve oferecer. |
| **RNF** | Requisito Não Funcional. Descreve uma restrição de qualidade ou comportamento do sistema. |
| **RG** | Restrição Geral. Define limitações ou condições obrigatórias para o funcionamento do sistema. |
| **(E)** | Explícito ao usuário. Requisito cuja execução é visível e perceptível pelo usuário na interface. |
| **(O)** | Oculto ao usuário. Requisito processado internamente pelo sistema, sem interação direta do usuário. |
| **Adm** | Administrador. Usuário com acesso total ao sistema. |
| **GF** | Gestor Financeiro. Usuário com acesso restrito às funcionalidades financeiras. |
| **Op** | Operador. Usuário com acesso restrito às funcionalidades de partidas e relatórios esportivos. |
| **Login** | Processo pelo qual um usuário se autentica no sistema, informando suas credenciais. |
| **Logout** | Processo pelo qual um usuário encerra sua sessão no sistema. |

### 1.4 Referências

### 1.5 Visão do Restante do Documento

Esse documento está organizado em seções, cada uma responsável por descrever partes específicas do sistema proposto. São elas:

A seção 2 apresenta a descrição geral do sistema, indicando os aspectos principais, como perspectivas, funcionalidades, restrições, suposições e dependências do produto. Com isso é possível ter uma visão mais específica do objetivo da aplicação.

A seção 3 descreve com maior detalhamento os requisitos do sistema, de como ele se comunicará com o mundo exterior, e lista as funções e recursos específicos. Com isso será possível ter uma visão geral e entender com mais clareza o funcionamento do sistema.

## 2\. Descrição Geral

### 2.1 Perspectiva do Produto

O sistema é uma aplicação computacional desenvolvida em Java. Ele tem como objetivo auxiliar na organização e no acompanhamento das informações financeiras de Clubes de Futebol organizados como SAF. A aplicação funcionará como uma ferramenta de apoio, permitindo que o usuário registre diferentes tipos de operações financeiras e acompanhe esses dados ao longo do tempo.

Através da interface o usuário poderá cadastrar transações, registrar informações sobre partidas realizadas, acompanhar receitas de diversas categorias e visualizar relatórios que apresentam o desempenho financeiro e esportivo do clube.

### 2.2 Funcionalidades

O sistema deverá fornecer um conjunto de funcionalidades que permitam ao usuário registrar, consultar e gerar relatórios relacionados à parte financeira e operacional dos clubes que serão geridos.

Com isso, o sistema deve permitir:

- Cadastro de usuários com diferentes níveis de permissão;  
- Cadastro, edição e exclusão de clubes de futebol;  
- Cadastro de jogadores, vinculando-os ao clube;  
- Registro de transações financeiras com jogadores: compra, venda e empréstimo;  
- Registro de despesas operacionais: contas de energia, água, gramados, uniformes, saúde, salários, entre outros;  
- Registro de receitas: bilheteria, patrocínio, venda de uniformes, plano sócio-torcedor, premiações;  
- Registro de informações sobre as partidas realizadas pelo time;  
- Cálculo automático do saldo financeiro do clube a cada nova transação;  
- Geração de relatórios financeiros e esportivos;  
- Exportação e importação de dados por meio de banco de dados relacional.

### 2.3 Características do usuário

O sistema é voltado principalmente para usuários responsáveis pela gestão administrativa e financeira de clubes de futebol organizados como Sociedade Anônima do Futebol.

**Administrador (Adm):** Possui acesso total ao sistema. É responsável por cadastrar outros usuários, gerenciar clubes e ter acesso irrestrito a todos os módulos do sistema. Geralmente corresponde ao presidente ou diretor-executivo do clube.

**Gestor Financeiro (GF):** Tem acesso exclusivamente às funcionalidades relacionadas à gestão financeira do clube: registro e edição de despesas, receitas, transferências de jogadores e geração de relatórios financeiros. Não tem acesso a funcionalidades administrativas de usuários ou clubes. Corresponde ao diretor financeiro ou gerente administrativo.

**Operador (Op):** Possui acesso limitado, podendo apenas registrar, editar, excluir e consultar partidas. Pode também gerar relatórios de desempenho esportivo não financeiro. Não tem acesso a nenhuma funcionalidade financeira. Corresponde a analistas de futebol ou assistentes técnicos.

Todos os usuários devem possuir conhecimentos básicos de informática, sendo capazes de utilizar sistemas computacionais.

### 2.4 Restrições Gerais

**RG01 Restrição de Login:** O acesso ao sistema deve ser restrito a usuários autenticados por meio de login e senha. Nenhuma funcionalidade do sistema pode ser acessada sem autenticação prévia.

**RG02 Persistência de Dados:** Todos os registros e informações do sistema devem ser armazenados de maneira permanente em um banco de dados relacional, a fim de garantir a existência e a integridade dos dados mesmo fora da execução do sistema.

**RG03 Controle de Acesso por Hierarquia:** Cada funcionalidade do sistema segue uma ordem hierárquica de acesso. Um usuário não pode acessar, criar ou modificar recursos para os quais não possui permissão, conforme o nível Adm, GF ou Op.

**RG04 Plataforma de Execução:** O sistema deve ser executável em qualquer sistema operacional compatível com a JVM (Java Virtual Machine), incluindo Windows, Linux e macOS.

**RG05 Acesso de Usuário Único por Sessão:** O sistema operará em modo monousuário por sessão, sem suporte a acesso simultâneo de múltiplos usuários em tempo real.

### 2.5 Suposições e Dependências

Assume-se que os usuários possuem conhecimento básico sobre conceitos de gestão financeira relacionados ao futebol, sendo capazes de registrar corretamente receitas, despesas, bilheteria, bônus de partidas e premiações.

Assume-se também que os usuários possuem conhecimento básico em sistemas computacionais, visto que os dados serão inseridos manualmente por eles, não dependendo de integrações automáticas.

O sistema depende da disponibilidade de um ambiente computacional capaz de executar aplicações desenvolvidas na linguagem Java, sendo necessários sistemas operacionais que suportam Máquina Virtual Java (JVM), como Linux, Windows ou macOS.

## 

## 3\. Requisitos Específicos

### 3.1 Requisitos Funcionais

#### Autenticação e Sessão

**RF01 – Cadastrar o primeiro usuário:** o sistema deve exibir uma tela de cadastro ao ser iniciado pela primeira vez, criando automaticamente o Administrador do sistema. (E)

**RF02 – Autenticar usuário:** o sistema deve permitir que o usuário informe login e senha para acessar o sistema, bloqueando qualquer funcionalidade enquanto a autenticação não for concluída com sucesso. (E)

- **RF02.1 – Restringir acesso por nível de permissão:** o sistema deve exibir apenas as funcionalidades compatíveis com o nível do usuário autenticado (Adm, GF ou Op). (O)  
    
- **RF02.2 – Exibir mensagem de erro de autenticação:** o sistema deve exibir mensagem de erro informando que o login ou a senha estão incorretos, caso o login não exista. (E)

**RF03 – Encerrar sessão:** o sistema deve permitir que o usuário autenticado encerre sua sessão a qualquer momento, retornando à tela de login. (E)

- **RF03.1 – Confirmar encerramento de sessão:** o sistema deve exibir mensagem de confirmação antes de encerrar a sessão. (E)  
    
- **RF03.2 – Invalidar dados da sessão encerrada:** o sistema deve impedir qualquer acesso às funcionalidades protegidas sem nova autenticação. (O)

#### Gerenciamento de Usuários

**RF04 – Cadastrar usuário:** o sistema deve permitir o cadastro de novos usuários. (E)

- **RF04.1 – Restringir cadastro de usuário ao Adm:** somente o Adm pode acessar a tela de cadastro de novos usuários; GF e Op não visualizam essa opção no sistema. (O)  
    
- **RF04.2 – Validar unicidade de nome de usuário e e-mail:** no momento do cadastro, o sistema deve verificar se o nome de usuário já existe. (O)  
    
  - **RF04.2.1 – Exibir mensagem de erro de nome duplicado:** o sistema deve apresentar mensagem de erro caso o nome de usuário já exista. (E)


- **RF04.3 – Informações de cadastro:** o sistema deve conter as seguintes informações de usuário: (E)  
    
  - Nome de usuário;  
  - Senha;  
  - Nível de usuário;  
  - Clube no qual o usuário opera.

**RF05 – Alterar usuário:** o sistema deve permitir editar as informações de um usuário já cadastrado. (E)

- **RF05.1 – Restringir alteração de usuário ao Adm:** o sistema deve permitir somente o Adm editar informações de outros usuários; GF e Op não visualizam essa opção no sistema. (O)  
    
- **RF05.2 – Alterar a própria senha:** o sistema deve permitir que qualquer usuário autenticado altere sua própria senha. (E)

**RF06 – Excluir usuário:** o sistema deve permitir ao Adm excluir o cadastro de um usuário, desvinculando-o permanentemente do sistema após confirmação da operação. (E)

- **RF06.1 – Restringir exclusão de usuário ao Adm:** somente o Adm pode excluir usuários; GF e Op não visualizam essa opção no sistema. (O)  
    
- **RF06.2 – Impedir autoexclusão:** o sistema deve bloquear a tentativa de um usuário excluir sua própria conta enquanto estiver autenticado. (O)  
    
- **RF06.3 – Preservar histórico de auditoria do usuário excluído:** ao excluir um usuário, o sistema deve manter os registros de auditoria associados a ele. (O)

**RF07 – Listar usuários:** o sistema deve exibir a lista de todos os usuários cadastrados, apresentando as informações deles. (E)

- **RF07.1 – Restringir listagem de usuários ao Adm:** somente o Adm pode visualizar a lista de usuários; GF e Op não têm acesso a essa tela. (O)  
    
- **RF07.2 – Buscar usuário:** o sistema deve permitir localizar um usuário específico na listagem através do nome do usuário. (E)

#### Gerenciamento de Clubes

**RF08 – Cadastrar clube:** o sistema deve permitir o cadastro de um ou mais clubes de futebol. (E)

- **RF08.1 – Restringir cadastro de clube:** somente o Adm pode cadastrar clubes; GF e Op não visualizam essa opção no sistema. (O)  
    
- **RF08.2 – Validar unicidade do clube:** o sistema deve verificar se já existe um clube com o mesmo cadastro. (O)  
    
  - **RF08.2.1 – Exibir mensagem de erro de clube duplicado:** o sistema deve apresentar mensagem de erro se o clube já estiver cadastrado. (E)


- **RF08.3 – Informações de cadastro:** o sistema deve conter as seguintes informações de clube: (E)  
    
  - Nome do clube;  
  - Ano de fundação do clube;  
  - País;

**RF09 – Alterar clube:** o sistema deve permitir editar as informações de um clube já cadastrado. (E)

- **RF09.1 – Restringir alteração de clube:** somente o Adm pode editar informações de clubes; GF e Op não visualizam essa opção no sistema. (O)

**RF10 – Excluir clube:** o sistema deve permitir excluir o cadastro de um clube, exigindo confirmação explícita antes de concluir a operação e removendo todos os dados vinculados a ele do banco de dados. (E)

- **RF10.1 – Restringir exclusão de clube ao Adm:** somente o Adm pode excluir clubes; GF e Op não visualizam essa opção no sistema. (O)  
    
- **RF10.2 – Excluir dados vinculados ao clube:** o sistema deve remover todos os registros diretamente associados ao clube, ao confirmar a exclusão. (O)

**RF11 – Listar clubes:** o sistema deve exibir todos os clubes cadastrados com suas informações básicas em formato de lista. (E)

- **RF11.1 – Restringir listagem de clubes ao Adm:** somente o Adm pode visualizar a lista de clubes cadastrados; GF e Op não têm acesso a essa tela. (O)

#### Gerenciamento de Jogadores

**RF12 – Cadastrar jogador:** o sistema deve permitir cadastrar jogadores vinculados a um clube. (E)

- **RF12.1 – Restringir cadastro de jogador a Adm e GF:** somente Adm e GF podem cadastrar jogadores; Op não visualiza essa opção. (O)  
    
- **RF12.2 – Validar informações de jogador:** o sistema deve verificar se o cadastro de jogador já está no clube. (O)  
    
  - **RF12.2.1 – Exibir mensagem de erro de jogador duplicado:** o sistema deve recusar o cadastro e exibir mensagem de erro em caso de duplicidade do cadastro. (O)


- **RF12.3 – Informações de cadastro:** o sistema deve conter as seguintes informações de clube: (E)  
    
  - 

**RF13 – Alterar jogador:** o sistema deve permitir editar as informações de um jogador cadastrado, aplicando as mesmas validações do cadastro. (E)

- **RF13.1 – Restringir alteração de jogador a Adm e GF:** somente Adm e GF podem editar informações de jogadores; Op não visualiza essa opção. (O)

**RF14 – Excluir jogador:** o sistema deve permitir excluir o cadastro de um jogador, desvinculando-o do clube após confirmação da operação. (E)

- **RF14.1 – Restringir exclusão de jogador a Adm e GF:** somente Adm e GF podem excluir jogadores; Op não visualiza essa opção. (O)

**RF15 – Listar jogadores:** o sistema deve exibir todos os jogadores vinculados a um clube, apresentando as informações deles. (E)

- **RF15.1 – Restringir listagem de jogadores a Adm e GF:** somente Adm e GF podem visualizar a lista de jogadores; Op não tem acesso a essa tela. (O)

#### Transações Financeiras com Jogadores

**RF16 – Registrar compra de jogador:** o sistema deve permitir registrar a aquisição de um jogador informando. (E)

- **RF16.1 – Restringir registro de compra a Adm e GF:** somente Adm e GF podem registrar compras de jogadores; Op não visualiza essa opção. (O)  
    
- **RF16.2 – Lançar compra como despesa automaticamente:** o sistema deve registrar o valor de compra como despesas financeiras automaticamente, ao registrar uma compra de jogador. (O)  
    
- **RF16.3 – Validar registro de compra:** o sistema deve verificar se as informações informadas são válidas. (O)  
    
  - **RF16.3.1 – Erro no registro de compra:** o sistema deve exibir uma mensagem de erro em caso de inconsistência na validação das informações de compra. (E)


- **RF16.4 – Cadastrar jogador comprado:** o sistema deve solicitar os dados básicos do jogador adquirido e cadastrá-lo automaticamente, ao registrar a compra. (E)  
    
- **RF16.5 – Informações de compra:** o sistema deve conter as seguintes informações da compra do jogador: (E)  
    
  - Jogador que foi comprado;  
  - Valor de compra.

**RF17 – Registrar venda de jogador:** o sistema deve permitir registrar a venda de um jogador. (E)

- **RF17.1 – Restringir registro de venda a Adm e GF:** somente Adm e GF podem registrar vendas de jogadores; Op não visualiza essa opção. (O)  
    
- **RF17.2 – Lançar venda como receita automaticamente:** ao confirmar a venda, o sistema deve registrar a receita financeira sem intervenção adicional do usuário. (O)  
    
- **RF17.3 – Validar registro de venda:** o sistema deve verificar se o registro de venda é válido. (O)  
    
  - **RF17.3.1 – Erro no registro de venda:** o sistema deve exibir uma mensagem de erro em caso de inconsistência na validação das informações de registro de venda. (E)


- **RF17.4 – Informações de Venda:** o sistema deve conter as seguintes informações da venda do jogador: (E)  
    
  - Jogador que foi vendido;  
  - Valor de venda.

**RF18 – Registrar empréstimo de jogador para outro clube:** o sistema deve permitir registrar o empréstimo de um jogador para outro clube. (E)

- **RF18.1 – Restringir registro de empréstimo de saída a Adm e GF:** somente Adm e GF podem registrar empréstimos de saída; Op não visualiza essa opção. (O)  
    
- **RF18.2 – Atualizar status do jogador emprestado para fora:** o sistema deve manter o vínculo do jogador com o clube mas retirando-o da lista de ativos, ao confirmar o empréstimo de jogador. (O)  
    
- **RF18.3 – Informações de empréstimo:** o sistema deve conter as seguintes informações da venda do jogador: (E)  
    
  - Jogador que foi emprestado;  
  - Tempo de Empréstimo.

**RF19 – Registrar empréstimo de jogador para o clube:** o sistema deve permitir registrar a vinda de um jogador de outro clube por empréstimo. (E)

- **RF19.1 – Restringir registro de empréstimo de entrada a Adm e GF:** somente Adm e GF podem registrar empréstimos de entrada; Op não visualiza essa opção. (O)  
    
- **RF19.2 – Cadastrar jogador emprestado:** o sistema deve solicitar os dados básicos do jogador e cadastrá-lo. (E)  
    
  - **RF19.2.1 – Distinção de jogador:** o sistema deve distinguir os jogadores que foram emprestados dos que não foram emprestados. (O)

#### Gerenciamento de Despesas

**RF20 – Registrar despesa:** o sistema deve permitir registrar despesas operacionais do clube. (E)

- **RF20.1 – Restringir registro de despesas a Adm e GF:** somente Adm e GF podem registrar despesas; Op não visualiza essa opção. (O)

**RF20.2 – Selecionar categoria de despesa:** o sistema deve exigir a seleção de uma das categorias disponíveis. (E)

- **RF20.2.1 – Registrar despesa de infraestrutura:** o sistema deve permitir registrar gastos com energia elétrica, água, esgoto, manutenção de instalações e gramados do CT e do estádio, podendo diferenciar o local e o tipo de serviço realizado. (E)  
    
- **RF20.2.2 – Registrar despesa de produção:** o sistema deve permitir registrar gastos com aquisição de uniformes, chuteiras, copos e vestimentas, podendo detalhar o tipo de item adquirido. (E)  
    
- **RF20.2.3 – Registrar despesa de saúde e fisioterapia:** o sistema deve permitir registrar gastos médicos do clube, incluindo atendimentos, exames, medicamentos e equipamentos de saúde. (E)  
    
- **RF20.2.4 – Registrar despesa de salários e encargos:** o sistema deve permitir registrar o pagamento de salários de jogadores, comissão técnica e funcionários, associando cada lançamento ao período de referência. (E)  
    
- **RF20.2.5 – Registrar despesa de viagens e logística:** o sistema deve permitir registrar gastos com deslocamento, hospedagem e alimentação da delegação, podendo vincular a despesa a partidas ou eventos. (E)  
    
- **RF20.2.6 – Registrar outras despesas:** o sistema deve permitir registrar despesas que não se enquadram nas categorias anteriores, exigindo descrição detalhada do lançamento. (E)  
    
- **RF20.3 – Validar dados da despesa:** o sistema deve validar as informações dos registros de despesa. (O)  
    
  - **RF20.3.1 – Erro no registro de despesa:** o sistema deve exibir uma mensagem de erro em caso de inconsistência no registro de despesa. (E)


- **RF20.4 – Informações de despesa:** o sistema deve conter as seguintes informações das despesas: (E)  
    
  - Categoria;  
  - Valor;  
  - Descrição.

**RF21 – Alterar despesa:** o sistema deve permitir editar qualquer campo de uma despesa já registrada. (E)

- **RF21.1 – Restringir alteração de despesas a Adm e GF:** somente Adm e GF podem editar despesas; Op não visualiza essa opção. (O)  
    
- **RF21.2 – Registrar alteração de despesa no histórico:** ao editar uma despesa, o sistema deve registrar automaticamente a operação no histórico de auditoria. (O)  
    
  - **RF21.2.1 – Registrar usuário responsável e valores alterados:** o sistema deve registrar no histórico de alterações o usuário responsável pela alteração e os valores anteriores e novos. (O)


- **RF21.3 – Recalcular saldo após edição de despesa:** o sistema deve recalcular automaticamente o saldo do clube ao editar uma despesa. (O)

**RF22 – Excluir despesa:** o sistema deve permitir excluir permanentemente uma despesa registrada. (E)

- **RF22.1 – Restringir exclusão de despesas a Adm e GF:** somente Adm e GF podem excluir despesas; Op não visualiza essa opção. (O)  
    
- **RF22.2 – Confirmar exclusão de despesa:** o sistema deve exibir mensagem de confirmação informando o impacto da operação no saldo do clube, antes de excluir. (E)  
    
- **RF22.3 – Recalcular saldo após exclusão de despesa:** o sistema deve recalcular e atualizar automaticamente o saldo financeiro do clube sem intervenção do usuário, ao confirmar a exclusão. (O)

**RF23 – Listar despesas:** o sistema deve permitir a visualização de todas as despesas registradas. (E)

- **RF23.1 – Restringir listagem de despesas a Adm e GF:** somente Adm e GF podem visualizar o histórico de despesas; Op não tem acesso a essa tela. (O)

**RF24 – Buscar despesa:** o sistema deve permitir localizar uma despesa específica. (E)

- **RF24.1 – Restringir busca de despesas a Adm e GF:** somente Adm e GF podem buscar despesas; Op não tem acesso a essa funcionalidade. (O)

#### Gerenciamento de Receitas

**RF25 – Registrar receita:** o sistema deve permitir registrar receitas do clube informando obrigatoriamente categoria, descrição, valor e data de competência. (E)

- **RF25.1 – Restringir registro de receitas a Adm e GF:** somente Adm e GF podem registrar receitas; Op não visualiza essa opção. (O)

**RF25.2 – Selecionar categoria de receita:** o sistema deve exigir a seleção de uma das categorias disponíveis. (E)

- **RF25.2.1 – Registrar receita de bilheteria:** o sistema deve permitir registrar receitas provenientes da venda de ingressos por partida, informando data, público e valor arrecadado. (E)  
    
- **RF25.2.2 – Registrar receita de patrocínio:** o sistema deve permitir registrar receitas de contratos de patrocínio e naming rights. (E)  
    
- **RF25.2.3 – Registrar receita de produtos:** o sistema deve permitir registrar receitas da venda de camisas e produtos em geral, informando quantidade, valor unitário e data da venda. (E)  
    
- **RF25.2.4 – Registrar receita do plano sócio-torcedor:** o sistema deve permitir registrar receitas de mensalidades e contribuições, informando período de referência e valor arrecadado. (E)  
    
- **RF25.2.5 – Registrar receita de premiações:** o sistema deve permitir registrar valores recebidos por classificação em competições. (E)  
    
- **RF25.2.6 – Registrar outras receitas:** o sistema deve permitir registrar receitas que não se enquadram nas categorias anteriores, exigindo descrição detalhada do lançamento. (E)  
    
- **RF25.3 – Validar dados da receita:** o sistema deve verificar se as informações dos dados de receitas são válidas. (O)  
    
  - **RF25.3.1 – Erro nos dados da receita:** o sistema deve exibir uma mensagem de erro em caso de inconsistência dos dados da receita. (E)


- **RF25.4 – Informações de receitas:** o sistema deve conter as seguintes informações das receitas: (E)  
    
  - Categoria;  
  - Valor;  
  - Descrição.

**RF26 – Alterar receita:** o sistema deve permitir editar qualquer campo de uma receita já registrada. (E)

- **RF26.1 – Restringir alteração de receitas a Adm e GF:** somente Adm e GF podem editar receitas; Op não visualiza essa opção. (O)  
    
- **RF26.2 – Registrar alteração de receita no histórico:** o sistema deve registrar automaticamente a operação no histórico de auditoria, ao editar uma receita. (O)  
    
  - **RF26.2.1 – Identificar usuário responsável e valores alterados:** o sistema deve identificar o usuário responsável pela alteração e os valores anteriores e novos. (O)


- **RF26.3 – Recalcular saldo após edição de receita:** o sistema deve recalcular automaticamente o saldo do clube ao confirmar a edição de receita. (O)

**RF27 – Excluir receita:** o sistema deve permitir excluir permanentemente uma receita registrada. (E)

- **RF27.1 – Restringir exclusão de receitas a Adm e GF:** somente Adm e GF podem excluir receitas; Op não visualiza essa opção. (O)  
    
- **RF27.2 – Confirmar exclusão de receita:** o sistema deve exibir mensagem de confirmação informando o impacto da operação no saldo do clube, antes de excluir. (E)  
    
- **RF27.3 – Recalcular saldo após exclusão de receita:** ao confirmar a exclusão, o sistema deve recalcular e atualizar automaticamente o saldo financeiro do clube sem intervenção do usuário. (O)

**RF28 – Listar receitas:** o sistema deve exibir todas as receitas registradas com todas as informações associadas a elas. (E)

- **RF28.1 – Restringir listagem de receitas a Adm e GF:** somente Adm e GF podem visualizar o histórico de receitas; Op não tem acesso a essa tela. (O)

**RF29 – Buscar receita:** o sistema deve permitir localizar uma receita específica por seu identificador e exibir os detalhes completos do registro encontrado. (E)

- **RF29.1 – Restringir busca de receitas a Adm e GF:** somente Adm e GF podem buscar receitas; Op não tem acesso a essa funcionalidade. (O)

#### Controle de Saldo Financeiro

**RF30 – Calcular saldo do clube:** o sistema deve calcular automaticamente o saldo financeiro do clube após cada operação que envolva receita ou despesa, sem necessidade de intervenção do usuário. (O)

O saldo é obtido pela seguinte fórmula:

$$ \\text{Saldo} \= \\sum \\text{Receitas} \- \\sum \\text{Despesas} $$

- **RF30.1 – Atualizar saldo no banco de dados:** ao recalcular o saldo, o sistema deve persistir o novo valor no banco de dados imediatamente. (O)  
    
- **RF30.2 – Restringir visualização do saldo a Adm e GF:** o valor do saldo financeiro do clube não deve ser exibido ou acessível a usuários com perfil Op. (O)

#### Registro e Gerenciamento de Partidas

**RF31 – Registrar partida:** o sistema deve permitir registrar informações de uma partida. (E)

- **RF31.1 – Restringir registro de partidas a Adm e Op:** somente Adm e Op podem registrar partidas; GF não visualiza essa opção. (O)  
    
- **RF31.2 – Registrar público e valor de ingresso:** o sistema deve permitir informar o número de espectadores e o valor do ingresso da partida, sendo esses campos obrigatórios quando o jogo for disputado em casa. (E)  
    
- **RF31.3 – Calcular a bilheteria automaticamente:** o sistema deve calcular o valor de bilheteria e registrá-lo automaticamente como receita financeira do clube na data da partida. (O)  
    
  $$ V\_{\\text{bilheteria}} \= V\_{\\text{ingresso}} \\times N\_{\\text{público}} $$  
    
  Onde $V\_{\\text{bilheteria}}$ é o total arrecadado, $V\_{\\text{ingresso}}$ é o valor unitário do ingresso e $N\_{\\text{público}}$ é a quantidade de espectadores presentes.  
    
- **RF31.4 – Classificar resultado da partida:** o sistema deve classificar automaticamente o resultado como vitória, empate ou derrota, sem intervenção adicional do usuário. (O)  
    
- **RF31.5 – Registrar bônus e premiação por partida:** o sistema deve permitir informar, vinculado a uma partida, o recebimento de bônus ou premiação com descrição e valor. (E)  
    
  - **RF31.5.1 – Registrar bônus de partida como receita automaticamente:** o sistema deve registrar automaticamente o bônus de partida como receita. (O)


- **RF31.6 – Validar dados da partida:** o sistema deve verificar se os dados informados são válidos. (O)  
    
  - **RF31.6.1 – Erro nos dados de partida:** o sistema deve exibir uma mensagem de erro em caso de inconsistência dos dados de partida. (E)


- **RF31.7 – Informações de partidas:** o sistema deve conter as seguintes informações das partidas: (E)  
    
  - Data;  
  - Competição;  
  - Público total;  
  - Valor do ingresso;  
  - Premiação;  
  - Placar.

**RF32 – Alterar partida:** o sistema deve permitir editar qualquer informação de uma partida já registrada. (E)

- **RF32.1 – Restringir alteração de partidas a Adm e Op:** somente Adm e Op podem editar partidas; GF não visualiza essa opção. (O)  
    
- **RF32.2 – Registrar alteração de partida no histórico:** ao editar uma partida, o sistema deve registrar automaticamente a operação no histórico de auditoria. (O)  
    
- **RF32.3 – Recalcular bilheteria e saldo após edição de partida:** o sistema deve recalcular automaticamente a bilheteria e o saldo em caso de edição das informações da partida. (O)

**RF33 – Excluir partida:** o sistema deve permitir excluir permanentemente uma partida registrada após confirmação. (E)

- **RF33.1 – Restringir exclusão de partidas a Adm e Op:** somente Adm e Op podem excluir partidas; GF não visualiza essa opção. (O)  
    
- **RF33.2 – Confirmar exclusão de partida:** o sistema deve exibir mensagem de confirmação informando que os dados da partida e a receita de bilheteria serão removidos permanentemente. (E)  
    
- **RF33.3 – Remover receita de bilheteria vinculada:** ao excluir a partida, o sistema deve remover automaticamente o valor da bilheteria do registro de receitas. (O)  
    
- **RF33.4 – Recalcular saldo após exclusão de partida:** o sistema deve recalcular e atualizar automaticamente o saldo financeiro do clube após a remoção da partida e da receita de bilheteria vinculada. (O)

**RF34 – Listar partidas:** o sistema deve exibir todas as partidas registradas. (E)

- **RF34.1 – Restringir listagem de partidas a Adm e Op:** somente Adm e Op podem visualizar o histórico de partidas; GF não tem acesso a essa tela. (O)

**RF35 – Buscar partida:** o sistema deve permitir localizar uma partida por seu identificador, exibindo os detalhes completos do registro encontrado. (E)

- **RF35.1 – Restringir busca de partidas a Adm e Op:** somente Adm e Op podem buscar partidas; GF não tem acesso a essa funcionalidade. (O)

#### Relatórios

**RF36 – Gerar relatório de despesas:** o sistema deve gerar relatório de despesas exibindo o total gasto por categoria e por período, com representação gráfica (barras ou pizza) e listagem detalhada dos lançamentos. (E)

- **RF36.1 – Restringir relatório de despesas a Adm e GF:** somente Adm e GF podem gerar e visualizar relatórios de despesas; Op não visualiza essa opção. (O)  
    
- **RF36.2 – Filtrar relatório de despesas por período:** o sistema deve permitir definir intervalo de datas para o relatório, exibindo apenas lançamentos dentro do período informado. (E)  
    
- **RF36.3 – Filtrar relatório de despesas por categoria:** o sistema deve permitir selecionar uma ou mais categorias para filtrar o relatório, exibindo apenas os lançamentos das categorias escolhidas. (E)

**RF37 – Gerar relatório de receitas:** o sistema deve gerar relatório de receitas exibindo o total recebido por categoria e por período, com representação gráfica (barras ou pizza) e listagem detalhada dos lançamentos. (E)

- **RF37.1 – Restringir relatório de receitas a Adm e GF:** somente Adm e GF podem gerar e visualizar relatórios de receitas; Op não visualiza essa opção. (O)  
    
- **RF37.2 – Filtrar relatório de receitas por período:** o sistema deve permitir definir intervalo de datas para o relatório, exibindo apenas lançamentos dentro do período informado. (E)  
    
- **RF37.3 – Filtrar relatório de receitas por categoria:** o sistema deve permitir selecionar uma ou mais categorias para filtrar o relatório de receitas, exibindo apenas os lançamentos das categorias selecionadas. (E)

**RF38 – Gerar relatório financeiro geral:** o sistema deve gerar relatório consolidado com total de receitas, total de despesas, saldo resultante e representação gráfica da evolução do saldo ao longo de um período. (E)

- **RF38.1 – Restringir relatório financeiro geral a Adm e GF:** somente Adm e GF podem gerar e visualizar o relatório financeiro geral; Op não visualiza essa opção. (O)  
    
- **RF38.2 – Filtrar relatório financeiro por período:** o sistema deve permitir definir intervalo de datas, calculando receitas, despesas e saldo apenas dentro do período selecionado. (E)

**RF39 – Gerar relatório de partidas:** o sistema deve gerar relatório de desempenho esportivo com total de partidas, vitórias, empates, derrotas, gols marcados, gols sofridos e aproveitamento percentual do clube. (E)

- **RF39.1 – Restringir relatório de partidas a Adm, GF e Op:** Adm, GF e Op podem gerar e visualizar relatórios de partidas; é o único tipo de relatório acessível ao Op. (O)  
    
- **RF39.2 – Filtrar relatório de partidas por competição:** o sistema deve permitir selecionar uma competição específica para o relatório, exibindo apenas resultados daquela competição. (E)  
    
- **RF39.3 – Filtrar relatório de partidas por período:** o sistema deve permitir definir intervalo de datas para o relatório, considerando apenas os jogos realizados no período selecionado. (E)  
    
- **RF39.4 – Filtrar relatório de partidas por local:** o sistema deve permitir filtrar o relatório por local (casa ou fora), exibindo as estatísticas de cada situação separadamente para facilitar a análise. (E)

#### Histórico de Auditoria

**RF40 – Registrar histórico de inserções:** o sistema deve registrar automaticamente um log de cada novo dado inserido, contendo tipo da operação, identificador do dado, data e hora e usuário responsável. (O)

- **RF40.1 – Restringir visualização do histórico de inserções ao Adm:** somente o Adm pode acessar e visualizar o histórico completo de inserções realizadas no sistema. (O)  
    
- **RF40.2 – Armazenar tipo e identificador do dado registrado:** o sistema deve armazenar o tipo do dado, o identificador único do registro e o nome de usuário que realizou a operação. (O)

**RF41 – Registrar histórico de alterações:** o sistema deve registrar automaticamente um log de cada novo dado editado, contendo tipo da operação, identificador do dado, data e hora e usuário responsável. (O)

- **RF41.1 – Restringir visualização do histórico de alterações ao Adm:** somente o Adm pode acessar e visualizar o histórico completo de alterações realizadas no sistema. (O)  
    
- **RF41.2 – Armazenar tipo, identificador e usuário da alteração:** o sistema deve armazenar o tipo do dado alterado, o identificador do registro e o nome de usuário do responsável pela alteração. (O)

### 3.2 Requisitos Não Funcionais

Os requisitos não funcionais descrevem as características de qualidade que o sistema deve apresentar, independentemente das funcionalidades específicas. Eles abrangem aspectos de desempenho, usabilidade, confiabilidade, segurança, portabilidade e manutenibilidade do software.

#### Desempenho

**RNF01 – Tempo de resposta para operações comuns:** o sistema deve responder a operações básicas em no máximo 4 (quatro) segundos. (O)

**RNF02 – Tempo de resposta para geração de relatórios:** o sistema deve gerar e exibir qualquer relatório solicitado em no máximo 5 (cinco) segundos. (O)

**RNF03 – Desempenho consistente com crescimento de dados:** o sistema não deve apresentar degradação perceptível de desempenho à medida que o volume de dados cresce, mantendo tempos de resposta aceitáveis para listagens, buscas e relatórios. (O)

#### Usabilidade

**RNF04 – Interface intuitiva:** o sistema deve ter a interface organizada de forma clara e consistente, permitindo que um usuário com conhecimento básico de informática realize as operações principais. (E)

**RNF05 – Mensagens de erro claras:** o sistema deve exibir mensagens de erro em linguagem simples e objetiva, indicando o que ocorreu e o que o usuário deve fazer para corrigir o problema. (E)

**RNF06 – Confirmação de operações irreversíveis:** o sistema deve solicitar confirmação explícita antes de executar operações irreversíveis, como exclusões de registros. (E)

**RNF07 – Consistência visual da interface:** a interface deve manter padrões visuais consistentes em todas as telas — posicionamento de botões, cores de ação e vocabulário. (E)

**RNF08 – Feedback visual de operações em andamento:** o sistema deve exibir indicador visual de progresso durante operações que possam demorar mais de 1 (um) segundo. (E)

**RNF09 – Interface com linguagem simples:** toda a interface deve estar escrita em português brasileiro, sem mistura de idiomas ou termos técnicos sem tradução. (E)

#### Confiabilidade

**RNF10 – Garantia de persistência de operações confirmadas:** qualquer operação confirmada pelo usuário deve ser gravada no banco de dados antes de ser considerada concluída. (O)

**RNF11 – Consistência do saldo financeiro:** o saldo financeiro exibido deve estar sempre consistente com o conjunto de receitas e despesas registradas. (O)

**RNF12 – Tratamento de erros internos:** o sistema deve tratar internamente todas as exceções não esperadas, exibindo uma mensagem de erro ao usuário. (O)

#### Segurança

**RNF13 – Controle de acesso baseado em perfil:** o sistema deve garantir que nenhuma funcionalidade restrita possa ser acessada por um usuário sem o nível de permissão adequado. (O)

**RNF14 – Sessão invalidada após logout:** após o encerramento de sessão, o sistema deve invalidar completamente os dados da sessão anterior, impedindo acesso a qualquer funcionalidade protegida sem nova autenticação. (O)

**RNF15 – Proteção de dados financeiros:** as informações financeiras do clube — saldo, receitas, despesas e transações com jogadores — devem ser acessíveis somente a usuários com perfil Adm ou GF, nunca sendo exibidas ao Op. (O)

**RNF16 – Imutabilidade do histórico de auditoria:** os registros do histórico de auditoria não devem poder ser editados ou excluídos por nenhum usuário do sistema. (O)

#### Portabilidade

**RNF17 – Compatibilidade com múltiplos sistemas operacionais:** o sistema deve ser executável em sistemas operacionais como Windows, Linux e macOS. (O)

**RNF18 – Independência de serviços externos:** o sistema não deve depender de serviços remotos, conexão com internet ou servidores externos para funcionar. (O)

### **3.3 Requisitos de Interface**

Os requisitos de interface descrevem as características das interações entre o sistema e os agentes externos com os quais ele se relaciona, incluindo os usuários humanos, o hardware subjacente, os softwares do ambiente de execução e os mecanismos de comunicação de dados.

#### **3.3.1 Interface de Usuário**

Esta subseção descreve os requisitos relacionados à estrutura visual, navegação, formulários e padrões de interação que o sistema deve apresentar ao usuário.

**RI01 – Estrutura de navegação principal:** o sistema deve apresentar uma estrutura de navegação principal, organizada em seções correspondentes aos módulos funcionais disponíveis para o perfil do usuário autenticado. (E)

- **RI01.1 – Ocultar itens sem permissão:** o sistema deve exibir na navegação principal apenas os módulos e funcionalidades acessíveis ao perfil do usuário autenticado. (O)

**RI02 – Tela de login:** o sistema deve apresentar, como primeira tela exibida ao ser iniciado, um formulário de autenticação contendo campos para nome de usuário e senha. (E)

- **RI02.1 – Ocultar caracteres do campo senha:** o sistema deve mascarar os caracteres digitados no campo de senha. (E)  
    
- **RI02.2 – Impedir acesso a outras telas sem autenticação:** o sistema deve bloquear a exibição de qualquer tela ou componente funcional enquanto o login não for feito. (O)

**RI03 – Tela de cadastro inicial:** o sistema deve exibir, quando iniciado pela primeira vez sem nenhum usuário registrado, uma tela de cadastro dedicada à criação do primeiro administrador. (E)

**RI04 – Formulários de cadastro e edição:** o sistema deve apresentar formulários organizados para todas as operações de cadastro e edição, controles de ação distintos para confirmar ou cancelar a operação. (E)

- **RI04.1 – Exibir mensagens de validação inline:** o sistema deve exibir mensagens de erro de validação ao lado ou abaixo do campo que originou o problema, sem redirecionar o usuário para outra tela. (E)  
    
- **RI04.2 – Preservar dados preenchidos após erro de validação:** o sistema deve manter os dados que já foram preenchidos e informar somente qual campo está incorreto. (E)  
    
- **RI04.3 – Informar campos de preenchimento obrigatório:** o sistema deve indicar visualmente os campos de preenchimento obrigatório. (E)

**RI05 – Telas de listagem:** o sistema deve apresentar os registros cadastrados em formato tabular, contendo colunas com as informações principais de cada item. (E)

- **RI05.1 – Exibir controles de ação conforme permissão:** o sistema deve exibir nas telas de listagem apenas os controles de ação que o usuário tem acesso. (O)  
    
- **RI05.2 – Exibir campo de busca nas listagens:** o sistema deve disponibilizar, em todas as telas de listagem, um campo de busca que permita localizar registros específicos. (E)  
    
- **RI05.3 – Exibir mensagem de lista vazia:** quando não houver registros, o sistema deve apresentar uma mensagem indicando a ausência de dados. (E)

**RI06 – Diálogos de confirmação:** o sistema deve apresentar janelas de confirmação antes de executar operações irreversíveis. (E)

- **RI06.1 – Bloquear interação com o restante da interface durante o diálogo:** o sistema deve impedir qualquer interação do usuário com as demais áreas da interface, quando uma janela de diálogo estiver aberta. (O)

**RI07 – Mensagens de feedback de operação:** o sistema deve exibir mensagens de retorno ao usuário após a conclusão de operações. (E)

- **RI07.1 – Diferenciar mensagens de sucesso e de erro visualmente:** o sistema deve utilizar elementos visuais distintos para mensagens de sucesso e de erro. (E)

**RI08 – Indicador de progresso:** o sistema deve exibir um indicador visual de carregamento durante operações que possam exceder 1 (um) segundo de processamento. (E)

**RI09 – Telas de relatório:** o sistema deve apresentar os relatórios gerados em tela dedicada, com as informações específicas daquele relatório. (E)

- **RI09.1 – Exibir representação gráfica nos relatórios financeiros:** o sistema deve apresentar, nos relatórios de despesas e receitas e financeiro geral, gráfico de barras ou pizza. (E)  
    
- **RI09.2 – Exibir filtros de relatório em área dedicada:** o sistema deve apresentar os filtros disponíveis para cada relatório. (E)

**RI10 – Padrão visual consistente:** o sistema deve manter padronização visual uniforme em todas as telas. (E)

**RI11 – Exibir saldo atual na tela principal:** o sistema deve exibir o saldo financeiro atual do clube em destaque na interface principal de Adm e GF. (E)

#### **3.3.2 Interface com Hardware**

Esta subseção descreve os requisitos relacionados às interações entre o sistema e os dispositivos físicos do ambiente de execução.

**RI12 – Dispositivos de entrada:** o sistema deve suportar a entrada de dados exclusivamente por meio dos dispositivos de entrada teclado e mouse. (O)

**RI13 – Requisitos de exibição:** o sistema deve ser executável e utilizável em monitores com resolução mínima de 1024x768 pixels. (O)

**RI14 – Ausência de dependência de hardware especializado:** o sistema não requer quaisquer outros periféricos além dos dispositivos de entrada e saída padrão. (O)

#### **3.3.3 Interface com Software Externo**

Esta subseção descreve os requisitos relacionados à interação do sistema com outros softwares presentes no ambiente de execução, incluindo o sistema operacional, o banco de dados e eventuais integrações com aplicações de terceiros.

**RI15 – Interface com o sistema operacional:** o sistema deve interagir com o sistema operacional hospedeiro exclusivamente por meio da JVM (Java Virtual Machine), não realizando chamadas diretas a APIs. (O)

**RI16 – Interface com o banco de dados relacional:** o sistema deve se comunicar com o banco de dados relacional. (O)

- **RI16.1 – Encerrar conexões com o banco de dados após cada operação:** o sistema deve garantir que as conexões abertas com o banco de dados sejam encerradas ao término de cada operação. (O)

**RI17 – Ausência de integração com sistemas externos:** o sistema não realiza integração com APIs externas, portais de federações de futebol ou sistemas bancários. (O)

- **RI17.1 – Ausência de dependência de conexão com a internet:** o sistema deve operar em sua totalidade sem necessidade de conexão com a internet. (O)

#### **3.3.4 Interface de Comunicação**

Esta subseção descreve os requisitos relacionados aos mecanismos de troca de dados adotados pelo sistema, incluindo a comunicação interna com o banco de dados e os formatos de exportação e importação de informações.

**RI18 – Comunicação local com o banco de dados:** toda a troca de dados entre o sistema e o banco de dados relacional deve ocorrer localmente. (O)

**RI19 – Ausência de protocolos de comunicação em rede:** o sistema não depende de protocolos de comunicação em rede. (O)

# 

## 

## **4\. Apêndices**

Esta seção reúne materiais complementares ao documento principal, oferecendo informações de apoio que auxiliam na compreensão do sistema, de suas regras de negócio e da organização dos requisitos descritos nas seções anteriores.

### **Apêndice A – Hierarquia de Perfis de Acesso**

O sistema adota um modelo de controle de acesso baseado em três perfis hierárquicos. O quadro a seguir sintetiza os módulos acessíveis a cada perfil, servindo como referência consolidada para os requisitos de restrição distribuídos ao longo da seção 3.1.

| Módulo | Adm | GF | Op |
| :---- | :---- | :---- | :---- |
| Autenticação e Sessão | sim | sim | sim |
| Gerenciamento de Usuários | sim | não | não |
| Gerenciamento de Clubes | sim | não | não |
| Gerenciamento de Jogadores | sim | sim | não |
| Transações Financeiras com Jogadores | sim | sim | não |
| Gerenciamento de Despesas | sim | sim | não |
| Gerenciamento de Receitas | sim | sim | não |
| Gerenciamento de Partidas | sim | sim | sim |
| Saldo Financeiro | sim | sim | não |
| Relatórios Financeiros | sim | sim | não |
| Relatório de Partidas | sim | sim | sim |
| Histórico de Auditoria | sim | não | não |

Os campos preenchidos com "sim" indicam que o usuário tem acesso àquela funcionalidade, enquanto "não" o usuário não tem acesso.

### **Apêndice B – Categorias de Despesas e Receitas**

Esta seção lista as categorias de lançamentos financeiros utilizadas pelo sistema, conforme definidas nos requisitos RF20 e RF28 a RF35. As categorias são fixas e não podem ser criadas ou removidas pelos usuários.

#### **B.1 Categorias de Despesas**

| Identificador | Categoria | Exemplos de Lançamentos |
| :---- | :---- | :---- |
| DESP-01 | Infraestrutura | Energia elétrica, água, esgoto, manutenção de instalações, gramado |
| DESP-02 | Produção | Uniforme de jogo, chuteiras, copos, vestimentas |
| DESP-03 | Saúde e Fisioterapia | Atendimentos médicos, exames, medicamentos, equipamentos |
| DESP-04 | Salários e Encargos | Pagamento mensal de jogadores, comissão técnica e funcionários |
| DESP-05 | Viagens e Logística | Deslocamento, hospedagem e alimentação da delegação |
| DESP-06 | Outras Despesas | Lançamentos que não se enquadram nas categorias anteriores |

#### **B.2 Categorias de Receitas**

| Identificador | Categoria | Exemplos de Lançamentos |
| :---- | :---- | :---- |
| REC-01 | Bilheteria | Receita de venda de ingressos por partida |
| REC-02 | Patrocínio | Contratos de patrocínio e naming rights |
| REC-03 | Produtos | Venda de camisas e produtos no geral |
| REC-04 | Plano Sócio-Torcedor | Mensalidades e contribuições de programas de sócio |
| REC-05 | Premiações | Valores recebidos por classificação em competições |
| REC-06 | Outras Receitas | Lançamentos que não se enquadram nas categorias anteriores |

### **Apêndice C – Regras de Cálculo do Saldo Financeiro**

O saldo financeiro do clube, calculado e mantido automaticamente pelo sistema conforme RF35 e RNF12, obedece à seguinte regra geral:

**Saldo \= Σ Receitas Registradas − Σ Despesas Registradas**

Para fins deste cálculo, consideram-se:

- **Receitas:** todos os lançamentos dos módulos de Gerenciamento de Receitas (RF28 a RF34) e as receitas geradas automaticamente pelo registro de venda de jogador (RF17.2) e pela bilheteria calculada no módulo de Partidas (RF26.1);  
- **Despesas:** todos os lançamentos do módulo de Gerenciamento de Despesas (RF20 a RF23) e as despesas geradas automaticamente pelo registro de compra de jogador (RF16.2).

O saldo é recalculado automaticamente a cada inserção, edição ou exclusão de qualquer lançamento de receita ou despesa, conforme requisitos RF21.3, RF22.2, RF33 e RF34.2. O sistema não permite que o saldo exibido ao usuário divirja do valor calculado a partir dos registros presentes na base de dados.

### **Apêndice D – Estrutura de Dados do Histórico de Auditoria**

O histórico de auditoria, descrito nos requisitos RF40 e RF41, registra automaticamente todas as operações de inserção e edição realizadas no sistema. Cada registro de auditoria contém os seguintes atributos mínimos:

| Atributo | Descrição |
| :---- | :---- |
| **Tipo de operação** | Indica se o evento é uma inserção ou uma edição de registro |
| **Tipo do dado** | Categoria do registro afetado: despesa, receita, partida, jogador ou transação financeira |
| **Identificador do registro** | Chave única que identifica o registro afetado na base de dados |
| **Usuário responsável** | Nome de usuário do agente autenticado que realizou a operação |
| **Data e hora** | Carimbo de tempo da operação, registrado no momento de sua execução |
| **Valores anteriores** | Conteúdo dos campos antes da edição (apenas para operações de edição) |
| **Valores novos** | Conteúdo dos campos após a edição (apenas para operações de edição) |

# 

## 

## **5\. Índice**

### **Seção 1 – Introdução**

- 1.1 Propósito do documento de requisitos  
- 1.2 Escopo do Produto  
- 1.3 Definições, acrônimos e abreviações  
- 1.4 Referências  
- 1.5 Visão do Restante do Documento

### **Seção 2 – Descrição Geral**

- 2.1 Perspectiva do Produto  
- 2.2 Funcionalidades  
- 2.3 Características do usuário  
- 2.4 Restrições Gerais  
- 2.5 Suposições e Dependências

### **Seção 3 – Requisitos Específicos**

- 3.1 Requisitos Funcionais  
    
  - Módulo 1 – Autenticação e Sessão (RF01–RF03)  
  - Módulo 2 – Gerenciamento de Usuários (RF04–RF07)  
  - Módulo 3 – Gerenciamento de Clubes (RF08–RF11)  
  - Módulo 4 – Gerenciamento de Jogadores (RF12–RF15)  
  - Módulo 5 – Transações Financeiras com Jogadores (RF16–RF19)  
  - Módulo 6 – Gerenciamento de Despesas (RF20–RF24)  
  - Módulo 7 – Gerenciamento de Receitas (RF25–RF29)  
  - Módulo 8 – Controle de Saldo Financeiro (RF30)  
  - Módulo 9 – Registro e Gerenciamento de Partidas (RF31–RF35)  
  - Módulo 10 – Relatórios (RF36–RF39)  
  - Módulo 11 – Histórico de Auditoría (RF40–RF41)


- 3.2 Requisitos Não Funcionais  
    
  - Desempenho (RNF01–RNF03)  
  - Usabilidade (RNF04–RNF09)  
  - Confiabilidade (RNF10–RNF12)  
  - Segurança (RNF13–RNF16)  
  - Portabilidade (RNF17–RNF18)


- 3.3 Requisitos de Interface  
    
  - 3.3.1 Interface de Usuário (RI01–RI11)  
  - 3.3.2 Interface com Hardware (RI12–RI14)  
  - 3.3.3 Interface com Software Externo (RI15–RI17)  
  - 3.3.4 Interface de Comunicação (RI18–RI19)

### **Seção 4 – Apêndices**

- Apêndice A – Hierarquia de Perfis de Acesso  
- Apêndice B – Categorias de Despesas e Receitas  
- Apêndice C – Regras de Cálculo do Saldo Financeiro  
- Apêndice D – Estrutura de Dados do Histórico de Auditoria

### **Seção 5 – Índice**

