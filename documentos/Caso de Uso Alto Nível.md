// USUÁRIO
Caso de Uso: Cadastro do Administrador
Atores: Administrador
Tipo: Primário
Descrição: O usuário inicia o programa pela primeira vez. É necessário cadastrar o Administrador. Só é feito uma vez.

Caso de Uso: Cadastro de Usuários
Atores: Administrador
Tipo: Primário
Descrição: O usuário inicia a criação de outros usuários. Os novos usuários podem ter cargo: Gestor de Finanças (GF) ou Operador (Op). O usuário é armazenado.

Caso de Uso: Buscar Usuário
Atores: Administrador
Tipo: Secundário
Descrição: O usuário busca por algum usuário usando informações. O sistema deve retornar o que encontrou ou uma mensagem.

Caso de Uso: Alterar Usuário
Atores: Administrador, Gestor de Finanças, Operador
Tipo: Secundário
Descrição: O usuário pode alterar as próprias informações.

Caso de Uso: Excluir Usuário
Atores: Administrador
Tipo: Secundário
Descrição: O usuário pode excluir qualquer usuário.

Caso de Uso: Listagem de Usuários
Atores: Administrador
Tipo: Secundário
Descrição: O usuário faz a listagem de todos usuários do sistema.


// RELATÓRIO
Caso de Uso: Relatório de Finanças
Atores: Administrador, Gestor de Finanças
Tipo: Primário
Descrição: O usuário faz o Relatório de Finanças. O Relatório de Finanças mostra gráficos sobre as Finanças do clube.

Caso de Uso: Relatório de Receitas
Atores: Administrador, Gestor de Finanças
Tipo: Primário
Descrição: O usuário faz o Relatório de Receitas. O Relatório de Receitas mostra gráficos sobre as Receitas do clube.

Caso de Uso: Relatório de Despesas
Atores: Administrador, Gestor de Finanças
Tipo: Primário
Descrição: O usuário faz o Relatório de Despesas. O Relatório de Despesas mostra gráficos sobre as Despesas do clube.

Caso de Uso: Relatório de Desempenho no Futebol
Atores: Administrador, Operador
Tipo: Primário
Descrição: O usuário faz o Relatório de Desempenho no Futebol . O Relatório de Desempenho no Futebol mostra o Aproveitamento do clube, Gráfico com Saldo de Gols e filtrar Partidas por competição.

// RECEITA
Caso de Uso: Cadastro de Receitas
Atores: Administrador, Gestor de Finanças
Tipo: Primário
Descrição: O usuário faz o Cadastro de Receita. Ao fim do cadastro, o valor é somado à finança do clube e é o registro é armazenado.

Caso de Uso: Buscar Receita
Atores: Administrador, Gestor de Finanças
Tipo: Secundário
Descrição: O usuário pode buscar alguma Receita usando informações. O sistema deve retornar o que encontrou ou uma mensagem.

Caso de Uso: Alterar Receita
Atores: Administrador, Gestor de Finanças
Tipo: Secundário
Descrição: O usuário pode alterar as informações de alguma Receita.

Caso de Uso: Excluir Receita
Atores: Administrador, Gestor de Finanças
Tipo: Secundário
Descrição: O usuário pode excluir alguma Receita.

Caso de Uso: Listagem de Receitas
Atores: Administrador, Gestor de Finanças
Tipo: Secundário
Descrição: O usuário faz a listagem de todas as Receitas do sistema. 

// DESPESA
Caso de Uso: Cadastro de Despesas
Atores: Administrador, Gestor de Finanças
Tipo: Primário
Descrição: O usuário faz o Cadastro de Despesas. Ao fim do cadastro, o valor é subtraído à finança do clube e é o registro é armazenado.

Caso de Uso: Buscar Despesa
Atores: Administrador, Gestor de Finanças
Tipo: Secundário
Descrição: O usuário pode buscar alguma Despesa usando informações. O sistema deve retornar o que encontrou ou uma mensagem.

Caso de Uso: Alterar Despesa
Atores: Administrador, Gestor de Finanças
Tipo: Secundário
Descrição: O usuário pode alterar as informações de alguma Despesa.

Caso de Uso: Excluir Despesa
Atores: Administrador, Gestor de Finanças
Tipo: Secundário
Descrição: O usuário pode excluir alguma Despesa.

Caso de Uso: Listagem de Despesas
Atores: Administrador, Gestor de Finanças
Tipo: Secundário
Descrição: O usuário faz a listagem de todas as Despesas do sistema. 

// FUTEBOL











