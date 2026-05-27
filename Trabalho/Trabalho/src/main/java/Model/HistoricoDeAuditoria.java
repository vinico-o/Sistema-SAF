/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Cauan
 */
public class HistoricoDeAuditoria {
    
    ArrayList<Auditoria> auditorias = new ArrayList<>();
    private int contador = 0;
    
    
    public ArrayList<Auditoria> getAuditorias() {
        return auditorias;
    }

    public void setAuditorias(ArrayList<Auditoria> auditorias) {
        this.auditorias = auditorias;
    }
    
    public void registrarAuditoria(String nomeUsuario, String entidadeAfetada, String tipoDeLog, int idRegistro){
        
        contador++;
        
        Date d = new Date();
        
        Auditoria a = new Auditoria(contador, tipoDeLog, d, nomeUsuario, entidadeAfetada, idRegistro);
        
        
        auditorias.add(a);
    }
    
}
