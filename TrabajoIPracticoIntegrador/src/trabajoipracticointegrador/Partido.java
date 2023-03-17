package trabajoipracticointegrador;

public class Partido extends Equipo{
  protected Equipo equipo1; // creo un argumento e instancio el objeto padre Equipo para equipo N? 1
  protected Equipo equipo2; // creo un argumento e instancio el objeto padre Equipo para equipo N? 2
 
  protected int golesEquipo1; // creo variable para goles equipo 1
  protected int golesEquipo2; // creo variable para goles equipo 2
  
  // constructor vacio
  public Partido() {
  }
  
  // constructor con argumentos

    public Partido(int golesEquipo1, int golesEquipo2, String nombre, String descripcion) {
        super(nombre, descripcion);
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    
    // getters y setters
    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }
    //
    
    
  

   

    
  
  

    
  
  
  
    
  
   
    
}
