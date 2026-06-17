package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

    private static final String URL = "jdbc:sqlite:SistemaSAF.db";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void iniciarTabelaUsuario() {

        String sql = "CREATE TABLE IF NOT EXISTS usuario ("
                + "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nome_usuario TEXT NOT NULL UNIQUE, "
                + "senha TEXT NOT NULL, "
                + "nivel_usuario INTEGER NOT NULL"
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
                + "tipo TEXT NOT NULL"
                + ");";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Tabela 'transacao' criada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela transacao!");
            e.printStackTrace();
        }
    }
}