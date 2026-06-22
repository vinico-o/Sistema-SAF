/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAcessObject;

import Model.Partida;
import Model.Sessao;
import JDBC.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author mardegan
 */
public class PartidaDAO {

    public static void createPartida(Partida partida) {

        String sql = "INSERT INTO partida (data, clube_adversario, gols_marcados, gols_sofridos, competicao, premiacao, publico, valor_do_ingresso, local, idClube) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

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

            stmt.execute();
            System.out.println("Partida cadastrada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar partida!");
            e.printStackTrace();
        }

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
}
