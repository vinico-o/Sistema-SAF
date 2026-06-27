/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAcessObject;

import Model.Sessao;
import Model.TransacaoFinanceira.Despesa;
import Model.TransacaoFinanceira.Receita;
import Model.TransacaoFinanceira.TransacaoFinanceira;
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
        createReceita(receita, true);
    }

    public static void createReceita(Receita receita, boolean showMessage) {
        // String de conexão SQL
        String sql = "INSERT INTO transacao (valor, categoria, descricao, data, tipo, idClube, idPartida, idJogador) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

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
            stmt.setObject(7, receita.getIdPartida());
            stmt.setObject(8, receita.getIdJogador());

            // Executa a inserção no banco de dados
            stmt.execute();
            stmt.close();

            if (showMessage) {
                JOptionPane.showMessageDialog(null, "Receita cadastrada!");
            }

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
                int pId = rs.getInt("idPartida");
                if (!rs.wasNull())
                    obj.setIdPartida(pId);
                int jId = rs.getInt("idJogador");
                if (!rs.wasNull())
                    obj.setIdJogador(jId);

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
        String sql = "update transacao set valor = ?, categoria = ?, descricao = ?, data = ?, tipo = ?, idPartida = ?, idJogador = ? where id_transacao = ?";

        // O try-with-resources abre e FECHA automaticamente a conexão e o stmt
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Vincula os parâmetros usando os getters do objeto usuario
            stmt.setFloat(1, receita.getValor());
            stmt.setString(2, receita.getCategoria());
            stmt.setString(3, receita.getDescricao());
            stmt.setDate(4, new java.sql.Date(receita.getData().getTime()));
            stmt.setString(5, receita.getTipo());
            stmt.setObject(6, receita.getIdPartida());
            stmt.setObject(7, receita.getIdJogador());

            stmt.setInt(8, receita.getIdTransacao());

            // Executa a inserção no banco de dados
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Receita editada!");

        } catch (Exception e) {
            // Exibe a mensagem de erro caso algo falhe (ex: driver faltando, banco offline)
            JOptionPane.showMessageDialog(null, "ERRO ao salvar no banco: " + e.getMessage());
        }
    }

    public static void ExcluirReceita(int id) {
        String sql = "delete from transacao where id_transacao = ?";

        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Receita excluída com SUCESSO");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e);
        }
    }

    public static void createDespesa(Despesa despesa) {
        createDespesa(despesa, true);
    }

    public static void createDespesa(Despesa despesa, boolean showMessage) {
        // String de conexão SQL
        String sql = "INSERT INTO transacao (valor, categoria, descricao, data, tipo, idClube, idPartida, idJogador) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

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
            stmt.setObject(7, despesa.getIdPartida());
            stmt.setObject(8, despesa.getIdJogador());

            // Executa a inserção no banco de dados
            stmt.execute();
            stmt.close();

            if (showMessage) {
                JOptionPane.showMessageDialog(null, "Despesa cadastrada!");
            }

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
                int pId = rs.getInt("idPartida");
                if (!rs.wasNull())
                    obj.setIdPartida(pId);
                int jId = rs.getInt("idJogador");
                if (!rs.wasNull())
                    obj.setIdJogador(jId);

                receitas.add(obj);

                /// joga o conteudo na lista
            }
            return receitas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public static ArrayList<TransacaoFinanceira> listTransacoes() {

        String sql = "SELECT * FROM transacao WHERE idClube = ?";
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            ArrayList<TransacaoFinanceira> receitas = new ArrayList<>();

            stmt.setInt(1, Sessao.getIdClubeAtual());

            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            /// enquanto conseguir ir para a proxima linha -> arquiva as infos
            {
                TransacaoFinanceira obj = new TransacaoFinanceira();

                obj.setIdTransacao(rs.getInt("id_transacao"));
                obj.setValor(rs.getFloat("valor"));
                obj.setCategoria(rs.getString("categoria"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setData(new java.util.Date(rs.getLong("data")));
                obj.setTipo(rs.getString("tipo"));
                int pId = rs.getInt("idPartida");
                if (!rs.wasNull())
                    obj.setIdPartida(pId);
                int jId = rs.getInt("idJogador");
                if (!rs.wasNull())
                    obj.setIdJogador(jId);

                receitas.add(obj);
            }
            return receitas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public static void updateDespesa(int id, Despesa despesa) {
        // String de conexão SQL
        String sql = "update transacao set valor = ?, categoria = ?, descricao = ?, data = ?, tipo = ?, idPartida = ?, idJogador = ? where id_transacao = ?";

        // O try-with-resources abre e FECHA automaticamente a conexão e o stmt
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Vincula os parâmetros usando os getters do objeto usuario
            stmt.setFloat(1, despesa.getValor());
            stmt.setString(2, despesa.getCategoria());
            stmt.setString(3, despesa.getDescricao());
            stmt.setDate(4, new java.sql.Date(despesa.getData().getTime()));
            stmt.setString(5, despesa.getTipo());
            stmt.setObject(6, despesa.getIdPartida());
            stmt.setObject(7, despesa.getIdJogador());

            stmt.setInt(8, despesa.getIdTransacao());

            // Executa a inserção no banco de dados
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Despesa editada!");

        } catch (Exception e) {
            // Exibe a mensagem de erro caso algo falhe (ex: driver faltando, banco offline)
            JOptionPane.showMessageDialog(null, "ERRO ao salvar no banco: " + e.getMessage());
        }
    }

    public static void ExcluirDespesa(int id) {
        String sql = "delete from transacao where id_transacao = ?";

        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Despesa excluída com SUCESSO");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e);
        }
    }

    public static void excluirTodasTransacoesDeClube(int idClube) {
        String sql = "delete from transacao where idClube = ?";

        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idClube);

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e);
        }
    }

    public static int obterUltimoIdTransacao() {
        String sql = "SELECT id_transacao FROM transacao ORDER BY id_transacao DESC LIMIT 1;";

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

    public static java.util.ArrayList<Model.TransacaoFinanceira.TransacaoFinanceira> buscarTransacoesPorPartida(
            int idPartida) {
        java.util.ArrayList<Model.TransacaoFinanceira.TransacaoFinanceira> transacoes = new java.util.ArrayList<>();
        String sql = "SELECT * FROM transacao WHERE idPartida = ?";
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idPartida);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if ("Receita".equals(rs.getString("tipo"))) {
                    Model.TransacaoFinanceira.Receita r = new Model.TransacaoFinanceira.Receita(
                            rs.getInt("id_transacao"),
                            rs.getFloat("valor"),
                            rs.getString("categoria"),
                            rs.getString("descricao"),
                            new java.util.Date(rs.getLong("data")),
                            rs.getString("tipo"));
                    r.setIdPartida(idPartida);
                    transacoes.add(r);
                } else {
                    Model.TransacaoFinanceira.Despesa d = new Model.TransacaoFinanceira.Despesa(
                            rs.getInt("id_transacao"),
                            rs.getFloat("valor"),
                            rs.getString("categoria"),
                            rs.getString("descricao"),
                            new java.util.Date(rs.getLong("data")),
                            rs.getString("tipo"));
                    d.setIdPartida(idPartida);
                    transacoes.add(d);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transacoes;
    }

    public static void excluirTransacoesPorPartida(int idPartida) {
        String sql = "delete from transacao where idPartida = ?";

        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idPartida);
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void desvincularTransacoesDeJogador(int idJogador) {
        String sql = "update transacao set idJogador = NULL where idJogador = ?";

        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idJogador);
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
