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
import org.apache.ibatis.session.SqlSession;
import modelo.pojos.Prendas;
import modelo.pojos.Respuesta;

/**
 *
 * @author afs30
 */
@Path("Prendas")
public class PrendasWS {

    @Context
    private UriInfo context;
    private Gson parser = new Gson();

    public PrendasWS() {
    }

    @GET
    @Path("getAllPrendas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllContratos() {
        Response.ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            List<Prendas> list = conn.selectList("Prendas.getAllPrendas");
            respuesta = Response.ok(parser.toJson(list));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("Error consultando los prendas."));
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta.build();
    }

    @POST
    @Path("registrarPrenda")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarContrato(
            @FormParam("idEmpeño") Integer idEmpeño,
            @FormParam("categoria") String categoria,
            @FormParam("numPiezas") Integer numPiezas,
            @FormParam("serie") String serie,
            @FormParam("modelo") String modelo,
            @FormParam("subCategoria") String subCategoria,
            @FormParam("descripcionPrenda") String descripcionPrenda,
            @FormParam("metal") String metal,
            @FormParam("peso") String peso,
            @FormParam("kilataje") String kilataje,
            @FormParam("prestamo") String prestamo,
            @FormParam("modeloPrenda") String modeloPrenda,
            @FormParam("precioComercializacion") String precioComercializacion,
            @FormParam("precioVenta") String precioVenta,
            @FormParam("estatusPrenda") String estatusPrenda,
            @FormParam("comercializacionAsociada") String comercializacionAsociada,
            @FormParam("fechaCreacion") String fechaCreacion,
            @FormParam("fechaComercializacion") String fechaComercializacion,
            @FormParam("fechaVenta") String fechaVenta,
            @FormParam("idUsuario") Integer idUsuario
    ) {

        Response.ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();
        System.out.println(fechaComercializacion);
        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idEmpeño", idEmpeño);
            param.put("categoria", categoria);
            param.put("numPiezas", numPiezas);
            param.put("serie", serie);
            param.put("modelo", modelo);
            param.put("subCategoria", subCategoria);
            param.put("descripcionPrenda", descripcionPrenda);
            param.put("metal", metal);
            param.put("peso", peso);
            param.put("kilataje", kilataje);
            param.put("prestamo", prestamo);
            param.put("modeloPrenda", modeloPrenda);
            param.put("precioComercializacion", precioComercializacion);
            param.put("precioVenta", precioVenta);
            param.put("estatusPrenda", estatusPrenda);
            param.put("comercializacionAsociada", comercializacionAsociada);
            param.put("fechaCreacion", fechaCreacion);
            param.put("fechaComercializacion", fechaComercializacion);
            param.put("fechaVenta", fechaVenta);
            param.put("idUsuario", idUsuario);

            System.out.println(param);

            conn.insert("Prendas.registrarPrendas", param);
            conn.commit();
            respuesta = Response.ok(new Respuesta("Prenda registrado correctamente..."));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("No se pudo registrar la Prenda"));
        } finally {
            conn.close();
        }
        return respuesta.build();
    }
}
