/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Auditoria;

import java.util.Date;

/**
 *
 * @author Cauan
 */
public class Auditoria {
    private int idAuditoria;
    private String tipoDeLog;
    private String nomeUsuario;
    private int idDoRegistroAfetado;
    private String entidadeAfetada;
    private Date data;



    public Auditoria() {
    }

    public Auditoria(int idAuditoria, String tipoDeLog, String nomeUsuario, int idDoRegistroAfetado, String entidadeAfetada) {
        this.idAuditoria = idAuditoria;
        this.tipoDeLog = tipoDeLog;
        this.nomeUsuario = nomeUsuario;
        this.idDoRegistroAfetado = idDoRegistroAfetado;
        this.entidadeAfetada = entidadeAfetada;
    }
    

    public int getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(int idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public String getTipoDeLog() {
        return tipoDeLog;
    }

    public void setTipoDeLog(String tipoDeLog) {
        this.tipoDeLog = tipoDeLog;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getIdDoRegistroAfetado() {
        return idDoRegistroAfetado;
    }

    public void setIdDoRegistroAfetado(int idDoRegistroAfetado) {
        this.idDoRegistroAfetado = idDoRegistroAfetado;
    }

    public String getEntidadeAfetada() {
        return entidadeAfetada;
    }

    public void setEntidadeAfetada(String entidadeAfetada) {
        this.entidadeAfetada = entidadeAfetada;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
}
