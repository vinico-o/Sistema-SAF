/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Despesa;
import Model.Elenco;
import Model.Jogador;
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
    
    
    public void iniciarAlteracaoDeInformacoesDeJogador(int idJogador, String nome, Date data_de_nascimento, String nacionalidade, String posicao, 
            int numero_da_camisa, float salario, int tempo_de_contrato){
        
        elenco.atualizarJogador(idJogador, nome, data_de_nascimento, nacionalidade, posicao, numero_da_camisa, salario, tempo_de_contrato);
        
        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "jogador", "EDIÇÃO", idJogador);

    }
    
    public Jogador iniciarBuscaDeJogador(String nome){
        
        Jogador ret = elenco.buscarJogador(nome);

        return ret;
    }
    
    public void iniciarCompraDeJogador(String nome, Date data_de_nascimento, String nacionalidade, String posicao, int numero_da_camisa,
            float salario, int tempo_de_contrato){
        
        elenco.cadastrarJogador(nome, data_de_nascimento, nacionalidade, posicao, numero_da_camisa, salario, tempo_de_contrato);

        
        // controladorFinanceiro.iniciarCadastroDeDespesas();
        
        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "jogador", "INSERÇÃO", idJogador);


    }
    
    public void iniciarVendaDeJogador(int idJogador){
        
        elenco.apagarJogador(idJogador);
        
        // controladorFinanceiro.iniciarCadastroDeReceitas();
        
        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "jogador", "EXCLUSÃO", idJogador);


    }
    
    public ArrayList<Jogador> iniciarListagemDeJogador(int idJogador){
        
        ArrayList<Jogador> j = elenco.listarJogadores();
        
        return j;
    }
    
}
