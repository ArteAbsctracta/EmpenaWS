/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;
import java.util.Set;
import javax.ws.rs.core.Application;


/**
 *
 * @author afs30
 */
@javax.ws.rs.ApplicationPath("ws")
public class AppliacationConfig extends Application {
        @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(servicios.ClientesWS.class);
        resources.add(servicios.ComercializacionWS.class);
        resources.add(servicios.ContratoWs.class);
        resources.add(servicios.CorsFilter.class);
        resources.add(servicios.EmpeñoWs.class)
        resources.add(servicios.PrendasWS.class);
        resources.add(servicios.RolesWS.class);
        resources.add(servicios.SesionWS.class);
        resources.add(servicios.UsuariosWs.class)
        resources.add(servicios.VentasRematesWS.class);


 

    }
}
