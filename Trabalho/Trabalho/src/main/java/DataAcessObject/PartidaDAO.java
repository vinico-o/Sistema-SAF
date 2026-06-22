/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAcessObject;

import Model.Partida.Partida;
import Model.Sessao;
import JDBC.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author mardegan
 */
public class PartidaDAO {

    public static int createPartida(Partida partida) {
        String sql = "INSERT INTO partida (data, clube_adversario, gols_marcados, gols_sofridos, competicao, premiacao, publico, valor_do_ingresso, local, idClube) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        int idPartida = -1;
        try (Connection conn = ConnectionFactory.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            stmt.setDate(1, new java.sql.Date(partida.getData().getTime()));
            stmt.setString(2, partida.getClubeAdversario());
            stmt.setInt(3, partida.getGolsMarcados());
            stmt.setInt(4, partida.getGolsSofridos());
            stmt.setString(5, partida.getCompeticao());
            stmt.setFloat(6, partida.getPremiacao());
            stmt.setInt(7, partida.getPublico());
            stmt.setFloat(8, partida.getValorDoIngresso());
            stmt.setString(9, partida.getLocal());
            stmt.setInt(10, Sessao.getIdClubeAtual());

            stmt.executeUpdate();

            java.sql.ResultSet rsKeys = stmt.getGeneratedKeys();
            if (rsKeys.next()) {
                idPartida = rsKeys.getInt(1);
            }

            System.out.println("Partida cadastrada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar partida!");
            e.printStackTrace();
        }

        return idPartida;
    }

    public static java.util.ArrayList<Partida> listarPartidas() {
        String sql = "SELECT * FROM partida WHERE idClube = ?";
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, Sessao.getIdClubeAtual());

            java.util.ArrayList<Partida> partidas = new java.util.ArrayList<>();

            java.sql.ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Partida obj = new Partida();

                obj.setIdPartida(rs.getInt("id_partida"));

                try {
                    String dataStr = rs.getString("data");
                    if (dataStr != null) {
                        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                        obj.setData(sdf.parse(dataStr));
                    }
                } catch (Exception e) {
                    // Try parsing as timestamp if it's saved as long/timestamp (like in Jogador)
                    try {
                        long timestamp = rs.getLong("data");
                        if (timestamp > 0) {
                            obj.setData(new java.util.Date(timestamp));
                        }
                    } catch (Exception e2) {
                    }
                }

                obj.setClubeAdversario(rs.getString("clube_adversario"));
                obj.setGolsMarcados(rs.getInt("gols_marcados"));
                obj.setGolsSofridos(rs.getInt("gols_sofridos"));
                obj.setCompeticao(rs.getString("competicao"));
                obj.setPremiacao(rs.getFloat("premiacao"));
                obj.setPublico(rs.getInt("publico"));
                obj.setValorDoIngresso(rs.getFloat("valor_do_ingresso"));
                obj.setLocal(rs.getString("local"));
                obj.setIdClube(rs.getInt("idClube"));

                partidas.add(obj);
            }
            return partidas;

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao listar partidas: " + e.getMessage());
            return new java.util.ArrayList<>();
        }
    }

    public static void apagarPartida(int idPartida) {
        DataAcessObject.TransacaoDAO.excluirTransacoesPorPartida(idPartida);
        String sql = "DELETE FROM partida WHERE id_partida = ?";
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idPartida);
            stmt.executeUpdate();
            System.out.println("Partida excluída com sucesso!");

        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao excluir partida: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Partida buscarPartidaPorId(int id_partida) {
        String sql = "SELECT * FROM partida WHERE id_partida = ?";
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id_partida);

            java.sql.ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Partida obj = new Partida();

                obj.setIdPartida(rs.getInt("id_partida"));

                try {
                    String dataStr = rs.getString("data");
                    if (dataStr != null) {
                        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                        obj.setData(sdf.parse(dataStr));
                    }
                } catch (Exception e) {
                    try {
                        long timestamp = rs.getLong("data");
                        if (timestamp > 0) {
                            obj.setData(new java.util.Date(timestamp));
                        }
                    } catch (Exception e2) {
                    }
                }

                obj.setClubeAdversario(rs.getString("clube_adversario"));
                obj.setGolsMarcados(rs.getInt("gols_marcados"));
                obj.setGolsSofridos(rs.getInt("gols_sofridos"));
                obj.setCompeticao(rs.getString("competicao"));
                obj.setPremiacao(rs.getFloat("premiacao"));
                obj.setPublico(rs.getInt("publico"));
                obj.setValorDoIngresso(rs.getFloat("valor_do_ingresso"));
                obj.setLocal(rs.getString("local"));
                obj.setIdClube(rs.getInt("idClube"));

                return obj;
            } else {
                return null;
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao buscar partida: " + e.getMessage());
            return null;
        }
    }

    public static void atualizarPartida(Partida partida) {
        String sql = "UPDATE partida SET data = ?, clube_adversario = ?, gols_marcados = ?, gols_sofridos = ?, competicao = ?, premiacao = ?, publico = ?, valor_do_ingresso = ?, local = ? WHERE id_partida = ?";
        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setDate(1, new java.sql.Date(partida.getData().getTime()));
            stmt.setString(2, partida.getClubeAdversario());
            stmt.setInt(3, partida.getGolsMarcados());
            stmt.setInt(4, partida.getGolsSofridos());
            stmt.setString(5, partida.getCompeticao());
            stmt.setFloat(6, partida.getPremiacao());
            stmt.setInt(7, partida.getPublico());
            stmt.setFloat(8, partida.getValorDoIngresso());
            stmt.setString(9, partida.getLocal());
            stmt.setInt(10, partida.getIdPartida());

            stmt.executeUpdate();
            System.out.println("Partida atualizada com sucesso!");

        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao atualizar partida: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static java.util.ArrayList<Partida> buscarPartidasFiltro(String competicao, java.util.Date dataInicial,
            java.util.Date dataFinal, String local) {
        StringBuilder sql = new StringBuilder("SELECT * FROM partida WHERE idClube = ?");
        java.util.ArrayList<Object> parametros = new java.util.ArrayList<>();
        parametros.add(Sessao.getIdClubeAtual());

        if (competicao != null && !competicao.trim().isEmpty() && !competicao.equals("Selecione")) {
            sql.append(" AND competicao = ?");
            parametros.add(competicao);
        }
        if (dataInicial != null) {
            sql.append(" AND data >= ?");
            parametros.add(new java.sql.Date(dataInicial.getTime()));
        }
        if (dataFinal != null) {
            sql.append(" AND data <= ?");
            parametros.add(new java.sql.Date(dataFinal.getTime()));
        }
        if (local != null && !local.trim().isEmpty() && !local.equals("Selecione")) {
            sql.append(" AND local = ?");
            parametros.add(local);
        }

        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql.toString())) {

            for (int i = 0; i < parametros.size(); i++) {
                stmt.setObject(i + 1, parametros.get(i));
            }

            java.util.ArrayList<Partida> partidas = new java.util.ArrayList<>();
            java.sql.ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Partida obj = new Partida();
                obj.setIdPartida(rs.getInt("id_partida"));

                try {
                    String dataStr = rs.getString("data");
                    if (dataStr != null) {
                        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                        obj.setData(sdf.parse(dataStr));
                    }
                } catch (Exception e) {
                    try {
                        long timestamp = rs.getLong("data");
                        if (timestamp > 0) {
                            obj.setData(new java.util.Date(timestamp));
                        }
                    } catch (Exception e2) {
                    }
                }

                obj.setClubeAdversario(rs.getString("clube_adversario"));
                obj.setGolsMarcados(rs.getInt("gols_marcados"));
                obj.setGolsSofridos(rs.getInt("gols_sofridos"));
                obj.setCompeticao(rs.getString("competicao"));
                obj.setPremiacao(rs.getFloat("premiacao"));
                obj.setPublico(rs.getInt("publico"));
                obj.setValorDoIngresso(rs.getFloat("valor_do_ingresso"));
                obj.setLocal(rs.getString("local"));
                obj.setIdClube(rs.getInt("idClube"));

                partidas.add(obj);
            }
            return partidas;

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao buscar partidas por filtro: " + e.getMessage());
            return new java.util.ArrayList<>();
        }
    }

    public static void excluirTodasPartidasDeClube(int idClube) {
        String sql = "delete from partida where idClube = ?";

        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idClube);

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e);
        }
    }

    public static int obterUltimoIdPartida() {
        String sql = "SELECT id_partida FROM partida ORDER BY id_partida DESC LIMIT 1;";

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

    public static Partida buscarPartidaMaisRecente() {
        String sql = "SELECT * FROM partida ORDER BY id_partida DESC LIMIT 1;";

        try (Connection conexao = JDBC.ConnectionFactory.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            java.sql.ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Partida obj = new Partida();
                obj.setIdPartida(rs.getInt("id_partida"));

                try {
                    String dataStr = rs.getString("data");
                    if (dataStr != null) {
                        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                        obj.setData(sdf.parse(dataStr));
                    }
                } catch (Exception e) {
                    try {
                        long timestamp = rs.getLong("data");
                        if (timestamp > 0) {
                            obj.setData(new java.util.Date(timestamp));
                        }
                    } catch (Exception e2) {
                    }
                }

                obj.setClubeAdversario(rs.getString("clube_adversario"));
                obj.setGolsMarcados(rs.getInt("gols_marcados"));
                obj.setGolsSofridos(rs.getInt("gols_sofridos"));
                obj.setCompeticao(rs.getString("competicao"));
                obj.setPremiacao(rs.getFloat("premiacao"));
                obj.setPublico(rs.getInt("publico"));
                obj.setValorDoIngresso(rs.getFloat("valor_do_ingresso"));
                obj.setLocal(rs.getString("local"));
                obj.setIdClube(rs.getInt("idClube"));

                return obj;
            } else {
                return null;
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Erro ao buscar partida mais recente: " + e.getMessage());
            return null;
        }
    }
}
