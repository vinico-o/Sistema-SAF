/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Despesa;
import Model.Partida;
import Model.Receita;
import Model.TransacaoFinanceira;
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
    
    public void exibirRelatorioDespesas(Date periodoInicial, Date periodoFinal, ArrayList<String> categorias, String tipo){
        ArrayList<Despesa> despesas = controladorFinanceiro.buscarDespesasRelatorio(periodoInicial, periodoFinal, categorias, "Despesa");
        //exibirRelatorioDeDespesa(despesas)
    }
    
    public void exibirRelatorioReceitas(Date periodoInicial, Date periodoFinal, ArrayList<String> categorias, String tipo){
        ArrayList<Receita> receitas = controladorFinanceiro.buscarReceitasRelatorio(periodoInicial, periodoFinal, categorias, "Receita");
        // exibirRelatorioDeReceita(receitas)
    }
    
    public void exibirRelatorioFinanceiroGeral(Date periodoInicial, Date periodoFinal, String tipo){
        ArrayList<TransacaoFinanceira> transacoes = controladorFinanceiro.buscarTransacoes(periodoInicial, periodoFinal, "ambos");
        // exibirRelatorioDeReceita(transacoes)
    }
}
