/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Partida.HistoricoDePartidas;
import Model.Partida.Partida;
import java.util.ArrayList;
import java.util.Date;

import DataAcessObject.PartidaDAO;

/**
 *
 * @author Cauan
 */
public class ControladorPartida {

    HistoricoDePartidas historicoDePartidas = new HistoricoDePartidas();

    public ArrayList<Partida> buscarPartidasRelatorio(String competicao, Date periodoInicial, Date periodoFinal,
            String local) {

        ArrayList<Partida> p = historicoDePartidas.buscarPartidasRelatorio(competicao, periodoInicial, periodoFinal,
                local);

        return p;
    }

    public void exibirPartidas(ArrayList<Partida> partidas) {

    }

    public void iniciarAlteracaoDeInformacoesDeJogador() {

    }

    public void cadastrarPartida(Date data, String clubeAdversario, int golsMarcados, int golsSofridos,
            String competicao, float premiacao, int publico, float valorDoIngresso, String local) {

        historicoDePartidas.cadastrarPartida(data, clubeAdversario, golsMarcados,
                golsSofridos, competicao,
                premiacao, publico, valorDoIngresso, local);

    }

    public void editarInformacoes(int idPartida, Date data, String clubeAdversario, int golsMarcados, int golsSofridos,
            String competicao, float premiacao, int publico, float valorDoIngresso, String local) {

        historicoDePartidas.atualizarDados(idPartida, data, clubeAdversario, golsMarcados, golsSofridos,
                competicao, premiacao, publico, valorDoIngresso, local);

    }

    public void excluirPartida(int idPartida) {
        historicoDePartidas.excluirPartida(idPartida);
    }

    public void selecionarPartida(int idPartida) {

    }

    public ArrayList<Partida> iniciarListagemDePartidas() {
        return historicoDePartidas.listarPartidas();
    }
}