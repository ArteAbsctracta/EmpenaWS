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
public class Clientes {
    
    private Integer idClientes;
    private String nombre;
    private String calle;
    private Integer numInterior;
    private Integer numExterior;
    private Integer codigoPostal;
    private String colonia;
    private String municipio;
    private String estado;
    private String pais;
    private String tipoIdentificacion;
    private String numIdentificacion;
    private String fechaNacimiento;
    private String curp;
    private String numTelefono;
    private String correo;
    private String rfc;
    private String fechaActualizacion;
    private String estatusCliente;
    private String comentariosClientes;
    private String sexo;
    private String fechaCreacion;
    private Integer idCreador;
    private Integer idActualizacion;

    public Clientes() {
    }

    public Clientes(Integer idClientes, String nombre, String calle, Integer numInterior, Integer numExterior, Integer codigoPostal, String colonia, String municipio, String estado, String pais, String tipoIdentificacion, String numIdentificacion, String fechaNacimiento, String curp, String numTelefono, String correo, String rfc, String fechaActualizacion, String estatusCliente, String comentariosClientes, String sexo, String fechaCreacion, Integer idCreador, Integer idActualizacion) {
        this.idClientes = idClientes;
        this.nombre = nombre;
        this.calle = calle;
        this.numInterior = numInterior;
        this.numExterior = numExterior;
        this.codigoPostal = codigoPostal;
        this.colonia = colonia;
        this.municipio = municipio;
        this.estado = estado;
        this.pais = pais;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numIdentificacion = numIdentificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.numTelefono = numTelefono;
        this.correo = correo;
        this.rfc = rfc;
        this.fechaActualizacion = fechaActualizacion;
        this.estatusCliente = estatusCliente;
        this.comentariosClientes = comentariosClientes;
        this.sexo = sexo;
        this.fechaCreacion = fechaCreacion;
        this.idCreador = idCreador;
        this.idActualizacion = idActualizacion;
    }

    public Integer getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Integer idClientes) {
        this.idClientes = idClientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumInterior() {
        return numInterior;
    }

    public void setNumInterior(Integer numInterior) {
        this.numInterior = numInterior;
    }

    public Integer getNumExterior() {
        return numExterior;
    }

    public void setNumExterior(Integer numExterior) {
        this.numExterior = numExterior;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getEstatusCliente() {
        return estatusCliente;
    }

    public void setEstatusCliente(String estatusCliente) {
        this.estatusCliente = estatusCliente;
    }

    public String getComentariosClientes() {
        return comentariosClientes;
    }

    public void setComentariosClientes(String comentariosClientes) {
        this.comentariosClientes = comentariosClientes;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(Integer idCreador) {
        this.idCreador = idCreador;
    }

    public Integer getIdActualizacion() {
        return idActualizacion;
    }

    public void setIdActualizacion(Integer idActualizacion) {
        this.idActualizacion = idActualizacion;
    }

    
}
