
package logica;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Pronostico {
    Partido getPartido = new Partido();
    Ronda ronda = new Ronda();
    
    private int puntos = 0;
    private int indice = 0;
    
    public int getPronostico() throws IOException {
        String archivo = "pronostico.csv";
        String nombreArchivo = "C:\\Users\\djord\\Documents\\NetBeansProjects\\TrabajoPracticoIntegrador\\recursos\\"+archivo;
        File archi = new File(nombreArchivo);
	Path ruta = Paths.get(nombreArchivo);
        try 
        {
            if(!archi.exists()){
                System.out.println("sss");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        
            
        
        
       
        List<String> files = Files.readAllLines(ruta, StandardCharsets.ISO_8859_1);
        for(String f: files) {
            String fila[] = f.split(", ");
            for(String celda: fila) {
                String b[] = celda.split(";");
                if(b[2].length()>0 && getPartido.addPartido().get(indice)=="Empate") {
                    puntos++;
                }
                else 
                {
                  if(b[1].length()>0 && getPartido.addPartido().get(indice)=="Ganador") {
                      puntos++;
                  } 
                  else 
                  {
                      if(b[3].length()>0 && getPartido.addPartido().get(indice)=="Perdedor") {
                          puntos++;
                      }
                  }
                }
            }
            indice++;
        }
        ronda.puntos = puntos;
        return puntos;
    }
    
    
    
    
}
    
    
           
    

