/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Clube;

import DataAcessObject.ClubeDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cauan
 */
public class HistoricoDeClubes {
    int contador = 0;
    private ArrayList<Clube> clubes = null;

    public HistoricoDeClubes() {
        clubes = new ArrayList<>();
    }


    public ArrayList<Clube> getClubes() {
        return clubes;
    }

    public void setClubes(ArrayList<Clube> clubes) {
        this.clubes = clubes;
    }
    
    public Clube cadastrarClube(String nomeClube, int anoFundacao, String pais) {

        Clube c = new Clube(0, nomeClube, anoFundacao, pais, 0f);

        clubes.add(c);

        return c;

    }
    
    public void exibirMensagemInvalido(){
        JOptionPane.showMessageDialog(null, "Clube já cadastrado!");
    }
    
    
    public boolean validarUnicidadeDeClube(String nomeClube, int anoFundacao, String pais){
        this.clubes = ClubeDAO.listClube();
        
        for (int i = 0; i < clubes.size(); i++){
            
            if (clubes.get(i).getNome().equals(nomeClube)){
                return false;
            }
        }
    return true;
    }
    
    public void editarClube (int idClube, String nomeClube, int anoFundacao, String pais){
        boolean retorno = validarUnicidadeDeClube(nomeClube, anoFundacao, pais);
        
        Clube c = new Clube(idClube, nomeClube, anoFundacao, pais, 0f);
        
        if (retorno == true){
            ClubeDAO.atualizarClube(idClube, c);
        }
        else{
            exibirMensagemInvalido();
        }
        
    }
    
    public Clube buscarClube (int idClube){
        this.clubes = ClubeDAO.listClube();
        
        for (int i = 0; i < clubes.size(); i++){
            if (clubes.get(i).getIdClube() == idClube){
                return clubes.get(i);
            }
        }
        
        return null;
    }
    
    public void apagarClube(int idClube){
        ClubeDAO.ExcluirClube(idClube);
    }
    
    public ArrayList<Clube> listarClubes(){
        this.clubes = ClubeDAO.listClube();
        
        return clubes;
    }
    
    public void BuscarEDiminuirSaldoPorInsercaoDeDespesa(int idClube, float valor) {
        this.clubes = ClubeDAO.listClube();
        
        for (int i = 0; i < clubes.size(); i++){
            
            if (clubes.get(i).getIdClube() == idClube){
             
                clubes.get(i).setSaldoAtual(clubes.get(i).getSaldoAtual() - valor);
                
                ClubeDAO.atualizarSaldo(idClube, clubes.get(i).getSaldoAtual());
                
                break;
            }
        }
    }

    public void BuscarEAlterarSaldoPorAtualizacaoDeDespesa(int idClube, float valorAnterior, float valorNovo) {
        this.clubes = ClubeDAO.listClube();
        
        for (int i = 0; i < clubes.size(); i++){
            
            if (clubes.get(i).getIdClube() == idClube){
             
                clubes.get(i).setSaldoAtual(clubes.get(i).getSaldoAtual() + valorAnterior);
                clubes.get(i).setSaldoAtual(clubes.get(i).getSaldoAtual() - valorNovo);
                
                ClubeDAO.atualizarSaldo(idClube, clubes.get(i).getSaldoAtual());
                break;
            }
        }
    }

    public void BuscarEAumentarSaldoPorExclusaoDeDespesa(int idClube, float valorApagado) {
        this.clubes = ClubeDAO.listClube();
        
        for (int i = 0; i < clubes.size(); i++){
            
            if (clubes.get(i).getIdClube() == idClube){
             
                clubes.get(i).setSaldoAtual(clubes.get(i).getSaldoAtual() + valorApagado);
                
                ClubeDAO.atualizarSaldo(idClube, clubes.get(i).getSaldoAtual());
                break;
            }
        }
    }

    public void BuscarEAumentarSaldoPorInsercaoDeReceita(int idClube, float valor) {
        this.clubes = ClubeDAO.listClube();
        
        for (int i = 0; i < clubes.size(); i++){
            
            if (clubes.get(i).getIdClube() == idClube){
             
                clubes.get(i).setSaldoAtual(clubes.get(i).getSaldoAtual() + valor);
                
                ClubeDAO.atualizarSaldo(idClube, clubes.get(i).getSaldoAtual());
                break;
            }
        }
    }

    public void BuscarEAlterarSaldoPorAtualizacaoDeReceita(int idClube, float valorAnterior, float valorNovo) {
        this.clubes = ClubeDAO.listClube();
        
        for (int i = 0; i < clubes.size(); i++){
            
            if (clubes.get(i).getIdClube() == idClube){
             
                clubes.get(i).setSaldoAtual(clubes.get(i).getSaldoAtual() - valorAnterior);
                clubes.get(i).setSaldoAtual(clubes.get(i).getSaldoAtual() + valorNovo);
                
                ClubeDAO.atualizarSaldo(idClube, clubes.get(i).getSaldoAtual());
                break;
            }
        }
    }

    public void BuscarEDiminuirSaldoPorExclusaoDeReceita(int idClube, float valorApagado) {
        this.clubes = ClubeDAO.listClube();
        
        for (int i = 0; i < clubes.size(); i++){
            
            if (clubes.get(i).getIdClube() == idClube){
             
                clubes.get(i).setSaldoAtual(clubes.get(i).getSaldoAtual() - valorApagado);
                
                ClubeDAO.atualizarSaldo(idClube, clubes.get(i).getSaldoAtual());
                break;
            }
        }
    }
    
    
    
    
    
}
