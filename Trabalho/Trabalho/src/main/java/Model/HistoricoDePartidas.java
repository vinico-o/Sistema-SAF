/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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

    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }
    
    public ArrayList<Partida> buscarPartidasRelatorio(String competicao, Date periodoInicial, Date periodoFinal, String local) {

        ArrayList<Partida> p = new ArrayList<>();

        for (int i = 0; i < partidas.size(); i++) {
            if (partidas.get(i).getCompeticao().equals(competicao)) {
                if ((partidas.get(i).getData().equals(periodoInicial) || partidas.get(i).getData().after(periodoInicial))
                        && (partidas.get(i).getData().equals(periodoFinal) || partidas.get(i).getData().before(periodoFinal))) {
                    if (partidas.get(i).getLocal().equals(local)) {
                        p.add(partidas.get(i));
                    }
                }
            }
        }
        return p;
    }
    
    public void atualizarDados(int idPartida, Date data, String clubeAdversario, int golsMarcados, int golsSofridos, String competicao, float premiacao, int publico, float valorDoIngresso, String local) {

    }

    public Partida buscarIDPartida(int idPartida) {

        return null;
    }

    public Boolean validarInformacoes(Date data, int golsMarcados, int golsSofridos, float premiacao, int publico, float valorDoIngresso) {

        return null;
    }

    public void cadastrarPartida(Date data, String clubeAdversario, int golsMarcados, int golsSofridos, String competicao, float premiacao, int publico, float valorDoIngresso, String local) {

    }

    public void listarPartidas() {

    }

    public void excluirPartida(int idPartida) {

    }
    
}
