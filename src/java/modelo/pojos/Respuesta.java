
package modelo.pojos;

public class Respuesta {
    private String mensaje;
    private boolean error;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Respuesta() {
        this.error = false;
        this.mensaje = "";
    }

    public Respuesta(String mensaje) {
        this.mensaje = mensaje;
        this.error = false;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
