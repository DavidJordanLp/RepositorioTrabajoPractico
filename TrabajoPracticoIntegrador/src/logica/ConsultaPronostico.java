
package logica;

import java.io.IOException;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ConsultaPronostico {
        private String equipo1;
        private String equipo2;
        private String ganadorEquipo1;
        private String ganadorEquipo2;
        private String empate;
        
        Scanner ent = new Scanner(System.in);
        public void getArchivo() throws IOException {
            String archivo = "pronostico.csv";
            //cambiar ruta por ruta propia
            String nombreArchivo = "C:\\Users\\David\\Documents\\NetBeansProjects\\TrabajoPracticoIntegrador_GRUPO F\\recursos\\"+archivo;
            Path ruta = Paths.get(nombreArchivo);
            List<String> files = Files.readAllLines(ruta, StandardCharsets.ISO_8859_1);
            System.out.println("Pronostico del jugador");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
            for (String f : files) {
                String[] celda = f.split(", ");
                for(String textoCelda:celda) {
                    String[] item = textoCelda.split(";");
                    if(item[2].length()>0) {
                        ganadorEquipo1 = "-------";
                        empate = "Empate";
                        ganadorEquipo2 = "-------";
                    }
                    else
                    {
                        if(item[1].length()>0) {
                            ganadorEquipo1 = "Ganador";
                            empate = "-------";
                            ganadorEquipo2 = "-------";
                        }
                        else
                        {
                            ganadorEquipo1 = "-------";
                            empate = "-------";
                            ganadorEquipo2 = "Ganador";
                        }
                    }
                    
                    System.out.println(item[0]+"|"+ganadorEquipo1+"|"+empate+"|"+ganadorEquipo2+"|"+item[4]);
                    
                    
                    
                }
            }           
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
                
               
            
           
        
        }
       
        
    
}
