/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.TransacaoFinanceira.TransacaoFinanceira.*;
import Model.Partida.Partida;
import Model.TransacaoFinanceira.TransacaoFinanceira;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Cauan
 */
public class ControladorRelatorio {
    
    ControladorJogador controladorFutebolistico = new ControladorJogador();
    ControladorFinanceiro controladorFinanceiro = new ControladorFinanceiro();
    ControladorPartida controladorPartida = new ControladorPartida();
    
    public void exibirRelatorioDesempenho(String competicao, Date periodoInicial, Date periodoFinal, String local){
        ArrayList<Partida> partidas = controladorPartida.buscarPartidasRelatorio(competicao, periodoInicial, periodoFinal, local);
        //exibirRelatorioDePartidas(partidas)
    }
    
    public ArrayList<TransacaoFinanceira> exibirRelatorioDespesas(Date periodoInicial, Date periodoFinal, ArrayList<String> categorias, String tipo){
        ArrayList<TransacaoFinanceira> despesas = controladorFinanceiro.buscarDespesasRelatorio(periodoInicial, periodoFinal, categorias, "Despesa");
        
        return despesas;
    }
    
    public ArrayList<TransacaoFinanceira> exibirRelatorioReceitas(Date periodoInicial, Date periodoFinal, ArrayList<String> categorias, String tipo){
        ArrayList<TransacaoFinanceira> receitas = controladorFinanceiro.buscarReceitasRelatorio(periodoInicial, periodoFinal, categorias, "Receita");
        
        return receitas;
    }
    
    public ArrayList<TransacaoFinanceira> exibirRelatorioFinanceiroGeral(Date periodoInicial, Date periodoFinal, String tipo){
        ArrayList<TransacaoFinanceira> transacoes = controladorFinanceiro.buscarTransacoes(periodoInicial, periodoFinal, "ambos");
        
        return transacoes;
    }
}
