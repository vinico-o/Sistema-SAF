/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAcessObject;

import Model.Auditoria.Auditoria;
import Model.Sessao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Cauan
 */
public class AuditoriaDAO {

    public static void createAuditoria(Auditoria auditoria) {
        // String de conexão SQL
        String sql = "INSERT INTO auditoria (tipo_de_log, data, idRegistroAfetado, entidadeAfetada, idClube, idUsuario, nomeUsuario) VALUES (?, ?, ?, ?, ?, ?, ?)";

        // O try-with-resources abre e FECHA automaticamente a conexão e o stmt
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Vincula os parâmetros usando os getters do objeto clube
            stmt.setString(1, auditoria.getTipoDeLog());
            stmt.setDate(2, new java.sql.Date(new Date().getTime()));
            stmt.setInt(3, auditoria.getIdDoRegistroAfetado());
            stmt.setString(4, auditoria.getEntidadeAfetada());
            stmt.setInt(5, Sessao.getIdClubeAtual());
            stmt.setInt(6, Sessao.getUsuarioLogado().getId_usuario());
            stmt.setString(7, Sessao.getUsuarioLogado().getNome_usuario());

            // Executa a inserção no banco de dados
            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            // Exibe a mensagem de erro caso algo falhe (ex: driver faltando, banco offline)
            JOptionPane.showMessageDialog(null, "ERRO ao salvar no banco: " + e.getMessage());
        }
    }

    public static ArrayList<Auditoria> listAuditoria() {

        String sql = "select * from auditoria where idClube = ?";
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            ArrayList<Auditoria> auditorias = new ArrayList<>();

            stmt.setInt(1, Sessao.getIdClubeAtual());

            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            /// enquanto conseguir ir para a proxima linha -> arquiva as infos
            {
                Auditoria obj = new Auditoria();

                obj.setIdAuditoria(rs.getInt("id_auditoria"));
                obj.setTipoDeLog(rs.getString("tipo_de_log"));
                obj.setData(new java.util.Date(rs.getLong("data")));
                obj.setIdDoRegistroAfetado(rs.getInt("idRegistroAfetado"));
                obj.setEntidadeAfetada(rs.getString("entidadeAfetada"));
                obj.setNomeUsuario(rs.getString("nomeUsuario"));

                auditorias.add(obj);
            }

            return auditorias;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public static void excluirTodasAuditoriasDeClube(int idClube) {
        String sql = "delete from auditoria where idClube = ?";

        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idClube);

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e);
        }
    }

}
