package pronostico;

public class Pronostico {
	private Partido partido;
        private Equipo equipo;
        private ResultadoEnum resultado;
        private Jugador jugador;
        private int punto = 0;
        

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado, Jugador jugador, int punto) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
        this.jugador = jugador;
        this.punto = punto;
    }

    public Partido getPartido() {
        return partido;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public int getPunto() {
        return punto;
    }
    
    public Equipo getEquipo() {
        return equipo;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }
    
    
    
    
        
        
	
	
}
