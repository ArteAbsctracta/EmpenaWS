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
public class Ingreso {
    private Integer idIngresos;
    private String fechaIngreso;
    private String concepto;
    private String montoIngreso;
    private String observaciones;

    public Ingreso() {
    }

    public Ingreso(Integer idIngresos, String fechaIngreso, String concepto, String montoIngreso, String observaciones) {
        this.idIngresos = idIngresos;
        this.fechaIngreso = fechaIngreso;
        this.concepto = concepto;
        this.montoIngreso = montoIngreso;
        this.observaciones = observaciones;
    }

    public Integer getIdIngresos() {
        return idIngresos;
    }

    public void setIdIngresos(Integer idIngresos) {
        this.idIngresos = idIngresos;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getMontoIngreso() {
        return montoIngreso;
    }

    public void setMontoIngreso(String montoIngreso) {
        this.montoIngreso = montoIngreso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    
    
    
}
