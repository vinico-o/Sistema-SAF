/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cauan
 */
public class HistoricoDeClubes {
    int contador = 0;
    private ArrayList<Clube> clubes;

    public HistoricoDeClubes() {
    }

    public HistoricoDeClubes(ArrayList<Clube> clubes) {
        this.clubes = clubes;
    }

    public ArrayList<Clube> getClubes() {
        return clubes;
    }

    public void setClubes(ArrayList<Clube> clubes) {
        this.clubes = clubes;
    }
    
    public void cadastrarClube(String nomeClube, int anoFundacao, String pais){
        
        boolean retorno = validarUnicidadeDeClube(nomeClube, anoFundacao, pais);
        
        if (retorno == true){
            contador++; 
            
            Clube c = new Clube(contador, nomeClube, anoFundacao, pais, 0);
        
            clubes.add(c);
        }
        else {
            exibirMensagemInvalido();
        }
        
    }
    
    public void exibirMensagemInvalido(){
        JOptionPane.showMessageDialog(null, "Clube não é único -> cancelamento do cadastro de clube");
    }
    
    
    public boolean validarUnicidadeDeClube(String nomeClube, int anoFundacao, String pais){
        for (int i = 0; i < clubes.size(); i++){
            
            if (clubes.get(i).getNome().equals(nomeClube)){
                if (clubes.get(i).getAnoDeFundacao() == anoFundacao){
                    if (clubes.get(i).getPais().equals(pais)){
                        return false;
                    }
                }
            }
        }
    return true;
    }
    
    public void editarClube (int idClube, String nomeClube, int anoFundacao, String pais){
        
        boolean retorno = validarUnicidadeDeClube(nomeClube, anoFundacao, pais);
        
        if (retorno == true){
            for (int i = 0; i < clubes.size(); i++){
            
            if (clubes.get(i).getIdClube() == idClube){
             
                clubes.get(i).setNome(nomeClube);
                clubes.get(i).setAnoDeFundacao(anoFundacao);
                clubes.get(i).setPais(pais);
                
                break;
            }
        }
        }
        else{
            exibirMensagemInvalido();
        }
        
    }
    
    public void apagarClube(int idClube){
        for (int i = 0; i < clubes.size(); i++){
            
            if (clubes.get(i).getIdClube() == idClube){
             
                clubes.remove(i);
                
                break;
            }
        }
    }
    
    public ArrayList<Clube> listarClubes(){
        return clubes;
    }
    
    public void BuscarEDiminuirSaldoPorInsercaoDeDespesa(int idClube, float valor) {
        
        for (int i = 0; i < clubes.size(); i++){
            
            if (clubes.get(i).getIdClube() == idClube){
             
                clubes.get(i).setSaldoAtual(clubes.get(i).getSaldoAtual() - valor);
                break;
            }
        }
    }

    public void BuscarEAlterarSaldoPorAtualizacaoDeDespesa(int idClube, float valorAnterior, float valorNovo) {
        for (int i = 0; i < clubes.size(); i++){
            
            if (clubes.get(i).getIdClube() == idClube){
             
                clubes.get(i).setSaldoAtual(clubes.get(i).getSaldoAtual() + valorAnterior);
                clubes.get(i).setSaldoAtual(clubes.get(i).getSaldoAtual() - valorNovo);
                break;
            }
        }
    }

    public void BuscarEAumentarSaldoPorExclusaoDeDespesa(int idClube, float valorApagado) {
        for (int i = 0; i < clubes.size(); i++){
            
            if (clubes.get(i).getIdClube() == idClube){
             
                clubes.get(i).setSaldoAtual(clubes.get(i).getSaldoAtual() + valorApagado);
                break;
            }
        }
    }

    public void BuscarEAumentarSaldoPorInsercaoDeReceita(int idClube, float valor) {
        for (int i = 0; i < clubes.size(); i++){
            
            if (clubes.get(i).getIdClube() == idClube){
             
                clubes.get(i).setSaldoAtual(clubes.get(i).getSaldoAtual() + valor);
                break;
            }
        }
    }

    public void BuscarEAlterarSaldoPorAtualizacaoDeReceita(int idClube, float valorAnterior, float valorNovo) {
        for (int i = 0; i < clubes.size(); i++){
            
            if (clubes.get(i).getIdClube() == idClube){
             
                clubes.get(i).setSaldoAtual(clubes.get(i).getSaldoAtual() - valorAnterior);
                clubes.get(i).setSaldoAtual(clubes.get(i).getSaldoAtual() + valorNovo);
                break;
            }
        }
    }

    public void BuscarEDiminuirSaldoPorExclusaoDeReceita(int idClube, float valorApagado) {
        for (int i = 0; i < clubes.size(); i++){
            
            if (clubes.get(i).getIdClube() == idClube){
             
                clubes.get(i).setSaldoAtual(clubes.get(i).getSaldoAtual() - valorApagado);
                break;
            }
        }
    }
    
    
    
    
    
}
