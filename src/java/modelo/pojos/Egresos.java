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
public class Egresos {
    private Integer idEgresos;
    private String fechaEgreso;
    private String concepto;
    private String montoEgreso;
    private String observaciones;

    public Egresos() {
    }

    public Egresos(Integer idEgresos, String fechaEgreso, String concepto, String montoEgreso, String observaciones) {
        this.idEgresos = idEgresos;
        this.fechaEgreso = fechaEgreso;
        this.concepto = concepto;
        this.montoEgreso = montoEgreso;
        this.observaciones = observaciones;
    }

    public Integer getIdEgresos() {
        return idEgresos;
    }

    public void setIdEgresos(Integer idEgresos) {
        this.idEgresos = idEgresos;
    }

    public String getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(String fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getMontoEgreso() {
        return montoEgreso;
    }

    public void setMontoEgreso(String montoEgreso) {
        this.montoEgreso = montoEgreso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
