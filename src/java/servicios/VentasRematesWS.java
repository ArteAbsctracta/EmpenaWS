/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import modelo.mybatis.MyBatisUtil;
import modelo.pojos.Respuesta;
import modelo.pojos.Usuarios;
import modelo.pojos.VentasRemates;

import org.apache.ibatis.session.SqlSession;
import utils.JavaUtils;

/**
 *
 * @author afs30
 */
@Path("Ventas")
public class VentasRematesWS {
    
    @Context
    private UriInfo context;
    private Gson parser = new Gson();
    
        public VentasRematesWS(){
    
    }
    
    @POST
    @Path("registrarVentas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarVentas(
            @FormParam("subTotal") String subTotal,
            @FormParam("ivaVenta") String ivaVenta,
            @FormParam("totalVenta") String totalVenta,
            @FormParam("idContrato") Integer idContrato,
            @FormParam("estatusVenta") String estatusVenta,
            @FormParam("idCliente") Integer idCliente,
            @FormParam("idCreador") Integer idCreador,
            @FormParam("fechaCreacion") String fechaCreacion,
            @FormParam("totalArticulos") String totalArticulos,
            @FormParam("fechaCancelacion") String fechaCancelacion,
            @FormParam("idUsuaurio") Integer idUsuario,
            @FormParam("tipoVenta") String tipoVenta){

        Response.ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("subTotal", subTotal);
            param.put("ivaVenta", ivaVenta);
            param.put("totalVenta", totalVenta);
            param.put("idContrato", idContrato);
            param.put("estatusVenta", estatusVenta);
            param.put("idCliente", idCliente);
            param.put("idCreado", idCreador);
            param.put("fechaCreacion",fechaCreacion);
            param.put("totalArticulos",totalArticulos);
            param.put("fechaCancelacion", fechaCancelacion);
            param.put("idUsuario",idUsuario);
            param.put("tipoVenta", tipoVenta);



            conn.insert("Ventas.registrarVentas", param);
            conn.commit();
            respuesta = Response.ok(new Respuesta("Venta registrado correctamente..."));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("No se pudo registrar la vENTA"));
        } finally {
            conn.close();
        }
        return respuesta.build();
    }
    
    @POST
    @Path("actualizarVentas/{idVenta}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarVentas(
            @PathParam("idventa") Integer idVenta,
            @FormParam("subTotal") String subTotal,
            @FormParam("ivaVenta") String ivaVenta,
            @FormParam("totalVenta") String totalVenta,
            @FormParam("idContrato") Integer idContrato,
            @FormParam("estatusVenta") String estatusVenta,
            @FormParam("idCliente") Integer idCliente,
            @FormParam("idCreador") Integer idCreador,
            @FormParam("fechaCreacion") String fechaCreacion,
            @FormParam("totalArticulos") String totalArticulos,
            @FormParam("fechaCancelacion") String fechaCancelacion,
            @FormParam("idUsuaurio") Integer idUsuario,
            @FormParam("tipoVenta") String tipoVenta){

        Response.ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idVenta",idVenta);
            param.put("ivaVenta", ivaVenta);
            param.put("totalVenta", totalVenta);
            param.put("idContrato", idContrato);
            param.put("estatusVenta", estatusVenta);
            param.put("idCliente", idCliente);
            param.put("idCreado", idCreador);
            param.put("fechaCreacion",fechaCreacion);
            param.put("totalArticulos",totalArticulos);
            param.put("fechaCancelacion", fechaCancelacion);
            param.put("idUsuario",idUsuario);
            param.put("tipoVenta", tipoVenta);

            conn.update("Ventas.actualizarVentas", param);
            conn.commit();
            respuesta = Response.ok(new Respuesta("Venta actualizada correctamente..."));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("No se pudo actualizar la Venta"));
        } finally {
            conn.close();
        }
        return respuesta.build();
    }
    
    
    @DELETE
    @Path("eliminarVenta/{idVenta}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarVentas(
            @PathParam("idVenta") Integer idVenta
    ) {
        Response.ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idVenta", idVenta);

            conn.update("Ventas.eliminarVentas", param);
            conn.commit();
            respuesta = Response.ok(new Respuesta("Venta eliminada correctamente..."));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("No se pudo eliminar la venta"));
        } finally {
            conn.close();
        }
        return respuesta.build();
    }
    
    @POST
    @Path("actualizarEstatus/{idVentas}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarEstatusVenta(
            @PathParam("idVenta") Integer idVenta) {

        Response.ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idVenta", idVenta);

            conn.update("Ventas.actualizarEstatus", param);
            conn.commit();
            respuesta = Response.ok(new Respuesta("Estatus actualizado correctamente..."));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("No se pudo actualizar el estado"));
        } finally {
            conn.close();
        }
        return respuesta.build();
    }
    
    @GET
    @Path("getAllVentas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllVentas() {
        Response.ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            List<VentasRemates> list = conn.selectList("Ventas.getAllVentas");
            respuesta = Response.ok(parser.toJson(list));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("Error consultando las ventas."));
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta.build();
    }
    
    
    @GET
    @Path("getAllVentasActivo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllVentasActivo() {
        Response.ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            List<VentasRemates> list = conn.selectList("Ventas.getAllVentasActivo");
            respuesta = Response.ok(parser.toJson(list));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("Error consultando los usuarios."));
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta.build();
    }
    
    @GET
    @Path("buscarVentas/{idContrato}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarVentaByid(@PathParam("idContrato") String idContrato) {
        Response.ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();
        try {
            List<VentasRemates> list = conn.selectList("Ventas.buscarVentaByid", idContrato);
            respuesta = Response.ok(parser.toJson(list));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("Error al consultar."));
        } finally {
            conn.close();
        }
        return respuesta.build();
    }
}

