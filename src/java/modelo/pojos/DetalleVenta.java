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
public class DetalleVenta {
        private Integer idDetalle;
        private Integer idPrenda;
        private Integer idEmpeño;
        private String precioVenta ;
        private String  prestamo;
        private String DescripcionPrenda;
        private String folioVenta;

    public DetalleVenta() {
    }

    public DetalleVenta(Integer idDetalle, Integer idPrenda, Integer idEmpeño, String precioVenta, String prestamo, String DescripcionPrenda, String folioVenta) {
        this.idDetalle = idDetalle;
        this.idPrenda = idPrenda;
        this.idEmpeño = idEmpeño;
        this.precioVenta = precioVenta;
        this.prestamo = prestamo;
        this.DescripcionPrenda = DescripcionPrenda;
        this.folioVenta = folioVenta;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdPrenda() {
        return idPrenda;
    }

    public void setIdPrenda(Integer idPrenda) {
        this.idPrenda = idPrenda;
    }

    public Integer getIdEmpeño() {
        return idEmpeño;
    }

    public void setIdEmpeño(Integer idEmpeño) {
        this.idEmpeño = idEmpeño;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(String prestamo) {
        this.prestamo = prestamo;
    }

    public String getDescripcionPrenda() {
        return DescripcionPrenda;
    }

    public void setDescripcionPrenda(String DescripcionPrenda) {
        this.DescripcionPrenda = DescripcionPrenda;
    }

    public String getFolioVenta() {
        return folioVenta;
    }

    public void setFolioVenta(String folioVenta) {
        this.folioVenta = folioVenta;
    }
        
        
        
        
}
