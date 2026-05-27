/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Cauan
 */
public class Clube {
    private int idClube;
    private String nome;
    private int anoDeFundacao;
    private String pais;
    private float saldoAtual;

    public Clube() {
    }

    public Clube(int idClube, String nome, int anoDeFundacao, String pais, float saldoAtual) {
        this.idClube = idClube;
        this.nome = nome;
        this.anoDeFundacao = anoDeFundacao;
        this.pais = pais;
        this.saldoAtual = saldoAtual;
    }

    public int getIdClube() {
        return idClube;
    }

    public void setIdClube(int idClube) {
        this.idClube = idClube;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeFundacao() {
        return anoDeFundacao;
    }

    public void setAnoDeFundacao(int anoDeFundacao) {
        this.anoDeFundacao = anoDeFundacao;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public float getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(float saldoAtual) {
        this.saldoAtual = saldoAtual;
    }
    
    
}
