package logica;

public class Ronda {
    private String nro;
    private Partido[] partidos;

    public Ronda() {
    }
    
    public Ronda(String nro) {
        this.nro = nro;
        this.partidos = partidos;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public Partido[] getPartidos() {
        return partidos;
    }

    public void setPartidos(Partido[] partidos) {
        this.partidos = partidos;
    }
    
    public int puntos(int puntos) {
        int punto = 0;
        punto = punto+puntos;
        return punto;
    }
}
