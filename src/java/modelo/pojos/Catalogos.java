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
public class Catalogos {
    private Integer idCatalogo;
    private String tipocatalogo;
    private String concepto;
    private String estatus;

    public Catalogos() {
    }

    public Catalogos(Integer idCatalogo, String tipocatalogo, String concepto, String estatus) {
        this.idCatalogo = idCatalogo;
        this.tipocatalogo = tipocatalogo;
        this.concepto = concepto;
        this.estatus = estatus;
    }

    public Integer getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Integer idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public String getTipocatalogo() {
        return tipocatalogo;
    }

    public void setTipocatalogo(String tipocatalogo) {
        this.tipocatalogo = tipocatalogo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    
}
