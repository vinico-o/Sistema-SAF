/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAcessObject;

import Model.Jogador;
import Model.Sessao;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Vinícius Mardegan
 */
public class JogadorDAO {
    
    public static void createJogador(Jogador jogador) {
    String sql = "INSERT INTO jogador (nome, data_nascimento, nacionalidade, posicao, numero_da_camisa, salario, tempo_de_contrato, idClube) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conexao = JDBC.ConnectionFactory.conectar();
         PreparedStatement stmt = conexao.prepareStatement(sql)) {

        stmt.setString(1, jogador.getNome());
        stmt.setDate(2, new java.sql.Date(jogador.getData_de_nascimento().getTime()));
        stmt.setString(3, jogador.getNacionalidade());
        stmt.setString(4, jogador.getPosicao());
        stmt.setInt(5, jogador.getNumero_da_camisa());
        stmt.setFloat(6, jogador.getSalario());
        stmt.setInt(7, jogador.getTempo_de_contrato());
        stmt.setInt(8, Sessao.getIdClubeAtual());

        stmt.execute();
        stmt.close();
        javax.swing.JOptionPane.showMessageDialog(null, "Jogador cadastrado!");

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(null, "ERRO ao salvar no banco: " + e.getMessage());
    }
}
    
}
