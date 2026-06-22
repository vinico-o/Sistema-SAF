/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.TransacaoFinanceira;

import Model.Sessao;
import java.util.Date;

/**
 *
 * @author Cauan
 */
public class TransacaoFinanceira {
    private int idTransacao;
    private float valor;
    private String categoria;
    private String descricao;
    private Date data;
    private String tipo;
    private int idClube;
    private Integer idPartida; // Usando Integer para aceitar null
    private Integer idJogador; // Usando Integer para aceitar null

    public TransacaoFinanceira() {
    }

    public TransacaoFinanceira(int idTransacao, float valor, String categoria, String descricao, Date data,
            String tipo) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.categoria = categoria;
        this.descricao = descricao;
        this.data = data;
        this.tipo = tipo;
        this.idClube = Sessao.getUsuarioLogado().getIdClube();
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setIdClube(int idClube) {
        this.idClube = idClube;
    }

    public int getIdClube() {
        return idClube;
    }

    public Integer getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Integer idPartida) {
        this.idPartida = idPartida;
    }

    public Integer getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(Integer idJogador) {
        this.idJogador = idJogador;
    }

}
