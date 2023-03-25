
package logica;

import java.io.IOException;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ConsultaResultados {
        RutaRecursos rutaRecursos = new RutaRecursos();
        Scanner ent = new Scanner(System.in);
        
        public void getArchivo() throws IOException {
            String archivo = "resultados.csv";
            //cambiar ruta por ruta propia
            
            String nombreArchivo = rutaRecursos.getRutaRecursos()+archivo;
            Path ruta = Paths.get(nombreArchivo);
            List<String> files = Files.readAllLines(ruta, StandardCharsets.ISO_8859_1);
            System.out.println("Resultados");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
            for (String f : files) {
                String[] celda = f.split(", ");
                for(String textoCelda:celda) {
                    System.out.println(textoCelda.replace(";", "   |   "));
                }
            }  
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
        }
}
