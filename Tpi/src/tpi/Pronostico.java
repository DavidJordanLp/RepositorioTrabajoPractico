
package tpi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Pronostico {
        ResultadoEnum result = new ResultadoEnum();
        
        int puntos = 0 ;
        ResultadoEnum resultadoEnum = new ResultadoEnum();
        public int consultarPronostico() throws FileNotFoundException{
                int resultado = 0;
                String archivo = "pronostico.csv";
                String nombreArchivo = "C:\\Users\\djord\\Documents\\NetBeansProjects\\Tpi\\recursos\\"+archivo;
	        Path ruta = Paths.get(nombreArchivo);
	        
	        try {
	            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.ISO_8859_1);
	            for (String linea : lineas) {
	                String[] textoSeparado = linea.split(", ");
                        for (String item : textoSeparado) {
                            String[] aa = item.split(";");
                            
                            if(aa[1].length()>0 && result.resultado=="Ganador") {
                                
                                puntos++;
                            } else {
                                if(aa[2].length()>0 && result.resultado=="Empate") {
                                    puntos++;
                                }else{
                                   if(aa[3].length()>0 && result.resultado=="Perdedor") {
                                    puntos++;
                                   }
                                }
                                
                                resultado = puntos;
                            }
                            
                          
                        }
                        
                        
                        
                        
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
                return resultado;
            }
        
        

}
