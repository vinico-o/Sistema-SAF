/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAcessObject;


import Model.Despesa;
import Model.Receita;
import Model.Sessao;
import Model.TransacaoFinanceira;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cauan
 */
public class TransacaoDAO {
    
    public static void createReceita(Receita receita) {
        // String de conexão SQL
        String sql = "INSERT INTO transacao (valor, categoria, descricao, data, tipo, idClube) VALUES (?, ?, ?, ?, ?, ?)";

        // O try-with-resources abre e FECHA automaticamente a conexão e o stmt
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Vincula os parâmetros usando os getters do objeto usuario
            stmt.setFloat(1, receita.getValor());
            stmt.setString(2, receita.getCategoria());
            stmt.setString(3, receita.getDescricao());
            stmt.setDate(4, new java.sql.Date(receita.getData().getTime()));
            stmt.setString(5, receita.getTipo());
            stmt.setInt(6, Sessao.getIdClubeAtual());

            // Executa a inserção no banco de dados
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Receita cadastrada!");

            
        } catch (Exception e) {
            // Exibe a mensagem de erro caso algo falhe (ex: driver faltando, banco offline)
            JOptionPane.showMessageDialog(null, "ERRO ao salvar no banco: " + e.getMessage());
        }
    }
    
    public static ArrayList<TransacaoFinanceira> listReceita() {
           
        String sql = "SELECT * from transacao where tipo = ? and idClube = ?";
        try (Connection conexao = JDBC.ConnectionFactory.conectar(); 
            PreparedStatement stmt = conexao.prepareStatement(sql)) {

            ArrayList<TransacaoFinanceira> receitas = new ArrayList<>();
            
            stmt.setString(1, "Receita");
            stmt.setInt(2, Sessao.getIdClubeAtual());
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) 
                /// enquanto conseguir ir para a proxima linha -> arquiva as infos
            {
                Receita obj = new Receita();

                obj.setIdTransacao(rs.getInt("id_transacao"));
                obj.setValor(rs.getFloat("valor"));
                obj.setCategoria(rs.getString("categoria"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setData(new java.util.Date(rs.getLong("data")));
                obj.setTipo(rs.getString("tipo"));


                receitas.add(obj);

            
            /// joga o conteudo na lista
            }
            return receitas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
        
    }
    
    public static void updateReceita(int id, Receita receita) {
        // String de conexão SQL
        String sql = "update transacao set valor = ?, categoria = ?, descricao = ?, data = ?, tipo = ? where id_transacao = ?";
        
        // O try-with-resources abre e FECHA automaticamente a conexão e o stmt
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Vincula os parâmetros usando os getters do objeto usuario
            stmt.setFloat(1, receita.getValor());
            stmt.setString(2, receita.getCategoria());
            stmt.setString(3, receita.getDescricao());
            stmt.setDate(4, new java.sql.Date(receita.getData().getTime()));
            stmt.setString(5, receita.getTipo());

            stmt.setInt(6, receita.getIdTransacao());
            
            // Executa a inserção no banco de dados
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Receita editada!");

            
        } catch (Exception e) {
            // Exibe a mensagem de erro caso algo falhe (ex: driver faltando, banco offline)
            JOptionPane.showMessageDialog(null, "ERRO ao salvar no banco: " + e.getMessage());
        }
    }
    
    public static void ExcluirReceita(int id) 
    {
        String sql = "delete from transacao where id_transacao = ?";
        
        try (Connection conexao = JDBC.ConnectionFactory.conectar();  
            PreparedStatement stmt = conexao.prepareStatement(sql))
        {
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Receita excluída com SUCESSO");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e);
        }
    }
    
    public static void createDespesa(Despesa despesa) {
        // String de conexão SQL
        String sql = "INSERT INTO transacao (valor, categoria, descricao, data, tipo, idClube) VALUES (?, ?, ?, ?, ?, ?)";

        // O try-with-resources abre e FECHA automaticamente a conexão e o stmt
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Vincula os parâmetros usando os getters do objeto usuario
            stmt.setFloat(1, despesa.getValor());
            stmt.setString(2, despesa.getCategoria());
            stmt.setString(3, despesa.getDescricao());
            stmt.setDate(4, new java.sql.Date(despesa.getData().getTime()));
            stmt.setString(5, despesa.getTipo());
            stmt.setInt(6, Sessao.getIdClubeAtual());

            // Executa a inserção no banco de dados
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Despesa cadastrada!");

            
        } catch (Exception e) {
            // Exibe a mensagem de erro caso algo falhe (ex: driver faltando, banco offline)
            JOptionPane.showMessageDialog(null, "ERRO ao salvar no banco: " + e.getMessage());
        }
    }
    
    public static ArrayList<TransacaoFinanceira> listDespesa() {
           
        String sql = "SELECT * FROM transacao WHERE tipo = ? and idClube = ?";
        try (Connection conexao = JDBC.ConnectionFactory.conectar(); 
            PreparedStatement stmt = conexao.prepareStatement(sql)) {

            ArrayList<TransacaoFinanceira> receitas = new ArrayList<>();
            
            stmt.setString(1, "Despesa");
            stmt.setInt(2, Sessao.getIdClubeAtual());
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) 
                /// enquanto conseguir ir para a proxima linha -> arquiva as infos
            {
                Despesa obj = new Despesa();

                obj.setIdTransacao(rs.getInt("id_transacao"));
                obj.setValor(rs.getFloat("valor"));
                obj.setCategoria(rs.getString("categoria"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setData(new java.util.Date(rs.getLong("data")));
                obj.setTipo(rs.getString("tipo"));


                receitas.add(obj);

            
            /// joga o conteudo na lista
            }
            return receitas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
        
    }
    
    public static void updateDespesa(int id, Despesa despesa) {
        // String de conexão SQL
        String sql = "update transacao set valor = ?, categoria = ?, descricao = ?, data = ?, tipo = ? where id_transacao = ?";
        
        // O try-with-resources abre e FECHA automaticamente a conexão e o stmt
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Vincula os parâmetros usando os getters do objeto usuario
            stmt.setFloat(1, despesa.getValor());
            stmt.setString(2, despesa.getCategoria());
            stmt.setString(3, despesa.getDescricao());
            stmt.setDate(4, new java.sql.Date(despesa.getData().getTime()));
            stmt.setString(5, despesa.getTipo());

            stmt.setInt(6, despesa.getIdTransacao());
            
            // Executa a inserção no banco de dados
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Despesa editada!");

            
        } catch (Exception e) {
            // Exibe a mensagem de erro caso algo falhe (ex: driver faltando, banco offline)
            JOptionPane.showMessageDialog(null, "ERRO ao salvar no banco: " + e.getMessage());
        }
    }
    
    public static void ExcluirDespesa(int id) 
    {
        String sql = "delete from transacao where id_transacao = ?";
        
        try (Connection conexao = JDBC.ConnectionFactory.conectar();   
            PreparedStatement stmt = conexao.prepareStatement(sql))
        {
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Despesa excluída com SUCESSO");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e);
        }
    }
    
}
