package pronostico;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws IOException {
        RutaArchivos rutaArchivos = new RutaArchivos();
        Path rutaResultados = Paths.get(rutaArchivos.getRutaResultados());
        //Path rutaPronostico = Paths.get(rutaArchivos.getRutaPronostico()); // desde archivo
        Path configuracion = Paths.get(rutaArchivos.getConfiguracion()); // BD y Puntos
        ArrayList<Ronda> rondas = new ArrayList<>();
        ArrayList<Jugador> jugadores = new ArrayList<>();
        ArrayList<Fase> fases = new ArrayList<>();
        CheckResultado checkResultado= new CheckResultado();
        ArrayList<String> contidadRondasPorFase = new ArrayList<>(); 
        
        //variables globales
        int indFase = 0;
        int num = 0;
        int num1 = 0;
        int puntoRondaCompleta = 0;
        int puntosGanador = 0;
        int puntosEmpate = 0;
        int puntosPerdedor = 0;
        int puntosNoAcierta= 0;
        int puntosFaseCompleta= 0;
        int corteControl1 = 0;
        int corteControl2 = 0;
        String numFase = "";
        //
            
        try (BufferedReader reader = Files.newBufferedReader(rutaResultados, StandardCharsets.UTF_8)) {
            // crea fase, ronda y partido independientemente del orden de fase y ronda.
            reader.readLine();
            String linea;
            //modelo ronda
            Ronda ronda = null;
            //modelo fase
            Fase fase = null;
           
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                String nroRonda = partes[1];
                String nroFase = partes[6];
                    
                    //verificar que golesEquipo1 o golesEquipo2 sea un entero
                    if(!checkResultado.esEntero(partes[3]) || !checkResultado.esEntero(partes[4])) {
                        System.out.println("golesEquipo1 o golesEquipo2 NO es un entero");
                        System.exit(0);
                    } 
                    
                    // verfificamos cantidad correcta de campos
                    if(partes.length<7 || partes.length>7) {
                            System.out.println("Cantidad de campos incorrecta");
                        System.exit(0);
                    }
                
                    // solo modela si el partido pertence a una ronda
                    if(nroRonda.length()>0) {
                        // modelado rondas en base al mayor numero de ronda del archivo resultados

                        if(contidadRondasPorFase.indexOf(nroFase+"|"+nroRonda)==-1) {
                           contidadRondasPorFase.add(nroFase+"|"+nroRonda);
                        }

                        while(num<contidadRondasPorFase.size()) {
                            ronda = new Ronda();
                            rondas.add(ronda);
                            num++;
                        }

                        while(indFase<Integer.parseInt(nroFase)) {
                            fase = new Fase();
                            fase.setNro(Integer.toString(indFase+1));
                            fases.add(fase);
                            indFase++;
                        }

                        int indexRonda = Integer.parseInt(nroRonda)-1;
                        int indexFase = Integer.parseInt(nroFase)-1;

                        if(num1<contidadRondasPorFase.size()) {
                            rondas.get(num1).setNro(nroRonda);
                            fases.get(indexFase).addRonda(rondas.get(num1));
                            num1++;
                        }

                        int id = Integer.parseInt(partes[1]);
                        Equipo equipo1 = new Equipo(partes[2]);
                        int golesEquipo1 = Integer.parseInt(partes[3]);
                        int golesEquipo2 = Integer.parseInt(partes[4]);
                        Equipo equipo2 = new Equipo(partes[5]);

                        Partido partido = new Partido(id, equipo1, equipo2, golesEquipo1, golesEquipo2);
                        fases.get(indexFase).getRondas().get(indexRonda).addPartidos(partido);
                    }
            }
        } catch (NoSuchFileException e) {
            System.out.println("No se encontro archivo resultados.csv, verifique que exista en la carpeta recursos y su ruta en la clase RutaArchivos.java, String rutaResultados");
        }
        
        //modelo jugador
        Jugador jugador = null;
        
        try (BufferedReader reader = Files.newBufferedReader(configuracion, StandardCharsets.UTF_8)) {
            reader.readLine();
            String linea = reader.readLine();
            String config[] = linea.split(";");
            //DAtos configuracion
            String url = config[0];
            int puerto = Integer.parseInt(config[1]);
            String BD = config[2];
            String user = config[3];
            String pass="";
                if(config[4].length()<1) {
                    pass = "";
                } else {
                    pass = config[4];
                }
            // Configuracion de puntos
            puntosGanador = Integer.parseInt(config[5]); // 3 puntos
            puntosEmpate = Integer.parseInt(config[6]); // 1 Punto
            puntosPerdedor = Integer.parseInt(config[7]); //2 Puntos
            puntosNoAcierta = Integer.parseInt(config[8]); //0 Puntos
            puntoRondaCompleta = Integer.parseInt(config[9]); //4 Puntos
            puntosFaseCompleta = Integer.parseInt(config[10]); //6 Puntos
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://"+url+":"+puerto+"/"+BD, user,pass);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado=sentencia.executeQuery("SELECT * FROM datos_pronosticos");
            while(resultado.next()) {
                //Datod bd
            	String nombreJugador = resultado.getString(2);
            	String equipo1 = resultado.getString(3);
            	String ganaEquipo1 = resultado.getString(4);
            	String empatado = resultado.getString(5);
            	String ganaEquipo2 = resultado.getString(6);
            	String equipo2 = resultado.getString(7);
            	
            	// modela si existe un pronoóstico en la tupla (no vacio)
                if(ganaEquipo1.length()>0 || empatado.length()>0 || ganaEquipo2.length()>0) {
                    for (int i = 0; i < rondas.size(); i++) {
                        for (int k = 0; k < rondas.get(i).getPartidos().size(); k++) {
                            if(rondas.get(i).partidos.get(k).getEquipo1().getNombre().contains(equipo1) && rondas.get(i).partidos.get(k).getEquipo2().getNombre().contains(equipo2)){
                            
                            // condicional para no crear objetos del mismo jugador n veces solo crea un objetoJugador por jugador
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
                        if(rondas.get(i).partidos.get(k).getGolesEquipo1()>rondas.get(i).partidos.get(k).getGolesEquipo2() && ganaEquipo1.length()>0){
                            //modelado equipo y pronostico a partir del molde anterior (se agrego punto a pronostico para mostrar en pantalla punto GANADO) "Se repite en else if"
                            equipoPronostico = rondas.get(i).partidos.get(k).getEquipo1();
                            //modela pronostico
                            pronostico = new Pronostico(rondas.get(i).partidos.get(k), equipoPronostico, ResultadoEnum.Ganador, jugador, puntosGanador);
                           //Gana puntos por acierto pronóstico
                            rondas.get(i).addPuntos(jugador, rondas.get(i).getPuntos(jugador)+puntosGanador);
                            // acumulador de aciertos si es igual a la cantidad de partidos por ronda SUMA punto por ronda completa
                            rondas.get(i).addPuntosRonda(jugador, rondas.get(i).getPuntosRonda(jugador)+1);
                           
                           
                               // si empate y jugador acertó
                               } else if(rondas.get(i).partidos.get(k).getGolesEquipo1()==rondas.get(i).partidos.get(k).getGolesEquipo2() && empatado.length()>0) {
                                // creo un equipo para manejar empate
                                Equipo empate = new Equipo("EMPATE");
                                equipoPronostico = empate;
                                //modela pronostico
                                pronostico = new Pronostico(rondas.get(i).partidos.get(k), equipoPronostico, ResultadoEnum.Ganador, jugador,puntosEmpate);
                                //Gana puntos por acierto pronóstico
                                rondas.get(i).addPuntos(jugador, rondas.get(i).getPuntos(jugador)+puntosEmpate);
                                // acumulador de aciertos, si es igual a la cantidad de partidos por ronda SUMA punto por ronda completa
                                rondas.get(i).addPuntosRonda(jugador, rondas.get(i).getPuntosRonda(jugador)+1);
                                // si equipo2 gana y jugador acertó
                               } else if(rondas.get(i).partidos.get(k).getGolesEquipo1()<rondas.get(i).partidos.get(k).getGolesEquipo2() && ganaEquipo2.length()>0){
                                    equipoPronostico = rondas.get(i).partidos.get(k).getEquipo2();
                                    //modela pronostico
                                    pronostico = new Pronostico(rondas.get(i).partidos.get(k), equipoPronostico, ResultadoEnum.Ganador, jugador,puntosGanador);
                                    //Gana puntos por acierto pronóstico
                                    rondas.get(i).addPuntos(jugador, rondas.get(i).getPuntos(jugador)+puntosGanador);
                                    // acumulador de aciertos si es igual a la cantidad de partidos por ronda SUMA punto por ronda completa
                                    rondas.get(i).addPuntosRonda(jugador, rondas.get(i).getPuntosRonda(jugador)+1);
                                    
                               //si jugador pronostico gana equipo1 y erró    
                               } else if(ganaEquipo1.length()>0){
                                    equipoPronostico = rondas.get(i).partidos.get(k).getEquipo1();
                                    //modela pronostico
                                    pronostico = new Pronostico(rondas.get(i).partidos.get(k), equipoPronostico, ResultadoEnum.Perderdor, jugador,puntosNoAcierta);                                   
                                    //no suma puntos por errar pronóstico
                                    rondas.get(i).addPuntos(jugador, rondas.get(i).getPuntos(jugador)+puntosNoAcierta);
                                    // acumulador de aciertos si es igual a la cantidad de partidos por ronda NO SUMA punto por ronda completa
                                     rondas.get(i).addPuntosRonda(jugador, rondas.get(i).getPuntosRonda(jugador)+0);
                               //si jugador pronostico empate y erró         
                               } else if(empatado.length()>0) {
                                    Equipo empate = new Equipo("EMPATE");
                                    equipoPronostico = empate;
                                    //modela pronostico
                                    pronostico = new Pronostico(rondas.get(i).partidos.get(k), equipoPronostico, ResultadoEnum.Perderdor, jugador,puntosNoAcierta);
                                    //no suma puntos por errar pronóstico
                                    rondas.get(i).addPuntos(jugador, rondas.get(i).getPuntos(jugador)+puntosNoAcierta);
                                    // acumulador de aciertos si es igual a la cantidad de partidos por ronda NO SUMA punto por ronda completa
                                    rondas.get(i).addPuntosRonda(jugador, rondas.get(i).getPuntosRonda(jugador)+0);
                                    
                               //si jugador pronostico gana equipo2 y erró       
                               } else {
                                    equipoPronostico = rondas.get(i).partidos.get(k).getEquipo2();
                                    //modela pronostico
                                    pronostico = new Pronostico(rondas.get(i).partidos.get(k), equipoPronostico, ResultadoEnum.Perderdor, jugador,puntosNoAcierta);
                                    //no suma puntos por errar pronóstico
                                    rondas.get(i).addPuntos(jugador, rondas.get(i).getPuntos(jugador)+puntosNoAcierta);
                                    // acumulador de aciertos si es igual a la cantidad de partidos por ronda NO SUMA punto por ronda completa
                                    rondas.get(i).addPuntosRonda(jugador, rondas.get(i).getPuntosRonda(jugador)+0);
                               }
                               rondas.get(i).addPronostico(pronostico);
                           }
                        }
                    }
                }
            }
        } catch (Exception e) {
        	System.out.println("Se produjo una falla en la conexion con la base de datos");
                System.exit(0);
        }
        // fin pronóstico BD
        
        // puntos extras si acierta todas las rondas de todas las fases
        
            
        
            /*for(Fase f:fases){
                for (int i = 0; i < jugadores.size(); i++) {
                    System.out.print(f.getNro()+"-"+jugadores.get(i).getNombre()+" - "+ (f.getRondas().get(0).getPartidos().size() + f.getRondas().get(1).getPartidos().size())+"-->");
                    System.out.print(f.getRondas().get(0).getPuntosRonda(jugadores.get(i))+f.getRondas().get(1).getPuntosRonda(jugadores.get(i)));
                    System.out.println();
                }
            }*/
 
                
        
        //
        
        // comienzo datos consola
        while(corteControl1<rondas.size()) {
            //captura N de fase
            for(Fase f:fases){
                if(f.getRondas().indexOf(rondas.get(corteControl1))!=-1) {
                    numFase = f.getNro();
                }
            }
            
            //cantidad de partidos y pronosticos por Ronda
            int partidosSize = rondas.get(corteControl1).getPartidos().size();
            int pronosticoSize = rondas.get(corteControl1).getPronosticos().size();
            
            System.out.println();
            System.out.println("-------------------------------------- (RESULTADOS FASE: "+numFase+" - RONDA: "+rondas.get(corteControl1).getNro()+") --------------------------------------");
            //imprime resultado
           
            while(corteControl2<partidosSize) {
                System.out.print("Partido "+(corteControl2+1)+": ("+rondas.get(corteControl1).getPronosticos().get(corteControl2).getPartido().getEquipo1().getNombre()+": ");
                System.out.print(rondas.get(corteControl1).getPronosticos().get(corteControl2).getPartido().getGolesEquipo1()+"-");
                System.out.print(rondas.get(corteControl1).getPronosticos().get(corteControl2).getPartido().getGolesEquipo2()+" :");
                System.out.print(rondas.get(corteControl1).getPronosticos().get(corteControl2).getPartido().getEquipo2().getNombre()+")");
                System.out.print("  |  ");
                corteControl2++;
            }
            System.out.println();
            
            //imprime pronostico
           System.out.println("-------------------------------------- (PRONOSTICOS FASE: "+numFase+" - RONDA "+rondas.get(corteControl1).getNro()+") --------------------------------------");
            System.out.println();
            System.out.println("JUGADOR\t -  PRONOSTICO  \t - RESULTADO PRONOSTICO \t - PUNTOS OBTENIDOS");
            System.out.println();
            for (int i = 0; i < pronosticoSize; i++) {
                System.out.print(rondas.get(corteControl1).getPronosticos().get(i).getJugador().getNombre()+"\t -  ");
               
                if(!rondas.get(corteControl1).getPronosticos().get(i).getEquipo().getNombre().equals("EMPATE")) {
                    System.out.print("(Gana "+rondas.get(corteControl1).getPronosticos().get(i).getEquipo().getNombre()+")\t -  ");
                } else {
                    System.out.print("("+rondas.get(corteControl1).getPronosticos().get(i).getEquipo().getNombre()+")      \t -  ");
                }
                
                // capturamos punto partido
                int punto = rondas.get(corteControl1).getPronosticos().get(i).getPunto();
                
                System.out.print(rondas.get(corteControl1).getPronosticos().get(i).getResultado()+"\t\t\t - \""+punto+" Punto/s\"");
                System.out.println();
            }
            System.out.println();
            System.out.println("------------------------------------------ PUNTAJE FASE: "+numFase+" - RONDA: "+rondas.get(corteControl1).getNro()+" ------------------------------------------");
            
                for (int i = 0; i < jugadores.size(); i++) {
                    System.out.print(jugadores.get(i).getNombre());
                    
                    //otorga puntos extra por ronda completa si puntos ronda = cantidad de partidos ronda
                    if(rondas.get(corteControl1).partidos.size()==rondas.get(corteControl1).getPuntosRonda(jugadores.get(i))) {
                        rondas.get(corteControl1).addPuntos(jugadores.get(i),rondas.get(corteControl1).getPuntos(jugadores.get(i))+puntoRondaCompleta);
                        System.out.print(" "+rondas.get(corteControl1).getPuntos(jugadores.get(i)));
                        System.out.print(" ("+(rondas.get(corteControl1).getPuntos(jugadores.get(i))-puntoRondaCompleta)+"+"+puntoRondaCompleta+" Ronda Completa)");
                        System.out.print(" Punto/s - ");
                    } else {
                        System.out.print(" "+rondas.get(corteControl1).getPuntos(jugadores.get(i))+" Punto/s - ");
                    }
                }
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();
            
            corteControl1++;
            corteControl2=0;
          }
            
                for (int i = 0; i < jugadores.size(); i++) {
            for(Fase f:fases){
                // abre if
                if(   (f.getRondas().get(0).getPartidos().size() + f.getRondas().get(1).getPartidos().size())  
                      ==  
                      (f.getRondas().get(0).getPuntosRonda(jugadores.get(i))+f.getRondas().get(1).getPuntosRonda(jugadores.get(i)))
                  )
                {
                    rondas.get(0).addPuntos(jugadores.get(i), f.getRondas().get(0).getPuntos(jugadores.get(i))+puntosFaseCompleta);
                    System.out.println("JUGADOR: "+ jugadores.get(i).getNombre()+" - FASE: "+f.getNro()+" "+" PUNTOS: "+(f.getRondas().get(0).getPuntos(jugadores.get(i))+f.getRondas().get(1).getPuntos(jugadores.get(i)))+" (Puntos total: "+((f.getRondas().get(0).getPuntos(jugadores.get(i))+f.getRondas().get(1).getPuntos(jugadores.get(i)))-puntosFaseCompleta)+" - Puntos fases completas: "+puntosFaseCompleta+")");
                } else {
                     System.out.println("JUGADOR: "+ jugadores.get(i).getNombre()+" - FASE: "+f.getNro()+" "+" PUNTOS: "+(f.getRondas().get(0).getPuntos(jugadores.get(i))+f.getRondas().get(1).getPuntos(jugadores.get(i))));
                }
                //cierra if
                    
                }
            }
        System.exit(0);
    }
}

