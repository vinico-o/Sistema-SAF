/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Cauan
 */
public class Elenco {
    
    private ArrayList<Jogador> jogadores = new ArrayList<>();
    int contador = 0;
    
    public ArrayList<Jogador> listarJogadores(){
        return jogadores;
    }
    
    public void atualizarJogador(int idJogador, String nome, Date data_de_nascimento, String nacionalidade, String posicao, 
            int numero_da_camisa, float salario, int tempo_de_contrato){
        
        boolean ret = validarInformacoes(nome, data_de_nascimento, nacionalidade, posicao, numero_da_camisa, salario, tempo_de_contrato);
        
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
    
    public boolean validarInformacoes(String nome, java.util.Date data_nascimento, String nacionalidade, String posicao, int numero_da_camisa, float salario, int tempo_de_contrato) {
        if (nome == null || nome.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "O nome do jogador não pode estar vazio.");
            return false;
        }

        if (data_nascimento == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "A data de nascimento é obrigatória ou inválida.");
            return false;
        }

        if (nacionalidade == null || nacionalidade.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "A nacionalidade do jogador não pode estar vazia.");
            return false;
        }

        if (posicao == null || posicao.trim().isEmpty() || posicao.equals("Selecione")) {
            javax.swing.JOptionPane.showMessageDialog(null, "Por favor, selecione uma posição válida para o jogador.");
            return false;
        }

        if (numero_da_camisa <= 0 || numero_da_camisa > 99) {
            javax.swing.JOptionPane.showMessageDialog(null, "O número da camisa deve estar entre 1 e 99.");
            return false;
        }

        if (salario < 0) {
            javax.swing.JOptionPane.showMessageDialog(null, "O salário do jogador não pode ser um valor negativo.");
            return false;
        }

        if (tempo_de_contrato <= 0) {
            javax.swing.JOptionPane.showMessageDialog(null, "O tempo de contrato deve ser de pelo menos 1 mês.");
            return false;
        }

        return true;
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
        
        boolean ret = validarInformacoes(nome, data_de_nascimento, nacionalidade, posicao, numero_da_camisa, salario, tempo_de_contrato);

        if (ret == true){
            contador++;
            Jogador j = new Jogador(contador, nome, data_de_nascimento, nacionalidade, posicao, numero_da_camisa, salario, tempo_de_contrato);
        
            jogadores.add(j);
            DataAcessObject.JogadorDAO.createJogador(j);
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
