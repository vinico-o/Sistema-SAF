/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;

import DataAcessObject.ClubeDAO;
import Model.Auditoria.HistoricoDeAuditoria;
import Model.Clube.Clube;
import Model.Clube.HistoricoDeClubes;
import Model.Sessao;

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
            
            
            if(Sessao.getUsuarioLogado() != null) {
                ControladorAuditoria controladorAuditoria = new ControladorAuditoria();
                controladorAuditoria.registrarAuditoria(Sessao.getUsuarioLogado().getNome_usuario(), "Clube", "INSERÇÃO", ClubeDAO.obterUltimoIdClube());
            }
            
            
            return true;
        } else {
            historicoDeClubes.exibirMensagemInvalido();
            return false;
        }
    }
    
    public ArrayList<Clube> listarClubes(){
        HistoricoDeClubes historicoDeClubes = new HistoricoDeClubes();
        
        return historicoDeClubes.listarClubes();
    }
    
   
    public void iniciarEdicaoDeClube(int idClube, String nomeClube, int anoDeFundacao, String pais){
        HistoricoDeClubes historicoDeClubes = new HistoricoDeClubes();
        boolean ret = historicoDeClubes.editarClube(idClube, nomeClube, anoDeFundacao, pais);
        
        if (ret == true){
            HistoricoDeAuditoria historicoDeAuditoria = new HistoricoDeAuditoria();
            
            historicoDeAuditoria.registrarAuditoria(Sessao.getUsuarioLogado().getNome_usuario(), "Clube", "EDIÇÃO", idClube);
        }
        
    }
    
    public Clube buscarClube (int idClube){
        HistoricoDeClubes historicoDeClubes = new HistoricoDeClubes();
        return historicoDeClubes.buscarClube(idClube);
    }
    
    
    public void iniciarExclusaoDeClube(int idClube){
        HistoricoDeClubes historicoDeClubes = new HistoricoDeClubes();
        
        boolean operacao = historicoDeClubes.apagarClube(idClube);
        
        if (operacao == true){
            HistoricoDeAuditoria historicoDeAuditoria = new HistoricoDeAuditoria();
            
            historicoDeAuditoria.registrarAuditoria(Sessao.getUsuarioLogado().getNome_usuario(), "Clube", "EXCLUSÃO", idClube);
        }
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

    public void DiminuirSaldoPorDespesa(int idClubeAtual, float valor) {
        HistoricoDeClubes historicoDeClubes = new HistoricoDeClubes();
        historicoDeClubes.BuscarEDiminuirSaldoPorInsercaoDeDespesa(idClubeAtual, valor);
    }

    void recalcularSaldoPorExclusaoDeReceita(int idClubeAtual, float valorApagado) {
       HistoricoDeClubes historicoDeClubes = new HistoricoDeClubes();
       historicoDeClubes.BuscarEDiminuirSaldoPorExclusaoDeReceita(idClubeAtual, valorApagado);
    }

    void AlterarSaldoPorAtualizacaoDeReceita(int idClube, float valorAnterior, float valor) {
        HistoricoDeClubes historicoDeClubes = new HistoricoDeClubes();
        historicoDeClubes.BuscarEAlterarSaldoPorAtualizacaoDeReceita(idClube, valorAnterior, valor);
    }
    

    
}
