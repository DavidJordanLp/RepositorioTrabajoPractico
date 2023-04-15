package pronostico;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        RutaArchivos rutaArchivos = new RutaArchivos();
        Path rutaResultados = Paths.get(rutaArchivos.getRutaResultados());
        Path rutaPronostico = Paths.get(rutaArchivos.getRutaPronostico());
        ArrayList<Ronda> rondas = new ArrayList<>();
        ArrayList<Jugador> jugadores = new ArrayList<>();
        CheckResultado checkResultado= new CheckResultado();
       
        int indRonda = 0;
            
        try (BufferedReader reader = Files.newBufferedReader(rutaResultados, StandardCharsets.UTF_8)) {
            reader.readLine();
            String linea;
            //modelo ronda
            Ronda ronda = null;
           
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                String nroRonda = partes[1];
                    
                    //verificar que golesEquipo1 o golesEquipo2 sea un entero
                    if(!checkResultado.esEntero(partes[3]) || !checkResultado.esEntero(partes[4])) {
                        System.out.println("golesEquipo1 o golesEquipo2 NO es un entero");
                        System.exit(0);
                    } 
                    
                    
                    // verfificamos cantidad correcta de campos
                    if(partes.length<6 || partes.length>6) {
                            System.out.println("Cantidad de campos incorrecta");
                        System.exit(0);
                    }
                
                
                // solo modela si el partido pertence a una ronda
                if(nroRonda.length()>0) {
                    // modelado rondas en base al mayor numero de ronda del archivo resultados
                    while(indRonda<Integer.parseInt(nroRonda)) {
                        ronda = new Ronda();
                        ronda.setNro(Integer.toString(indRonda+1));
                        rondas.add(ronda);
                        indRonda++;
                    }
                        
                    int id = Integer.parseInt(partes[1]);
                    Equipo equipo1 = new Equipo(partes[2]);
                    int golesEquipo1 = Integer.parseInt(partes[3]);
                    int golesEquipo2 = Integer.parseInt(partes[4]);
                    Equipo equipo2 = new Equipo(partes[5]);
                    
                    Partido partido = new Partido(id, equipo1, equipo2, golesEquipo1, golesEquipo2);
                    rondas.get(Integer.parseInt(nroRonda)-1).addPartidos(partido);
                }
                                 
            }
        } catch (NoSuchFileException e) {
            System.out.println("No se encontro archivo resultados.csv, verifique que exista en la carpeta recursos y su ruta en la clase RutaArchivos.java, String rutaResultados");
        }
        Jugador jugador = null;
        try (BufferedReader reader = Files.newBufferedReader(rutaPronostico, StandardCharsets.UTF_8)) {
            reader.readLine();
            String linea;
                try {
                
                   
                    while ((linea = reader.readLine()) != null) {
                        String partes[] = linea.split(";");
                        String nombreJugador = partes[0];
                        
                        // solo entra si campos ganaEquipo1, Empate, ganaEquipo2 contienen al menos un caracter (OJO ESPACIOS)
                        if(partes[2].length()>0 || partes[3].length()>0 || partes[4].length()>0) {
                            for (int i = 0; i < rondas.size(); i++) {
                                for (int k = 0; k < rondas.get(i).getPartidos().size(); k++) {
                                    if(rondas.get(i).partidos.get(k).getEquipo1().getNombre().contains(partes[1]) && rondas.get(i).partidos.get(k).getEquipo2().getNombre().contains(partes[5])){
                                    
                                    // condicional para no crear objetos del mismo jugador n veces solo crea un objeto por jugador
                                    if(jugador==null) {
                                        jugador = new Jugador(nombreJugador);
                                        jugadores.add( jugador);
                                    } else if(!jugador.getNombre().contains(nombreJugador)) {
                                        jugador = new Jugador(nombreJugador);
                                        jugadores.add( jugador);
                                    } 
                                    
                                    // modelo equipo y pronostico
                                    Equipo equipoPronostico = null;
                                    Pronostico pronostico = null;
                                // si equipo1 gana y jugador acertó
                                if(rondas.get(i).partidos.get(k).getGolesEquipo1()>rondas.get(i).partidos.get(k).getGolesEquipo2() && partes[2].length()>0){
                                    //modelado equipo y pronostico a partir del molde anterior (se agrego punto a pronostico para mostrar en pantalla punto GANADO) "Se repite en else if"
                                    equipoPronostico = rondas.get(i).partidos.get(k).getEquipo1();
                                    pronostico = new Pronostico(rondas.get(i).partidos.get(k), equipoPronostico, ResultadoEnum.Ganador, jugador, 1);
                                    //HashMap puntos por jugador en Ronda "Se repite en else if"
                                    rondas.get(i).puntos(jugador, rondas.get(i).getPuntos(jugador)+1);
                                   
                                       // si empate y jugador acertó
                                       } else if(rondas.get(i).partidos.get(k).getGolesEquipo1()==rondas.get(i).partidos.get(k).getGolesEquipo2() && partes[3].length()>0) {
                                        // creo un equipo para manejar empate
                                        Equipo empate = new Equipo("EMPATE");
                                        equipoPronostico = empate;
                                        pronostico = new Pronostico(rondas.get(i).partidos.get(k), equipoPronostico, ResultadoEnum.Ganador, jugador,1);
                                        rondas.get(i).puntos(jugador, rondas.get(i).getPuntos(jugador)+1);
                                     
                                       // si equipo2 gana y jugador acertó
                                       } else if(rondas.get(i).partidos.get(k).getGolesEquipo1()<rondas.get(i).partidos.get(k).getGolesEquipo2() && partes[4].length()>0){
                                            equipoPronostico = rondas.get(i).partidos.get(k).getEquipo2();
                                            pronostico = new Pronostico(rondas.get(i).partidos.get(k), equipoPronostico, ResultadoEnum.Ganador, jugador,1);
                                            rondas.get(i).puntos(jugador, rondas.get(i).getPuntos(jugador)+1);
                                            
                                       //si jugador pronostico gana equipo1 y erró    
                                       } else if(partes[2].length()>0){
                                            equipoPronostico = rondas.get(i).partidos.get(k).getEquipo1();
                                            pronostico = new Pronostico(rondas.get(i).partidos.get(k), equipoPronostico, ResultadoEnum.Perderdor, jugador,0);
                                            rondas.get(i).puntos(jugador, rondas.get(i).getPuntos(jugador)+0);
                                       //si jugador pronostico empate y erró         
                                       } else if(partes[3].length()>0) {
                                            Equipo empate = new Equipo("EMPATE");
                                            equipoPronostico = empate;
                                            pronostico = new Pronostico(rondas.get(i).partidos.get(k), equipoPronostico, ResultadoEnum.Perderdor, jugador,0);
                                            rondas.get(i).puntos(jugador, rondas.get(i).getPuntos(jugador)+0);
                                            
                                       //si jugador pronostico gana equipo2 y erró       
                                       } else {
                                            equipoPronostico = rondas.get(i).partidos.get(k).getEquipo2();
                                            pronostico = new Pronostico(rondas.get(i).partidos.get(k), equipoPronostico, ResultadoEnum.Perderdor, jugador,0);
                                            rondas.get(i).puntos(jugador, rondas.get(i).getPuntos(jugador)+0);
                                       }
                                       rondas.get(i).addPronostico(pronostico);
                                   }
                                }
                            }
                        }
                    }
        
    } catch (NoSuchFileException e) {
                System.out.println("No se encontro archivo pronostico.csv, verifique que exista en la carpeta recursos y su ruta en la clase RutaArchivos.java, String rutaPronostico");
        System.exit(0);
    }
            int corteControl1 = 0;
            int corteControl2 = 0;
            while(corteControl1<rondas.size()) {
                int pronosticoSize = rondas.get(corteControl1).getPronosticos().size();
                int partidosSize = rondas.get(corteControl1).getPartidos().size();
                System.out.println();
                System.out.println("-------------------------------------- (RONDA: "+rondas.get(corteControl1).getNro()+" RESULTADOS) --------------------------------------");
                while(corteControl2<partidosSize) {
                    System.out.print("Partido "+(corteControl2+1)+": ("+rondas.get(corteControl1).getPronosticos().get(corteControl2).getPartido().getEquipo1().getNombre()+": ");
                    System.out.print(rondas.get(corteControl1).getPronosticos().get(corteControl2).getPartido().getGolesEquipo1()+"-");
                    System.out.print(rondas.get(corteControl1).getPronosticos().get(corteControl2).getPartido().getGolesEquipo2()+" :");
                    System.out.print(rondas.get(corteControl1).getPronosticos().get(corteControl2).getPartido().getEquipo2().getNombre()+")");
                    System.out.print("  |  ");
                    corteControl2++;
                }
                System.out.println();
                System.out.println("-------------------------------------- (RONDA "+rondas.get(corteControl1).getNro()+" PRONOSTICOS) --------------------------------------");
                System.out.println();
                for (int i = 0; i < pronosticoSize; i++) {
                    System.out.print(rondas.get(corteControl1).getPronosticos().get(i).getJugador().getNombre());
                    System.out.print(" ");
                    if(!rondas.get(corteControl1).getPronosticos().get(i).getEquipo().getNombre().equals("EMPATE")) {
                        System.out.print("(Gana "+rondas.get(corteControl1).getPronosticos().get(i).getEquipo().getNombre()+")");
                    } else {
                        System.out.print("("+rondas.get(corteControl1).getPronosticos().get(i).getEquipo().getNombre()+")");
                    }
                    System.out.print(" ");
                    System.out.print(rondas.get(corteControl1).getPronosticos().get(i).getResultado()+" \""+rondas.get(corteControl1).getPronosticos().get(i).getPunto()+" Punto/s\"");
                    System.out.println();
                    
                    
                }
                System.out.println();
                System.out.println("-------------------------------------- PUNTAJE RONDA "+rondas.get(corteControl1).getNro()+" --------------------------------------");
                
                for (int i = 0; i < jugadores.size(); i++) {
                    System.out.print(jugadores.get(i).getNombre()+" "+rondas.get(corteControl1).getPuntos(jugadores.get(i))+" Punto/s - ");
                }
                System.out.println();
                System.out.println("----------------------------------------------------------------------------------------------------------------");
                corteControl1++;
                corteControl2=0;
            }
        System.exit(0);
    }
    }
}

