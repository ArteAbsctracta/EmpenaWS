/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojos;

/**
 *
 * @author afs30
 */
public class Permisos {
    
    private Integer idPermiso;
    private String numPermiso;
    private String tipoPermiso;
    private String concepto;

    public Permisos() {
    }

    public Permisos(Integer idPermiso, String numPermiso, String tipoPermiso, String concepto) {
        this.idPermiso = idPermiso;
        this.numPermiso = numPermiso;
        this.tipoPermiso = tipoPermiso;
        this.concepto = concepto;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getNumPermiso() {
        return numPermiso;
    }

    public void setNumPermiso(String numPermiso) {
        this.numPermiso = numPermiso;
    }

    public String getTipoPermiso() {
        return tipoPermiso;
    }

    public void setTipoPermiso(String tipoPermiso) {
        this.tipoPermiso = tipoPermiso;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    
    
    
}
