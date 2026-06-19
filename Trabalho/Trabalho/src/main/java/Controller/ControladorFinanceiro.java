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
import Controller.ControladorClube;
import Model.Receita;
import Model.Sessao;
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
            
            ControladorClube controladorClube = new ControladorClube();
            controladorClube.DiminuirSaldoPorDespesa(Sessao.getIdClubeAtual(), valor);
            
            return true;
        } else {
            return false;
        }
        
        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "receita", "INSERÇÃO", idReceita);
    }
    
    
    public boolean iniciarEdicaoDeDespesa(int idTransacaoFinanceira, int idClube, String categoria, float valor, String descricao, String tipo){
        
        HistoricoDeTransacoes historicoDeTransacoes = new HistoricoDeTransacoes();
        
        boolean validacao = historicoDeTransacoes.validarInformacoes(valor);
        
        
        float valorAnterior = historicoDeTransacoes.atualizarDespesa(idTransacaoFinanceira, categoria, valor, descricao, "Despesa");
            
        
        if (!(validacao == false)) {
            Despesa d = new Despesa (idTransacaoFinanceira, valor, categoria, descricao, new Date(), tipo);
            TransacaoDAO.updateDespesa(idTransacaoFinanceira, d);
            
            ControladorClube controladorClube = new ControladorClube();
            controladorClube.AlterarSaldoPorAtualizacaoDeDespesa(idClube, valorAnterior, valor);
            
            // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "despesa", "EDIÇÃO", idDespesa); -> acho q da para colocar um simplesmente pegar o valor na interface

            return true;
        } else {
            return false;
        }
        

    }
    
    
    public void iniciarExclusaoDeDespesa(int idTransacaoFinanceira, int idClube){
        
        float valorApagado = historicoDeTransacoes.excluirDespesa(idTransacaoFinanceira);
        
        ControladorClube controladorClube = new ControladorClube();
        
        controladorClube.recalcularSaldoPorExclusaoDeDespesa(idClube, valorApagado);

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
            
            ControladorClube controladorClube = new ControladorClube();
            controladorClube.AumentarSaldoPorReceita(Sessao.getIdClubeAtual(), valor);
        
            // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "receita", "INSERÇÃO", idReceita);
            
            return true;
        } else {
            return false;
        }
        
        
    }
    
    public boolean iniciarEdicaoDeReceitas(int idTransacaoFinanceira, int idClube, String categoria, float valor, String descricao, String tipo){
        
        HistoricoDeTransacoes historicoDeTransacoes = new HistoricoDeTransacoes();
        
        boolean validacao = historicoDeTransacoes.validarInformacoes(valor);
        
        float valorAnterior = historicoDeTransacoes.atualizarReceita(idTransacaoFinanceira, categoria, valor, descricao, "Receita");
            
        
        if (!(validacao == false)) {
            Receita r = new Receita (idTransacaoFinanceira, valor, categoria, descricao, new Date(), tipo);
            TransacaoDAO.updateReceita(idTransacaoFinanceira, r);
            
            ControladorClube controladorClube = new ControladorClube();
            controladorClube.AlterarSaldoPorAtualizacaoDeReceita(idClube, valorAnterior, valor);
        
            // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "despesa", "EDIÇÃO", idDespesa); -> acho q da para colocar um simplesmente pegar o valor na interface

            
            return true;
        } else {
            return false;
        }
        
        
    }
    
    public void iniciarExclusaoDeReceita(int idTransacaoFinanceira, int idClube){
        
        float valorApagado = historicoDeTransacoes.excluirReceita(idTransacaoFinanceira);
        
        controladorClube.recalcularSaldoPorExclusaoDeReceita(idClube, valorApagado);

        // historicoDeAuditoria.registrarAuditoria(nomeUsuario, "receita", "EXCLUSÃO", idTransacaoFinanceira);

    }
    
    public ArrayList<TransacaoFinanceira> iniciarListagemDeReceitas(){
        return historicoDeTransacoes.listarReceitas();
    }
    
    public void iniciarAlteracaoDeInformacoesDeJogador()
    {
        
        
        
        
    }
    
    
    
    
}
