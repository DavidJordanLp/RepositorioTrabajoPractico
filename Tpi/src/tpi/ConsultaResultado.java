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


	public class ConsultaResultado {
            String equipo1;
            String equipo2;
            String golesEquipo1;
            String golesEquipo2;
            public String cons1() throws FileNotFoundException{
                String resultado = null;
                String archivoResultado = "resultados.csv";
                String nombreArchivo = "C:\\Users\\djord\\Documents\\NetBeansProjects\\Tpi\\recursos\\"+archivoResultado;
	        Path ruta = Paths.get(nombreArchivo);
	        
	        try {
	            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.ISO_8859_1);
	            for (String linea : lineas) {
	                String[] textoSeparado = linea.split(";");
                        equipo1 = textoSeparado[0];
                        golesEquipo1 = textoSeparado[1];
                        golesEquipo2 = textoSeparado[2];
                        equipo2 = textoSeparado[3];
	                resultado += equipo1+"|"+golesEquipo1+"|"+golesEquipo2+"|"+equipo2+"\n";
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
                return resultado;
            }
        }
             
       