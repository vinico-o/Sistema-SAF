/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Partida;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Cauan
 */
public class HistoricoDePartidas {

    private ArrayList<Partida> partidas;

    public HistoricoDePartidas() {
    }

    public HistoricoDePartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public ArrayList<Partida> listarPartidas() {
        this.partidas = DataAcessObject.PartidaDAO.listarPartidas();
        return partidas;
    }

    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }

    public ArrayList<Partida> buscarPartidasRelatorio(String competicao, Date periodoInicial, Date periodoFinal,
            String local) {
        return DataAcessObject.PartidaDAO.buscarPartidasFiltro(competicao, periodoInicial, periodoFinal, local);















    }

    public void atualizarDados(int idPartida, Date data, String clubeAdversario, int golsMarcados, int golsSofridos,
            String competicao, float premiacao, int publico, float valorDoIngresso, String local) {

        boolean validacao = validarInformacoes(data, clubeAdversario, golsMarcados, golsSofridos, competicao, premiacao,
                publico, valorDoIngresso, local);

        if (validacao) {
            Partida partida = new Partida(data, clubeAdversario, golsMarcados, golsSofridos, competicao,
                    premiacao, publico, valorDoIngresso, local);
            partida.setIdPartida(idPartida);

            DataAcessObject.PartidaDAO.atualizarPartida(partida);
        }
    }

    public Partida buscarIDPartida(int idPartida) {

        return null;
    }

    public boolean validarInformacoes(Date data, String clubeAdversario, int golsMarcados, int golsSofridos,
            String competicao, float premiacao, int publico, float valorDoIngresso, String local) {

        if (data == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "A data é obrigatória ou inválida.");
            return false;
        }

        if (clubeAdversario == null || clubeAdversario.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "O clube adversário não pode estar vazio.");
            return false;
        }

        if (golsMarcados < 0 || golsSofridos < 0) {
            javax.swing.JOptionPane.showMessageDialog(null, "A quantidade de gols não pode ser negativa.");
            return false;
        }

        if (competicao == null || competicao.trim().isEmpty() || competicao.equals("Selecione")) {
            javax.swing.JOptionPane.showMessageDialog(null, "Selecione uma competição válida.");
            return false;
        }

        if (premiacao < 0) {
            javax.swing.JOptionPane.showMessageDialog(null, "A premiação não pode ser negativa.");
            return false;
        }

        if (publico < 0) {
            javax.swing.JOptionPane.showMessageDialog(null, "O público não pode ser negativo.");
            return false;
        }

        if (valorDoIngresso < 0) {
            javax.swing.JOptionPane.showMessageDialog(null, "O valor do ingresso não pode ser negativo.");
            return false;
        }

        if (local == null || local.trim().isEmpty() || local.equals("Selecione")) {
            javax.swing.JOptionPane.showMessageDialog(null, "Selecione um local válido (Em casa ou Fora de casa).");
            return false;
        }

        return true;
    }

    public void cadastrarPartida(Date data, String clubeAdversario, int golsMarcados,
            int golsSofridos, String competicao, float premiacao, int publico, float valorDoIngresso, String local) {

        boolean isValido = validarInformacoes(data, clubeAdversario, golsMarcados, golsSofridos, competicao, premiacao,
                publico, valorDoIngresso, local);

        if (isValido) {
            Partida partida = new Partida(data, clubeAdversario, golsMarcados, golsSofridos, competicao,
                    premiacao, publico, valorDoIngresso, local);
            if (partidas == null) {
                partidas = new ArrayList<>();
            }
            partidas.add(partida);

            DataAcessObject.PartidaDAO.createPartida(partida);
        }
    }

    public void excluirPartida(int idPartida) {
        DataAcessObject.PartidaDAO.apagarPartida(idPartida);
    }

}