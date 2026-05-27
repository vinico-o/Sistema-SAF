/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Sistema;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Cauan
 */
public class Elenco {
    
    private ArrayList<Jogador> jogadores;
    int contador = 0;
    
    public ArrayList<Jogador> listarJogadores(){
        return jogadores;
    }
    
    public void atualizarJogador(int idJogador, String nome, Date data_de_nascimento, String nacionalidade, String posicao, 
            int numero_da_camisa, float salario, int tempo_de_contrato){
        
        boolean ret = validarInformacoes(salario);
        
        if (ret == true){
            for (int i = 0; i < jogadores.size(); i++){
            
            if (jogadores.get(i).getIdJogador() == idJogador){
                
                jogadores.get(i).setNome(nome);
                jogadores.get(i).setData_de_nascimento(data_de_nascimento);
                jogadores.get(i).setNacionalidade(nacionalidade);
                jogadores.get(i).setPosicao(posicao);
                jogadores.get(i).setNumero_da_camisa(numero_da_camisa);
                jogadores.get(i).setSalario(salario);
                jogadores.get(i).setTempo_de_contrato(tempo_de_contrato);
                
                break;
            }
        }
        }else{
            exibirMensagemInvalido();
        }
    }
    
    public boolean validarInformacoes (float salario){
        if (salario >= 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void exibirMensagemInvalido(){
        JOptionPane.showMessageDialog(null, "Valor inválido");
    }
    
    
    public Jogador buscarJogador (String nome){
        
        for (int i = 0; i < jogadores.size(); i++){
            
            if (jogadores.get(i).getNome().equals(nome)){
                return jogadores.get(i);
            }
        }
        
        return null;
    }
    
    public void cadastrarJogador(String nome, Date data_de_nascimento, String nacionalidade, String posicao, int numero_da_camisa,
            float salario, int tempo_de_contrato){
        
        boolean ret = validarInformacoes(salario);

        if (ret == true){
            contador++;
            Jogador j = new Jogador(contador, nome, data_de_nascimento, nacionalidade, posicao, numero_da_camisa, salario, tempo_de_contrato, Sistema.idClube);
        
            jogadores.add(j);
        }else{
            exibirMensagemInvalido();
        }
        
        
    }
    
    public void apagarJogador (int idJogador){
        for (int i = 0; i < jogadores.size(); i++){
            if (jogadores.get(i).getIdJogador() == idJogador){
                jogadores.remove(i);
                break;
            }
        }
    }
    
    
    
    
}
