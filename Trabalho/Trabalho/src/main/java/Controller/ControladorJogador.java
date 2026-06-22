/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.TransacaoFinanceira.*;
import Model.Jogador.Elenco;
import Model.Jogador.Jogador;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Cauan
 */
public class ControladorJogador {

    Elenco elenco = new Elenco();
    ControladorFinanceiro controladorFinanceiro = new ControladorFinanceiro();

    public void iniciarAlteracaoDeInformacoesDeJogador(int idJogador, String nome, Date data_de_nascimento,
            String nacionalidade, String posicao,
            int numero_da_camisa, float salario, int tempo_de_contrato, float valor) {

        elenco.atualizarJogador(idJogador, nome, data_de_nascimento, nacionalidade, posicao, numero_da_camisa, salario,
                tempo_de_contrato, valor);

        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "jogador", "EDIÇÃO",
        // idJogador);

    }

    public Jogador iniciarBuscaDeJogador(String nome) {

        Jogador ret = elenco.buscarJogador(nome);

        return ret;
    }

    public int iniciarCompraDeJogador(String nome, Date data_de_nascimento, String nacionalidade, String posicao,
            int numero_da_camisa, float salario, int tempo_de_contrato, float valor) {

        return elenco.cadastrarJogador(nome, data_de_nascimento, nacionalidade, posicao, numero_da_camisa, salario,
                tempo_de_contrato, valor);

    }

    public void iniciarVendaDeJogador(int idJogador) {

        Elenco elenco = new Elenco();

        elenco.apagarJogador(idJogador);

    }

    public ArrayList<Jogador> iniciarListagemDeJogador() {
        Elenco hsitoricoJogador = new Elenco();

        return hsitoricoJogador.listarJogadores();
    }

}
