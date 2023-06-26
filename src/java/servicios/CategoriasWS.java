/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

/**
 *
 * @author afs30
 */
public class CategoriasWS {
    
    private Integer idCategoria;
    private String tipocategoria;
    private String subcategoria;
    private String concepto;
    private String estatus;

    public CategoriasWS() {
    }

    public CategoriasWS(Integer idCategoria, String tipocategoria, String subcategoria, String concepto, String estatus) {
        this.idCategoria = idCategoria;
        this.tipocategoria = tipocategoria;
        this.subcategoria = subcategoria;
        this.concepto = concepto;
        this.estatus = estatus;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTipocategoria() {
        return tipocategoria;
    }

    public void setTipocategoria(String tipocategoria) {
        this.tipocategoria = tipocategoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
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
