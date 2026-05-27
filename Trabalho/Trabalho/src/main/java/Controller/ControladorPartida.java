/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.HistoricoDePartidas;
import Model.Partida;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Cauan
 */
public class ControladorPartida {
    
    HistoricoDePartidas historicoDePartidas = new HistoricoDePartidas();
    
    public ArrayList<Partida> buscarPartidasRelatorio(String competicao, Date periodoInicial, Date periodoFinal, String local){
        
        ArrayList<Partida> p = historicoDePartidas.buscarPartidasRelatorio(competicao, periodoInicial, periodoFinal, local);
        
        return p;
    }
    
    public void exibirPartidas(ArrayList<Partida> partidas) {

    }

    public void iniciarAlteracaoDeInformacoesDeJogador() {

    }

    public void editarInformacoes(int idPartida, Date data, String clubeAdversario, int golsMarcados, int golsSofridos, String competicao, float premiacao, int publico, float valorDoIngresso, String local) {

    }

    public void selecionarPartida(int idPartida) {

    }
}
