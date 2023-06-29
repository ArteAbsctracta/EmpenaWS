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
import modelo.pojos.Contratos;
import modelo.pojos.Respuesta;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author afs30
 */
@Path("Contratos")
public class ContratoWs {

    @Context
    private UriInfo context;
    private Gson parser = new Gson();

    public ContratoWs() {
    }

    @GET
    @Path("getAllContratos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllContratos() {
        Response.ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            List<Contratos> list = conn.selectList("Contratos.getAllContratos");
            respuesta = Response.ok(parser.toJson(list));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("Error consultando los contratos."));
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta.build();
    }

    @POST
    @Path("registrarContrato")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarContrato(
            @FormParam("idEmpeño") Integer idEmpeño,
            @FormParam("fechaCreacion") String fechaCreacion,
            @FormParam("fechaActualizacion") String fechaActualizacion,
            @FormParam("fechaLimite") String fechaLimite,
            @FormParam("fechaComercializar") String fechaComercializar,
            @FormParam("importePrestamo") String importePrestamo,
            @FormParam("estatusContrato") String estatusContrato,
            @FormParam("contratoAnterior") String contratoAnterior,
            @FormParam("contratoSiguiente") String contratoSiguiente,
            @FormParam("fechaComercializacion") String fechaComercializacion,
            @FormParam("fechaCancelacion") String fechaCancelacion,
            @FormParam("idUsuario") Integer idUsuario,
            @FormParam("observaciones") String observaciones,
            @FormParam("idRefrendo") Integer idRefrendo,
            @FormParam("idFiniquito") Integer idFiniquito,
            @FormParam("idEspera") Integer idEspera) {

        Response.ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();
           System.out.println(fechaComercializacion);
        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idEmpeño", idEmpeño);
            param.put("fechaCreacion", fechaCreacion);
            param.put("fechaActualizacion", fechaActualizacion);
            param.put("fechaLimite", fechaLimite);
            param.put("fechaComercializar", fechaComercializar);
            param.put("importePrestamo", importePrestamo);
            param.put("estatusContrato", estatusContrato);
            param.put("contratoAnterior", contratoAnterior);
            param.put("contratoSiguiente", contratoSiguiente);
            param.put("fechaComercializacion", fechaComercializacion);
            param.put("fechaCancelacion", fechaCancelacion);
            param.put("idUsuario", idUsuario);
            param.put("observaciones", observaciones);
            param.put("idRefrendo", idRefrendo);
            param.put("idFiniquito", idFiniquito);
            param.put("idEspera", idEspera);
            
            System.out.println(param);
 
            conn.insert("Contratos.registrarContrato", param);
            conn.commit();
            respuesta = Response.ok(new Respuesta("Contrato registrado correctamente..."));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("No se pudo registrar el Contrato"));
        } finally {
            conn.close();
        }
        return respuesta.build();
    }
}
