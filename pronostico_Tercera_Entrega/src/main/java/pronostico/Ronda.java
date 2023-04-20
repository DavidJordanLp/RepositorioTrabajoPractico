package pronostico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ronda {
    private String nro;
    final List<Partido> partidos = new ArrayList<>();
    private final List<Pronostico> pronosticos = new ArrayList<>();
    private final HashMap<Jugador,Integer> jugadoresPuntos = new HashMap<>();
    private final HashMap<Jugador,Integer> puntosRonda = new HashMap<>();
   
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
    
    public int getPuntosRonda(Jugador jugador) {
        int puntos = 0;
        if(puntosRonda.get(jugador)!=null) {
            puntos = puntosRonda.get(jugador);
        }
        return puntos ;
    }

    public void addPartidos(Partido partido) {
        partidos.add(partido);
    }
    
    public void addPronostico(Pronostico pronostico) {
        pronosticos.add(pronostico);
    }
    
    public void addPuntos(Jugador jugador, int punto) {
        jugadoresPuntos.put(jugador, punto);
    }
    
    public void addPuntosRonda(Jugador jugador, int punto) {
        puntosRonda.put(jugador, punto);
    }
}
