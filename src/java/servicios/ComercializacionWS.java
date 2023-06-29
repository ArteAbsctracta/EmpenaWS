/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import modelo.mybatis.MyBatisUtil;
import modelo.pojos.Comercializacion;
import modelo.pojos.Respuesta;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author afs30
 */
@Path("Comercializacion")
public class ComercializacionWS {
    @Context
    private UriInfo context;
    private Gson parser = new Gson();

    public ComercializacionWS() {
    }
    
    @GET
    @Path("getAllComercializacion")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllContratos() {
        Response.ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            List<Comercializacion> list = conn.selectList("Comercializacion.getAllComercializacion");
            respuesta = Response.ok(parser.toJson(list));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("Error consultando los Comercializacion."));
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta.build();
    }
}
