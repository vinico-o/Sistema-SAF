/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Despesa;
import Model.HistoricoDeAuditoria;
import Model.HistoricoDeClubes;
import Model.HistoricoDeTransacoes;
import Model.Receita;
import Model.TransacaoFinanceira;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Cauan
 */
public class ControladorFinanceiro {
    
    HistoricoDeTransacoes historicoDeTransacoes = new HistoricoDeTransacoes();
    ControladorClube controladorClube = new ControladorClube();
    HistoricoDeAuditoria historicoDeAuditoria = new HistoricoDeAuditoria();
    HistoricoDeClubes historicoDeClubes = new HistoricoDeClubes();
    
    public ArrayList<Despesa> buscarDespesasRelatorio(Date periodoInicial, Date periodoFinal, ArrayList<String> categorias, String tipo)
    {
        
        ArrayList<Despesa> despesas = historicoDeTransacoes.buscarDespesasRelatorio(periodoInicial, periodoFinal, categorias, "Despesa");
        
        return despesas;
    }
    
    public ArrayList<Receita> buscarReceitasRelatorio(Date periodoInicial, Date periodoFinal, ArrayList<String> categorias, String tipo)
    {
        
        ArrayList<Receita> receitas = historicoDeTransacoes.buscarReceitasRelatorio(periodoInicial, periodoFinal, categorias, "Receita");
        
        return receitas;
    }
    
    public ArrayList<TransacaoFinanceira> buscarTransacoes(Date periodoInicial, Date periodoFinal, String tipo)
    {
        ArrayList<TransacaoFinanceira> transacoes = historicoDeTransacoes.buscarTransacaoRelatorio(periodoInicial, periodoFinal, "ambos");
    
        return transacoes;
    }
    
    
    public Despesa iniciarBuscaDeDespesas(int idTransacaoFinanceira){
                
        Despesa ret = historicoDeTransacoes.buscarDespesa(idTransacaoFinanceira);

        return ret;
    }
    
    public void iniciarCadastroDeDespesas(String categoria, float valor, String descricao, String tipo){
        
        historicoDeTransacoes.cadastrarDespesa(categoria, valor, descricao, "Despesa");
        
        // controladorClube.DiminuirSaldoPorDespesa(idClube, valor);
        
        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "despesa", "INSERÇÃO", idDespesa);
    }
    
    
    public void iniciarEdicaoDeDespesas(int idTransacaoFinanceira, int idClube, String categoria, float valor, String descricao, String tipo){
        
        float valorAnterior = historicoDeTransacoes.atualizarDespesa(idTransacaoFinanceira, categoria, valor, descricao, "Despesa");
        
        // controladorClube.AlterarSaldoPorAtualizacaoDeDespesa(idClube, valorAnterior, valor);
        
        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "despesa", "EDIÇÃO", idDespesa); -> acho q da para colocar um simplesmente pegar o valor na interface

    }
    
    
    public void iniciarExclusaoDeDespesa(int idTransacaoFinanceira, int idClube){
        
        float valorApagado = historicoDeTransacoes.excluirDespesa(idTransacaoFinanceira);
        
        // controladorClube.recalcularSaldoPorExclusaoDeDespesa(idClube, valorApagado);

        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "despesa", "EXCLUSÃO", idTransacaoFinanceira);

    }
    
    public ArrayList<Despesa> iniciarListagemDeDespesas(){
        return historicoDeTransacoes.listarDespesas();
    }
    
    public Receita iniciarBuscaDeReceitas(int idTransacaoFinanceira) {

        Receita ret = historicoDeTransacoes.buscarReceita(idTransacaoFinanceira);

        return ret;
    }
    
    public void iniciarCadastroDeReceitas(String categoria, float valor, String descricao, String tipo){
        
        historicoDeTransacoes.cadastrarReceita(categoria, valor, descricao, "Receita");
        
        // controladorClube.AumentarSaldoPorReceita(idClube, valor);
        
        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "receita", "INSERÇÃO", idReceita);
    }
    
    public void iniciarEdicaoDeReceitas(int idTransacaoFinanceira, int idClube, String categoria, float valor, String descricao, String tipo){
        
        float valorAnterior = historicoDeTransacoes.atualizarReceita(idTransacaoFinanceira, categoria, valor, descricao, "Receita");
        
        // controladorClube.AlterarSaldoPorAtualizacaoDeReceita(idClube, valorAnterior, valor);
        
        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "despesa", "EDIÇÃO", idDespesa); -> acho q da para colocar um simplesmente pegar o valor na interface

    }
    
    public void iniciarExclusaoDeReceita(int idTransacaoFinanceira, int idClube){
        
        float valorApagado = historicoDeTransacoes.excluirReceita(idTransacaoFinanceira);
        
        // controladorClube.recalcularSaldoPorExclusaoDeReceita(idClube, valorApagado);

        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "receita", "EXCLUSÃO", idTransacaoFinanceira);

    }
    
    public ArrayList<Receita> iniciarListagemDeReceitas(){
        return historicoDeTransacoes.listarReceitas();
    }
    
    public void iniciarAlteracaoDeInformacoesDeJogador()
    {
        
        
        
        
    }
    
    
    
    
}
