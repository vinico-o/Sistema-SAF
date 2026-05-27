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
public class Jogador {
    private int idJogador;
    private String nome;
    private Date data_de_nascimento;
    private String nacionalidade;
    private String posicao;
    private int numero_da_camisa;
    private float salario;
    private int tempo_de_contrato;
    private int idClube;

    public Jogador() {
    }

    public Jogador(int idJogador, String nome, Date data_de_nascimento, String nacionalidade, String posicao, int numero_da_camisa, float salario, int tempo_de_contrato, int idClube) {
        this.idJogador = idJogador;
        this.nome = nome;
        this.data_de_nascimento = data_de_nascimento;
        this.nacionalidade = nacionalidade;
        this.posicao = posicao;
        this.numero_da_camisa = numero_da_camisa;
        this.salario = salario;
        this.tempo_de_contrato = tempo_de_contrato;
        this.idClube = idClube;
    }

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(Date data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getNumero_da_camisa() {
        return numero_da_camisa;
    }

    public void setNumero_da_camisa(int numero_da_camisa) {
        this.numero_da_camisa = numero_da_camisa;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getTempo_de_contrato() {
        return tempo_de_contrato;
    }

    public void setTempo_de_contrato(int tempo_de_contrato) {
        this.tempo_de_contrato = tempo_de_contrato;
    }

    public int getIdClube() {
        return idClube;
    }

    public void setIdClube(int idClube) {
        this.idClube = idClube;
    }

        
    
}
