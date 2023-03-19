package trabajoipracticointegrador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

	public class Consultas {
            String equipo1;
            String equipo2;
            String golesEquipo1;
            String golesEquipo2;
            public String cons1() {
                String nombreArchivo = "C:\\Users\\djord\\Documents\\NetBeansProjects\\TrabajoIPracticoIntegrador\\recursos\\resultados.csv"; 
	        Path ruta = Paths.get(nombreArchivo);
	        
	        try {
	            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.ISO_8859_1);
	            
	            for (String linea : lineas) {
                        String[] textoSeparado = linea.split(";");
                        equipo1 = textoSeparado[0];
                        golesEquipo1 = textoSeparado[1];
                        golesEquipo2 = textoSeparado[2];
                        equipo2 = textoSeparado[3];
	                System.out.println(equipo1+"|"+golesEquipo1+"|"+golesEquipo2+"|"+equipo2);
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
            
                return "";
            }
	    
	   
	}
