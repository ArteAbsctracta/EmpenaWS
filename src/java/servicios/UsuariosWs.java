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
import modelo.pojos.Usuarios;
import org.apache.ibatis.session.SqlSession;
import utils.JavaUtils;

/**
 *
 * @author afs30
 */
@Path("Usuarios")
public class UsuariosWs {
    
    @Context
    private UriInfo context;
    private Gson parser = new Gson();

    public UsuariosWs(){
    
    }
    
    @POST
    @Path("registrarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarUsuario(
            @FormParam("nombre") String nombre,
            @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("apellidoMaterno") String apellidoMaterno,
            @FormParam("usuario") String usuario,
            @FormParam("password") String password,
            @FormParam("idRol") Integer idRol,
            @FormParam("curp") String curp){

        ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("nombre", nombre);
            param.put("apellidoPaterno", apellidoPaterno);
            param.put("apellidoMaterno", apellidoMaterno);
            param.put("usuario", usuario);
            param.put("password", JavaUtils.hashString(password.toUpperCase()));
            param.put("idRol", idRol);
            param.put("curp", curp);

            conn.insert("Usuarios.registrarUsuario", param);
            conn.commit();
            respuesta = Response.ok(new Respuesta("Usuario registrado correctamente..."));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("No se pudo registrar el usuario"));
        } finally {
            conn.close();
        }
        return respuesta.build();
    }
    
    @POST
    @Path("actualizarUsuario/{idUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarUsuario(
            @PathParam("idUsuario") Integer idUsuario,
            @FormParam("nombre") String nombre,
            @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("apellidoMaterno") String apellidoMaterno,
            @FormParam("usuario") String usuario,
            @FormParam("idRol") Integer idRol,
            @FormParam("curp") String curp){

        ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idUsuario", idUsuario);
            param.put("nombre", nombre);
            param.put("apellidoPaterno", apellidoPaterno);
            param.put("apellidoMaterno", apellidoMaterno);
            param.put("usuario", usuario);
            param.put("idRol", idRol);
            param.put("curp", curp);

            conn.update("Usuarios.actualizarUsuario", param);
            conn.commit();
            respuesta = Response.ok(new Respuesta("Usuario actualizado correctamente..."));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("No se pudo actualizar el usuario"));
        } finally {
            conn.close();
        }
        return respuesta.build();
    }

    @PUT
    @Path("eliminarUsuario/{idUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarUsuario(
            @PathParam("idUsuario") Integer idUsuario
    ) {
        ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idUsuario", idUsuario);

            conn.update("Usuarios.eliminarUsuario", param);
            conn.commit();
            respuesta = Response.ok(new Respuesta("Usuario eliminado correctamente..."));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("No se pudo eliminar el usuario"));
        } finally {
            conn.close();
        }
        return respuesta.build();
    }
    
    @PUT
    @Path("actualizarEstatus/{idUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarEstatusUsuario(
            @PathParam("idUsuario") Integer idUsuario) {

        ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idUsuario", idUsuario);

            conn.update("Usuarios.actualizarEstatus", param);
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
    @Path("getAllUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            List<Usuarios> list = conn.selectList("Usuarios.getAllUsers");
            respuesta = Response.ok(parser.toJson(list));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("Error consultando los usuarios."));
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta.build();
    }

    @GET
    @Path("getAllUsersActivo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsersActivo() {
        ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            List<Usuarios> list = conn.selectList("Usuarios.getAllUsersActivo");
            respuesta = Response.ok(parser.toJson(list));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("Error consultando los usuarios."));
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta.build();
    }
    
     @GET
    @Path("getUsuarioById/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarioById(@PathParam("nombre") String nombre) {
        ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();

        try {
            Usuarios usuario = conn.selectOne("Usuarios.getUsuarioById", nombre);
            respuesta = Response.ok(usuario);
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("Error al consultar el usuario"));
        } finally {
            conn.close();
        }
        return respuesta.build();
    }

    @POST
    @Path("usuarioId")
    @Produces(MediaType.APPLICATION_JSON)
    public Response usuarioById(@FormParam("usuario") String usuario) {
        ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();
        long num = 0;
        try {

            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("usuario", usuario);

            Usuarios result = conn.selectOne("Usuarios.getUsuarioById", param);
            conn.commit();

            respuesta = Response.ok(new Respuesta(result != null ? "1" : "0"));
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = Response
                    .status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new Respuesta("Error al consultar"));
        } finally {
            conn.close();
        }
        return respuesta.build();
    }

    @GET
    @Path("buscarUsuario/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarUsuarioByNombre(@PathParam("nombre") String nombre) {
        ResponseBuilder respuesta = null;
        SqlSession conn = MyBatisUtil.getSession();
        try {
            Usuarios list = conn.selectOne("Usuarios.buscarUsuarioPorNombre", nombre);
            respuesta = Response.ok(parser.toJson(list));
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
}
