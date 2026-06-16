package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

    // 1. Configurações de conexão do banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/SistemaSAF";
    private static final String USER = "root";
    private static final String PASSWORD = "Vini2606@";

    public static void iniciarTabelaUsuario() {

        String sql = "CREATE TABLE IF NOT EXISTS usuario ("
           + "id_usuario INT AUTO_INCREMENT PRIMARY KEY, "
           + "nome_usuario VARCHAR(50) NOT NULL UNIQUE, "
           + "senha VARCHAR(255) NOT NULL, "
           + "nivel_usuario INT NOT NULL"
           + ");";

        // 3. Abrindo a conexão e executando o comando
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");

            // Executa o comando SQL de criação
            stmt.execute(sql);
            System.out.println("Tabela 'aluno' criada (ou já existente) com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ou executar comando no banco de dados!");
            e.printStackTrace();
        }
    }
    
    public static void iniciarTabelaClube() {

        String sql = "CREATE TABLE IF NOT EXISTS clube ("
           + "id_clube INT AUTO_INCREMENT PRIMARY KEY, "
           + "nome_clube VARCHAR(50) NOT NULL UNIQUE, "
           + "ano_de_fundacao int NOT NULL, "
           + "pais VARCHAR(50) NOT NULL, "
           + "saldo_atual float NOT NULL"
           + ");";

        // 3. Abrindo a conexão e executando o comando
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SistemaSAF", "root", "root");
             Statement stmt = conn.createStatement()) {

            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");

            // Executa o comando SQL de criação
            stmt.execute(sql);
            System.out.println("Tabela 'clube' criada (ou já existente) com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ou executar comando no banco de dados!");
            e.printStackTrace();
        }
    }
    
    
    public static void iniciarTabelaTransacao() {

        String sql = "CREATE TABLE IF NOT EXISTS transacao ("
           + "id_transacao INT AUTO_INCREMENT PRIMARY KEY, "
           + "valor float NOT NULL, "
           + "categoria VARCHAR(50) NOT NULL, "
           + "descricao VARCHAR(50) NOT NULL, "
           + "data date NOT NULL, "
           + "tipo VARCHAR(50) NOT NULL"
           + ");";

        // 3. Abrindo a conexão e executando o comando
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SistemaSAF", "root", "root");
             Statement stmt = conn.createStatement()) {

            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");

            // Executa o comando SQL de criação
            stmt.execute(sql);
            System.out.println("Tabela 'transacao' criada (ou já existente) com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ou executar comando no banco de dados!");
            e.printStackTrace();
        }
    }
}
