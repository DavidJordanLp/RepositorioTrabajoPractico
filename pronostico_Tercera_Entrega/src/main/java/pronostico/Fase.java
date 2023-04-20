package pronostico;

import java.util.ArrayList;
import java.util.HashMap;

public class Fase {
	private String nro;
	private final ArrayList<Ronda> rondas = new ArrayList<>();
        private final HashMap<Jugador, Ronda> puntosFase = new HashMap<>();
	
	public Fase() {
	}

        public String getNro() {
            return nro;
        }

        public void setNro(String nro) {
            this.nro = nro;
        }

        public ArrayList<Ronda> getRondas() {
		return rondas;
	}

	public void addRonda(Ronda ronda) {
		rondas.add(ronda);
	}
        
        public int getPuntosFaseSize() {
            return puntosFase.size();
        }
        
         public Ronda getPuntosFase(Jugador jugador) {
            return puntosFase.get(jugador);
        }
        
        public void addPuntosFase(Jugador jugador, Ronda ronda) {
            puntosFase.put(jugador, ronda);
        }

}
