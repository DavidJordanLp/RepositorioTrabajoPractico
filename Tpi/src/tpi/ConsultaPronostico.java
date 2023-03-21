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
            String cel1;
            String cel2;
            String cel3;
            
            public String consultarPronostico() throws FileNotFoundException{
                
                
              String resultado = "";
                String archivoResultado = "pronostico.csv";
                String nombreArchivo = "C:\\Users\\David\\Documents\\NetBeansProjects\\RepositorioTrabajoPractico\\Tpi\\recursos\\"+archivoResultado;
	        Path ruta = Paths.get(nombreArchivo);
	        
	        try {
	            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.ISO_8859_1);
	            for (String linea : lineas) {
	                String[] equipos = linea.split(", ");
                        for (String item : equipos) {
                            String[] aa = item.split(";");
                            if(aa[1].length()>0) {
                                cel1 = "Ganador";
                                cel2 = "-------";
                                cel3 = "-------";
                            } else {
                                if(aa[2].length()>0) {
                                    cel1 = "-------";
                                    cel2 = "Empate";
                                    cel3 = "-------";
                                }else{
                                    cel1 = "-------";
                                    cel2 = "-------";
                                    cel3 = "Ganador";
                                }
                            }
                            System.out.println(aa[0]+"|"+cel1+"|"+cel2+"|"+cel3+"|"+aa[4]);
                            System.out.println();
                        }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
                return resultado;
            }
        }
             
       