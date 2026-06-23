/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAcessObject;

import Model.Sessao;
import Model.Usuario.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mardegan
 */
public class UsuarioDAO {

    public UsuarioDAO() {

    }

    public static boolean existeUsuarioCadastrado() {
        String sql = "SELECT COUNT(*) FROM usuario";

        // 3. Execução usando Try-with-resources (fecha tudo automaticamente no final)
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            // 4. Move o ponteiro para a primeira linha do resultado
            if (rs.next()) {
                // Como o COUNT retorna um número, pegamos a primeira coluna como int ou long
                int totalUsuarios = rs.getInt(1);

                if (totalUsuarios == 0) {
                    return false;
                }

            }

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ou executar a consulta: " + e.getMessage());
            e.printStackTrace();
        }

        return true;

    }

    public static boolean existeNomeUsuario(String nomeUsuario) {
        String sql = "SELECT 1 FROM usuario WHERE nome_usuario = ?";
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nomeUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Retorna true se achou
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void createUsuario(Usuario usuario) {
        // String de conexão SQL
        String sql = "INSERT INTO usuario (nome_usuario, senha, nivel_usuario, idClube) VALUES (?, ?, ?, ?)";

        // O try-with-resources abre e FECHA automaticamente a conexão e o stmt
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Vincula os parâmetros usando os getters do objeto usuario
            stmt.setString(1, usuario.getNome_usuario());
            stmt.setString(2, usuario.getSenha());
            stmt.setInt(3, usuario.getNivel_usuario());
            stmt.setInt(4, usuario.getIdClube());

            // Executa a inserção no banco de dados
            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            // Exibe a mensagem de erro caso algo falhe (ex: driver faltando, banco offline)
            JOptionPane.showMessageDialog(null, "ERRO ao salvar no banco: " + e.getMessage());
        }
    }

    public static ArrayList<Usuario> listarUsuarios() {
        String sql = "select * from usuario WHERE idClube = ? or idClube = 0";
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, Sessao.getIdClubeAtual());

            ArrayList<Usuario> usuarios = new ArrayList<>();

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario obj = new Usuario();

                obj.setId_usuario(rs.getInt("id_usuario"));
                obj.setNome_usuario(rs.getString("nome_usuario"));
                obj.setNivel_usuario(rs.getInt("nivel_usuario"));

                usuarios.add(obj);
            }
            return usuarios;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public static Usuario buscarUsuario(String nome_usuario) {
        String sql = "select * from usuario where nome_usuario = ?";
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome_usuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario obj = new Usuario();

                obj.setId_usuario(rs.getInt("id_usuario"));
                obj.setNome_usuario(rs.getString("nome_usuario"));
                obj.setNivel_usuario(rs.getInt("nivel_usuario"));
                obj.setSenha(rs.getString("senha"));
                obj.setIdClube(rs.getInt("idClube"));

                return obj;

            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public static void atualizarUsuario(Usuario usuario, int id_usuario) {

        String sql = "update usuario set nome_usuario = ?, senha = ?, nivel_usuario = ? where id_usuario = ?";

        // O try-with-resources abre e FECHA automaticamente a conexão e o stmt
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Vincula os parâmetros usando os getters do objeto clube
            stmt.setString(1, usuario.getNome_usuario());
            stmt.setString(2, usuario.getSenha());
            stmt.setInt(3, usuario.getNivel_usuario());

            stmt.setInt(4, id_usuario);

            // Executa a inserção no banco de dados
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Usuário atualizado!");
        } catch (Exception e) {
            // Exibe a mensagem de erro caso algo falhe (ex: driver faltando, banco offline)
            JOptionPane.showMessageDialog(null, "ERRO ao salvar no banco: " + e.getMessage());
        }
    }

    public static void excluirUsuario(int id_usuario) {

        String sql = "delete from usuario where id_usuario = ?";

        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id_usuario);

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Usuário excluído com SUCESSO");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e);
        }
    }

    public static void excluirTodosUsuariosDeClube(int idClube) {
        String sql = "delete from usuario where idClube = ?";

        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idClube);

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e);
        }
    }

    public static int obterUltimoIdUsuario() {
        String sql = "SELECT id_usuario FROM usuario ORDER BY id_usuario DESC LIMIT 1;";

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
