
package tpi;

public class Equipo {
    public String nombre;
    public String Descripcion;

    protected Equipo() {
    }

    protected Equipo(String nombre, String Descripcion) {
        this.nombre = nombre;
        this.Descripcion = Descripcion;
    }

    protected String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected String getDescripcion() {
        return Descripcion;
    }

    protected void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
