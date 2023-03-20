
package tpi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Pronostico {
        ResultadoEnum resutResultadoEnum = new ResultadoEnum();
        int puntos = 0 ;
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
                            String[] datosPronostico = item.split(";");
                            // va a sumar 2 puntos debido a que en pronostico se complen dos condiciones!!!
                            if(datosPronostico[1].length()>0) {
                                puntos++;
                            } else {
                                if(datosPronostico[2].length()>0) {
                                    puntos++;
                                }else{
                                   if(datosPronostico[3].length()>0) {
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
