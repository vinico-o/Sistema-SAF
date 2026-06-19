/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAcessObject.TransacaoDAO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Cauan
 */
public class HistoricoDeTransacoes {

    private ArrayList<TransacaoFinanceira> transacoes = new ArrayList<>();
    int contador = 0;

    public HistoricoDeTransacoes() {
    }

    public HistoricoDeTransacoes(ArrayList<TransacaoFinanceira> transacoes) {
        this.transacoes = transacoes;
    }

    public ArrayList<TransacaoFinanceira> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(ArrayList<TransacaoFinanceira> transacoes) {
        this.transacoes = transacoes;
    }

    public ArrayList<Despesa> buscarDespesasRelatorio(Date periodoInicial, Date periodoFinal, ArrayList<String> categorias, String tipo) {
        ArrayList<Despesa> d = new ArrayList<>();
        d = null;
        
        for (int i = 0; i < transacoes.size(); i++){
            if (transacoes.get(i).getTipo().equals("Despesa"))
            {
                if (transacoes.get(i).getData().before(periodoFinal) && transacoes.get(i).getData().after(periodoInicial))
                {
                    for (int j = 0; j < categorias.size(); j++)
                    {
                        if (transacoes.get(i).getCategoria().equals(categorias.get(j)))
                        {
                            d.add((Despesa) transacoes.get(i));
                        }
                    }
                    
                    
                }
            }
        }
        
        return d;
    }
    
    

    public ArrayList<Receita> buscarReceitasRelatorio(Date periodoInicial, Date periodoFinal, ArrayList categorias, String tipo) {
        ArrayList<Receita> r = new ArrayList<>();
        r = null;
        
        for (int i = 0; i < transacoes.size(); i++){
            if (transacoes.get(i).getTipo().equals("Receita"))
            {
                if (transacoes.get(i).getData().before(periodoFinal) && transacoes.get(i).getData().after(periodoInicial))
                {
                    for (int j = 0; j < categorias.size(); j++)
                    {
                        if (transacoes.get(i).getCategoria().equals(categorias.get(j)))
                        {
                            r.add((Receita) transacoes.get(i));
                        }
                    }
                    
                    
                }
            }
        }
        
        return r;
    }

    public ArrayList<TransacaoFinanceira> buscarTransacaoRelatorio(Date periodoInicial, Date periodoFinal, String tipo) {
        ArrayList<TransacaoFinanceira> t = new ArrayList<>();
        t = null;
        
        for (int i = 0; i < transacoes.size(); i++){
            if (transacoes.get(i).getTipo().equals(tipo))
            {
                if (transacoes.get(i).getData().before(periodoFinal) && transacoes.get(i).getData().after(periodoInicial))
                {    
                    t.add((Receita) transacoes.get(i));    
                }
            }
        }
        return t;
    }

    public TransacaoFinanceira buscarDespesa(int idTransacaoFinanceira) {
        this.transacoes = TransacaoDAO.listDespesa();
        
        for (TransacaoFinanceira d: transacoes){
            if (d.getIdTransacao() == idTransacaoFinanceira){
                return d;
            }
        }
        
        return null;
    }

    public ArrayList<TransacaoFinanceira> listarDespesas() {
        this.transacoes = TransacaoDAO.listDespesa();
        
        return transacoes;
    }

    public Despesa cadastrarDespesa(String categoria, float valor, String descricao, String tipo) {

        Despesa d = new Despesa(0, valor, categoria, descricao, new Date(), tipo);
        transacoes.add(d);

        return d;

    }
    
    public void exibirMensagemInvalido(){
        JOptionPane.showMessageDialog(null, "Valor inválido");
    }

    public boolean validarInformacoes(float valor) {
        
        if (valor >= 0){
            return true;
        }
        else {
            return false;
        }
        
    }

    public float atualizarDespesa(int idTransacaoFinanceira, String categoria, float valor, String descricao, String tipo) {

        ArrayList<TransacaoFinanceira> receitas = TransacaoDAO.listDespesa();
        
        float valorAnterior = 0;
        
        for (int i = 0; i < receitas.size(); i++)
        {
            if (receitas.get(i).getTipo().equals("Despesa") && receitas.get(i).getIdTransacao() == idTransacaoFinanceira)
            {
                valorAnterior = receitas.get(i).getValor();
                
                break;
            }
        }
        
        return valorAnterior;
    }

    public float excluirDespesa(int idTransacaoFinanceira) {
        ArrayList<TransacaoFinanceira> despesas = TransacaoDAO.listDespesa();
        
        float valorApagado = 0;
        
        for (int i = 0; i < despesas.size(); i++)
        {
            if (despesas.get(i).getIdTransacao() == idTransacaoFinanceira && despesas.get(i).getTipo().equals("Despesa"))
            {
                valorApagado = despesas.get(i).getValor();
                
                break;
            }
        }
        
        TransacaoDAO.ExcluirDespesa(idTransacaoFinanceira);
        
        return valorApagado;
    }

    public TransacaoFinanceira buscarReceita(int idTransacaoFinanceira) {
        this.transacoes = TransacaoDAO.listReceita();
        
        for (TransacaoFinanceira r: transacoes){
            if (r.getIdTransacao() == idTransacaoFinanceira){
                return r;
            }
        }
        
        return null;
    }

    public Receita cadastrarReceita(String categoria, float valor, String descricao, String tipo) {

        Receita r = new Receita(0, valor, categoria, descricao, new Date(), tipo);
        transacoes.add(r);

        return r;

    }

    public float atualizarReceita(int idTransacaoFinanceira, String categoria, float valor, String descricao, String tipo) {
        
        ArrayList<TransacaoFinanceira> receitas = TransacaoDAO.listReceita();
        
        float valorAnterior = 0;
        
        for (int i = 0; i < receitas.size(); i++)
        {
            if (receitas.get(i).getTipo().equals("Receita") && receitas.get(i).getIdTransacao() == idTransacaoFinanceira)
            {
            
                valorAnterior = receitas.get(i).getValor();
                
                break;
            }
        }
        
        return valorAnterior;
    }

    public float excluirReceita(int idTransacaoFinanceira) {
        ArrayList<TransacaoFinanceira> receitas = TransacaoDAO.listReceita();
        
        float valorApagado = 0;
        
        for (int i = 0; i < receitas.size(); i++)
        {
            if (receitas.get(i).getIdTransacao() == idTransacaoFinanceira && receitas.get(i).getTipo().equals("Receita"))
            {
                valorApagado = receitas.get(i).getValor();
                
                receitas.remove(i);
                
                break;
            }
        }
        
        TransacaoDAO.ExcluirReceita(idTransacaoFinanceira);
        
        return valorApagado;
    }
    
    public ArrayList<TransacaoFinanceira> listarReceitas() {
        this.transacoes = TransacaoDAO.listReceita();
        
        return transacoes;
    }

}
