/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.TransacaoFinanceira;

import java.util.Date;

/**
 *
 * @author Cauan
 */
public class Despesa extends TransacaoFinanceira {

    public Despesa(int idTransacao, float valor, String categoria, String descricao, Date data, String tipo) {
        super(idTransacao, valor, categoria, descricao, data, tipo);
    }

    public Despesa() {

    }
}
