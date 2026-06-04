/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DataAcessObject.ClubeDAO;
import Model.Clube;
import Model.HistoricoDeAuditoria;
import Model.HistoricoDeClubes;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cauan
 */
public class ControladorClube {
    
    //HistoricoDeAuditoria historicoDeAuditoria = new HistoricoDeAuditoria();
    
    
    public boolean iniciarCadastroDeClube(String nomeClube, int anoDeFundacao, String pais){
        HistoricoDeClubes historicoDeClubes = new HistoricoDeClubes();
        
        boolean validacao = historicoDeClubes.validarUnicidadeDeClube(nomeClube, anoDeFundacao, pais);
        
        if (!(validacao == false)) {
            Clube clube = historicoDeClubes.cadastrarClube(nomeClube, anoDeFundacao, pais);
            ClubeDAO.createClube(clube);
            
            return true;
        } else {
            return false;
        }
    }
    
    public ArrayList<Clube> listarClubes(){
        HistoricoDeClubes historicoDeClubes = new HistoricoDeClubes();
        
        return historicoDeClubes.listarClubes();
    }
    
   
    public void iniciarEdicaoDeClube(int idClube, String nomeClube, int anoDeFundacao, String pais){
        HistoricoDeClubes historicoDeClubes = new HistoricoDeClubes();
        historicoDeClubes.editarClube(idClube, nomeClube, anoDeFundacao, pais);
        
        // implementar dps 
        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "clube", "EDIÇÃO", idClube);
    }
    
    public Clube buscarClube (int idClube){
        HistoricoDeClubes historicoDeClubes = new HistoricoDeClubes();
        return historicoDeClubes.buscarClube(idClube);
    }
    
    
    public void iniciarExclusaoDeClube(int idClube){
        HistoricoDeClubes historicoDeClubes = new HistoricoDeClubes();
        
        historicoDeClubes.apagarClube(idClube);
        
        // implementar dps 
        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "clube", "EXCLUSÃO", idClube);
    }
    
    public void AlterarSaldoPorAtualizacaoDeDespesa(int idClube, float valorAnterior, float valorNovo){
        HistoricoDeClubes historicoDeClubes = new HistoricoDeClubes();
        historicoDeClubes.BuscarEAlterarSaldoPorAtualizacaoDeDespesa(idClube, valorAnterior, valorNovo);
    }
    
    public void recalcularSaldoPorExclusaoDeDespesa(int idClube, float valorApagado){
        HistoricoDeClubes historicoDeClubes = new HistoricoDeClubes();
        historicoDeClubes.BuscarEAumentarSaldoPorExclusaoDeDespesa(idClube, valorApagado);
    }
    
    public void AumentarSaldoPorReceita(int idClube, float valor){
        HistoricoDeClubes historicoDeClubes = new HistoricoDeClubes();
        historicoDeClubes.BuscarEAumentarSaldoPorInsercaoDeReceita(idClube, valor);
    }
    

    
}
