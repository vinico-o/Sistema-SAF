**USUÁRIO**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Gerenciar Usuários** |
| **Atores**: | Administrador |
| **Finalidade**: | Disponibiliza ações que envolvem os usuários do sistema, desde criação, busca e exclusão |
| **Tipo**: |Primário |
| **Descrição**: | As funções disponibilizadas são: Cadastro de usuário, Buscar usuário e Exclusão de Usuário. As funções de Cadastro e Exclusão de usuários são registradas no Histórico de Auditoria de Registro. |
| **Referências cruzadas**: | Requisitos: RF04, RF04.1, RF04.2, RF04.2.1, RF04.3, RF06, RF06.1, RF06.2, RF06.3, RF07, RF07.1, RF07.2, RF40, RF40.1, RF40.2 | 

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Cadastro do Administrador** |
| **Atores**: | Administrador |
| **Finalidade**: | Recolher informações de Administrador e criar conta |
| **Tipo**: |Primário |
| **Descrição**: | Ao iniciar o sistema pela primeira vez, o sistema identifica que nenhum Administrador foi cadastrado e solicita o registro. O usuário preenche as informações necessárias para criar a conta de Administrador e, então, o sistema cria a conta e libera o acesso completo. Essa ação é realizada uma única vez durante toda a vida útil do sistema. |
| **Referências cruzadas**: | Requisitos: RF01, RF40, RF40.1, RF40.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Autenticação de Usuário** |
| **Atores**: | Administrador, Gestor de Finanças, Operador |
| **Finalidade**: | Recolher informações de autenticação e conectar ao sistema |
| **Tipo**: |Secundário|
| **Descrição**: | Ao acessar o sistema, o usuário inicia a autenticação. Ele informa suas credenciais. O sistema valida as informações e permite o acesso ao sistema, caso estejam corretas. Caso contrário, o sistema exibe uma mensagem de erro. |
| **Referências cruzadas**: | Requisitos: RF02, RF02.1, RF02.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Desconexão de Usuário** |
| **Atores**: | Administrador, Gestor de Finanças, Operador |
| **Finalidade**: | Desconectar usuário do sistema |
| **Tipo**: |Secundário|
| **Descrição**: | O usuário decide encerrar a sessão, então o sistema finaliza o acesso. Caso o usuário queira continuar utilizando o sistema, é necessário se autenticar novamente.|
| **Referências cruzadas**: | Requisitos: RF03, RF03.1, RF03.2 |


| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Alterar Informações de Usuário** |
| **Atores**: | Administrador, Gestor de Finanças, Operador |
| **Finalidade**: | Alterar informações de usuário e salvá-las |
| **Tipo**: |Secundário |
| **Descrição**: | O usuário acessa as configurações da própria conta e deseja atualizar seus dados. Ele altera as informações que deseja e confirma a operação. O sistema salva as novas informações e registra a ação no Histórico de Auditoria de Alteração. |
| **Referências cruzadas**: | Requisitos: RF05, RF05.1, RF05.2, RF41, RF41.1, RF41.2  |








**CLUBE**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Gerenciar Clubes** |
| **Atores**: | Administrador |
| **Finalidade**: | Disponibiliza ações que envolvem os clubes do sistema, desde criação, alteração de informações, listagem e exclusão |
| **Tipo**: |Primário |
| **Descrição**: | As funções disponibilizadas são: Cadastro de Clube, Listagem de Clubes, Alterar informações do Clube e Exclusão de Clube. As funções de Cadastro e Exclusão de clubes são registradas no Histórico de Auditoria de Registro. A Alteração de Informações é registrada no Histórico de Auditoria de Alteração. |
| **Referências cruzadas**: | Requisitos: RF08.1, RF08.2.1, RF08.3, RF09, RF09.1, RF10, RF10.1, RF10.2, RF11, RF11.1, RF40, RF40.1, RF40.2, RF41, RF41.1, RF41.2 |





**RELATÓRIO**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Gerar Relatórios** |
| **Atores**: |Administrador, Gestor de Finanças, Operador |
| **Finalidade**: | Disponibiliza a geração de relatórios que envolvem os dados do Clube nos âmbitos financeiros e futebolísticos |
| **Tipo**: |Primário |
| **Descrição**: | Os relatórios disponibilizados são: Relatório de Finanças, Relatório de Receitas, Relatório de Despesas e Relatório de Desempenho no Futebol. Nos âmbitos financeiros, somente o Gestor de Finanças e o Administrador podem gerar relatórios. Já no lado do futebol, só o Operador e o Administrador podem gerar relatórios. |
| **Referências cruzadas**: | Requisitos: RF36, RF36.1, RF36.2, RF36.3, RF37, RF37.1, RF37.2, RF37.3, RF38, RF38.1, RF38.2, RF39, RF39.1, RF39.2, RF39.3, RF39.4 |





**RECEITA**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Gerenciar Receitas** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Finalidade**: | Disponibiliza ações que envolvem as receitas do sistema, desde criação, busca, alteração de informações, listagem e exclusão |
| **Tipo**: |Primário |
| **Descrição**: | As funções disponibilizadas são: Cadastro de Receita, Buscar Receita, Alteração de Informações de Receita, Listagem de Receitas e Exclusão de Receita. As funções de Cadastro e Exclusão de receita são registradas no Histórico de Auditoria de Registro. A alteração de informações é registrada no Histórico de Auditoria de Alteração. |
| **Referências cruzadas**: | Requisitos: RF25, RF25.1, RF25.2, RF25.2.1, RF25.2.2, RF25.2.3, RF25.2.4, RF25.2.5, RF25.2.6, RF25.3, RF25.3.1, RF25.4, RF26, RF26.1, RF26.2, RF26.2.1, RF26.3, RF27, RF27.1, RF27.2, RF27.3, RF28, RF28.1, RF29, RF29.1, RF30, RF30.1, RF30.2, RF40, RF40.1, RF40.2, RF41, RF41.1, RF41.2 |




**DESPESA**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Gerenciar Despesas** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Finalidade**: | Disponibiliza ações que envolvem as despesas do sistema, desde criação, busca, alteração de informações, listagem e exclusão |
| **Tipo**: |Primário |
| **Descrição**: | As funções disponibilizadas são: Cadastro de Despesa, Buscar Despesa, Alteração de Informações de Despesa, Listagem de Despesas e Exclusão de Despesa. As funções de Cadastro e Exclusão de despesas são registradas no Histórico de Auditoria de Registro. A alteração de informações é registrada no Histórico de Auditoria de Alteração. |
| **Referências cruzadas**: | Requisitos: RF20, RF20.1, RF20.2, RF20.2.1, RF20.2.2, RF20.2.3, RF20.2.4, RF20.2.5, RF20.2.6, RF20.3, RF20.3.1, RF20.4, RF21, RF21.1, RF21.2, RF21.2.1, RF21.3, RF22, RF22.2, RF22.3, RF23, RF23.1, RF24, RF24.1, RF30, RF30.1, RF30.2, RF40, RF40.1, RF40.2, RF41, RF41.1, RF41.2 |




**FUTEBOL**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Gerenciar Jogadores** |
| **Atores**: |Administrador, Operador|
| **Finalidade**: | Disponibiliza ações que envolvem os jogadores do sistema, desde compra, busca, alteração de informações, listagem e venda de jogadores |
| **Tipo**: |Primário|
| **Descrição**: | As funções disponibilizadas são: Compra de Jogador, Buscar Jogador, Alteração de Informações de Jogador, Listagem de Jogador e Exclusão de Jogador. As funções de Compra e Venda de jogador são registradas no Histórico de Auditoria de Registro. A alteração de informações de jogador é registrada no Histórico de Auditoria de Alteração. |
| **Referências cruzadas**: | Requisitos: RF12, RF12.1, RF12.2, RF12.2.1, RF12.3, RF13, RF13.1, RF14, RF14.1, RF15, RF15.1 RF15.2, RF16, RF16.1, RF16.2, RF16.3, RF16.3.1, RF16.4, RF16.5, RF17, RF17.1, RF17.2, RF17.3, RF17.3.1, RF17.4, RF18, RF18.1, RF18.2, RF18.3, RF19, RF19.1, RF19.2, RF19.2.1, RF30, RF30.1, RF40, RF40.1, RF40.2, RF41, RF41.1, RF41.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Gerenciar Partidas** |
| **Atores**: |Administrador, Operador|
| **Finalidade**: | Disponibiliza ações que envolvem as partidas do sistema, desde cadastro, busca, alteração de informações, listagem e exclusão de partidas |
| **Tipo**: |Primário|
| **Descrição**: | As funções disponibilizadas são: Cadastro de Partida, Buscar Partida, Alteração de Informações de Partida, Listagem de Partida e Exclusão de Partida. As funções de Cadastro e Exclusão de partida são registradas no Histórico de Auditoria de Registro. A alteração de informações é registrada no Histórico de Auditoria de Alteração. |
| **Referências cruzadas**: | Requisitos: RF31, RF31.1, RF31.2, RF31.3, RF31.4, RF31.5, RF31.5.1, RF31.6, RF31.6.1, RF31.7, RF30, RF30.1, RF32, RF32.1, RF32.2, RF32.3, RF33, RF31.1, RF33.2, RF33.3, RF33.4, RF34, RF34.1, RF35, RF35.1, RF40, RF40.1, RF40.2, RF41, RF41.1, RF41.2 |





**AUDITORIA**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Listagem de Registros** |
| **Atores**: |Administrador|
| **Finalidade**: | Listar todos registros feitos no sistema |
| **Tipo**: |Secundário|
| **Descrição**: | O Administrador deseja visualizar todas as operações de cadastro realizadas no sistema. Ele inicia a listagem de registros de auditoria e o sistema exibe todas as ações de registro efetuadas.|
| **Referências cruzadas**: | Requisitos: RF40, RF40.1, RF40.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Listagem de Alterações** |
| **Atores**: |Administrador|
| **Finalidade**: | Listar todas alterações feitas no sistema |
| **Tipo**: |Secundário |
| **Descrição**: |O Administrador deseja visualizar todas as modificações realizadas no sistema. Ele inicia a listagem de alterações de auditoria e o sistema exibe todas as ações de mudanças efetuadas.|
| **Referências cruzadas**: | Requisitos: RF41, RF41.1, RF41.2 |



