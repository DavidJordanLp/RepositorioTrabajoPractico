package trabajoipracticointegrador;

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


	public  class Consultas1 {
            public String cons1() throws FileNotFoundException{
              String resultado = null;
              String nombreArchivo = "C:\\Users\\lucas\\OneDrive\\Escritorio\\Curso Java\\resultadosCSV.csv"; //Ruta de acceso al excel a leer
	        Path ruta = Paths.get(nombreArchivo);
	        
	        try {
	            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.ISO_8859_1);
	            for (String linea : lineas) {
	                resultado = linea.replace(';', '|');
	                System.out.println();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
                return resultado;
            }
        }
             
       