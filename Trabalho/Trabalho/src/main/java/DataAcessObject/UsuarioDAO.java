/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAcessObject;

import JDBC.ConnectionFactory;
import Model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/SistemaSAF", "root", "Vini2606@");
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
   
   public static void createUsuario(Usuario usuario) {
        // String de conexão SQL
        String sql = "INSERT INTO usuario (nome_usuario, senha, nivel_usuario) VALUES (?, ?, ?)";

        // O try-with-resources abre e FECHA automaticamente a conexão e o stmt
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/SistemaSAF", "root", "Vini2606@");
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Vincula os parâmetros usando os getters do objeto usuario
            stmt.setString(1, usuario.getNome_usuario());
            stmt.setString(2, usuario.getSenha());
            stmt.setInt(3, usuario.getNivel_usuario());

            // Executa a inserção no banco de dados
            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            // Exibe a mensagem de erro caso algo falhe (ex: driver faltando, banco offline)
            JOptionPane.showMessageDialog(null, "ERRO ao salvar no banco: " + e.getMessage());
        }
    }
    
}
