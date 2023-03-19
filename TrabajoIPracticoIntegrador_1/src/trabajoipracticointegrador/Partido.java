package trabajoipracticointegrador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Partido extends Equipo{
    
  protected int idPartido = 1;
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
    
    public void resultados() throws IOException {
        String resultado = null;
        String archivo = "resultados.csv";
        String ruta = "C:\\Users\\djord\\Documents\\NetBeansProjects\\TrabajoIPracticoIntegrador_1\\recursos\\";
        String nombreArchivo = ruta+archivo;
     /*   FileReader fr = new FileReader(nombreArchivo);
        BufferedReader bf = new BufferedReader(fr);*/
	 
        //resultado = "Equipo 1;Cant. Goles 1;Cant. Goles 2;Equipo 2\n";
         resultado = equipo1.getNombre()+";"+golesEquipo1+";"+golesEquipo2+";"+equipo2.getNombre();
         File getArchivo = new File(nombreArchivo);
         FileWriter salidaArchivo = new FileWriter(getArchivo, true);
         if(!getArchivo.exists()){
            Files.writeString(Paths.get(ruta), resultado);
         } else {
            if(getArchivo.length()==0){
                    salidaArchivo.write(resultado);
                
                } else {
                    salidaArchivo.write("\n"+resultado);
                } 
                
                
            
         }
                    salidaArchivo.close();
    }
}
