**USUÁRIO**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Cadastro do Administrador** |
| **Atores**: |Administrador |
| **Tipo**: |Primário |
| **Descrição**: | Ao iniciar o sistema pela primeira vez, o sistema identifica que nenhum Administrador foi cadastrado e solicita o registro. O usuário preenche as informações necessárias para criar a conta de Administrador e, então, o sistema cria a conta e libera o acesso completo. Essa ação é realizada uma única vez durante toda a vida útil do sistema. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Cadastro de Usuários** |
| **Atores**: |Administrador |
| **Tipo**: |Primário |
| **Descrição**: | O Administrador acessa o sistema e inicia a criação de uma nova conta de usuário. Ele preenche as informações e atribui o perfil de Gestor de Finanças ou Operador. Após confirmar os dados, o sistema armazena o novo usuário e registra a ação no Histórico de Auditoria de Registro. O usuário recém-criado já fica disponível para autenticação. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Autenticação de Usuário** |
| **Atores**: |Administrador, Gestor de Finanças, Operador |
| **Tipo**: |Secundário|
| **Descrição**: | Ao acessar o sistema, o usuário inicia a autenticação. Ele informa suas credenciais. O sistema valida as informações e permite o acesso ao sistema, caso estejam corretas. Caso contrário, o sistema exibe uma mensagem de erro. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Desconexão de Usuário** |
| **Atores**: |Administrador, Gestor de Finanças, Operador |
| **Tipo**: |Secundário|
| **Descrição**: | O usuário decide encerrar a sessão, então o sistema finaliza o acesso. Caso o usuário queira continuar utilizando o sistema, é necessário se autenticar novamente.|

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Buscar Usuário** |
| **Atores**: |Administrador |
| **Tipo**: |Secundário |
| **Descrição**: | O Administrador precisa localizar um usuário específico cadastrado no sistema, então o usuário informa os dados que conhece sobre o usuário. O sistema faz a busca e retorna o que encontrou. Caso não encontre, o sistema apresenta uma mensagem indicando que nenhum resultado foi encontrado. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Alterar Informações de Usuário** |
| **Atores**: |Administrador, Gestor de Finanças, Operador |
| **Tipo**: |Secundário |
| **Descrição**: | O usuário acessa as configurações da própria conta e deseja atualizar seus dados. Ele altera as informações que deseja e confirma a operação. O sistema salva as novas informações e registra a ação no Histórico de Auditoria de Alteração. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Excluir Usuário** |
| **Atores**: |Administrador|
| **Tipo**: |Secundário |
| **Descrição**: | O Administrador identifica a necessidade de remover um usuário do sistema. Ele localiza o usuário desejado e confirma a ação de exclusão. O sistema remove permanentemente o registro do usuário, impedindo futuros acessos com aquelas credenciais. A ação é registrada no Histórico de Auditoria Registro. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Listagem de Usuários** |
| **Atores**: |Administrador|
| **Tipo**: |Secundário |
| **Descrição**: | O Administrador deseja ter uma visão de todos os usuários do sistema. Ele inicia a listagem e o sistema exibe todos os registros de usuários disponíveis e suas informações gerais. Essa visualização permite ao Administrador gerenciar e acompanhar o quadro de usuários ativos. |







**CLUBE**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Cadastro do Clube** |
| **Atores**: |Administrador|
| **Tipo**: |Primário|
| **Descrição**: | O Administrador acessa o sistema e deseja registrar as informações do clube. Ele preenche os dados e confirma o registro. O sistema armazena as informações do clube e registra a ação no Histórico de Auditoria de Registro. O clube está apto para ser administrado.|

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Alterar Informações de Clube** |
| **Atores**: |Administrador|
| **Tipo**: |Primário|
| **Descrição**: | O Administrador acessa as configurações do clube e deseja atualizar seus dados. Ele altera as informações que deseja e confirma a operação. O sistema salva as novas informações e registra a ação no Histórico de Auditoria de Alteração.|

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Excluir Clube** |
| **Atores**: |Administrador|
| **Tipo**: |Primário|
| **Descrição**: | O Administrador decide remover um clube específico do sistema. Ele localiza o clube desejado e confirma a operação. O sistema remove permanentemente o registro do clube. A ação é registrada no Histórico de Auditoria de Registro. |








**RELATÓRIO**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Relatório de Finanças** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Tipo**: |Primário |
| **Descrição**: |O usuário acessa a seção de relatórios para compreender a situação financeira do clube. Ele escolhe o Relatório de Finanças, o sistema processa dados e apresenta gráficos que refletem o panorama financeiro.|

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Relatório de Receitas** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Tipo**: |Primário |
| **Descrição**: | O usuário deseja analisar as entradas financeiras do clube. Ele escolhe o Relatório de Receitas, o sistema processa dados e apresenta gráficos que refletem o panorama das receitas. O relatório permite identificar as principais fontes de renda.|


| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Relatório de Despesas** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Tipo**: |Primário |
| **Descrição**: | O usuário deseja analisar os gastos financeiros do clube. Ele escolhe o Relatório de Despesas, o sistema processa dados e apresenta gráficos que refletem o panorama das despesas. O relatório permite identificar os principais gastos. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Relatório de Desempenho no Futebol** |
| **Atores**: |Administrador, Operador|
| **Tipo**: |Primário |
| **Descrição**: | O usuário deseja acompanhar o rendimento esportivo do clube. Ele escolhe o Relatório de Desempenho, o sistema processa dados e apresenta gráficos de desempenho relacionados às atividades do clube em campo. O relatório fornece uma visão do rendimento da equipe e estimula o investimento nas equipes. |




**RECEITA**

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Cadastro de Receitas** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Tipo**: |Primário |
| **Descrição**: |O usuário identifica uma nova receita do clube. Ele inicia o registro, preenche as informações e confirma o registro. O sistema adiciona o valor às finanças do clube e armazena a ação no Histórico de Auditoria de Registro. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Buscar Receita** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Tipo**: |Secundário |
| **Descrição**: | O usuário precisa localizar uma receita específica registrada no sistema. Ele informa os dados que conhece sobre a receita e aciona a consulta. O sistema retorna os registros correspondentes ou, caso não encontre, o sistema apresenta uma mensagem indicando que nenhum resultado foi encontrado. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Alterar Informações de Receita** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Tipo**: |Secundário |
| **Descrição**: |O usuário identifica a necessidade de atualizar os dados de uma receita já cadastrada. Ele localiza o registro, faz alterações necessárias e confirma a operação. O sistema salva as novas informações e registra a ação no Histórico de Auditoria de Alteração. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Excluir Receita** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Tipo**: |Secundário |
| **Descrição**: | O usuário identifica uma receita registrada que precisa ser removida do sistema. Ele localiza o registro e confirma a ação. O sistema remove permanentemente a receita, deixando-a indisponível para futuras consultas. A ação é registrada no Histórico de Auditoria de Registro. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Listagem de Receitas** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Tipo**: |Secundário |
| **Descrição**: | O Administrador deseja ter uma visão de todas as receitas registradas no sistema. Ele inicia a listagem e o sistema exibe todos os registros de receitas e suas informações gerais. Essa visualização permite ao Administrador gerenciar e acompanhar o quadro de receitas. |









**DESPESA**

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Cadastro de Despesas** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Tipo**: |Primário |
| **Descrição**: |O usuário identifica uma nova despesa do clube. Ele inicia o registro, preenche as informações e confirma o registro. O sistema subtrai o valor das finanças do clube e armazena a ação no Histórico de Auditoria de Registro. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Buscar Despesa** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Tipo**: |Secundário |
| **Descrição**: |O usuário precisa localizar uma despesa específica registrada no sistema. Ele informa os dados que conhece sobre a despesa e aciona a consulta. O sistema retorna os registros correspondentes ou, caso não encontre, o sistema apresenta uma mensagem indicando que nenhum resultado foi encontrado.|

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Alterar Informações de Despesa** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Tipo**: |Secundário |
| **Descrição**: |O usuário identifica a necessidade de atualizar os dados de uma despesa já cadastrada. Ele localiza o registro, faz alterações necessárias e confirma a operação. O sistema salva as novas informações e registra a ação no Histórico de Auditoria de Alteração. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Excluir Despesa** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Tipo**: |Secundário |
| **Descrição**: | O usuário identifica uma despesa registrada que precisa ser removida do sistema. Ele localiza o registro e confirma a ação. O sistema remove permanentemente a despesa, deixando-a indisponível para futuras consultas. A ação é registrada no Histórico de Auditoria de Registro.|

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Listagem de Despesas** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Tipo**: |Secundário |
| **Descrição**: | O Administrador deseja ter uma visão de todas as despesas registradas no sistema. Ele inicia a listagem e o sistema exibe todos os registros de despesas e suas informações gerais. Essa visualização permite ao Administrador gerenciar e acompanhar o quadro de despesas. |









**FUTEBOL**

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Comprar Jogadores** |
| **Atores**: |Administrador, Operador|
| **Tipo**: |Primário|
| **Descrição**: |O usuário deseja registrar a compra de um jogador para o clube. Ele inicia a compra, preenche as informações do atleta e confirma a operação. O sistema registra o jogador no elenco, subtrai o valor da compra das finanças do clube e armazena a ação no Histórico de Auditoria de Registro. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Buscar Jogador** |
| **Atores**: |Administrador, Operador|
| **Tipo**: |Secundário|
| **Descrição**: |O usuário precisa localizar um jogador específico registrado no sistema. Ele informa os dados que conhece sobre o jogador e aciona a consulta. O sistema retorna os registros correspondentes ou, caso não encontre, o sistema apresenta uma mensagem indicando que nenhum resultado foi encontrado.|

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Alterar Informações de Jogador** |
| **Atores**: |Administrador, Operador|
| **Tipo**: |Secundário |
| **Descrição**: |O usuário identifica a necessidade de atualizar os dados de um jogador já cadastrado. Ele localiza o jogador, faz alterações necessárias e confirma a operação. O sistema salva as novas informações e registra a ação no Histórico de Auditoria de Alteração.|

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Vender Jogador** |
| **Atores**: |Administrador, Operador|
| **Tipo**: |Primário|
| **Descrição**: |O usuário registra a saída de um jogador como uma transferência. Ele localiza o jogador, informa os dados da venda e confirma a operação. O sistema remove o jogador do elenco, acrescenta o valor da venda às finanças do clube e armazena a ação no Histórico de Auditoria de Registro. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Listagem de Jogadores** |
| **Atores**: |Administrador, Operador|
| **Tipo**: |Secundário |
| **Descrição**: | O Administrador deseja ter uma visão de todos os jogadores registrados no sistema. Ele inicia a listagem e o sistema exibe todos os registros de jogadores e suas informações gerais. Essa visualização permite ao Administrador gerenciar e acompanhar o quadro de jogadores.|


| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Cadastrar Partida** |
| **Atores**: |Administrador, Operador|
| **Tipo**: |Primário|
| **Descrição**: |O usuário deseja registrar uma partida realiza. Ele inicia o cadastro, preenche as informações da partida e confirma a operação. O sistema registra a partida no clube, soma o valor dos ganhos nas finanças do clube e armazena a ação no Histórico de Auditoria de Registro. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Buscar Partida** |
| **Atores**: |Administrador, Operador|
| **Tipo**: |Secundário|
| **Descrição**: |O usuário precisa localizar uma partida específica registrada no sistema. Ele informa os dados que conhece sobre a partida e aciona a consulta. O sistema retorna os registros correspondentes ou, caso não encontre, o sistema apresenta uma mensagem indicando que nenhum resultado foi encontrado.|

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Alterar Informações de Partida** |
| **Atores**: |Administrador, Operador|
| **Tipo**: |Secundário |
| **Descrição**: |O usuário identifica a necessidade de atualizar os dados de uma partida cadastrada. Ele localiza a partida, faz alterações necessárias e confirma a operação. O sistema salva as novas informações e registra a ação no Histórico de Auditoria de Alteração.|

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Apagar Partida** |
| **Atores**: |Administrador, Operador|
| **Tipo**: |Primário|
| **Descrição**: |O usuário deseja a saída apagar uma partida cadastrada. Ele localiza a partida, informa os dados e confirma a operação. O sistema remove a partida do sistema, subtrai o valor dos ganhos das finanças do clube e armazena a ação no Histórico de Auditoria de Registro. |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Listagem de Partidas** |
| **Atores**: |Administrador, Operador|
| **Tipo**: |Secundário |
| **Descrição**: | O Administrador deseja ter uma visão de todas as partidas registradas no sistema. Ele inicia a listagem e o sistema exibe todos os registros de partidas e suas informações gerais. Essa visualização permite ao Administrador gerenciar e acompanhar o quadro futebolistico do clube.|




**AUDITORIA**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Listagem de Registros** |
| **Atores**: |Administrador|
| **Tipo**: |Secundário|
| **Descrição**: | O Administrador deseja visualizar todas as operações de cadastro realizadas no sistema. Ele inicia a listagem de registros de auditoria e o sistema exibe todas as ações de registro efetuadas.|

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Listagem de Alterações** |
| **Atores**: |Administrador|
| **Tipo**: |Secundário |
| **Descrição**: |O Administrador deseja visualizar todas as modificações realizadas no sistema. Ele inicia a listagem de alterações de auditoria e o sistema exibe todas as ações de mudanças efetuadas.|



