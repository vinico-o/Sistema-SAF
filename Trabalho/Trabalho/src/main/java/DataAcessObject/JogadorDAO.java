/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAcessObject;

import Model.Jogador;
import Model.Sessao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vinícius Mardegan
 */
public class JogadorDAO {

    public static void createJogador(Jogador jogador) {
        String sql = "INSERT INTO jogador (nome, data_de_nascimento, nacionalidade, posicao, numero_da_camisa, salario, tempo_de_contrato, valor, idClube) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            stmt.setInt(9, Sessao.getIdClubeAtual());

            stmt.execute();
            stmt.close();
            javax.swing.JOptionPane.showMessageDialog(null, "Jogador cadastrado!");

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "ERRO ao salvar no banco: " + e.getMessage());
        }

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

                jogadores.add(obj);
            }
            return jogadores;

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao listar jogadores: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
