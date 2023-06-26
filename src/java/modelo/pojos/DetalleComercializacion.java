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
public class DetalleComercializacion {
        private Integer idDetalle;
        private Integer idComercializacion;
        private Integer idContrato;
        private Integer idEmpeño;
        private Integer idPrenda;
        private double precioComercializacion;

    public DetalleComercializacion() {
    }

    public DetalleComercializacion(Integer idDetalle, Integer idComercializacion, Integer idContrato, Integer idEmpeño, Integer idPrenda, double precioComercializacion) {
        this.idDetalle = idDetalle;
        this.idComercializacion = idComercializacion;
        this.idContrato = idContrato;
        this.idEmpeño = idEmpeño;
        this.idPrenda = idPrenda;
        this.precioComercializacion = precioComercializacion;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdComercializacion() {
        return idComercializacion;
    }

    public void setIdComercializacion(Integer idComercializacion) {
        this.idComercializacion = idComercializacion;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public Integer getIdEmpeño() {
        return idEmpeño;
    }

    public void setIdEmpeño(Integer idEmpeño) {
        this.idEmpeño = idEmpeño;
    }

    public Integer getIdPrenda() {
        return idPrenda;
    }

    public void setIdPrenda(Integer idPrenda) {
        this.idPrenda = idPrenda;
    }

    public double getPrecioComercializacion() {
        return precioComercializacion;
    }

    public void setPrecioComercializacion(double precioComercializacion) {
        this.precioComercializacion = precioComercializacion;
    }
        
        
}
