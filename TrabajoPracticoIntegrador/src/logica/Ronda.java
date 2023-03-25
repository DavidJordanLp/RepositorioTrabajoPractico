package logica;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    int puntos = 0;
    String nro;
    List<String> partidos = new ArrayList();

    public void setPartidos(List<String> partidos) {
        this.partidos = partidos;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getNro() {
        return nro;
    }
    
    
    
    protected void guardarRonda() {
        System.out.println(partidos);
    }
    
    
  }
