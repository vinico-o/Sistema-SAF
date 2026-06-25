CREATE TABLE IF NOT EXISTS clube (id_clube INTEGER PRIMARY KEY AUTOINCREMENT, nome_clube TEXT NOT NULL UNIQUE, ano_de_fundacao INTEGER NOT NULL, pais TEXT NOT NULL, saldo_atual REAL NOT NULL);
CREATE TABLE IF NOT EXISTS usuario (id_usuario INTEGER PRIMARY KEY AUTOINCREMENT, nome_usuario TEXT NOT NULL UNIQUE, senha TEXT NOT NULL, nivel_usuario INTEGER NOT NULL, idClube INTEGER, FOREIGN KEY (idClube) REFERENCES clube(id_clube) );
CREATE TABLE IF NOT EXISTS jogador (id_jogador INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, data_de_nascimento TEXT NOT NULL, nacionalidade TEXT NOT NULL, posicao TEXT NOT NULL, numero_da_camisa INTEGER NOT NULL UNIQUE, salario REAL NOT NULL, tempo_de_contrato INTEGER NOT NULL, valor REAL NOT NULL, statusEmprestimo TEXT, idClube INTEGER, FOREIGN KEY (idClube) REFERENCES clube(id_clube));
CREATE TABLE IF NOT EXISTS partida (id_partida INTEGER PRIMARY KEY AUTOINCREMENT, data TEXT NOT NULL, clube_adversario TEXT NOT NULL, gols_marcados INTEGER NOT NULL, gols_sofridos INTEGER NOT NULL, competicao TEXT NOT NULL, premiacao REAL NOT NULL, publico INTEGER NOT NULL, valor_do_ingresso REAL NOT NULL, local TEXT NOT NULL, idClube INTEGER, FOREIGN KEY (idClube) REFERENCES clube(id_clube));
CREATE TABLE IF NOT EXISTS transacao (id_transacao INTEGER PRIMARY KEY AUTOINCREMENT, valor REAL NOT NULL, categoria TEXT NOT NULL, descricao TEXT NOT NULL, data TEXT NOT NULL, tipo TEXT NOT NULL, idClube INTEGER, idPartida INTEGER, idJogador INTEGER, FOREIGN KEY (idClube) REFERENCES clube(id_clube), FOREIGN KEY (idPartida) REFERENCES partida(id_partida), FOREIGN KEY (idJogador) REFERENCES jogador(id_jogador));
CREATE TABLE IF NOT EXISTS auditoria (id_auditoria INTEGER PRIMARY KEY AUTOINCREMENT, tipo_de_log TEXT NOT NULL, data TEXT NOT NULL, idRegistroAfetado INTEGER NOT NULL, entidadeAfetada TEXT NOT NULL, idClube INTEGER NOT NULL, idUsuario INTEGER NOT NULL, nomeUsuario TEXT NOT NULL, FOREIGN KEY (idClube) REFERENCES clube(id_clube), FOREIGN KEY (idUsuario) REFERENCES usuario(id_usuario) );

-- Clubes
INSERT INTO clube (nome_clube, ano_de_fundacao, pais, saldo_atual) VALUES ('Botafogo SAF', 1904, 'Brasil', 50000000.0);
INSERT INTO clube (nome_clube, ano_de_fundacao, pais, saldo_atual) VALUES ('Cruzeiro SAF', 1921, 'Brasil', 30000000.0);

-- Usuarios do Botafogo SAF (idClube = 1)
INSERT INTO usuario (nome_usuario, senha, nivel_usuario, idClube) VALUES ('admin', '1234', 0, 1);
INSERT INTO usuario (nome_usuario, senha, nivel_usuario, idClube) VALUES ('gestor', '1234', 1, 1);
INSERT INTO usuario (nome_usuario, senha, nivel_usuario, idClube) VALUES ('operador', '1234', 2, 1);

-- Usuarios do Cruzeiro SAF (idClube = 2)
INSERT INTO usuario (nome_usuario, senha, nivel_usuario, idClube) VALUES ('admin2', '1234', 0, 2);
INSERT INTO usuario (nome_usuario, senha, nivel_usuario, idClube) VALUES ('gestor2', '1234', 1, 2);
INSERT INTO usuario (nome_usuario, senha, nivel_usuario, idClube) VALUES ('operador2', '1234', 2, 2);

-- Jogadores Botafogo (data_de_nascimento em epoch milissegundos)
INSERT INTO jogador (nome, data_de_nascimento, nacionalidade, posicao, numero_da_camisa, salario, tempo_de_contrato, valor, statusEmprestimo, idClube) VALUES 
('Lucas Perri', strftime('%s', '1997-12-10') * 1000, 'Brasileira', 'Goleiro', 12, 150000.0, 36, 5000000.0, 'DEFINITIVO', 1),
('Gatito Fernández', strftime('%s', '1988-06-01') * 1000, 'Paraguaia', 'Goleiro', 1, 200000.0, 12, 1000000.0, 'DEFINITIVO', 1),
('Adryelson', strftime('%s', '1998-03-23') * 1000, 'Brasileira', 'Zagueiro', 4, 180000.0, 48, 8000000.0, 'DEFINITIVO', 1),
('Victor Cuesta', strftime('%s', '1988-11-19') * 1000, 'Argentina', 'Zagueiro', 15, 300000.0, 24, 2000000.0, 'DEFINITIVO', 1),
('Marçal', strftime('%s', '1989-02-19') * 1000, 'Brasileira', 'Lateral Esquerdo', 21, 350000.0, 24, 3000000.0, 'DEFINITIVO', 1),
('Di Placido', strftime('%s', '1994-01-28') * 1000, 'Argentina', 'Lateral Direito', 24, 150000.0, 12, 1500000.0, 'DEFINITIVO', 1),
('Marlon Freitas', strftime('%s', '1995-03-27') * 1000, 'Brasileira', 'Volante', 17, 250000.0, 36, 4000000.0, 'DEFINITIVO', 1),
('Tchê Tchê', strftime('%s', '1992-08-30') * 1000, 'Brasileira', 'Volante', 6, 400000.0, 24, 3000000.0, 'DEFINITIVO', 1),
('Eduardo', strftime('%s', '1989-10-17') * 1000, 'Brasileira', 'Meia', 33, 450000.0, 24, 2500000.0, 'DEFINITIVO', 1),
('Victor Sá', strftime('%s', '1994-03-27') * 1000, 'Brasileira', 'Atacante', 7, 300000.0, 36, 3500000.0, 'DEFINITIVO', 1),
('Tiquinho Soares', strftime('%s', '1991-01-17') * 1000, 'Brasileira', 'Atacante', 9, 600000.0, 24, 6000000.0, 'DEFINITIVO', 1);

-- Jogadores Cruzeiro
INSERT INTO jogador (nome, data_de_nascimento, nacionalidade, posicao, numero_da_camisa, salario, tempo_de_contrato, valor, statusEmprestimo, idClube) VALUES 
('Rafael Cabral', strftime('%s', '1990-05-20') * 1000, 'Brasileira', 'Goleiro', 101, 200000.0, 24, 1500000.0, 'DEFINITIVO', 2),
('Matheus Pereira', strftime('%s', '1996-05-05') * 1000, 'Brasileira', 'Meia', 110, 500000.0, 36, 10000000.0, 'DEFINITIVO', 2),
('Arthur Gomes', strftime('%s', '1998-07-03') * 1000, 'Brasileira', 'Atacante', 111, 250000.0, 48, 5000000.0, 'DEFINITIVO', 2);

-- Partidas Botafogo (formato yyyy-MM-dd esperado pelo SimpleDateFormat do PartidaDAO)
INSERT INTO partida (data, clube_adversario, gols_marcados, gols_sofridos, competicao, premiacao, publico, valor_do_ingresso, local, idClube) VALUES 
('2024-01-15', 'Vasco', 2, 0, 'Campeonato Carioca', 50000.0, 35000, 60.0, 'Nilton Santos', 1),
('2024-01-22', 'Flamengo', 1, 1, 'Campeonato Carioca', 50000.0, 40000, 80.0, 'Maracanã', 1),
('2024-02-05', 'Palmeiras', 1, 0, 'Brasileirão', 150000.0, 38000, 100.0, 'Nilton Santos', 1),
('2024-02-12', 'Fluminense', 0, 2, 'Brasileirão', 0.0, 30000, 80.0, 'Maracanã', 1),
('2024-02-25', 'Corinthians', 3, 1, 'Copa do Brasil', 500000.0, 32000, 70.0, 'Nilton Santos', 1);

-- Partidas Cruzeiro
INSERT INTO partida (data, clube_adversario, gols_marcados, gols_sofridos, competicao, premiacao, publico, valor_do_ingresso, local, idClube) VALUES 
('2024-01-15', 'Atlético-MG', 1, 0, 'Campeonato Mineiro', 60000.0, 50000, 60.0, 'Mineirão', 2),
('2024-01-22', 'América-MG', 2, 2, 'Campeonato Mineiro', 0.0, 25000, 50.0, 'Mineirão', 2);

-- Transacoes Botafogo (data em epoch milissegundos)
INSERT INTO transacao (valor, categoria, descricao, data, tipo, idClube, idPartida, idJogador) VALUES 
(2100000.0, 'Bilheteria', 'Bilheteria jogo contra o Vasco', strftime('%s', '2024-01-16') * 1000, 'Receita', 1, 1, NULL),
(1500000.0, 'Patrocínio', 'Cota mensal', strftime('%s', '2024-01-01') * 1000, 'Receita', 1, NULL, NULL),
(3800000.0, 'Bilheteria', 'Bilheteria jogo contra o Palmeiras', strftime('%s', '2024-02-06') * 1000, 'Receita', 1, 3, NULL),
(500000.0, 'Premiação', 'Avanço na Copa do Brasil', strftime('%s', '2024-02-26') * 1000, 'Receita', 1, 5, NULL),
(1000000.0, 'Patrocínio', 'Cota mensal material esportivo', strftime('%s', '2024-02-10') * 1000, 'Receita', 1, NULL, NULL);

INSERT INTO transacao (valor, categoria, descricao, data, tipo, idClube, idPartida, idJogador) VALUES 
(3330000.0, 'Salários', 'Folha salarial de Janeiro', strftime('%s', '2024-02-05') * 1000, 'Despesa', 1, NULL, NULL),
(500000.0, 'Manutenção', 'Manutenção do gramado Nilton Santos', strftime('%s', '2024-01-10') * 1000, 'Despesa', 1, NULL, NULL),
(120000.0, 'Logística', 'Viagem para jogar no Maracanã e despesas gerais', strftime('%s', '2024-01-25') * 1000, 'Despesa', 1, 2, NULL),
(150000.0, 'Logística', 'Despesas com hotel e alimentação', strftime('%s', '2024-02-13') * 1000, 'Despesa', 1, 4, NULL),
(250000.0, 'Outros', 'Impostos e encargos de Janeiro', strftime('%s', '2024-02-20') * 1000, 'Despesa', 1, NULL, NULL);

-- Transacoes Cruzeiro
INSERT INTO transacao (valor, categoria, descricao, data, tipo, idClube, idPartida, idJogador) VALUES 
(3000000.0, 'Bilheteria', 'Jogo contra o Galo', strftime('%s', '2024-01-16') * 1000, 'Receita', 2, 6, NULL),
(2000000.0, 'Patrocínio', 'Patrocínio Master', strftime('%s', '2024-01-01') * 1000, 'Receita', 2, NULL, NULL);

INSERT INTO transacao (valor, categoria, descricao, data, tipo, idClube, idPartida, idJogador) VALUES 
(1500000.0, 'Salários', 'Folha salarial', strftime('%s', '2024-02-05') * 1000, 'Despesa', 2, NULL, NULL);
