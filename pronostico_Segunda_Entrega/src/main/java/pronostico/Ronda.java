package pronostico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Ronda {
    private String nro;
    List<Partido> partidos = new ArrayList<>();
    List<Pronostico> pronosticos = new ArrayList<>();
    HashMap<Jugador,Integer> jugadoresPuntos = new HashMap<Jugador,Integer>();
   
    public Ronda() {
    }


    
    
    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }
    
    public List<Partido> getPartidos() {
        return partidos;
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    
   
    public int getPuntos(Jugador jugador) {
        int puntos = 0;
        if(jugadoresPuntos.get(jugador)!=null) {
            puntos = jugadoresPuntos.get(jugador);
        }
        return puntos ;
    }

    public int getSizePuntos() {
        return jugadoresPuntos.size();
    }
 
    
    
    public void addPartidos(Partido partido) {
        partidos.add(partido);
    }
    
    public void addPronostico(Pronostico pronostico) {
        pronosticos.add(pronostico);
    }
    
   
   
    
    public void puntos(Jugador jugador, int punto) {
        jugadoresPuntos.put(jugador, punto);
    }
    
    
 
    
    
}
