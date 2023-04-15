//


package logica;

import static com.sun.tools.attach.VirtualMachine.list;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import static java.nio.file.Files.list;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;

public class Tpi {
    public static void main(String[] args) throws IOException {
    RutaArchivos rutaArchivos = new RutaArchivos();
    rutaArchivos.consultarArchivos();
    List<Partido> partidos = new ArrayList();
    List<Pronostico> pronostico = new ArrayList();
    Pronostico prono = new Pronostico();
    Ronda ronda = new Ronda();
    int puntos = 0;
    
    //resultados
    Path rutaResultados = Paths.get(rutaArchivos.getRutaResultados());
    List<String> filasResultado = Files.readAllLines(rutaResultados, StandardCharsets.ISO_8859_1);
        for (int i = 0; i < filasResultado.size()-1; i++) {
            if(i!=0) {
                String f[] = filasResultado.get(i).split(";");
                int id = Integer.parseInt(f[0]);
                Equipo equipo1 = new Equipo(f[1]);
                int golesEquipo1 = Integer.parseInt(f[2]);
                int golesEquipo2 = Integer.parseInt(f[3]);
                Equipo equipo2 = new Equipo(f[4]);
                Partido partido = new Partido(id, equipo1, equipo2, golesEquipo1, golesEquipo2);
                ronda.partidos = new Partido[filasResultado.size()-1];
                ronda.partidos[i] = partido;
                partidos.add(partido);
            }
        }
        
    // pronostico
    Path rutaPronosticos = Paths.get(rutaArchivos.getRutaPronostico());
    List<String> filasPronosticos = Files.readAllLines(rutaPronosticos, StandardCharsets.ISO_8859_1);
    
        System.out.println();
        for (int i = 0; i < filasPronosticos.size()-1; i++) {
            if(i!=0) {
                String f[] = filasPronosticos.get(i).split(";");
                int id = Integer.parseInt(f[0]);
                
                String ganaEquipo1 = null;
                String ganaEquipo2 = null;
                String empate = null;
                
                if(f[2].length()>0) {
                    ganaEquipo1 = ResultEnum.Ganador.toString();
                    empate = "-------";
                    ganaEquipo2 = "-------";
                }
                
                if(f[3].length()>0) {
                    ganaEquipo1 = "-------";
                    empate = ResultEnum.Empate.toString();
                    ganaEquipo2 = "-------";
                }
                
                if(f[4].length()>0) {
                    ganaEquipo1 = "-------";
                    empate = "-------";
                    ganaEquipo2 = ResultEnum.Ganador.toString();
                }
                
                if(f[2].length()>0 || f[3].length()>0 || f[4].length()>0)
                {
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                    System.out.println("Resultado y Pronosito: "+i);
                    System.out.println(partidos.get(i-1).getEquipo1().getNombre()+" "+partidos.get(i-1).getGolesEquipo1()+"-"+partidos.get(i-1).getGolesEquipo2()+" "+partidos.get(i-1).getEquipo2().getNombre());
                    
                    if(partidos.get(i-1).getGolesEquipo1()==partidos.get(i-1).getGolesEquipo2() && f[3].length()>0) 
                    {
                        System.out.println("|"+f[1]+"|"+ganaEquipo1+"|"+empate+"|"+ganaEquipo2+"| "+f[5]+"| (Acertó pronóstico, gana un(1) punto.)");
                        prono.puntos(puntos++);
                
                    } else {
                        if(partidos.get(i-1).getGolesEquipo1()>partidos.get(i-1).getGolesEquipo2() && f[2].length()>0) 
                        {
                        System.out.println("|"+f[1]+"|"+ganaEquipo1+"|"+empate+"|"+ganaEquipo2+"| "+f[5]+"| (Acertó pronóstico, gana un(1) punto.)");
                        prono.puntos(puntos++);
                        } else {
                            if(partidos.get(i-1).getGolesEquipo1()<partidos.get(i-1).getGolesEquipo2() && f[4].length()>0) 
                            {
                        System.out.println("|"+f[1]+"|"+ganaEquipo1+"|"+empate+"|"+ganaEquipo2+"|"+f[5]+"| (Acertó pronóstico, gana un(1) punto.)");
                        prono.puntos(puntos++); 
                            }
                            else
                            {
                                System.out.println("|"+f[1]+"|"+ganaEquipo1+"|"+empate+"|"+ganaEquipo2+"|"+f[5]+"| (No acertó)");
                            }
                        }
                    }
                    
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                    System.out.println();
                    ronda.setNro("1");
                    ronda.puntos(prono.puntos(puntos));
                } 
            }
        }
        
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        String textPunto = null;
        if(prono.puntos(puntos)>1)
        {
            textPunto = ronda.puntos(puntos)+" puntos";
        }
        else
        {
            textPunto = ronda.puntos(puntos)+" punto";
        }
        
        
        System.out.println("El jugador obtuvo un total de "+textPunto+" en esta ronda.");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println();
        System.out.println("Trabajo practico realizado por \nMaria Esther Rivarola  \n" +
                            "Leonardo Pedalino  \n" +
                            "Gloria Elisabet Pérez  \n" +
                            "federico ferrari \n" +
                            "David Jordan \n");
        System.exit(0);
    }
}
