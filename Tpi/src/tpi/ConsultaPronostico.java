package tpi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


	public class ConsultaPronostico {
            /*String equipo1;
            String equipo2;
            String golesEquipo1;
            String golesEquipo2;*/
            public String cons1() throws FileNotFoundException{
                String[] equipos;
                List<String> aa = null;
              String resultado = "";
                String archivoResultado = "pronostico.csv";
                String nombreArchivo = "C:\\Users\\djord\\Documents\\NetBeansProjects\\Tpi\\recursos\\"+archivoResultado;
	        Path ruta = Paths.get(nombreArchivo);
	        
	        try {
	            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.ISO_8859_1);
	            for (String linea : lineas) {
	                equipos = linea.split(", ");
                        aa.add(equipos[0]);
                        System.out.println(aa);
                        
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
                return resultado;
            }
        }
             
       