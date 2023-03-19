
package tpi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Pronostico {
        int puntos = 0 ;
        ResultadoEnum resultadoEnum = new ResultadoEnum();
        public int consultarPronostico() throws FileNotFoundException{
                int resultado = 0;
                String archivoResultado = "pronostico.csv";
                String nombreArchivo = "C:\\Users\\djord\\Documents\\NetBeansProjects\\Tpi\\recursos\\"+archivoResultado;
	        Path ruta = Paths.get(nombreArchivo);
	        
	        try {
	            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.ISO_8859_1);
	            for (String linea : lineas) {
	                String[] textoSeparado = linea.split(";");
                        if(textoSeparado[1].length()>0){
                            puntos = 2;
                        } else {
                            if(textoSeparado[2].length()>0) {
                                puntos = 1;
                            } else {
                                puntos = 0;
                            }
                            resultado = puntos;
                        }
                        
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
                return resultado;
            }
        
        

}
