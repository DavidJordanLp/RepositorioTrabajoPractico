
package tpi;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Partido {
        ResultadoEnum result = new ResultadoEnum();
        
        
        private String equipo1;
        private String equipo2;
        private int golesEquipo1;
        private int golesEquipo2;
        String resultado;
        
        
        String archivo = "resultados.csv";
        String nombreArchivo = "C:\\Users\\djord\\Documents\\NetBeansProjects\\Tpi\\recursos\\"+archivo;
        Path ruta = Paths.get(nombreArchivo);
        
        protected void partido() {
            
           
             try {
                    
	            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.ISO_8859_1);
	            for (String linea : lineas) {
	                String[] textoSeparado = linea.split(", ");
                         for (String item : textoSeparado) {
                            String[] aa = item.split(";");
                            equipo1 = aa[0];
                            golesEquipo1 = parseInt(aa[1]);
                            golesEquipo2 = parseInt(aa[2]);
                            equipo2 = aa[3];
                            if(golesEquipo1==golesEquipo2) {
                                result.setEmpate("Empate");
                                //System.out.println(result.getEmpate());
                            } else {
                                if(golesEquipo1>golesEquipo2) {
                                    result.setGanador("Ganador");
                                    //System.out.println(result.getGanador());
                                } else {
                                    result.setPerdedor("Perdedor");
                                    //System.out.println(result.getPerdedor());
                                }
                            }
                            System.out.println(equipo1+" | "+golesEquipo1+" | "+golesEquipo2+" | "+equipo2);
                        }
                    }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
             
        }
        
      
        }

    
    
    

