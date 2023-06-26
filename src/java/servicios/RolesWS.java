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
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import modelo.mybatis.MyBatisUtil;
import modelo.pojos.Respuesta;
import modelo.pojos.Roles;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author afs30
 */

@Path("Roles")
public class RolesWS {
    @Context
    private UriInfo context;
    private Gson parser = new Gson();
    
    public RolesWS() {
    }

    @POST
    @Path("registrarRol")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarRol(@FormParam("nombreRol") String nombreRol,
                                 @FormParam("estatus") String estatus, 
                                 @FormParam("descripcion")String descripcion) {

        ResponseBuilder respuesta = null;
	SqlSession conn = MyBatisUtil.getSession();

	try {
            HashMap<String, Object> param = new HashMap<String, Object>();

            param.put("nombreRol", nombreRol);
            param.put("estatus", estatus);
            param.put("descripcion", descripcion);

            conn.insert("Roles.registrarRol", param);
            conn.commit();
            respuesta = Response.ok(new Respuesta("El rol fue registrado correctamente..."));
	} catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
            .status(Status.INTERNAL_SERVER_ERROR)
            .entity(new Respuesta("No se pudo registrar el rol"));
	} finally {
            conn.close();
	}
            return respuesta.build();
	}
    
        @PUT
	@Path("actualizarRol/{idRol}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarRol(
			@PathParam("idRol") Integer idRol,
			@FormParam("nombreRol") String nombreRol,
			@FormParam("descripcion") String descripcion) {

		ResponseBuilder respuesta = null;
		SqlSession conn = MyBatisUtil.getSession();

		try {
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("idRol", idRol);
			param.put("nombreRol", nombreRol);
			param.put("descripcion", descripcion);

			conn.update("Roles.actualizarRol", param);
			conn.commit();
			respuesta = Response.ok(new Respuesta("El rol fue actualizado correctamente..."));
		} catch (Exception ex) {
			ex.printStackTrace();
			respuesta = Response
					.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new Respuesta("No se pudo actualizar el rol"));
		} finally {
			conn.close();
		}
		return respuesta.build();
	}
    
        @DELETE
	@Path("eliminarRol/{idRol}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarRol(
			@PathParam("idRol") Integer idRol) {

		ResponseBuilder respuesta = null;
		SqlSession conn = MyBatisUtil.getSession();

		try {
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("idRol", idRol);

			conn.update("Roles.eliminarRol", param);
			conn.commit();
			respuesta = Response.ok(new Respuesta("Rol eliminado correctamente..."));
		} catch (Exception ex) {
			ex.printStackTrace();
			respuesta = Response
					.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new Respuesta("No se pudo eliminar el rol"));
		} finally {
			conn.close();
		}
		return respuesta.build();
	}    
    
        @GET
	@Path("getAllRol")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRol() {
		SqlSession conn = MyBatisUtil.getSession();
		ResponseBuilder respuesta = null;

		try {
			List<Roles> list = conn.selectList("Roles.getAllRol");
			respuesta = Response.ok(parser.toJson(list));
		} catch (Exception ex) {
			ex.printStackTrace();
			respuesta = Response
					.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new Respuesta("Error al consultar roles."));
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return respuesta.build();
	}

	@GET
	@Path("getAllRolActivo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRolActivo() {
		SqlSession conn = MyBatisUtil.getSession();
		ResponseBuilder respuesta = null;

		try {
			List<Roles> list = conn.selectList("Roles.getAllRolActivo");
			respuesta = Response.ok(parser.toJson(list));
		} catch (Exception ex) {
			ex.printStackTrace();
			respuesta = Response
					.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new Respuesta("Error al consultar roles."));
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return respuesta.build();
	}
    
    
	@PUT
	@Path("actualizarEstatus/{idRol}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarEstatusRol(@PathParam("idRol") Integer idRol) {
		ResponseBuilder respuesta = null;
		SqlSession conn = MyBatisUtil.getSession();

		try {
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("idRol", idRol);

			conn.update("Rol.actualizarEstatus", param);
			conn.commit();
			respuesta = Response.ok(new Respuesta("Estatus actualizado correctamente..."));
		} catch (Exception ex) {
			ex.printStackTrace();
			respuesta = Response
					.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new Respuesta("No se pudo actualizar el estado"));
		} finally {
			conn.close();
		}
		return respuesta.build();
	}

	@GET
	@Path("getRolById/{nombreRol}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRolById(@PathParam("nombreRol") String nombreRol) {
		SqlSession conn = MyBatisUtil.getSession();
		ResponseBuilder respuesta = null;

		try {
			Roles rol = conn.selectOne("Roles.getRolById", nombreRol);
			respuesta = Response.ok(parser.toJson(rol));
		} catch (Exception ex) {
			ex.printStackTrace();
			respuesta = Response
				.status(Status.INTERNAL_SERVER_ERROR)
				.entity(new Respuesta("Error al consultar roles."));
		} finally {
			conn.close();
		}
		return respuesta.build();
	}

	@POST
	@Path("rolId")
	@Produces(MediaType.APPLICATION_JSON)
	public Response rolById(@FormParam("nombreRol") String nombreRol) {
		ResponseBuilder respuesta = null;
		SqlSession conn = MyBatisUtil.getSession();
		try {

			Roles result = conn.selectOne("Roles.rolId", nombreRol);
			conn.commit();
			
			respuesta = Response.ok(new Respuesta(result != null ? "1": "0"));
		} catch (Exception ex) {
			ex.printStackTrace();
			respuesta = Response
				.status(Status.INTERNAL_SERVER_ERROR)
				.entity(new Respuesta("Error al consultar."));
		} finally {
			conn.close();
		}
		return respuesta.build();
	}

	@GET
	@Path("buscarRol/{nombreRol}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarRol(@PathParam("nombreRol") String nombreRol) {
		ResponseBuilder respuesta = null;
		SqlSession conn = MyBatisUtil.getSession();
		try {
			List<Roles> list = conn.selectList("Roles.buscarRol", nombreRol);
			respuesta = Response.ok(parser.toJson(list));
		} catch (Exception ex) {
			ex.printStackTrace();
			respuesta = Response
				.status(Status.INTERNAL_SERVER_ERROR)
				.entity(new Respuesta("Error al buscar rol."));
		} finally {
			conn.close();
		}
		return respuesta.build();
	}
}
