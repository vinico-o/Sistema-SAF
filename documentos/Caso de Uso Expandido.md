**USUÁRIO**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Gerenciar Usuários** |
| **Atores**: | Administrador |
| **Finalidade**: | Disponibiliza ações que envolvem os usuários do sistema, desde criação, busca e exclusão |
| **Tipo**: |Primário |
| **Descrição**: | As funções disponibilizadas são: Cadastro de Usuário, Buscar Usuário e Exclusão de Usuário. As funções de Cadastro e Exclusão de Usuário são registradas no Histórico de Auditoria. |
| **Referências cruzadas**: | Requisitos: RF04, RF04.1, RF04.2, RF04.2.1, RF04.3, RF06, RF06.1, RF06.2, RF06.3, RF07, RF07.1, RF07.2, RF40, RF40.1, RF40.2 | 

## Sequência típica de eventos
### Subcaso: Cadastro de Usuário

| Ação do Ator | Resposta do Sistema |
| :-- | :-- |
| 1. O Administrador acessa o campo de cadastro de usuário do sistema. | 2. O sistema exibe a tela de cadastro de usuário. |
| | 3. O sistema indica visualmente os campos de preenchimento obrigatório. |
| 4. o Administrador preenche os campos de nome de usuário,  senha e nível de usuário. |  |
| 5. O Administrador confirma o cadastro.  | 6. O sistema valida as informações preenchidas. |
| | 7. O sistema cria a conta do usuário e registra no Histórico de Auditoria. |
| | 8. O sistema exibe uma mensagem de sucesso e confirma a operação. |

### Sequências alternativas:

Linha 4: Campos obrigatórios não preenchidos. O sistema indica os campos em branco.

Linha 6: Nome de usuário já cadastrado no sistema. Indica erro de cadastro.

### Subcaso: Edição de informações de Usuário

| Ação do Ator | Resposta do Sistema |
| :-- | :-- |
| 1. O usuário acessa o campo de edição de informações de usuário. | 2. O sistema exibe a tela de edição de usuário. |
| | 3. O sistema indica os campos passíveis de edição. |
| 4. O usuário preenche os campos que serão editados. |  |
| 5. O usuário confirma a edição.  | 6. O sistema valida as informações preenchidas. |
| | 7. O sistema altera as informações da conta do usuário e registra no Histórico de Auditoria. |
| | 8. O sistema exibe uma mensagem de sucesso e confirma a operação. |

### Sequências alternativas:

Linha 4: Nenhum campo preenchido. O sistema indica que nenhuma alteração será feita.

Linha 5: O Administrador cancela a operação de edição. O sistema fecha o diálogo sem realizar nenhuma alteração.

Linha 6: Nome de usuário já cadastrado no sistema. Indica erro de cadastro.

### Subcaso: Exclusão de Usuário

| Ação do Ator | Resposta do Sistema |
| :-- | :-- |
| 1. O Administrador acessa o campo de exclusão de usuários. | 2. O sistema exibe a tela de edição de usuários, listando-os. |
| 3. O Administrador seleciona o usuário que será excluído do sistema. | 4. O sistema exibe um diálogo de confirmação de exclusão. |
| 5. O Administrador confirma a exclusão. | 6. O sistema remove o usuário permanentemente e registra no Histórico de Auditoria. |
| | 7. O sistema exibe uma mensagem de sucesso e confirma a operação. |

### Sequências alternativas:

Linha 3: O Administrador seleciona o próprio usuário. Indica erro de autoexclusão.

Linha 5: O Administrador cancela a operação de exclusão. O sistema fecha o diálogo sem realizar nenhuma alteração.

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Cadastro do Administrador** |
| **Atores**: | Administrador |
| **Finalidade**: | Recolher informações de Administrador e criar conta |
| **Tipo**: |Primário |
| **Descrição**: | Ao iniciar o sistema pela primeira vez, o sistema identifica que nenhum Administrador foi cadastrado e solicita o registro. O usuário preenche as informações necessárias para criar a conta de Administrador e, então, o sistema cria a conta e libera o acesso completo. Essa ação é realizada uma única vez durante toda a vida útil do sistema. A ação é registrada no Histórico de Auditoria. |
| **Referências cruzadas**: | Requisitos: RF01, RF40, RF40.1, RF40.2 |

| Ação do Ator | Resposta do Sistema |
| :-- | :-- |
| 1. O usuário inicia o sistema pela primeira vez. | 2. O sistema identifica que nenhum Administrador está cadastrado e exibe a tela de cadastro inicial do Administrador |
|   | 3. O sistema indica visualmente os campos de preenchimento obrigatório. |
| 4. O usuário preenche os campos de nome de usuário e senha. |  |
| 5. O usuário confirma o cadastro. | 6. O sistema valida as informações preenchidas. |
|  | 7. O sistema cria a conta de Administrador, registra a ação no Histórico de Auditoria e libera o acesso completo ao sistema. |
|  | 8. O sistema exibe mensagem de sucesso e redireciona o usuário à tela de autenticação (RI07, RI07.1). |

### Sequências alternativas:

Linha 4: Campos obrigatórios não preenchidos. O sistema indica os campos em branco.

Linha 5: o usuário cancela a operação. O sistema volta para a tela de primeiro login.

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Autenticação de Usuário** |
| **Atores**: | Administrador, Gestor de Finanças, Operador |
| **Finalidade**: | Recolher informações de autenticação e conectar ao sistema |
| **Tipo**: |Secundário|
| **Descrição**: | Ao acessar o sistema, o usuário inicia a autenticação. Ele informa suas credenciais. O sistema valida as informações e permite o acesso ao sistema, caso estejam corretas. Caso contrário, o sistema exibe uma mensagem de erro. |
| **Referências cruzadas**: | Requisitos: RF02, RF02.1, RF02.2 |

| Ação do Ator | Resposta do Sistema |
| :-- | :-- |
| 1. O usuário inicia o sistema. | 2. O sistema exibe a tela de login, com os campos de nome de usuário e senha. |
|   | 3. O sistema indica visualmente os campos de preenchimento obrigatório. |
| 4. O usuário preenche os campos de nome de usuário e senha. |  |
| 5. O usuário confirma o login. | 6. O sistema valida as credenciais informadas. |
|  | 7. O sistema autentica o usuário. |
|  | 8. O sistema exibe as funcionalidades compatíveis com o nível de usuário autenticado. |

### Sequências alternativas:

Linha 4: Campos obrigatórios não preenchidos. O sistema indica os campos em branco.

Linha 6: Credenciais inválidas. Indica login ou senha incorretos.

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Desconexão de Usuário** |
| **Atores**: | Administrador, Gestor de Finanças, Operador |
| **Finalidade**: | Desconectar usuário do sistema |
| **Tipo**: |Secundário|
| **Descrição**: | O usuário decide encerrar a sessão, então o sistema finaliza o acesso. Caso o usuário queira continuar utilizando o sistema, é necessário se autenticar novamente.|
| **Referências cruzadas**: | Requisitos: RF03, RF03.1, RF03.2 |

| Ação do Ator | Resposta do Sistema |
| :-- | :-- |
| 1. O usuário aciona a opção de encerras a sessão. | 2. O sistema exibe uma mensagem de confirmação para encerrar a sessão. |
| 3. O usuário confirma o encerramento de sessão. | 4. O sistema finaliza a sessão. |
|  | 5. O sistema retorna à tela de login. |

### Sequências alternativas:

Linha 3: O usuário cancela a operação de encerrar sessão. o sistema mantém a sessão atual.

**CLUBE**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Gerenciar Clubes** |
| **Atores**: | Administrador |
| **Finalidade**: | Disponibiliza ações que envolvem os clubes do sistema, desde criação, alteração de informações, listagem e exclusão |
| **Tipo**: |Primário |
| **Descrição**: | As funções disponibilizadas são: Cadastro de Clube, Listagem de Clubes, Alterar informações do Clube e Exclusão de Clube. As funções de Cadastro, Exclusão e Alteração de Informações de Clube são registradas no Histórico de Auditoria. |
| **Referências cruzadas**: | Requisitos: RF08.1, RF08.2.1, RF08.3, RF09, RF09.1, RF10, RF10.1, RF10.2, RF11, RF11.1, RF40, RF40.1, RF40.2, RF41, RF41.1, RF41.2 |

## Sequência típica de eventos
### Subcaso: Cadastro de Clube

| Ação do Ator | Resposta do Sistema |
| :-- | :-- |
| 1. O Administrador acessa o campo de cadastro de clube do sistema. | 2. O sistema exibe a tela de cadastro de clube. |
| | 3. O sistema indica visualmente os campos de preenchimento origatório. |
| 4. O Administrador preenche os campos de nome do clube, ano de fundação e país. |  |
| 5. O Administrador confirma o cadastro.  | 6. O sistema valida as informações preenchidas. |
| | 7. O sistema cria o clube e registra no Histórico de Auditoria. |
| | 8. O sistema exibe uma mensagem de sucesso e confirma a operação. |

### Sequências alternativas:

Linha 4: Campos obrigatórios não preenchidos. O sistema indica os campos em branco.

Linha 5: O Administrador cancela a operação de cadastro. O sistema cancela a operação e volta para a tela atual.

Linha 6: Clube já cadastrado no sistema. Indica erro de cadastro.

### Subcaso: Edição de informações de Clube

| Ação do Ator | Resposta do Sistema |
| :-- | :-- |
| 1. O Administrador acessa o campo de edição de informações de clube. | 2. O sistema exibe a tela edição de clube. |
| | 3. O sistema carrega as informações cadastradas nos campos. |
| 4. O Administrador altera os campos que serão editados. |  |
| 5. O Administrador confirma a edição.  | 6. O sistema valida as informações alteradas. |
| | 7. O sistema altera as informações do clueb e registra no Histórico de Auditoria. |
| | 8. O sistema exibe uma mensagem de sucesso e confirma a operação. |

### Sequências alternativas:

Linha 4: Nenhum campo alterado. O sistema indica que nenhuma alteração será feita.

Linha 5: O Administrador cancela a operação de edição. O sistema fecha o diálogo sem realizar nenhuma alteração.

Linha 6: Informações editadas já exitentes no sistema. Indica erro de edição de alteração.

### Subcaso: Exclusão de Clube

| Ação do Ator | Resposta do Sistema |
| :-- | :-- |
| 1. O Administrador acessa o campo de exclusão de clube. | 2. O sistema exibe a tela exclusão de clubes, listando-os. |
| 3. O Administrador seleciona o clube que será excluído do sistema. | 4. O sistema exibe um diálogo de confirmação de exclusão. |
| 5. O Administrador confirma a exclusão. | 6. O sistema remove o clube permanentemente e registra no Histórico de Auditoria. |
| | 7. O sistema exibe uma mensagem de sucesso e confirma a operação. |

### Sequências alternativas:

Linha 5: O Administrador cancela a operação de exclusão. O sistema fecha o diálogo sem realizar nenhuma alteração.

**RELATÓRIO**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Gerar Relatórios** |
| **Atores**: |Administrador, Gestor de Finanças, Operador |
| **Finalidade**: | Disponibiliza a geração de relatórios que envolvem os dados do Clube nos âmbitos financeiros e futebolísticos |
| **Tipo**: |Primário |
| **Descrição**: | Os relatórios disponibilizados são: Relatório de Finanças, Relatório de Receitas, Relatório de Despesas e Relatório de Desempenho no Futebol. Nos âmbitos financeiros, somente o Gestor de Finanças e o Administrador podem gerar relatórios. Já no lado do futebol, só o Operador e o Administrador podem gerar relatórios. |
| **Referências cruzadas**: | Requisitos: RF36, RF36.1, RF36.2, RF36.3, RF37, RF37.1, RF37.2, RF37.3, RF38, RF38.1, RF38.2, RF39, RF39.1, RF39.2, RF39.3, RF39.4 |

## Sequência Típica de Eventos
### Subcaso: Relatório de Despesas 

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Gestor de Finanças acessa a geração do Relatório de Despesas. | 2. O sistema inclui os filtros possíveis: período e categoria. |
| 3. O ator coloca os filtros desejados e solicita a geração. | 4. O sistema processa as informações e exibe indicador de progresso (se necessário). |
|  | 5. O sistema exibe o relatório com o total gasto por categoria e por período, acompanhado de representação gráfica (como gráficos de barras ou de pizza) e listagem detalhada de cada despesa. |

### Sequência alternativa:

Linha 5: Não há despesas que se enquadram nos filtros. O sistema exibe uma mensagem indicando a ausência de despesas considerando os filtros.

### Subcaso: Relatório de Receitas 

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Gestor de Finanças acessa a geração do Relatório de Receitas. | 2. O sistema inclui os filtros possíveis: período e categoria. |
| 3. O ator coloca os filtros desejados e solicita a geração. | 4. O sistema processa as informações e exibe indicador de progresso (se necessário). |
|  | 5. O sistema exibe o relatório com o total gasto por categoria e por período, acompanhado de representação gráfica (como gráficos de barras ou de pizza) e listagem detalhada de cada receita. |

### Sequência alternativa:

Linha 5: Não há receitas que se enquadram nos filtros. O sistema exibe uma mensagem indicando a ausência de receitas considerando os filtros.

### Subcaso: Relatório Financeiro Geral

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Gestor de Finanças acessa a geração do Relatório Financeiro Geral. | 2. O sistema inclui o filtro possível: período. |
| 3. O ator coloca o período desejado e solicita a geração. | 4. O sistema processa as informações e exibe indicador de progresso (se necessário). |
|  | 5. O sistema exibe o relatório com todas receitas, todas despesas, saldo resultante e representação gráfica da evolução do saldo no período. |

### Sequência alternativa:

Linha 5: Não há registros que se enquadram no período. O sistema exibe uma mensagem indicando a ausência de registros considerando o período.

### Subcaso: Relatório de Desempenho no Futebol

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Operador acessa a  geração do Relatório de Desempenho no Futebol. | 2. O sistema exibe os filtros possíveis: competição, período e local (casa ou fora). |
| 3. O ator define os filtros desejados e solicita a geração. | 4. O sistema processa as informações e exibe indicador de progresso (se necessário). |
| | 5. O sistema exibe o relatório com total de partidas, vitórias, empates, derrotas, gols marcados, gols sofridos e aproveitamento. |

### Sequência alternativa:

Linha 5: Não há partidas que se enquadram nos filtros. O sistema exibe uma mensagem indicando a ausência de partidas considerando os filtros.

**RECEITA**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Gerenciar Receitas** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Finalidade**: | Disponibiliza ações que envolvem as receitas do sistema, desde criação, busca, alteração de informações, listagem e exclusão |
| **Tipo**: |Primário |
| **Descrição**: | As funções disponibilizadas são: Cadastro de Receita, Buscar Receita, Alteração de Informações de Receita, Listagem de Receitas e Exclusão de Receita. As funções de Cadastro, Exclusão e Alteração de Informações de Receita são registradas no Histórico de Auditoria.|
| **Referências cruzadas**: | Requisitos: RF25, RF25.1, RF25.2, RF25.2.1, RF25.2.2, RF25.2.3, RF25.2.4, RF25.2.5, RF25.2.6, RF25.3, RF25.3.1, RF25.4, RF26, RF26.1, RF26.2, RF26.2.1, RF26.3, RF27, RF27.1, RF27.2, RF27.3, RF28, RF28.1, RF29, RF29.1, RF30, RF30.1, RF30.2, RF40, RF40.1, RF40.2, RF41, RF41.1, RF41.2 |

## Sequência Típica de Eventos
### Subcaso: Cadastro de Receita

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Gestor de Finanças acessa a tela de registro de receita. | 2. O sistema exibe o formulário com os campos: categoria, valor e descrição. |
| 3. O ator seleciona a categoria da receita. | 4. O sistema exibe os campos específicos da categoria indicada. |
| 5. O ator preenche os dados e confirma. | 6. O sistema valida os dados. |
|  | 7. O sistema registra a receita, atualiza o saldo financeiro do clube, registra a ação no Histórico de Auditoria e exibe mensagem de sucesso. |

### Sequência alternativa:

Linha 6: Dados de receita inválidos. O sistema indica os campos inconsistentes.

### Subcaso: Buscar Receita

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Gestor de Finanças acessa a listagem de receitas e utiliza o campo de busca. | 2. O sistema exibe a(s) receita(s) correspondente(s) de acordo com a informação dada no campo. |

### Sequência alternativa:

Linha 2: Receita não encontrada. O sistema mostra uma mensagem indicando a ausência da receita.

### Subcaso: Alteração de Informações de Receita

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Gestor de Finanças seleciona uma receita e inicia a edição. | 2. O sistema exibe o formulário com as informações da receita. |
| 3. O ator altera os campos e confirma. | 4. O sistema valida os dados. |
| | 5. O sistema salva as alterações, recalculando automaticamente o saldo do clube, registrando a alteração no Histórico de Auditoria com o usuário responsável e as mudanças e exibe mensagem de sucesso. |

### Sequência alternativa:

Linha 4: Dados inconsistentes. O sistema indica os campos com novos dados, porém inconsistentes.

### Subcaso: Listagem de Receitas

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Gestor de Finanças acessa a listagem de receitas. | 2. O sistema exibe todas as receitas registradas em tabela. |

### Sequência alternativa:

Linha 2: Não há receitas registradas. O sistema mostra uma mensagem indicando a ausência de receitas.

### Subcaso: Exclusão de Receita

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Gestor de Finanças seleciona uma receita e inicia a exclusão. | 2. O sistema exibe caixa de confirmação e mostra o impacto da exclusão no saldo do clube. |
| 3. O ator confirma a exclusão. | 4. O sistema remove a receita permanentemente, recalculando e atualizando o saldo financeiro, além de registrar a ação no Histórico de Auditoria e exibir mensagem de sucesso. |

### Sequência alternativa:

Linha 3: O ator cancela a exclusão. O sistema não exclui a receita.

**DESPESA**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Gerenciar Despesas** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Finalidade**: | Disponibiliza ações que envolvem as despesas do sistema, desde criação, busca, alteração de informações, listagem e exclusão |
| **Tipo**: |Primário |
| **Descrição**: | As funções disponibilizadas são: Cadastro de Despesa, Buscar Despesa, Alteração de Informações de Despesa, Listagem de Despesas e Exclusão de Despesa. As funções de Cadastro, Exclusão e Alteração de Informações de Despesa são registradas no Histórico de Auditoria. |
| **Referências cruzadas**: | Requisitos: RF20, RF20.1, RF20.2, RF20.2.1, RF20.2.2, RF20.2.3, RF20.2.4, RF20.2.5, RF20.2.6, RF20.3, RF20.3.1, RF20.4, RF21, RF21.1, RF21.2, RF21.2.1, RF21.3, RF22, RF22.2, RF22.3, RF23, RF23.1, RF24, RF24.1, RF30, RF30.1, RF30.2, RF40, RF40.1, RF40.2, RF41, RF41.1, RF41.2 |


## Sequência Típica de Eventos
### Subcaso: Cadastro de Despesa

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Gestor de Finanças acessa a tela de registro de despesa. | 2. O sistema exibe o formulário com os campos: categoria, valor e descrição. |
| 3. O ator seleciona a categoria da despesa. | 4. O sistema exibe os campos específicos da categoria indicada. |
| 5. O ator preenche os dados e confirma. | 6. O sistema valida os dados. |
|  | 7. O sistema registra a despesa, atualiza o saldo financeiro do clube, registra a ação no Histórico de Auditoria e exibe mensagem de sucesso. |

### Sequência alternativa:

Linha 6: Dados de despesa inválidos. O sistema indica os campos inconsistentes.

### Subcaso: Buscar Despesa

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Gestor de Finanças acessa a listagem de despesas e utiliza o campo de busca. | 2. O sistema exibe a(s) despesa(s) correspondente(s) de acordo com a informação dada no campo. |

### Sequência alternativa:

Linha 2: Despesa não encontrada. O sistema mostra uma mensagem indicando a ausência da despesa.

### Subcaso: Alteração de Informações de Despesa

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Gestor de Finanças seleciona uma despesa e inicia a edição. | 2. O sistema exibe o formulário com as informações da despesa. |
| 3. O ator altera os campos e confirma. | 4. O sistema valida os dados. |
| | 5. O sistema salva as alterações, recalculando automaticamente o saldo do clube, registrando a alteração no Histórico de Auditoria com o usuário responsável e as mudanças e exibe mensagem de sucesso. |

### Sequência alternativa:

Linha 4: Dados inconsistentes. O sistema indica os campos com novos dados, porém inconsistentes.


### Subcaso: Listagem de Despesas

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Gestor de Finanças acessa a listagem de despesas. | 2. O sistema exibe todas as despesas registradas em tabela. |

### Sequência alternativa:

Linha 2: Não há despesas registradas. O sistema mostra uma mensagem indicando a ausência de despesas.


### Subcaso: Exclusão de Despesa

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Gestor de Finanças seleciona uma despesa e inicia a exclusão. | 2. O sistema exibe caixa de confirmação e mostra o impacto da exclusão no saldo do clube. |
| 3. O ator confirma a exclusão. | 4. O sistema remove a despesa permanentemente, recalculando e atualizando o saldo financeiro, além de registrar a ação no Histórico de Auditoria e exibir mensagem de sucesso. |

### Sequência alternativa:

Linha 3: O ator cancela a exclusão. O sistema não exclui a despesa.

**FUTEBOL**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Gerenciar Jogadores** |
| **Atores**: |Administrador, Operador|
| **Finalidade**: | Disponibiliza ações que envolvem os jogadores do sistema, desde compra, busca, alteração de informações, listagem e venda de jogadores |
| **Tipo**: |Primário|
| **Descrição**: | As funções disponibilizadas são: Compra de Jogador, Buscar Jogador, Alteração de Informações de Jogador, Listagem de Jogador e Exclusão de Jogador. As funções de Compra, Venda e Alteração de Informações de Jogador são registradas no Histórico de Auditoria.|
| **Referências cruzadas**: | Requisitos: RF12, RF12.1, RF12.2, RF12.2.1, RF12.3, RF13, RF13.1, RF14, RF14.1, RF15, RF15.1 RF15.2, RF16, RF16.1, RF16.2, RF16.3, RF16.3.1, RF16.4, RF16.5, RF17, RF17.1, RF17.2, RF17.3, RF17.3.1, RF17.4, RF18, RF18.1, RF18.2, RF18.3, RF19, RF19.1, RF19.2, RF19.2.1, RF30, RF30.1, RF40, RF40.1, RF40.2, RF41, RF41.1, RF41.2 |

## Sequência Típica de Eventos
### Subcaso: Compra de Jogador

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Operador acessa a opção de registrar compra de jogador. | 2. O sistema exibe o formulário de compra com os campos: jogador comprado e valor de compra, além das informações básicas do jogador para cadastro. |
| 3. O ator preenche os dados do jogador e da compra e confirma. | 4. O sistema valida as informações informadas. |
|  | 5. O sistema cadastra o jogador, o valor é guardado como despesa, atualiza o saldo do clube, registra a ação no Histórico de Auditoria e exibe mensagem de sucesso. |

### Sequências alternativas:

Linha 4: Os dados de compra são inválidos. O sistema indica os campos inconsistentes.

Linha 4: O jogador já está cadastrado no clube. O sistema impede que o recadastro para evitar duplicidade.

### Subcaso: Buscar Jogador

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Operador acessa a listagem de jogadores e informa o nome no campo. | 2. O sistema exibe o(s) jogador(es) correspondente(s) com o mesmo nome informado. |

### Sequências alternativa:

Linha 2: Nenhum jogador encontrado. O sistema exibe que não há jogadores com este nome.


### Subcaso: Alteração de Informações de Jogador

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Operador seleciona um jogador e inicia a edição. |  2. O sistema exibe o formulário com as informações do jogador. |
| 3. O ator altera os campos e confirma. | 4. O sistema valida os dados alterados. |
| | 5. O sistema salva as alterações, registra a ação no Histórico de Auditoria e exibe mensagem de sucesso. |

### Sequência alternativa:

Linha 4: Os dados são inconsistentes ou inválidos. O sistema indica os campos com erro.


### Subcaso: Listagem de Jogadores

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Operador acessa a listagem de jogadores. | 2. O sistema exibe todos os jogadores registrados no clube com suas informações em tabela. |

### Sequência alternativa:

Linha 2: Não há jogadores registrados. O sistema exibe uma mensagem indicando a ausência de jogadores.


### Subcaso: Venda de Jogador

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Operador acessa a opção de vender jogador. | 2. O sistema exibe o formulário com os campos: jogador vendido e valor de venda. |
| 3. O ator preenche os dados e confirma. | 4. O sistema valida as informações. |
| | 5. O sistema registra a venda, registra a venda como receita financeira, atualizando o saldo do clube, registrando a ação no Histórico de Auditoria e exibindo uma mensagem de sucesso. |

### Sequência alternativa:

Linha 4: Dados inconsistentes. O sistema exibe mensagem de erro.

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Gerenciar Partidas** |
| **Atores**: |Administrador, Operador|
| **Finalidade**: | Disponibiliza ações que envolvem as partidas do sistema, desde cadastro, busca, alteração de informações, listagem e exclusão de partidas |
| **Tipo**: |Primário|
| **Descrição**: | As funções disponibilizadas são: Cadastro de Partida, Buscar Partida, Alteração de Informações de Partida, Listagem de Partida e Exclusão de Partida. As funções de Cadastro, Exclusão e Alteração de Informações de Partida são registradas no Histórico de Auditoria.|
| **Referências cruzadas**: | Requisitos: RF30, RF30.1, RF31, RF31.1, RF31.2, RF31.3, RF31.4, RF31.5, RF31.5.1, RF31.6, RF31.6.1, RF31.7, RF32, RF32.1, RF32.2, RF32.3, RF33, RF31.1, RF33.2, RF33.3, RF33.4, RF34, RF34.1, RF35, RF35.1, RF40, RF40.1, RF40.2, RF41, RF41.1, RF41.2 |

## Sequência Típica de Eventos
### Subcaso: Cadastro de Partida

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Operador acessa a opção de registrar partida. | 2. O sistema exibe um formulário para receber as informações: data, competição, público total, valor do ingresso, premiação (se houver) e placar. |
| 3. O usuário informa os dados necessários dos campos. | 4. O sistema classifica automaticamente o resultado com base no placar (vitória, empate ou derrota).
|  | 5. O sistema registra como receita com o cálculo automático de bilheteria (público x valor do ingresso). Além disso, o sistema registra como receita a premiação (se houver). |
| | 6. O sistema atualiza o saldo financeiro do clube, registra a ação no Histórico de Auditoria e exibe uma mensagem indicando o sucesso da ação. |

### Sequências alternativas:

Linha 3: o ator preenche dados inconsistentes e confirma. O sistema indica o erro.

Linha 3: o ator não preenche dados em campos de bilheteria, como público ou valor do ingresso (para jogos em casa). O sistema indica a ausência.


### Subcaso: Buscar Partida

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Operador acessa a listagem de partidas e informa o identificador da partida no campo para realizar a busca. | 2. O sistema encontra e exibe as informações da partida encontrada. |

### Sequências alternativa:

Linha 2: o sistema não encontra a partida. O sistema mostra uma mensagem indicando que não há registro sobre a partida.


### Subcaso: Alteração de Informações de Partida

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Operador seleciona uma partida na listagem e inicia a edição. |2. O sistema exibe o formulário com as informações atuais da partida. |
| 3. O ator altera os campos e confirma. | 4. O sistema faz a validação dos dados alterados. |
| | 5. O sistema recalcula automaticamente a bilheteria e o saldo financeiro. |
| | 6. O sistema salva as alterações, registra a ação no Histórico de Auditoria e exibe mensagem de sucesso. |


### Sequências alternativa:

Linha 3: O ator tenta confirmar edição com dados inválidos. O sistema exibe uma mensagem de validação ao lado do campo com problema.


### Subcaso: Listagem de Partidas

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Operador acessa a listagem de partidas. | 2. O sistema exibe todas as partidas registradas como tabela. |

### Sequência alternativa:

Linha 2: Não há partidas salvas. O sistema exibe uma mensagem indicando a ausência de partidas no sistema.


### Subcaso: Exclusão de Partida

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador ou Operador seleciona uma partida e inicia a exclusão. | 2. O sistema exibe caixa de confirmação informando que os dados da partida e a receita de bilheteria serão removidos permanentemente. |
| 3. O ator confirma a exclusão. | 4. O sistema remove a partida, excluindo a receita de bilheteria vinculada, recalculando e atualizando o saldo financeiro, também faz o registro da ação no Histórico de Auditoria e exibe mensagem de sucesso. |

### Sequência alternativa:

Linha 3: o ator cancela a exclusão da partida. O sistema não exclui a partida.

**AUDITORIA**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Listagem de Registros** |
| **Atores**: |Administrador|
| **Finalidade**: | Listar todos registros feitos no sistema |
| **Tipo**: |Secundário|
| **Descrição**: | O Administrador deseja visualizar todas as operações de cadastro realizadas no sistema. Ele inicia a listagem de registros de auditoria e o sistema exibe todas as ações de registro efetuadas.|
| **Referências cruzadas**: | Requisitos: RF40, RF40.1, RF40.2 |

## Sequência Típica de Eventos

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador acessa a tela de Histórico de Auditoria e seleciona a listagem de registros. | 2. O sistema exibe todas as ações de registro ocorridas, mostrando: tipo da operação, identificador do dado, data e hora e usuário responsável. |

### Sequências alternativa:

Linha 2: O sistema mostra uma mensagem indicando que não há registros salvos.




| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Listagem de Alterações** |
| **Atores**: |Administrador|
| **Finalidade**: | Listar todas alterações feitas no sistema |
| **Tipo**: |Secundário |
| **Descrição**: |O Administrador deseja visualizar todas as modificações realizadas no sistema. Ele inicia a listagem de alterações de auditoria e o sistema exibe todas as ações de mudanças efetuadas.|
| **Referências cruzadas**: | Requisitos: RF41, RF41.1, RF41.2 |

## Sequência Típica de Eventos

| Ação do Ator | Resposta do Sistema |
|---|---|
| 1. O Administrador acessa a tela de Histórico de Auditoria e seleciona a listagem de alterações. | 2. O sistema exibe todas as ações de alteração ocorridas, mostrando: tipo da operação, identificador do dado, data e hora e usuário responsável. |

### Sequências alternativa:

Linha 2: O sistema mostra uma mensagem indicando que não há alterações salvas.