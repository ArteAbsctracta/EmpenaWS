/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import modelo.mybatis.MyBatisUtil;
import modelo.pojos.Empeño;
import modelo.pojos.Respuesta;
import org.apache.ibatis.session.SqlSession;
import utils.JavaUtils;

/**
 *
 * @author afs30
 */
@Path("Empenos")
public class EmpeñoWs {

    @Context
    private UriInfo context;
    private Gson parser = new Gson();

    public EmpeñoWs() {
    }

    @GET
    @Path("getAllEmpenos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllContratos() {
        Response.ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            List<Empeño> list = conn.selectList("Empenos.getAllEmpenos");
            respuesta = Response.ok(parser.toJson(list));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("Error consultando los Empeños."));
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta.build();
    }

    @POST
    @Path("registrarEmpenos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarUsuario(
            @FormParam("idCliente") Integer idCliente,
            @FormParam("fechaCreacion") String fechaCreacion,
            @FormParam("observaciones") String observaciones,
            @FormParam("idUsuario") Integer idUsuario,
            @FormParam("contratoActual") String contratoActual,
            @FormParam("fechaActualizacion") String FechaActualizacion,
            @FormParam("interesPorcentaje") String interesPorcentaje,
            @FormParam("almacenajePorcentaje") String almacenajePorcentaje,
            @FormParam("numPeriodos") Integer numPeriodos,
            @FormParam("diasPeriodos") Integer diasPeriodo,
            @FormParam("ivaEmpeño") Double ivaEmpeño,
            @FormParam("tasaCormecializacion") Double tasaCormecializacion) {

        Response.ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idCliente", idCliente);
            param.put("fechaCreacion", fechaCreacion);
            param.put("observaciones", observaciones);
            param.put("idUsuario", idUsuario);
            param.put("contratoActual", contratoActual);
            param.put("fechaActualizacion", FechaActualizacion);
            param.put("interesPorcentaje", interesPorcentaje);
            param.put("almacenajePorcentaje", almacenajePorcentaje);
            param.put("numPeriodos", numPeriodos);
            param.put("diasPeriodos", diasPeriodo);
            param.put("ivaEmpeño", ivaEmpeño);
            param.put("tasaCormecializacion", tasaCormecializacion);

            conn.insert("Empenos.registrarEmpeno", param);
            conn.commit();
            respuesta = Response.ok(new Respuesta("Empeño registrado correctamente..."));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("No se pudo registrar el Empeño"));
        } finally { 
            conn.close();
        }
        return respuesta.build();
    }
    
    
    
    @POST
    @Path("actualizarEmpenos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarEmpeno(
            @FormParam("idEmpeño") Integer idEmpeño,
            @FormParam("idCliente") Integer idCliente,
            @FormParam("fechaCreacion") String fechaCreacion,
            @FormParam("observaciones") String observaciones,
            @FormParam("idUsuario") Integer idUsuario,
            @FormParam("contratoActual") String contratoActual,
            @FormParam("fechaActualizacion") String FechaActualizacion,
            @FormParam("interesPorcentaje") String interesPorcentaje,
            @FormParam("almacenajePorcentaje") String almacenajePorcentaje,
            @FormParam("numPeriodos") Integer numPeriodos,
            @FormParam("diasPeriodos") Integer diasPeriodo,
            @FormParam("ivaEmpeño") Double ivaEmpeño,
            @FormParam("tasaCormecializacion") Double tasaCormecializacion) {

        Response.ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();
        
        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idEmpeño", idEmpeño);
            param.put("idCliente", idCliente);
            param.put("fechaCreacion", fechaCreacion);
            param.put("observaciones", observaciones);
            param.put("idUsuario", idUsuario);
            param.put("contratoActual", contratoActual);
            param.put("fechaActualizacion", FechaActualizacion);
            param.put("interesPorcentaje", interesPorcentaje);
            param.put("almacenajePorcentaje", almacenajePorcentaje);
            param.put("numPeriodos", numPeriodos);
            param.put("diasPeriodos", diasPeriodo);
            param.put("ivaEmpeño", ivaEmpeño);
            param.put("tasaCormecializacion", tasaCormecializacion);
            System.out.println(param);
            conn.insert("Empenos.actualizarEmpeno", param);
            conn.commit();
            respuesta = Response.ok(new Respuesta("Empeño actualizado correctamente..."));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("No se pudo actualizar el Empeño"));
        } finally { 
            conn.close();
        }
        return respuesta.build();
    }
}
