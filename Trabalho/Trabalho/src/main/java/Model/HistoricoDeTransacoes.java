/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Cauan
 */
public class HistoricoDeTransacoes {

    private ArrayList<TransacaoFinanceira> transacoes;
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

    public Despesa buscarDespesa(int idTransacaoFinanceira) {
        for (int i = 0; i < transacoes.size(); i++){
            if (transacoes.get(i).getTipo().equals("Despesa") && transacoes.get(i).getIdTransacao() == idTransacaoFinanceira)
            {
                return (Despesa) transacoes.get(i);
            }
        }
        
        return null;
    }

    public ArrayList<Despesa> listarDespesas() {
        ArrayList<Despesa> d = new ArrayList<>();
        d = null;
        for (int i = 0; i < transacoes.size(); i++){
            if (transacoes.get(i).getTipo().equals("Despesa"))
            {
                d.add((Despesa) transacoes.get(i));
            }
        }
        
        return d;
    }

    public void cadastrarDespesa(String categoria, float valor, String descricao, String tipo) {

        boolean ret = validarInformacoes(valor);

        if (ret == true) {
            contador++;

            Date data = new Date();

            Boolean resposta = validarInformacoes(valor);

            if (resposta == true) {
                Despesa d = new Despesa(contador, valor, categoria, descricao, data, "Despesa");
                transacoes.add(d);
            }
        }
        else{
            exibirMensagemInvalido();
        }

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

        float valorAnterior = 0;

        boolean ret = validarInformacoes(valor);

        if (ret == true) {
            for (int i = 0; i < transacoes.size(); i++) {
                if (transacoes.get(i).getTipo().equals("Despesa") && transacoes.get(i).getIdTransacao() == idTransacaoFinanceira) {
                    transacoes.get(i).setCategoria(categoria);
                    transacoes.get(i).setDescricao(descricao);
                    transacoes.get(i).setValor(valor);
                    transacoes.get(i).setDescricao(descricao);

                    valorAnterior = transacoes.get(i).getValor();

                    break;
                }
            }

            return valorAnterior;
        } else {
            exibirMensagemInvalido();
            
            return 0;
        }
    }

    public float excluirDespesa(int idTransacaoFinanceira) {
        float valorApagado = 0;
        
        for (int i = 0; i < transacoes.size(); i++)
        {
            if (transacoes.get(i).getIdTransacao() == idTransacaoFinanceira && transacoes.get(i).getTipo().equals("Despesa"))
            {
                valorApagado = transacoes.get(i).getValor();
                
                transacoes.remove(i);
                
                break;
            }
        }
        
        return valorApagado;
    }

    public Receita buscarReceita(int idTransacaoFinanceira) {
        for (int i = 0; i < transacoes.size(); i++){
            if (transacoes.get(i).getTipo().equals("Receita") && transacoes.get(i).getIdTransacao() == idTransacaoFinanceira)
            {
                return (Receita) transacoes.get(i);
            }
        }
        
        return null;
    }

    public void cadastrarReceita(String categoria, float valor, String descricao, String tipo) {

        boolean ret = validarInformacoes(valor);

        if (ret == true) {
            contador++;

            Date data = new Date();

            Boolean resposta = validarInformacoes(valor);

            if (resposta == true) {
                Receita r = new Receita(contador, valor, categoria, descricao, data, "Receita");
                transacoes.add(r);
            }
        }
        else{
            exibirMensagemInvalido();
        }

    }

    public float atualizarReceita(int idTransacaoFinanceira, String categoria, float valor, String descricao, String tipo) {
        float valorAnterior = 0;
        
        for (int i = 0; i < transacoes.size(); i++)
        {
            if (transacoes.get(i).getTipo().equals("Receita") && transacoes.get(i).getIdTransacao() == idTransacaoFinanceira)
            {
                transacoes.get(i).setCategoria(categoria);
                transacoes.get(i).setDescricao(descricao);
                transacoes.get(i).setValor(valor);
                transacoes.get(i).setDescricao(descricao);
            
                valorAnterior = transacoes.get(i).getValor();
                
                break;
            }
        }
        
        return valorAnterior;
    }

    public float excluirReceita(int idTransacaoFinanceira) {
        float valorApagado = 0;
        
        for (int i = 0; i < transacoes.size(); i++)
        {
            if (transacoes.get(i).getIdTransacao() == idTransacaoFinanceira && transacoes.get(i).getTipo().equals("Receita"))
            {
                valorApagado = transacoes.get(i).getValor();
                
                transacoes.remove(i);
                
                break;
            }
        }
        
        return valorApagado;
    }
    
    public ArrayList<Receita> listarReceitas() {
        ArrayList<Receita> r = new ArrayList<>();
        r = null;
        for (int i = 0; i < transacoes.size(); i++){
            if (transacoes.get(i).getTipo().equals("Receita"))
            {
                r.add((Receita) transacoes.get(i));
            }
        }
        
        return r;
    }

}
