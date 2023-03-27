package logica;

public class Ronda {
    private String nro;
     Partido[] partidos;

    public Ronda() {
    }

    public Ronda(String nro, Partido[] partidos) {
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
    
    

    
    public int puntos(int puntos) {
        int punto = 0;
        punto = punto+puntos;
        return punto;
    }
}
