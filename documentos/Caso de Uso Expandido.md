**USUÁRIO**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Cadastro do Administrador** |
| **Atores**: |Administrador |
| **Finalidade**: | Recolher informações de Administrador e criar conta |
| **Tipo**: |Primário |
| **Descrição**: | Ao iniciar o sistema pela primeira vez, o sistema identifica que nenhum Administrador foi cadastrado e solicita o registro. O usuário preenche as informações necessárias para criar a conta de Administrador e, então, o sistema cria a conta e libera o acesso completo. Essa ação é realizada uma única vez durante toda a vida útil do sistema. |
| **Referências cruzadas**: | Requisitos: RF01, RF40, RF40.1, RF40.2 | 

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Cadastro de Usuários** |
| **Atores**: |Administrador |
| **Finalidade**: | Recolher informações de novo Usuário e criar conta |
| **Tipo**: |Primário |
| **Descrição**: | O Administrador acessa o sistema e inicia a criação de uma nova conta de usuário. Ele preenche as informações e atribui o perfil de Gestor de Finanças ou Operador. Após confirmar os dados, o sistema armazena o novo usuário e registra a ação no Histórico de Auditoria de Registro. O usuário recém-criado já fica disponível para autenticação. |
| **Referências cruzadas**: | Requisitos: RF04, RF04.1, RF04.2, RF04.2.1, RF04.3, RF40, RF40.1, RF40.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Autenticação de Usuário** |
| **Atores**: |Administrador, Gestor de Finanças, Operador |
| **Finalidade**: | Recolher informações de autênticação e conectar ao sistema |
| **Tipo**: |Secundário|
| **Descrição**: | Ao acessar o sistema, o usuário inicia a autenticação. Ele informa suas credenciais. O sistema valida as informações e permite o acesso ao sistema, caso estejam corretas. Caso contrário, o sistema exibe uma mensagem de erro. |
| **Referências cruzadas**: | Requisitos: RF02, RF02.1, RF02.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Desconexão de Usuário** |
| **Atores**: |Administrador, Gestor de Finanças, Operador |
| **Finalidade**: | Desconectar usuário do sistema |
| **Tipo**: |Secundário|
| **Descrição**: | O usuário decide encerrar a sessão, então o sistema finaliza o acesso. Caso o usuário queira continuar utilizando o sistema, é necessário se autenticar novamente.|
| **Referências cruzadas**: | Requisitos: RF03, RF03.1, RF03.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Buscar Usuário** |
| **Atores**: |Administrador |
| **Finalidade**: | Recolher informações de usuário e buscá-lo no sistema |
| **Tipo**: |Secundário |
| **Descrição**: | O Administrador precisa localizar um usuário específico cadastrado no sistema, então o usuário informa os dados que conhece sobre o usuário. O sistema faz a busca e retorna o que encontrou. Caso não encontre, o sistema apresenta uma mensagem indicando que nenhum resultado foi encontrado. |
| **Referências cruzadas**: | Requisitos: RF07, RF07.1, RF07.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Alterar Informações de Usuário** |
| **Atores**: |Administrador, Gestor de Finanças, Operador |
| **Finalidade**: | Alterar informações de usuário e salvá-las |
| **Tipo**: |Secundário |
| **Descrição**: | O usuário acessa as configurações da própria conta e deseja atualizar seus dados. Ele altera as informações que deseja e confirma a operação. O sistema salva as novas informações e registra a ação no Histórico de Auditoria de Alteração. |
| **Referências cruzadas**: | Requisitos: RF05, RF05.1, RF05.2, RF41, RF41.1, RF41.2  |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Excluir Usuário** |
| **Atores**: |Administrador|
| **Finalidade**: | Localizar usuário cadastrado e apagá-lo do sistema |
| **Tipo**: |Secundário |
| **Descrição**: | O Administrador identifica a necessidade de remover um usuário do sistema. Ele localiza o usuário desejado e confirma a ação de exclusão. O sistema remove permanentemente o registro do usuário, impedindo futuros acessos com aquelas credenciais. A ação é registrada no Histórico de Auditoria Registro. |
| **Referências cruzadas**: | Requisitos: RF06, RF06.1, RF06.2, RF06.3, RF07.2, RF40, RF40.1, RF40.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Listagem de Usuários** |
| **Atores**: |Administrador|
| **Finalidade**: | Listar todos usuários cadastrados no sistema |
| **Tipo**: |Secundário |
| **Descrição**: | O Administrador deseja ter uma visão de todos os usuários do sistema. Ele inicia a listagem e o sistema exibe todos os registros de usuários disponíveis e suas informações gerais. Essa visualização permite ao Administrador gerenciar e acompanhar o quadro de usuários ativos. |
| **Referências cruzadas**: | Requisitos: RF07, RF07.1 |







**CLUBE**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Cadastro do Clube** |
| **Atores**: |Administrador|
| **Finalidade**: | Recolher informações de Administrador e cadastrar clube |
| **Tipo**: |Primário|
| **Descrição**: | O Administrador acessa o sistema e deseja registrar as informações do clube. Ele preenche os dados e confirma o registro. O sistema armazena as informações do clube e registra a ação no Histórico de Auditoria de Registro. O clube está apto para ser administrado.|
| **Referências cruzadas**: | Requisitos: RF08.1, RF08.2.1, RF08.3, RF40, RF40.1, RF40.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Alterar Informações de Clube** |
| **Atores**: |Administrador|
| **Finalidade**: | Alterar informações de clube e salvá-las |
| **Tipo**: |Primário|
| **Descrição**: | O Administrador acessa as configurações do clube e deseja atualizar seus dados. Ele altera as informações que deseja e confirma a operação. O sistema salva as novas informações e registra a ação no Histórico de Auditoria de Alteração.|
| **Referências cruzadas**: | Requisitos: RF09, RF09.1, RF41, RF41.1, RF41.2  |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Excluir Clube** |
| **Atores**: |Administrador|
| **Finalidade**: | Localizar clube cadastrado e apagá-lo do sistema |
| **Tipo**: |Primário|
| **Descrição**: | O Administrador decide remover um clube específico do sistema. Ele localiza o clube desejado e confirma a operação. O sistema remove permanentemente o registro do clube. A ação é registrada no Histórico de Auditoria de Registro. |
| **Referências cruzadas**: | Requisitos: RF10, RF10.1, RF10.2, RF40, RF40.1, RF40.2 |








**RELATÓRIO**
| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Relatório de Finanças** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Finalidade**: | Visualizar informações sobre as finanças do clube |
| **Tipo**: |Primário |
| **Descrição**: |O usuário acessa a seção de relatórios para compreender a situação financeira do clube. Ele escolhe o Relatório de Finanças, o sistema processa dados e apresenta gráficos que refletem o panorama financeiro.|
| **Referências cruzadas**: | Requisitos: RF38, RF38.1, RF38.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Relatório de Receitas** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Finalidade**: | Visualizar informações sobre as receitas do clube |
| **Tipo**: |Primário |
| **Descrição**: | O usuário deseja analisar as entradas financeiras do clube. Ele escolhe o Relatório de Receitas, o sistema processa dados e apresenta gráficos que refletem o panorama das receitas. O relatório permite identificar as principais fontes de renda.|
| **Referências cruzadas**: | Requisitos: RF37, RF37.1, RF37.2, RF37.3 |


| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Relatório de Despesas** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Finalidade**: | Visualizar informações sobre as despesas do clube |
| **Tipo**: |Primário |
| **Descrição**: | O usuário deseja analisar os gastos financeiros do clube. Ele escolhe o Relatório de Despesas, o sistema processa dados e apresenta gráficos que refletem o panorama das despesas. O relatório permite identificar os principais gastos. |
| **Referências cruzadas**: | Requisitos: RF36, RF36.1, RF36.2, RF36.3 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Relatório de Desempenho no Futebol** |
| **Atores**: |Administrador, Operador|
| **Finalidade**: | Visualizar informações sobre o desempenho do clube no futebol |
| **Tipo**: |Primário |
| **Descrição**: | O usuário deseja acompanhar o rendimento esportivo do clube. Ele escolhe o Relatório de Desempenho, o sistema processa dados e apresenta gráficos de desempenho relacionados às atividades do clube em campo. O relatório fornece uma visão do rendimento da equipe e estimula o investimento nas equipes. |
| **Referências cruzadas**: | Requisitos: RF39, RF39.1, EF39.2, RF39.3, RF39.4 |




**RECEITA**

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Cadastro de Receitas** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Finalidade**: | Recolher informações de Receita e registrá-la no sistema |
| **Tipo**: |Primário |
| **Descrição**: |O usuário identifica uma nova receita do clube. Ele inicia o registro, preenche as informações e confirma o registro. O sistema adiciona o valor às finanças do clube e armazena a ação no Histórico de Auditoria de Registro. |
| **Referências cruzadas**: | Requisitos: RF25, RF25.1, RF25.2, RF25.2.1, RF25.2.2, RF25.2.3, RF25.2.4, RF25.2.5, RF25.2.6, RF25.3, RF25.3.1, RF25.4, RF30, RF30.1, RF40, RF40.1, RF40.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Buscar Receita** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Finalidade**: | Recolher informações de receita e buscá-la no sistema |
| **Tipo**: |Secundário |
| **Descrição**: | O usuário precisa localizar uma receita específica registrada no sistema. Ele informa os dados que conhece sobre a receita e aciona a consulta. O sistema retorna os registros correspondentes ou, caso não encontre, o sistema apresenta uma mensagem indicando que nenhum resultado foi encontrado. |
| **Referências cruzadas**: | Requisitos: RF29, RF29.1 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Alterar Informações de Receita** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Finalidade** | Alterar informações de receita e salvá-las |
| **Tipo**: |Secundário |
| **Descrição**: |O usuário identifica a necessidade de atualizar os dados de uma receita já cadastrada. Ele localiza o registro, faz alterações necessárias e confirma a operação. O sistema salva as novas informações e registra a ação no Histórico de Auditoria de Alteração. |
| **Referências cruzadas**: | Requisitos: RF26, RF26.1, RF26.2, RF26.2.1, RF26.3, RF29, RF29.1, RF30, RF30.1, RF41, RF41.1, RF41.2  |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Excluir Receita** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Finalidade**: | Localizar receita cadastrada e apagá-la do sistema |
| **Tipo**: |Secundário |
| **Descrição**: | O usuário identifica uma receita registrada que precisa ser removida do sistema. Ele localiza o registro e confirma a ação. O sistema remove permanentemente a receita, deixando-a indisponível para futuras consultas. A ação é registrada no Histórico de Auditoria de Registro. |
| **Referências cruzadas**: | Requisitos: RF27, RF27.1, RF27.2, RF27.3, RF29, RF29.1, RF30, RF30.1, RF40, RF40.1, RF40.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Listagem de Receitas** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Finalidade**: | Listar todas receitas cadastradas no sistema |
| **Tipo**: |Secundário |
| **Descrição**: | O Administrador deseja ter uma visão de todas as receitas registradas no sistema. Ele inicia a listagem e o sistema exibe todos os registros de receitas e suas informações gerais. Essa visualização permite ao Administrador gerenciar e acompanhar o quadro de receitas. |
| **Referências cruzadas**: | Requisitos: RF28, RF28.1 |









**DESPESA**

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Cadastro de Despesas** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Finalidade**: | Recolher informações de Despesa e registrá-la no sistema |
| **Tipo**: |Primário |
| **Descrição**: |O usuário identifica uma nova despesa do clube. Ele inicia o registro, preenche as informações e confirma o registro. O sistema subtrai o valor das finanças do clube e armazena a ação no Histórico de Auditoria de Registro. |
| **Referências cruzadas**: | Requisitos: RF20, RF20.1, RF20.2, RF20.2.1, RF20.2.2, RF20.2.3, RF20.2.4, RF20.2.5, RF20.2.6, RF20.3, RF20.3.1, RF20.4, RF30, RF30.1, RF40, RF40.1, RF40.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Buscar Despesa** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Finalidade**: | Recolher informações de despesa e buscá-la no sistema |
| **Tipo**: |Secundário |
| **Descrição**: |O usuário precisa localizar uma despesa específica registrada no sistema. Ele informa os dados que conhece sobre a despesa e aciona a consulta. O sistema retorna os registros correspondentes ou, caso não encontre, o sistema apresenta uma mensagem indicando que nenhum resultado foi encontrado.|
| **Referências cruzadas**: | Requisitos: RF24, RF24.1 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Alterar Informações de Despesa** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Finalidade**: | Alterar informações de despesa e salvá-las |
| **Tipo**: |Secundário |
| **Descrição**: |O usuário identifica a necessidade de atualizar os dados de uma despesa já cadastrada. Ele localiza o registro, faz alterações necessárias e confirma a operação. O sistema salva as novas informações e registra a ação no Histórico de Auditoria de Alteração. |
| **Referências cruzadas**: | Requisitos: RF21, RF21.1, RF21.2, RF21.2.1, RF21.3, RF41, RF41.1, RF41.2  |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Excluir Despesa** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Finalidade**: | Localizar despesa cadastrada e apagá-la do sistema |
| **Tipo**: |Secundário |
| **Descrição**: | O usuário identifica uma despesa registrada que precisa ser removida do sistema. Ele localiza o registro e confirma a ação. O sistema remove permanentemente a despesa, deixando-a indisponível para futuras consultas. A ação é registrada no Histórico de Auditoria de Registro.|
| **Referências cruzadas**: | Requisitos: RF22, RF22.2, RF22.3, RF24, RF24.1, RF30, RF30.1, RF40, RF40.1, RF40.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Listagem de Despesas** |
| **Atores**: |Administrador, Gestor de Finanças|
| **Finalidade**: | Listar todas despesas cadastradas no sistema |
| **Tipo**: |Secundário |
| **Descrição**: | O Administrador deseja ter uma visão de todas as despesas registradas no sistema. Ele inicia a listagem e o sistema exibe todos os registros de despesas e suas informações gerais. Essa visualização permite ao Administrador gerenciar e acompanhar o quadro de despesas. |
| **Referências cruzadas**: | Requisitos: RF23, RF23.1 |









**FUTEBOL**

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Comprar Jogadores** |
| **Atores**: |Administrador, Operador|
| **Finalidade**: | Comprar (definitivo ou empréstimo) jogador e registrá-lo no sistema |
| **Tipo**: |Primário|
| **Descrição**: |O usuário deseja registrar a compra de um jogador para o clube. Ele inicia a compra, preenche as informações do atleta e confirma a operação. O sistema registra o jogador no elenco, subtrai o valor da compra das finanças do clube e armazena a ação no Histórico de Auditoria de Registro. |
| **Referências cruzadas**: | Requisitos: RF12, RF12.1, RF12.2, RF12.2.1, RF12.3, RF16, RF16.1, RF16.2, RF16.3, RF16.3.1, RF16.4, RF16.5, RF19, RF19.1, RF19.2, RF19.2.1, RF30, RF30.1, RF40, RF40.1, RF40.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Buscar Jogador** |
| **Atores**: |Administrador, Operador|
| **Finalidade**: | Recolher informações de jogador e buscá-lo no sistema |
| **Tipo**: |Secundário|
| **Descrição**: |O usuário precisa localizar um jogador específico registrado no sistema. Ele informa os dados que conhece sobre o jogador e aciona a consulta. O sistema retorna os registros correspondentes ou, caso não encontre, o sistema apresenta uma mensagem indicando que nenhum resultado foi encontrado.|
| **Referências cruzadas**: | Requisitos: RF15.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Alterar Informações de Jogador** |
| **Atores**: |Administrador, Operador|
| **Finalidade**: | Alterar informações de jogador e salvá-las |
| **Tipo**: |Secundário |
| **Descrição**: |O usuário identifica a necessidade de atualizar os dados de um jogador já cadastrado. Ele localiza o jogador, faz alterações necessárias e confirma a operação. O sistema salva as novas informações e registra a ação no Histórico de Auditoria de Alteração.|
| **Referências cruzadas**: | Requisitos: RF13, RF13.1, RF30, RF30.1, RF41, RF41.1, RF41.2  |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Vender Jogador** |
| **Atores**: |Administrador, Operador|
| **Finalidade**: | Vender (definitivo ou empréstimo) jogador específico e removê-lo do sistemo |
| **Tipo**: |Primário|
| **Descrição**: |O usuário registra a saída de um jogador como uma transferência. Ele localiza o jogador, informa os dados da venda e confirma a operação. O sistema remove o jogador do elenco, acrescenta o valor da venda às finanças do clube e armazena a ação no Histórico de Auditoria de Registro. |
| **Referências cruzadas**: | Requisitos: RF17, RF17.1, RF17.2, RF17.3, RF17.3.1, RF17.4, RF18, RF18.1, RF18.2, RF18.3, RF30, RF30.1, RF40, RF40.1, RF40.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Listagem de Jogadores** |
| **Atores**: |Administrador, Operador|
| **Finalidade**: | Listar todos jogadores cadastrados no sistema |
| **Tipo**: |Secundário |
| **Descrição**: | O Administrador deseja ter uma visão de todos os jogadores registrados no sistema. Ele inicia a listagem e o sistema exibe todos os registros de jogadores e suas informações gerais. Essa visualização permite ao Administrador gerenciar e acompanhar o quadro de jogadores.|
| **Referências cruzadas**: | Requisitos: RF15, RF515.1 |



| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Cadastrar Partida** |
| **Atores**: |Administrador, Operador|
| **Finalidade**: | Recolher informações de Partida e registrá-la no sistema |
| **Tipo**: |Primário|
| **Descrição**: |O usuário deseja registrar uma partida realiza. Ele inicia o cadastro, preenche as informações da partida e confirma a operação. O sistema registra a partida no clube, soma o valor dos ganhos nas finanças do clube e armazena a ação no Histórico de Auditoria de Registro. |
| **Referências cruzadas**: | Requisitos: RF31, RF31.1, RF31.2, RF31.3, RF31.4, RF31.5, RF31.5.1, RF31.6, RF31.6.1, RF31.7, RF30, RF30.1, RF40, RF40.1, RF40.2  |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Buscar Partida** |
| **Atores**: |Administrador, Operador|
| **Finalidade**: | Recolher informações de partida e buscá-la no sistema |
| **Tipo**: |Secundário|
| **Descrição**: |O usuário precisa localizar uma partida específica registrada no sistema. Ele informa os dados que conhece sobre a partida e aciona a consulta. O sistema retorna os registros correspondentes ou, caso não encontre, o sistema apresenta uma mensagem indicando que nenhum resultado foi encontrado.|
| **Referências cruzadas**: | Requisitos: RF35, RF35.1 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Alterar Informações de Partida** |
| **Atores**: |Administrador, Operador|
| **Finalidade**: | Alterar informações de partida e salvá-las |
| **Tipo**: |Secundário |
| **Descrição**: |O usuário identifica a necessidade de atualizar os dados de uma partida cadastrada. Ele localiza a partida, faz alterações necessárias e confirma a operação. O sistema salva as novas informações e registra a ação no Histórico de Auditoria de Alteração.|
| **Referências cruzadas**: | Requisitos: RF32, RF32.1, RF32.2, RF32.3, RF41, RF41.1, RF41.2 | 

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Apagar Partida** |
| **Atores**: |Administrador, Operador|
| **Finalidade**: | Localizar partida cadastrada e apagá-la do sistema |
| **Tipo**: |Primário|
| **Descrição**: |O usuário deseja a saída apagar uma partida cadastrada. Ele localiza a partida, informa os dados e confirma a operação. O sistema remove a partida do sistema, subtrai o valor dos ganhos das finanças do clube e armazena a ação no Histórico de Auditoria de Registro. |
| **Referências cruzadas**: | Requisitos: RF33, RF31.1, RF33.2, RF33.3, RF33.4, RF35, RF35.1, RF40, RF40.1, RF40.2 |

| **Campo** | **Conteúdo** |
| :-- | :-- |
| **Caso de Uso**: |**Listagem de Partidas** |
| **Atores**: |Administrador, Operador|
| **Finalidade**: | Listar todas partidas registradas no sistema |
| **Tipo**: |Secundário |
| **Descrição**: | O Administrador deseja ter uma visão de todas as partidas registradas no sistema. Ele inicia a listagem e o sistema exibe todos os registros de partidas e suas informações gerais. Essa visualização permite ao Administrador gerenciar e acompanhar o quadro futebolistico do clube.|
| **Referência cruzadas**: | Requisitos: RF34, RF34.1 |


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



