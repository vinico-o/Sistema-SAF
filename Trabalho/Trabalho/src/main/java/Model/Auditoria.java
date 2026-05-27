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
public class Auditoria {
    private int idAuditoria;
    private String tipoDeLog;
    private Date data;
    private String usuario;
    private String entidadeAfetada;
    private int idDoRegistro;

    public Auditoria() {
    }

    public Auditoria(int idAuditoria, String tipoDeLog, Date data, String usuario, String entidadeAfetada, int idDoRegistro) {
        this.idAuditoria = idAuditoria;
        this.tipoDeLog = tipoDeLog;
        this.data = data;
        this.usuario = usuario;
        this.entidadeAfetada = entidadeAfetada;
        this.idDoRegistro = idDoRegistro;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEntidadeAfetada() {
        return entidadeAfetada;
    }

    public void setEntidadeAfetada(String entidadeAfetada) {
        this.entidadeAfetada = entidadeAfetada;
    }

    public int getIdDoRegistro() {
        return idDoRegistro;
    }

    public void setIdDoRegistro(int idDoRegistro) {
        this.idDoRegistro = idDoRegistro;
    }
    
    
}
