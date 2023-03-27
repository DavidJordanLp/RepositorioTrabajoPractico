package logica;

public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultEnum resultado;

    public Pronostico() {
    }

    public Pronostico(Partido partido, Equipo equipo, ResultEnum resultado) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public ResultEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultEnum resultado) {
        this.resultado = resultado;
    }
    
    
    
    
    public int puntos(int puntosGanados) {
        int punto = 0;
        punto = punto+puntosGanados;
        return punto;
    }
}
