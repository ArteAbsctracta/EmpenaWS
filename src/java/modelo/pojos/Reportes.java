/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojos;
import java.util.Date;
/**
 *
 * @author afs30
 */
public class Reportes {
    private Integer idReportes;
    private String tipoReporte;
    private Date fechaGeneracion;
    private String contenido;

    public Reportes() {
    }

    public Reportes(Integer idReportes, String tipoReporte, Date fechaGeneracion, String contenido) {
        this.idReportes = idReportes;
        this.tipoReporte = tipoReporte;
        this.fechaGeneracion = fechaGeneracion;
        this.contenido = contenido;
    }

    public Integer getIdReportes() {
        return idReportes;
    }

    public void setIdReportes(Integer idReportes) {
        this.idReportes = idReportes;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
    
    
    
}
