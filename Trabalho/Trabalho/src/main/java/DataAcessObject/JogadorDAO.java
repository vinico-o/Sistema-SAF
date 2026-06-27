/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAcessObject;

import Model.Jogador.Jogador;
import Model.Sessao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinícius Mardegan
 */
public class JogadorDAO {
    public static int createJogador(Jogador jogador) {
        String sql = "INSERT INTO jogador (nome, data_de_nascimento, nacionalidade, posicao, numero_da_camisa, salario, tempo_de_contrato, valor, statusEmprestimo, idClube) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        int idJogador = -1;
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, jogador.getNome());
            stmt.setDate(2, new java.sql.Date(jogador.getData_de_nascimento().getTime()));
            stmt.setString(3, jogador.getNacionalidade());
            stmt.setString(4, jogador.getPosicao());
            stmt.setInt(5, jogador.getNumero_da_camisa());
            stmt.setFloat(6, jogador.getSalario());
            stmt.setInt(7, jogador.getTempo_de_contrato());
            stmt.setFloat(8, jogador.getValor());
            stmt.setString(9, jogador.getStatusEmprestimo() != null ? jogador.getStatusEmprestimo() : "DEFINITIVO");
            stmt.setInt(10, Sessao.getIdClubeAtual());

            stmt.executeUpdate();

            java.sql.ResultSet rsKeys = stmt.getGeneratedKeys();
            if (rsKeys.next()) {
                idJogador = rsKeys.getInt(1);
            }

            stmt.close();
            javax.swing.JOptionPane.showMessageDialog(null, "Jogador cadastrado!");

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "ERRO ao salvar no banco: " + e.getMessage());
        }

        return idJogador;
    }

    public static boolean verificarCamisaEmUso(int numero_da_camisa, int idClube, int idIgnorar) {
        String sql = "SELECT id_jogador FROM jogador WHERE numero_da_camisa = ? AND idClube = ? AND id_jogador != ?";
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, numero_da_camisa);
            stmt.setInt(2, idClube);
            stmt.setInt(3, idIgnorar);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Se retornar algo, a camisa já está em uso
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Jogador> listarJogadores() {
        String sql = "SELECT * FROM jogador WHERE idClube = ?";
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, Sessao.getIdClubeAtual());

            ArrayList<Jogador> jogadores = new ArrayList<>();

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Jogador obj = new Jogador();

                obj.setIdJogador(rs.getInt("id_jogador"));
                obj.setNome(rs.getString("nome"));
                obj.setData_de_nascimento(new java.util.Date(rs.getLong("data_de_nascimento")));
                obj.setNacionalidade(rs.getString("nacionalidade"));
                obj.setPosicao(rs.getString("posicao"));
                obj.setNumero_da_camisa(rs.getInt("numero_da_camisa"));
                obj.setSalario(rs.getFloat("salario"));
                obj.setTempo_de_contrato(rs.getInt("tempo_de_contrato"));
                obj.setValor(rs.getFloat("valor"));
                obj.setStatusEmprestimo(rs.getString("statusEmprestimo"));

                jogadores.add(obj);
            }
            return jogadores;

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao listar jogadores: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static Jogador buscarJogadorPorId(int id_jogador) {
        String sql = "SELECT * FROM jogador WHERE id_jogador = ?";
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id_jogador);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Jogador obj = new Jogador();

                obj.setIdJogador(rs.getInt("id_jogador"));
                obj.setNome(rs.getString("nome"));
                obj.setData_de_nascimento(new java.util.Date(rs.getLong("data_de_nascimento")));
                obj.setNacionalidade(rs.getString("nacionalidade"));
                obj.setPosicao(rs.getString("posicao"));
                obj.setNumero_da_camisa(rs.getInt("numero_da_camisa"));
                obj.setSalario(rs.getFloat("salario"));
                obj.setTempo_de_contrato(rs.getInt("tempo_de_contrato"));
                obj.setValor(rs.getFloat("valor"));
                obj.setStatusEmprestimo(rs.getString("statusEmprestimo"));

                return obj;
            } else {
                return null;
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao buscar jogador: " + e.getMessage());
            return null;
        }
    }

    public static Jogador buscarJogadorPorNome(String nome) {
        String sql = "SELECT * FROM jogador WHERE nome = ? AND idClube = ?";
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setInt(2, Sessao.getIdClubeAtual());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Jogador obj = new Jogador();

                obj.setIdJogador(rs.getInt("id_jogador"));
                obj.setNome(rs.getString("nome"));
                obj.setData_de_nascimento(new java.util.Date(rs.getLong("data_de_nascimento")));
                obj.setNacionalidade(rs.getString("nacionalidade"));
                obj.setPosicao(rs.getString("posicao"));
                obj.setNumero_da_camisa(rs.getInt("numero_da_camisa"));
                obj.setSalario(rs.getFloat("salario"));
                obj.setTempo_de_contrato(rs.getInt("tempo_de_contrato"));
                obj.setValor(rs.getFloat("valor"));
                obj.setStatusEmprestimo(rs.getString("statusEmprestimo"));

                return obj;
            } else {
                return null;
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao buscar jogador: " + e.getMessage());
            return null;
        }
    }

    public static void apagarJogador(int idJogador) {
        DataAcessObject.TransacaoDAO.desvincularTransacoesDeJogador(idJogador);
        String sql = "DELETE FROM jogador WHERE id_jogador = ?";
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idJogador);

            stmt.execute();
            stmt.close();

            javax.swing.JOptionPane.showMessageDialog(null, "Jogador excluído com sucesso!");

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao excluir jogador: " + e.getMessage());
        }
    }

    public static void excluirTodosJogadoresDeClube(int idClube) {
        String sql = "delete from jogador where idClube = ?";

        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idClube);

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e);
        }
    }

    public static int obterUltimoIdJogador() {
        String sql = "SELECT id_jogador FROM jogador ORDER BY id_jogador DESC LIMIT 1;";

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

    public static void atualizarJogador(Jogador jogador) {
        String sql = "UPDATE jogador SET nome = ?, data_de_nascimento = ?, nacionalidade = ?, posicao = ?, numero_da_camisa = ?, salario = ?, tempo_de_contrato = ?, valor = ?, statusEmprestimo = ? WHERE id_jogador = ?";
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, jogador.getNome());
            stmt.setDate(2, new java.sql.Date(jogador.getData_de_nascimento().getTime()));
            stmt.setString(3, jogador.getNacionalidade());
            stmt.setString(4, jogador.getPosicao());
            stmt.setInt(5, jogador.getNumero_da_camisa());
            stmt.setFloat(6, jogador.getSalario());
            stmt.setInt(7, jogador.getTempo_de_contrato());
            stmt.setFloat(8, jogador.getValor());
            stmt.setString(9, jogador.getStatusEmprestimo());
            stmt.setInt(10, jogador.getIdJogador());

            stmt.executeUpdate();

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao atualizar jogador: " + e.getMessage());
        }
    }
}
