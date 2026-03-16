# 1. Introdução

## 1.1 Propósito do documento de requisitos
Este documento tem como propósito definir e descrever os requisitos de um sistema de gestão de clubes de futebol.  
Além disso, o documento será utilizado como referência no planejamento, implementação, testes e manutenção do sistema, para assim garantir que todas as necessidades referentes ao sistema sejam satisfeitas.  
O público-alvo deste documento envolve os desenvolvedores do projeto, como também os donos e gestores dos clubes que utilizarão a aplicação.

## 1.2 Escopo do Produto
O (nome da aplicação) tem como objetivo auxiliar na organização e manipulação das informações financeiras de clubes de futebol organizados como Sociedade Anônima do Futebol (SAF). O sistema será utilizado para registrar despesas, receitas, funcionários, jogadores, partidas, calcular gastos e emitir relatórios desses gastos.

## 1.3 Definições, acrônimos e abreviações
As principais abreviações utilizadas neste documento serão listadas a seguir.  

SAF é sigla para Sociedade Anônima do Futebol. Ela permitiu que clubes de futebol pudessem ser transformados em empresas.  

CT é sigla para Centro de Treinamento. Local utilizado pelos jogadores para realizar treinamentos e preparação dos jogos.

## 1.4 Referências
(nehuma ainda)

## 1.5 Visão do restante do documento
Esse documento está organizado em seções, ca uma responsável para descrever partes específicas do sistema proposto.  

A seção 2 apresenta a descrição geral do sistema, indicando os aspectos principais, como perspectivas, funcionalidades, restrições, suposições e dependências do produto. Com isso é possível ter uma visão mais específica do objetivo da aplicação.  

A seção 3 descreve com maior detalhamento os requisitos do sistema, de como ele se comunicará com o mundo exterior; lista as funções e recursos específicos. Com isso será ter uma visão geral e entender com mais clareza o funcionamento do sistema.

# 2. Descrição Geral

## 2.1 Perspectiva do Produto
O sistema tem como objetivo auxiliar na organização e no acompanhamento das informações financeiras de Clubes de Futebol organizados com SAF. A aplicação funcionará como uma ferramenta de apoio, permitindo que o usuário registre diferentes tipos de operações financeiras e acompanhe esses dados ao longo do tempo.  

Através da interface o usuário poderá cadastrar transações, registrar informações sobre partidas realizadas, acompanhar receitas de diversas categorias e visualizar relatórios que apresentam o desempenho financeiro do clube.

## 2.2 Funcionalidades
O sistema deverá fornecer um conjunto de funcionalidades que permitam ao usuário registrar, consultar e gerar relatórios relacionadas à parte financeira dos clubes que serão geridos.  

Com isso, o sistema deve permitir:

- Cadastro de um ou mais clubes de futebol.  
- Cadastro de jogadores vinculados aos clubes;  
- Registar transações financeiras (receitas e despesas);  
- Registrar informações sobre as partidas realizadas pelo time;  
- Gerar relatórios financeiros de modo a informar gastos e despesas ao longo do tempo.

## 2.3 Características do usuário
O sistema é voltado principalmente para usuários responsáveis pela gestão administrativa e financeira de clubes de futebol organizados como Sociedade Anônima do Futebol.  

Os usuários devem possuir conhecimentos básicos de informática, sendo capazes de utilizar sistemas computacionais, bem como experiência na área de finanças e gestão de clubes.

## 2.4 Restrições Gerais

**[RG01] Restrição de Login**  
O acesso ao sistema deve ser restrito a usuários autenticados por meio de login e senha, tendo em vista que haverão informações financeiras do clube.

**[RG02] Persistência de Dados**  
Todos os registros e informações do sistema devem ser armazenados de maneira permanente, a fim de garantir a existência dos dados mesmo fora da execução do sistema.

## 2.5 Suposições e Dependências
Assume-se que os usuários possuem conhecimento básico sobre conceitos de gestão financeira relacionados ao futebol, para registrar corretamente receitas, despesas, bilheteria, bônus de partidas, premiações.  

Assume-se também que os usuários possuem conhecimento básico em sistemas computacionais, visto que dados de serão inseridos manualmente por eles, não dependendo de integrações automáticas.  

O sistema depende da disponibilidade de um ambiente computacional capaz de executar aplicações desenvolvidas na linguagem Java, sendo necessários sistemas operacionais que suportam Máquina Virtual Java (JVM), como Linux, Windows ou MacOs.  

Obs: não sei se misturei isso com o 2.4

# 3. Requisitos Específicos

## 3.1 Requisitos Funcionais

- **[RF] Autenticação de Usuário**  
O sistema deve permitir autenticação de usuários por meio de login e senha.

- **[RF] Cadastro de Clubes**  
O sistema deve permitir cadastrar um ou mais clubes de futebol.

- **[RF] Alterações em Clubes**  
O sistema deve permitir editar as informações de um clube já cadastrado no sistema.

- **[RF] Exclusão de Clubes**  
O sistema deve permitir excluir o cadastro de um clube, desvinculando-o do sistema. 
    - **[RF.1] Exclusão de dados de clubes**  
        O sistema deve excluir os dados referentes a um clube que foi excluído do sistema.

- **[RF] Compras de jogador**  
O sistema deve permitir comprar jogadores.
    - **[RF.1] Registro de Compra**  
    O sistema deve registrar o valor, data e informações do jogador a ser comprado.

- **[RF] Vendas de jogador**  
O sistema deve permitir vender jogadores.
    - **[RF.1] Registro de Venda**  
    O sistema deve registrar o valor, data, informações do jogador a ser vendido e clube de destino.

- **[RF] Empréstimo de jogador**  
O sistema deve permitir o empréstimo de jogadores a outros clubes.
    - **[RF.1] Registro de Empréstimo**  
    O sistema deve registrar o valor, data do empréstimo, tempo de empréstimo, informações do jogador a ser emprestado e clube de destino.

- **[RF] Empréstimo de jogador com opção/obrigação de compra (Alterar o nome?)**  
O sistema deve permitir o empréstimo de jogadores ao(s) próprio(s) clube(s).

- **[RF.1] Registro de Empréstimo**  
O sistema deve registrar o valor, data do empréstimo, tempo de empréstimo, informações do jogador que virá ao clube por empréstimo.

- **[RF] Registro de Despesas**  
O sistema deve permitir o registro de despesas que não estão relacionadas com jogadores.
    - **[RF.1] Registro de Despesas com Gramados**  
    O sistema deve permitir o registro de gastos com gramados, considerando gramados do CT e do Estádio.
    - **[RF.2] Registro de Despesas com Uniformes**  
    O sistema deve permitir o registro de gastos com uniformes, considerando os uniformes de jogos, treino e goleiro. (Alterar?????)
    - **[RF.3] Registro de Despesas com Saúde**  
    O sistema deve permitir o registro de gastos na área da saúde (COMPLETAR????).

- **[RF] Edição de Despesas**  
O sistema deve permitir a alteração de alguma(s) informações sobre qualquer despesa registrada.

- **[RF] Exclusão de Despesas**  
O sistema deve permitir a exclusão de qualquer despesa registrada.
    - **[RF] Recalcular Despesas**  
    O sistema deve refazer o cálculo do saldo após a exclusão de alguma despesa.

- **[RF] Histórico de Despesas**  
O sistema deve permitir a visualização de todas as despesas registradas.

- **[RF] Validação de Despesas**  
O sistema deve validar se as informações sobre as informações de [RF08] e [RF] estão corretas. ((VALOR TEM Q SER POSITIVO POR EXEMPLO).

- **[RF] Registro de Receitas**  (deixar especificas para cada situacao???)
O sistema deve permitir o registro de receitas que não estão relacionadas com jogadores.
    - **[RF.1] Registro de Receitas com Bilheteria (*** acho q dá pra tirar esse pq a receita da bilheteria está envolvida com o registro de partidas**)**  
    O sistema deve permitir o registro de receita vindas de jogos de futebol.
    - **[RF.2] Registro de Receitas com Patrocínio**  
    O sistema deve permitir o registro de receitas vindas de patrocínios (MAIS DE UM PATROCINIO?) ligadas ao time.
    - **[RF.3] Registro de Receitas com Vendas de Uniforme.**  
    O sistema deve permitir o registro de receitas vindas de vendas de uniforme.
    - **[RF.4] Registro de Receitas com Planos Sócio-Torcedor (TALVEZ COLOCAR ISSO?)**  
    O sistema deve permitir a receita vinda do plano sócio-torcedor (AO FIM DO MÊS?).
    - **[RF.5] Registro de Receitas com Títulos de Competições (TALVEZ COLOCAR ISSO?)**  
    O sistema deve permitir a receita vindo de algum título de competição, registrando o nome da competição e valor recebido.

- **[RF] Edição de Receitas**  
O sistema deve permitir a alteração de alguma(s) informações sobre qualquer receita registrada.

- **[RF] Exclusão de Receitas**  
O sistema deve permitir a exclusão de qualquer receita registrada. (-> TEM Q RECALCULAR O SALDO FINAL DO MÊS SE FIZER ISSO)

- **[RF] Histórico de Receitas**  
O sistema deve permitir a visualização de todas as receitas registradas.

- **[RF] Validação de Receitas**  
O sistema deve validar se as informações sobre as informações de [RF13] e [RF14] estão corretas. ((VALOR TEM Q SER POSITIVO POR EXEMPLO)

- **[RF] Registro de Partidas de Futebol**  
O sistema deve permitir registrar informações das partidas jogadas.

- **[RF.1] Registro de Partidas**  
O sistema deve permitir registrar data, público total e bilheteria do jogo. (???? Ficou redundante publico total e bilheteria)

- **[RF] Edição de Partidas**  
O sistema deve permitir a alteração de alguma(s) informações sobre qualquer partida registrada.

- **[R0] Exclusão de Partidas**  
O sistema deve permitir a exclusão de qualquer partida registrada. (-> TEM Q RECALCULAR O SALDO FINAL DO MÊS SE FIZER ISSO)

- **[RF] Histórico de Partidas**  
O sistema deve permitir a visualização de todas as partidas registradas.

- **[RF] Validação de Partidas**  
O sistema deve validar se as informações sobre as informações de [RF18] e [RF19] estão corretas e sem interferências. ((VALOR TEM Q SER POSITIVO POR EXEMPLO)
    - **[RF.1] Impedir Conflitos de Horário**  
    O sistema deve impedir que o registro de partidas [RF18.2] e edição de partidas [RF19] marquem os jogos para o mesmo dia.

- **[RF] Cálculo de Saldo**  
O sistema deve calcular o saldo do clube a cada interação com o sistema automaticamente.

- **[RF.1] Atualização de Saldo**  
O sistema atualiza o saldo do clube a cada Cálculo de Saldo [RF23] automaticamente.

- **[RF] Relatórios de Receita**  
O sistema deve gerar relatórios (com gráficos) de receitas.

- **[RF] Relatórios de Despesas**  
O sistema deve gerar relatórios (com gráficos) de despesas.

- **[RF] Relatórios Financeiros Geral**  
O sistema deve gerar relatórios (com gráficos) de saldo.

- **[RF] Relatórios de Partidas**  
O sistema deve gerar relatórios (com gráficos) de partidas.

- **[RF] Busca de Receitas**  
O sistema deve permitir a busca por receita específica. (PENSEI EM RF16 (listagem) e o user busca a receita pelo ID).

- **[RF] Busca de Despesas**  
O sistema deve permitir a busca por despesa específica. (SEGUE O DE CIMA)

- **[RF] Busca de Partidas**  
O sistema deve permitir a busca por partida específica. (SEGUE O DE CIMA)

(ACHEI INTERESSANTE BOTAR ESSES HISTÓRICOS ABAIXO – requisitos de auditoria que já vimos em aula)

- **[RF] Histórico de Registros**  
O sistema deve registrar o histórico de registros feitos pelo usuário, quanto a [RF04.1], [RF05.1], [RF06.1], [RF07.1], [RF08], [RF13], [RF18].
    - **[RF.1] Registro de Histórico de Registro**  
    O sistema deve registrar o tipo de registro (Compra, Venda, Empréstimo pra fora, Empréstimo pro clube, Despesa, Receita , Partida // ID do tipo de registro // User – apagar dps isso) e quem fez isso.

- **[RF] Histórico de Alterações**  
O sistema deve registrar o histórico de alterações feitos pelo usuário, quanto a [RF09], [RF14] e [RF19].
    - **[RF.1] Registro de Histórico de Alteração**  
    O sistema deve registrar o tipo de alteração (Compra, Venda, Empréstimo pra fora, Empréstimo pro clube, Despesa, Receita , Partida // ID do tipo de registro // User - apagar dps isso) e quem fez isso.

- **[RF] Exportação de Informações ((( SERIALIZABLE)**  
O sistema deve exportar e armazenar o Histórico de Despesas, Histórico de Receitas, Histórico de Partidas, Histórico de Registros e Histórico de Alterações do sistema. (ARQUIVO?)

- **[RF] Carregar Informações ((( SERIALIZABLE)**  
O sistema deve importar e carregar o Histórico de Despesas, Histórico de Receitas, Histórico de Partidas, Histórico de Registros e Histórico de Alterações do sistema. (ARQUIVO?)
