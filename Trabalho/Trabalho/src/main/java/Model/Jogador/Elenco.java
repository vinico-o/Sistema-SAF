/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Jogador;

import Controller.ControladorAuditoria;
import DataAcessObject.JogadorDAO;
import Model.Sessao;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Cauan
 */
public class Elenco {

    private ArrayList<Jogador> jogadores = new ArrayList<>();
    int contador = 0;

    public ArrayList<Jogador> listarJogadores() {
        this.jogadores = DataAcessObject.JogadorDAO.listarJogadores();

        return jogadores;
    }

    public void atualizarJogador(int idJogador, String nome, Date data_de_nascimento, String nacionalidade,
            String posicao,
            int numero_da_camisa, float salario, int tempo_de_contrato, float valor) {

        boolean ret = validarInformacoes(idJogador, nome, data_de_nascimento, nacionalidade, posicao, numero_da_camisa,
                salario,
                tempo_de_contrato, valor);

        Jogador jogador = new Jogador(idJogador, nome, data_de_nascimento, nacionalidade, posicao, numero_da_camisa,
                salario,
                tempo_de_contrato, valor);

        DataAcessObject.JogadorDAO.atualizarJogador(jogador);
        ControladorAuditoria controladorAuditoria = new ControladorAuditoria();

        controladorAuditoria.registrarAuditoria(Sessao.getUsuarioLogado().getNome_usuario(), "Jogador", "EDIÇÃO",
                idJogador);

    }

    public boolean validarInformacoes(int idJogador, String nome, java.util.Date data_nascimento, String nacionalidade,
            String posicao,
            int numero_da_camisa, float salario, int tempo_de_contrato, float valor) {
        if (nome == null || nome.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "O nome do jogador não pode estar vazio.");
            return false;
        }

        if (data_nascimento == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "A data de nascimento é obrigatória ou inválida.");
            return false;
        }

        if (nacionalidade == null || nacionalidade.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "A nacionalidade do jogador não pode estar vazia.");
            return false;
        }

        if (posicao == null || posicao.trim().isEmpty() || posicao.equals("Selecione")) {
            javax.swing.JOptionPane.showMessageDialog(null, "Por favor, selecione uma posição válida para o jogador.");
            return false;
        }

        if ((numero_da_camisa <= 0 || numero_da_camisa > 99)) {
            javax.swing.JOptionPane.showMessageDialog(null, "O número da camisa deve estar entre 1 e 99.");
            return false;
        }

        if (DataAcessObject.JogadorDAO.verificarCamisaEmUso(numero_da_camisa, Sessao.getIdClubeAtual(), idJogador)) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "O número da camisa " + numero_da_camisa + " já está em uso por outro jogador neste clube.");
            return false;
        }

        if (salario < 0) {
            javax.swing.JOptionPane.showMessageDialog(null, "O salário do jogador não pode ser um valor negativo.");
            return false;
        }

        if (tempo_de_contrato <= 0) {
            javax.swing.JOptionPane.showMessageDialog(null, "O tempo de contrato deve ser de pelo menos 1 mês.");
            return false;
        }

        if (valor <= 0) {
            javax.swing.JOptionPane.showMessageDialog(null, "O valor do jogador deve ser maior que 0.");
            return false;
        }

        return true;
    }

    public void exibirMensagemInvalido() {
        JOptionPane.showMessageDialog(null, "Valor inválido");
    }

    public Jogador buscarJogador(String nome) {

        for (int i = 0; i < jogadores.size(); i++) {

            if (jogadores.get(i).getNome().equals(nome)) {
                return jogadores.get(i);
            }
        }

        return null;
    }

    public int cadastrarJogador(String nome, Date data_de_nascimento, String nacionalidade, String posicao,
            int numero_da_camisa,
            float salario, int tempo_de_contrato, float valor) {

        boolean ret = validarInformacoes(-1, nome, data_de_nascimento, nacionalidade, posicao, numero_da_camisa,
                salario,
                tempo_de_contrato, valor);

        if (ret == true) {
            contador++;
            Jogador j = new Jogador(contador, nome, data_de_nascimento, nacionalidade, posicao, numero_da_camisa,
                    salario, tempo_de_contrato, valor);

            jogadores.add(j);
            return DataAcessObject.JogadorDAO.createJogador(j);
        } else {
            exibirMensagemInvalido();
            return -1;
        }

    }

    public void apagarJogador(int idJogador) {
        DataAcessObject.JogadorDAO.apagarJogador(idJogador);
        ControladorAuditoria controladorAuditoria = new ControladorAuditoria();
        controladorAuditoria.registrarAuditoria(Sessao.getUsuarioLogado().getNome_usuario(), "Jogador", "EXCLUSÃO",
                idJogador);
    }

}
