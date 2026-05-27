/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Clube;
import Model.HistoricoDeAuditoria;
import Model.HistoricoDeClubes;
import java.util.ArrayList;

/**
 *
 * @author Cauan
 */
public class ControladorClube {
    
    HistoricoDeClubes historicoDeClubes = new HistoricoDeClubes();
    HistoricoDeAuditoria historicoDeAuditoria = new HistoricoDeAuditoria();
    
    
    public void iniciarCadastroDeClube(String nomeClube, int anoDeFundacao, String pais){
        historicoDeClubes.cadastrarClube(nomeClube, anoDeFundacao, pais);
       
        
        // implementar dps 
        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "clube", "INSERÇÃO", idClube);
    }
    
    public void iniciarEdicaoDeClube(int idClube, String nomeClube, int anoDeFundacao, String pais){
        historicoDeClubes.editarClube(idClube, nomeClube, anoDeFundacao, pais);
        
        // implementar dps 
        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "clube", "EDIÇÃO", idClube);
    }
    
    public void iniciarExclusaoDeClube(int idClube){
        
        historicoDeClubes.apagarClube(idClube);
        
        // implementar dps 
        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "clube", "EXCLUSÃO", idClube);
    }
    
    public void AlterarSaldoPorAtualizacaoDeDespesa(int idClube, float valorAnterior, float valorNovo){
        historicoDeClubes.BuscarEAlterarSaldoPorAtualizacaoDeDespesa(idClube, valorAnterior, valorNovo);
    }
    
    public void recalcularSaldoPorExclusaoDeDespesa(int idClube, float valorApagado){
        historicoDeClubes.BuscarEAumentarSaldoPorExclusaoDeDespesa(idClube, valorApagado);
    }
    
    public void AumentarSaldoPorReceita(int idClube, float valor){
        historicoDeClubes.BuscarEAumentarSaldoPorInsercaoDeReceita(idClube, valor);
    }
    
}
