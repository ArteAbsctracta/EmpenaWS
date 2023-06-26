/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import com.google.gson.Gson;
import java.util.HashMap;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
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
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author afs30
 */

@Path("Clientes")
public class ClientesWS {
    
    @Context
    private UriInfo context;
    private Gson parser= new Gson();
    
    public ClientesWS(){
    
    }
    
    @POST
    @Path("registrarClientes")
    @Produces(MediaType.APPLICATION_JSON)
        public Response registrarRol(@FormParam("nombre") String nombre,
                                     @FormParam("calle") String calle,
                                     @FormParam("numInterior") Integer numInterior,
                                     @FormParam("numExterior") Integer numExterior,
                                     @FormParam("codigoPostal")Integer codigoPostal,
                                     @FormParam("colonia") String colonia,
                                     @FormParam("municipio")String municipio,
                                     @FormParam("estado")String estado,
                                     @FormParam("pais")String pais,
                                     @FormParam("tipoIdentificacion")String tipoIdentificacion,
                                     @FormParam("numIdentificacion")String numIdentificacion,
                                     @FormParam("fechaNacimiento")String fechaNacimiento,
                                     @FormParam("curp") String curp,
                                     @FormParam("numTelefono") String numTelefono,
                                     @FormParam("correo")String correo,
                                     @FormParam("rfc")String rfc,
                                     @FormParam("fechaActualizacion")String fechaActualizacion,
                                     @FormParam("estatusCliente") String estatusCliente,
                                     @FormParam("comentariosClientes")String comentariosClientes,
                                     @FormParam("sexo")String sexo,
                                     @FormParam("fechaCreacion")String fechaCreacion,
                                     @FormParam("idCreador")Integer idCreador,                                    
                                     @FormParam("idActualizacion")Integer idActualizacion ) {

	ResponseBuilder respuesta = null;
	SqlSession conn = MyBatisUtil.getSession();

            try {
		HashMap<String, Object> param = new HashMap<String, Object>();


                param.put("nombre", nombre);
                param.put("calle", calle);
                param.put("numInterior", numInterior);
                param.put("numExterior", numExterior);
                param.put("codigoPostal", codigoPostal);
                param.put("colonia", colonia);
                param.put("municipio", municipio);
                param.put("estado", estado);
                param.put("pais", pais);
                param.put("tipoIdentificacion", tipoIdentificacion);
                param.put("numIdentificacion", numIdentificacion);
                param.put("fechaNacimiento", fechaNacimiento);
                param.put("curp", curp);
                param.put("numTelefono", numTelefono);
                param.put("correo", correo);
                param.put("rfc", rfc);
                param.put("fechaActualizacion", fechaActualizacion);
                param.put("estatusCliente", estatusCliente);
                param.put("comentariosClientes", comentariosClientes);
                param.put("sexo", sexo);
                param.put("fechaCreacion", fechaCreacion);
                param.put("idCreador", idCreador);
                param.put("idActualizacion", idActualizacion);

		conn.insert("Clientes.registrarClientes", param);
		conn.commit();
		respuesta = Response.ok(new Respuesta("El cliente fue registrado correctamente..."));
            } catch (Exception ex) {
		ex.printStackTrace();
		respuesta = Response
			.status(Status.INTERNAL_SERVER_ERROR)
			.entity(new Respuesta("No se pudo registrar el cliente"));
            } finally {
			conn.close();
            }
	return respuesta.build();
	}
    	@PUT
	@Path("actualizarClientes/{idCliente}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarClientes(
			@PathParam("idCliente") Integer idCliente,
                        @FormParam("nombre") String nombre,
                        @FormParam("calle") String calle,
                        @FormParam("numInterior") Integer numInterior,
                        @FormParam("numExterior") Integer numExterior,
                        @FormParam("codigoPostal")Integer codigoPostal,
                        @FormParam("colonia") String colonia,
                        @FormParam("municipio")String municipio,
                        @FormParam("estado")String estado,
                        @FormParam("pais")String pais,
                        @FormParam("tipoIdentificacion")String tipoIdentificacion,
                        @FormParam("numIdentificacion")String numIdentificacion,
                        @FormParam("fechaNacimiento")String fechaNacimiento,
                        @FormParam("curp") String curp,
                        @FormParam("numTelefono") String numTelefono,
                        @FormParam("correo")String correo,
                        @FormParam("rfc")String rfc,
                        @FormParam("fechaActualizacion")String fechaActualizacion,
                        @FormParam("estatusCliente") String estatusCliente,
                        @FormParam("comentariosClientes")String comentariosClientes,
                        @FormParam("sexo")String sexo,
                        @FormParam("fechaCreacion")String fechaCreacion,
                        @FormParam("idCreador")Integer idCreador,                                    
                        @FormParam("idActualizacion")Integer idActualizacion ) {

		ResponseBuilder respuesta = null;
		SqlSession conn = MyBatisUtil.getSession();

		try {
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("idCliente", idCliente);
			param.put("nombre", nombre);
                        param.put("calle", calle);
                        param.put("numInterior", numInterior);
                        param.put("numExterior", numExterior);
                        param.put("codigoPostal", codigoPostal);
                        param.put("colonia", colonia);
                        param.put("municipio", municipio);
                        param.put("estado", estado);
                        param.put("pais", pais);
                        param.put("tipoIdentificacion", tipoIdentificacion);
                        param.put("numIdentificacion", numIdentificacion);
                        param.put("fechaNacimiento", fechaNacimiento);
                        param.put("curp", curp);
                        param.put("numTelefono", numTelefono);
                        param.put("correo", correo);
                        param.put("rfc", rfc);
                        param.put("fechaActualizacion", fechaActualizacion);
                        param.put("estatusCliente", estatusCliente);
                        param.put("comentariosClientes", comentariosClientes);
                        param.put("sexo", sexo);
                        param.put("fechaCreacion", fechaCreacion);
                        param.put("idCreador", idCreador);
                        param.put("idActualizacion", idActualizacion);


			conn.update("Clientes.actualizarClientes", param);
			conn.commit();
			respuesta = Response.ok(new Respuesta("El clientes fue actualizado correctamente..."));
		} catch (Exception ex) {
			ex.printStackTrace();
			respuesta = Response
					.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new Respuesta("No se pudo actualizar el clientes"));
		} finally {
			conn.close();
		}
		return respuesta.build();
	}
        
        @DELETE
	@Path("eliminarClientes/{idCliente}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarClientes(
			@PathParam("idCliente") Integer idCliente) {

		ResponseBuilder respuesta = null;
		SqlSession conn = MyBatisUtil.getSession();

		try {
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("idCliente", idCliente);

			conn.update("Clientes.eliminarClientes", param);
			conn.commit();
			respuesta = Response.ok(new Respuesta("Clientes eliminado correctamente..."));
		} catch (Exception ex) {
			ex.printStackTrace();
			respuesta = Response
					.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new Respuesta("No se pudo eliminar el Clientes"));
		} finally {
			conn.close();
		}
		return respuesta.build();
	}
}
