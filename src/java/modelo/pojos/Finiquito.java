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
public class Finiquito {
    private Integer idFiniquito;
    private Integer idEmpeño;
    private Integer idContrato;
    private Integer idUsuario;
    private Date fechaCreacion;
    private String capturador;
    private double importeInteres;
    private double importeAlmacenaje;
    private double ivaInteres;
    private double ivaAlmacenaje;
    private double subtotalFiniquito;
    private double ivaFiniquito;
    private double totalFiniquito;

    public Finiquito() {
    }

    public Finiquito(Integer idFiniquito, Integer idEmpeño, Integer idContrato, Integer idUsuario, Date fechaCreacion, String capturador, double importeInteres, double importeAlmacenaje, double ivaInteres, double ivaAlmacenaje, double subtotalFiniquito, double ivaFiniquito, double totalFiniquito) {
        this.idFiniquito = idFiniquito;
        this.idEmpeño = idEmpeño;
        this.idContrato = idContrato;
        this.idUsuario = idUsuario;
        this.fechaCreacion = fechaCreacion;
        this.capturador = capturador;
        this.importeInteres = importeInteres;
        this.importeAlmacenaje = importeAlmacenaje;
        this.ivaInteres = ivaInteres;
        this.ivaAlmacenaje = ivaAlmacenaje;
        this.subtotalFiniquito = subtotalFiniquito;
        this.ivaFiniquito = ivaFiniquito;
        this.totalFiniquito = totalFiniquito;
    }

    public Integer getIdFiniquito() {
        return idFiniquito;
    }

    public void setIdFiniquito(Integer idFiniquito) {
        this.idFiniquito = idFiniquito;
    }

    public Integer getIdEmpeño() {
        return idEmpeño;
    }

    public void setIdEmpeño(Integer idEmpeño) {
        this.idEmpeño = idEmpeño;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCapturador() {
        return capturador;
    }

    public void setCapturador(String capturador) {
        this.capturador = capturador;
    }

    public double getImporteInteres() {
        return importeInteres;
    }

    public void setImporteInteres(double importeInteres) {
        this.importeInteres = importeInteres;
    }

    public double getImporteAlmacenaje() {
        return importeAlmacenaje;
    }

    public void setImporteAlmacenaje(double importeAlmacenaje) {
        this.importeAlmacenaje = importeAlmacenaje;
    }

    public double getIvaInteres() {
        return ivaInteres;
    }

    public void setIvaInteres(double ivaInteres) {
        this.ivaInteres = ivaInteres;
    }

    public double getIvaAlmacenaje() {
        return ivaAlmacenaje;
    }

    public void setIvaAlmacenaje(double ivaAlmacenaje) {
        this.ivaAlmacenaje = ivaAlmacenaje;
    }

    public double getSubtotalFiniquito() {
        return subtotalFiniquito;
    }

    public void setSubtotalFiniquito(double subtotalFiniquito) {
        this.subtotalFiniquito = subtotalFiniquito;
    }

    public double getIvaFiniquito() {
        return ivaFiniquito;
    }

    public void setIvaFiniquito(double ivaFiniquito) {
        this.ivaFiniquito = ivaFiniquito;
    }

    public double getTotalFiniquito() {
        return totalFiniquito;
    }

    public void setTotalFiniquito(double totalFiniquito) {
        this.totalFiniquito = totalFiniquito;
    }
    
    
    
}
