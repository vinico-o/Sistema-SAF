/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Cauan
 */
public class Partida {
    private int idPartida;
    private Date data;
    private String clubeAdversario;
    private int golsMarcados;
    private int golsSofridos;
    private String competicao;
    private float premiacao;
    private int publico;
    private float valorDoIngresso;
    private String local;

    public Partida() {
    }

    public Partida(int idPartida, Date data, String clubeAdversario, int golsMarcados, int golsSofridos, String competicao, float premiacao, int publico, float valorDoIngresso, String local) {
        this.idPartida = idPartida;
        this.data = data;
        this.clubeAdversario = clubeAdversario;
        this.golsMarcados = golsMarcados;
        this.golsSofridos = golsSofridos;
        this.competicao = competicao;
        this.premiacao = premiacao;
        this.publico = publico;
        this.valorDoIngresso = valorDoIngresso;
        this.local = local;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getClubeAdversario() {
        return clubeAdversario;
    }

    public void setClubeAdversario(String clubeAdversario) {
        this.clubeAdversario = clubeAdversario;
    }

    public int getGolsMarcados() {
        return golsMarcados;
    }

    public void setGolsMarcados(int golsMarcados) {
        this.golsMarcados = golsMarcados;
    }

    public int getGolsSofridos() {
        return golsSofridos;
    }

    public void setGolsSofridos(int golsSofridos) {
        this.golsSofridos = golsSofridos;
    }

    public String getCompeticao() {
        return competicao;
    }

    public void setCompeticao(String competicao) {
        this.competicao = competicao;
    }

    public float getPremiacao() {
        return premiacao;
    }

    public void setPremiacao(float premiacao) {
        this.premiacao = premiacao;
    }

    public int getPublico() {
        return publico;
    }

    public void setPublico(int publico) {
        this.publico = publico;
    }

    public float getValorDoIngresso() {
        return valorDoIngresso;
    }

    public void setValorDoIngresso(float valorDoIngresso) {
        this.valorDoIngresso = valorDoIngresso;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    
}
