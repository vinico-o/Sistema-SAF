/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DataAcessObject.AuditoriaDAO;
import Model.Auditoria.Auditoria;
import Model.Auditoria.HistoricoDeAuditoria;
import java.util.ArrayList;

/**
 *
 * @author Cauan
 */
public class ControladorAuditoria {

    public void registrarAuditoria(String nomeUsuario, String entidadeAfetada, String tipoDeLog,
            int idRegistroAfetado) {
        HistoricoDeAuditoria historicoDeAuditoria = new HistoricoDeAuditoria();

        historicoDeAuditoria.registrarAuditoria(nomeUsuario, entidadeAfetada, tipoDeLog, idRegistroAfetado);
    }

    public ArrayList<Auditoria> listarAuditorias() {
        HistoricoDeAuditoria historicoDeAuditoria = new HistoricoDeAuditoria();

        return historicoDeAuditoria.listarAuditorias();
    }

    public ArrayList<Auditoria> buscarRegistros(String operacao, String nomeResp, String tabelaAfet) {
        HistoricoDeAuditoria historicoDeAuditoria = new HistoricoDeAuditoria();

        return historicoDeAuditoria.buscarRegistros(operacao, nomeResp, tabelaAfet);
    }

}
