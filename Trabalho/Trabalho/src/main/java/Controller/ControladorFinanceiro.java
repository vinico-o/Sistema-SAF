/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DataAcessObject.TransacaoDAO;
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
    
    
    public TransacaoFinanceira iniciarBuscaDeDespesas(int idTransacaoFinanceira){
                
        TransacaoFinanceira ret = historicoDeTransacoes.buscarDespesa(idTransacaoFinanceira);

        return ret;
    }
    
    public boolean iniciarCadastroDeDespesas(String categoria, float valor, String descricao, String tipo){
        
        HistoricoDeTransacoes historicoDeTransacoes = new HistoricoDeTransacoes();
        
        boolean validacao = historicoDeTransacoes.validarInformacoes(valor);
        
        if (!(validacao == false)) {
            Despesa despesa = historicoDeTransacoes.cadastrarDespesa(categoria, valor, descricao, tipo);
            TransacaoDAO.createDespesa(despesa);
            
            return true;
        } else {
            return false;
        }
        
        // controladorClube.AumentarSaldoPorReceita(idClube, valor);
        
        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "receita", "INSERÇÃO", idReceita);
    }
    
    
    public boolean iniciarEdicaoDeDespesa(int idTransacaoFinanceira, int idClube, String categoria, float valor, String descricao, String tipo){
        
        HistoricoDeTransacoes historicoDeTransacoes = new HistoricoDeTransacoes();
        
        boolean validacao = historicoDeTransacoes.validarInformacoes(valor);
        
        
        float valorAnterior = historicoDeTransacoes.atualizarDespesa(idTransacaoFinanceira, categoria, valor, descricao, "Despesa");
            
        
        if (!(validacao == false)) {
            Despesa d = new Despesa (idTransacaoFinanceira, valor, categoria, descricao, new Date(), tipo);
            TransacaoDAO.updateDespesa(idTransacaoFinanceira, d);
            
            return true;
        } else {
            return false;
        }
        
        // controladorClube.AlterarSaldoPorAtualizacaoDeReceita(idClube, valorAnterior, valor);
        
        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "despesa", "EDIÇÃO", idDespesa); -> acho q da para colocar um simplesmente pegar o valor na interface

    }
    
    
    public void iniciarExclusaoDeDespesa(int idTransacaoFinanceira, int idClube){
        
        float valorApagado = historicoDeTransacoes.excluirDespesa(idTransacaoFinanceira);
        
        // controladorClube.recalcularSaldoPorExclusaoDeReceita(idClube, valorApagado);

        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "receita", "EXCLUSÃO", idTransacaoFinanceira);

    }
    
    public ArrayList<TransacaoFinanceira> iniciarListagemDeDespesas(){
        return historicoDeTransacoes.listarDespesas();
    }
    
    public TransacaoFinanceira iniciarBuscaDeReceitas(int idTransacaoFinanceira) {

        TransacaoFinanceira ret = historicoDeTransacoes.buscarReceita(idTransacaoFinanceira);

        return ret;
    }
    
    public boolean iniciarCadastroDeReceitas(String categoria, float valor, String descricao, String tipo){
        
        HistoricoDeTransacoes historicoDeTransacoes = new HistoricoDeTransacoes();
        
        boolean validacao = historicoDeTransacoes.validarInformacoes(valor);
        
        if (!(validacao == false)) {
            Receita receita = historicoDeTransacoes.cadastrarReceita(categoria, valor, descricao, tipo);
            TransacaoDAO.createReceita(receita);
            
            return true;
        } else {
            return false;
        }
        
        // controladorClube.AumentarSaldoPorReceita(idClube, valor);
        
        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "receita", "INSERÇÃO", idReceita);
    }
    
    public boolean iniciarEdicaoDeReceitas(int idTransacaoFinanceira, int idClube, String categoria, float valor, String descricao, String tipo){
        
        HistoricoDeTransacoes historicoDeTransacoes = new HistoricoDeTransacoes();
        
        boolean validacao = historicoDeTransacoes.validarInformacoes(valor);
        
        
        float valorAnterior = historicoDeTransacoes.atualizarReceita(idTransacaoFinanceira, categoria, valor, descricao, "Receita");
            
        
        if (!(validacao == false)) {
            Receita r = new Receita (idTransacaoFinanceira, valor, categoria, descricao, new Date(), tipo);
            TransacaoDAO.updateReceita(idTransacaoFinanceira, r);
            
            return true;
        } else {
            return false;
        }
        
        
        
        
        
        // controladorClube.AlterarSaldoPorAtualizacaoDeReceita(idClube, valorAnterior, valor);
        
        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "despesa", "EDIÇÃO", idDespesa); -> acho q da para colocar um simplesmente pegar o valor na interface

    }
    
    public void iniciarExclusaoDeReceita(int idTransacaoFinanceira, int idClube){
        
        float valorApagado = historicoDeTransacoes.excluirReceita(idTransacaoFinanceira);
        
        // controladorClube.recalcularSaldoPorExclusaoDeReceita(idClube, valorApagado);

        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "receita", "EXCLUSÃO", idTransacaoFinanceira);

    }
    
    public ArrayList<TransacaoFinanceira> iniciarListagemDeReceitas(){
        return historicoDeTransacoes.listarReceitas();
    }
    
    public void iniciarAlteracaoDeInformacoesDeJogador()
    {
        
        
        
        
    }
    
    
    
    
}
