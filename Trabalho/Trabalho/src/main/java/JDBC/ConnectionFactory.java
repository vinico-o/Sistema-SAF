package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

    private static final String URL = "jdbc:sqlite:SistemaSAF.db";

    public static Connection conectar() throws SQLException {
        System.out.println("Banco aberto em: " + URL);
        return DriverManager.getConnection(URL);
    }

    public static void iniciarTabelaUsuario() {

        String sql = "CREATE TABLE IF NOT EXISTS usuario ("
                + "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nome_usuario TEXT NOT NULL UNIQUE, "
                + "senha TEXT NOT NULL, "
                + "nivel_usuario INTEGER NOT NULL, "
                + "idClube INTEGER, "
                + "FOREIGN KEY (idClube) REFERENCES clube(id_clube) "
                + ");";

        try (Connection conn = conectar();
                Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Tabela 'usuario' criada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela usuario!");
            e.printStackTrace();
        }
    }

    public static void iniciarTabelaClube() {

        String sql = "CREATE TABLE IF NOT EXISTS clube ("
                + "id_clube INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nome_clube TEXT NOT NULL UNIQUE, "
                + "ano_de_fundacao INTEGER NOT NULL, "
                + "pais TEXT NOT NULL, "
                + "saldo_atual REAL NOT NULL"
                + ");";

        try (Connection conn = conectar();
                Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Tabela 'clube' criada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela clube!");
            e.printStackTrace();
        }
    }

    public static void iniciarTabelaTransacao() {

        String sql = "CREATE TABLE IF NOT EXISTS transacao ("
                + "id_transacao INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "valor REAL NOT NULL, "
                + "categoria TEXT NOT NULL, "
                + "descricao TEXT NOT NULL, "
                + "data TEXT NOT NULL, "
                + "tipo TEXT NOT NULL, "
                + "idClube INTEGER, "
                + "idPartida INTEGER, "
                + "idJogador INTEGER, "
                + "FOREIGN KEY (idClube) REFERENCES clube(id_clube), "
                + "FOREIGN KEY (idPartida) REFERENCES partida(id_partida), "
                + "FOREIGN KEY (idJogador) REFERENCES jogador(id_jogador)"
                + ");";

        try (Connection conn = conectar();
                Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

            // Migração silenciosa para bancos existentes
            try {
                stmt.execute("ALTER TABLE transacao ADD COLUMN idPartida INTEGER");
            } catch (SQLException ignore) {
            }
            try {
                stmt.execute("ALTER TABLE transacao ADD COLUMN idJogador INTEGER");
            } catch (SQLException ignore) {
            }

            System.out.println("Tabela 'transacao' criada/atualizada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela transacao!");
            e.printStackTrace();
        }
    }

    public static void iniciarTabelaJogador() {

        String sql = "CREATE TABLE IF NOT EXISTS jogador ("
                + "id_jogador INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nome TEXT NOT NULL, "
                + "data_de_nascimento TEXT NOT NULL, "
                + "nacionalidade TEXT NOT NULL, "
                + "posicao TEXT NOT NULL, "
                + "numero_da_camisa INTEGER NOT NULL UNIQUE, "
                + "salario REAL NOT NULL, "
                + "tempo_de_contrato INTEGER NOT NULL, "
                + "valor REAL NOT NULL, "
                + "statusEmprestimo TEXT, "
                + "idClube INTEGER, "
                + "FOREIGN KEY (idClube) REFERENCES clube(id_clube)"
                + ");";

        try (Connection conn = conectar();
                Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            
            try {
                stmt.execute("ALTER TABLE jogador ADD COLUMN statusEmprestimo TEXT");
            } catch (SQLException ignore) {
            }
            
            System.out.println("Tabela 'jogador' criada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela jogador!");
            e.printStackTrace();
        }
    }

    public static void iniciarTabelaPartida() {

        String sql = "CREATE TABLE IF NOT EXISTS partida ("
                + "id_partida INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "data TEXT NOT NULL, "
                + "clube_adversario TEXT NOT NULL, "
                + "gols_marcados INTEGER NOT NULL, "
                + "gols_sofridos INTEGER NOT NULL, "
                + "competicao TEXT NOT NULL, "
                + "premiacao REAL NOT NULL, "
                + "publico INTEGER NOT NULL, "
                + "valor_do_ingresso REAL NOT NULL, "
                + "local TEXT NOT NULL, "
                + "idClube INTEGER, "
                + "FOREIGN KEY (idClube) REFERENCES clube(id_clube)"
                + ");";

        try (Connection conn = conectar();
                Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Tabela 'partida' criada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela partida!");
            e.printStackTrace();
        }
    }

    public static void iniciarTabelaAuditoria() {

        String sql = "CREATE TABLE IF NOT EXISTS auditoria ("
                + "id_auditoria INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "tipo_de_log TEXT NOT NULL, "
                + "data TEXT NOT NULL, "
                + "idRegistroAfetado INTEGER NOT NULL, "
                + "entidadeAfetada TEXT NOT NULL, "
                + "idClube INTEGER NOT NULL, "
                + "idUsuario INTEGER NOT NULL, "
                + "nomeUsuario TEXT NOT NULL, "
                + "FOREIGN KEY (idClube) REFERENCES clube(id_clube), "
                + "FOREIGN KEY (idUsuario) REFERENCES usuario(id_usuario) "
                + ");";

        try (Connection conn = conectar();
                Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Tabela 'auditoria' criada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela usuario!");
            e.printStackTrace();
        }
    }
}