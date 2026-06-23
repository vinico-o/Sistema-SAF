/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAcessObject;

import Model.Clube.Clube;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cauan
 */
public class ClubeDAO {

    public static void createClube(Clube clube) {
        // String de conexão SQL
        String sql = "INSERT INTO clube (nome_clube, ano_de_fundacao, pais, saldo_atual) VALUES (?, ?, ?, ?)";

        // O try-with-resources abre e FECHA automaticamente a conexão e o stmt
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Vincula os parâmetros usando os getters do objeto clube
            stmt.setString(1, clube.getNome());
            stmt.setInt(2, clube.getAnoDeFundacao());
            stmt.setString(3, clube.getPais());
            stmt.setFloat(4, clube.getSaldoAtual());

            // Executa a inserção no banco de dados
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Clube cadastrado!");
        } catch (Exception e) {
            // Exibe a mensagem de erro caso algo falhe (ex: driver faltando, banco offline)
            JOptionPane.showMessageDialog(null, "ERRO ao salvar no banco: " + e.getMessage());
        }
    }

    public static ArrayList<Clube> listClube() {

        String sql = "select * from clube";
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            ArrayList<Clube> clubes = new ArrayList<>();

            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            /// enquanto conseguir ir para a proxima linha -> arquiva as infos
            {
                Clube obj = new Clube();

                obj.setIdClube(rs.getInt("id_clube"));
                obj.setNome(rs.getString("nome_clube"));
                obj.setAnoDeFundacao(rs.getInt("ano_de_fundacao"));
                obj.setPais(rs.getString("pais"));
                obj.setSaldoAtual(rs.getFloat("saldo_atual"));

                clubes.add(obj);

                /// joga o conteudo na lista
            }
            return clubes;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public static void ExcluirClube(int id) {
        String sql = "delete from clube where id_clube = ?";

        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();

            TransacaoDAO.excluirTodasTransacoesDeClube(id);
            JogadorDAO.excluirTodosJogadoresDeClube(id);
            PartidaDAO.excluirTodasPartidasDeClube(id);
            UsuarioDAO.excluirTodosUsuariosDeClube(id);
            AuditoriaDAO.excluirTodasAuditoriasDeClube(id);

            JOptionPane.showMessageDialog(null, "Clube excluído com SUCESSO");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e);
        }
    }

    public static void atualizarClube(int idClube, Clube clube) {

        String sql = "update clube set nome_clube = ?, ano_de_fundacao = ?, pais = ? where id_clube = ?";

        // O try-with-resources abre e FECHA automaticamente a conexão e o stmt
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Vincula os parâmetros usando os getters do objeto clube
            stmt.setString(1, clube.getNome());
            stmt.setInt(2, clube.getAnoDeFundacao());
            stmt.setString(3, clube.getPais());

            stmt.setInt(4, idClube);

            // Executa a inserção no banco de dados
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Clube atualizado!");
        } catch (Exception e) {
            // Exibe a mensagem de erro caso algo falhe (ex: driver faltando, banco offline)
            JOptionPane.showMessageDialog(null, "ERRO ao salvar no banco: " + e.getMessage());
        }
    }

    public static void atualizarSaldo(int idClube, float saldo) {

        String sql = "update clube set saldo_atual = ? where id_clube = ?";

        // O try-with-resources abre e FECHA automaticamente a conexão e o stmt
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Vincula os parâmetros usando os getters do objeto clube
            stmt.setFloat(1, saldo);

            stmt.setInt(2, idClube);

            // Executa a inserção no banco de dados
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Saldo do clube foi atualizado!");
        } catch (Exception e) {
            // Exibe a mensagem de erro caso algo falhe (ex: driver faltando, banco offline)
            JOptionPane.showMessageDialog(null, "ERRO ao salvar no banco: " + e.getMessage());
        }
    }

    public static int obterUltimoIdClube() {
        String sql = "SELECT id_clube FROM clube ORDER BY id_clube DESC LIMIT 1;";

        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERRO ao usar o banco: " + e.getMessage());
        }

        return -1; // se der erro -> retorna -1
    }

}
