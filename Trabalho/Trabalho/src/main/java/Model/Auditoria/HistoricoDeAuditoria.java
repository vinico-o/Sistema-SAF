/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Auditoria;

import DataAcessObject.AuditoriaDAO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Cauan
 */
public class HistoricoDeAuditoria {

    ArrayList<Auditoria> auditorias = new ArrayList<>();

    public ArrayList<Auditoria> getAuditorias() {
        return auditorias;
    }

    public void setAuditorias(ArrayList<Auditoria> auditorias) {
        this.auditorias = auditorias;
    }

    public void registrarAuditoria(String nomeUsuario, String entidadeAfetada, String tipoDeLog, int idRegistro) {

        Auditoria a = new Auditoria(0, tipoDeLog, nomeUsuario, idRegistro, entidadeAfetada);

        AuditoriaDAO.createAuditoria(a);
    }

    public ArrayList<Auditoria> listarAuditorias() {
        auditorias = AuditoriaDAO.listAuditoria();

        return auditorias;
    }

    public ArrayList<Auditoria> buscarRegistros(String operacao, String nomeResp, String tabelaAfet) {
        ArrayList<Auditoria> regs = new ArrayList<>();

        auditorias = AuditoriaDAO.listAuditoria();

        for (Auditoria a : auditorias) {

            if (a.getTipoDeLog().equals(operacao) && a.getNomeUsuario().equals(nomeResp)
                    && a.getEntidadeAfetada().equals(tabelaAfet)) {
                regs.add(a);
            }
        }

        return regs;
    }

}
