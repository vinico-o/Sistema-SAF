**USUÁRIO**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: | **Gerenciar Usuários** |
| **Atores**: | Administrador |
| **Tipo**: | Primário |
| **Descrição**: | As funções disponibilizadas são: Cadastro de Usuário, Buscar Usuário e Exclusão de Usuário. As funções de Cadastro e Exclusão de Usuário são registradas no Histórico de Auditoria. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: | **Cadastro do Administrador** |
| **Atores**: | Administrador |
| **Tipo**: | Primário |
| **Descrição**: | Ao iniciar o sistema pela primeira vez, o sistema identifica que nenhum Administrador foi cadastrado e solicita o registro. O usuário preenche as informações necessárias para criar a conta de Administrador e, então, o sistema cria a conta e libera o acesso completo. Essa ação é realizada uma única vez durante toda a vida útil do sistema. A ação é registrada no Histórico de Auditoria. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: | **Autenticação de Usuário** |
| **Atores**: | Administrador, Gestor de Finanças, Operador |
| **Tipo**: | Secundário |
| **Descrição**: | Ao acessar o sistema, o usuário inicia a autenticação. Ele informa suas credenciais. O sistema valida as informações e permite o acesso ao sistema, caso estejam corretas. Caso contrário, o sistema exibe uma mensagem de erro. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: | **Desconexão de Usuário** |
| **Atores**: | Administrador, Gestor de Finanças, Operador |
| **Tipo**: | Secundário |
| **Descrição**: | O usuário decide encerrar a sessão, então o sistema finaliza o acesso. Caso o usuário queira continuar utilizando o sistema, é necessário se autenticar novamente. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: | **Alterar Informações de Usuário** |
| **Atores**: | Administrador, Gestor de Finanças, Operador |
| **Tipo**: | Secundário |
| **Descrição**: | O usuário acessa as configurações da própria conta e deseja atualizar seus dados. Ele altera as informações que deseja e confirma a operação. O sistema salva as novas informações e registra a ação no Histórico de Auditoria. |

**CLUBE**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: | **Gerenciar Clubes** |
| **Atores**: | Administrador |
| **Tipo**: | Primário |
| **Descrição**: | As funções disponibilizadas são: Cadastro de Clube, Listagem de Clubes, Alterar informações do Clube e Exclusão de Clube. As funções de Cadastro, Exclusão e Alteração de Informações de Clube são registradas no Histórico de Auditoria. |

**RELATÓRIO**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: | **Gerar Relatórios** |
| **Atores**: | Administrador, Gestor de Finanças, Operador |
| **Tipo**: | Primário |
| **Descrição**: | Os relatórios disponibilizados são: Relatório de Finanças, Relatório de Receitas, Relatório de Despesas e Relatório de Desempenho no Futebol. Nos âmbitos financeiros, somente o Gestor de Finanças e o Administrador podem gerar relatórios. Já no lado do futebol, só o Operador e o Administrador podem gerar relatórios. |

**RECEITA**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: | **Gerenciar Receitas** |
| **Atores**: | Administrador, Gestor de Finanças |
| **Tipo**: | Primário |
| **Descrição**: | As funções disponibilizadas são: Cadastro de Receita, Buscar Receita, Alteração de Informações de Receita, Listagem de Receitas e Exclusão de Receita. As funções de Cadastro, Exclusão e Alteração de Informações de Receita são registradas no Histórico de Auditoria. |

**DESPESA**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: | **Gerenciar Despesas** |
| **Atores**: | Administrador, Gestor de Finanças |
| **Tipo**: | Primário |
| **Descrição**: | As funções disponibilizadas são: Cadastro de Despesa, Buscar Despesa, Alteração de Informações de Despesa, Listagem de Despesas e Exclusão de Despesa. As funções de Cadastro, Exclusão e Alteração de Informações de Despesa são registradas no Histórico de Auditoria. |

**FUTEBOL**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: | **Gerenciar Jogadores** |
| **Atores**: | Administrador, Operador |
| **Tipo**: | Primário |
| **Descrição**: | As funções disponibilizadas são: Compra de Jogador, Buscar Jogador, Alteração de Informações de Jogador, Listagem de Jogador e Exclusão de Jogador. As funções de Compra, Venda e Alteração de Informações de Jogador são registradas no Histórico de Auditoria. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: | **Gerenciar Partidas** |
| **Atores**: | Administrador, Operador |
| **Tipo**: | Primário |
| **Descrição**: | As funções disponibilizadas são: Cadastro de Partida, Buscar Partida, Alteração de Informações de Partida, Listagem de Partida e Exclusão de Partida. As funções de Cadastro, Exclusão e Alteração de Informações de Partida são registradas no Histórico de Auditoria. |

**AUDITORIA**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Listagem de Auditoria** |
| **Atores**: |Administrador|
| **Tipo**: |Secundário|
| **Descrição**: | O Administrador deseja visualizar todos os registros e alterações realizados no sistema. A listagem de auditoria têm os filtros possíveis: Listagem de Registros, Listagem de Alterações, Listagem de Auditoria (ambos).  |