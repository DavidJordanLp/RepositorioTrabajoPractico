package trabajoipracticointegrador;

public class Equipo {
    protected String nombre;
    protected String descripcion;

    // constructor vacio
    public Equipo() {
    }

    //constructor con argumentos
    public Equipo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //

   
    
}
