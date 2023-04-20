package pronostico;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class TestPuntaje {

	@Test
	void test1() {
		//genero una ronda
		Ronda ronda = new Ronda();
		//creo un jugador
		Jugador jugador = new Jugador("David");
		// suponiendo que el jugador acertó un pronostico gana un punto
		ronda.addPuntos(jugador, 1);
		System.out.println(jugador.getNombre()+" gana "+ronda.getPuntos(jugador)+" punto/s");
		// suponiendo que el jugador acertó un segundo pronostico suma un punto más
		ronda.addPuntos(jugador, ronda.getPuntos(jugador)+1);
		System.out.println(jugador.getNombre()+" gana "+ronda.getPuntos(jugador)+" punto/s");
		//se espero que el jugador haya obtenido 2 puntos
		assertEquals(ronda.getPuntos(jugador), 2);
	}
	
	@Test
	void test2() {
		//genero una ronda
		Ronda ronda = new Ronda();
		//creo un jugador
		Jugador jugador = new Jugador("Carina");
		// suponiendo que el jugador acertó un pronostico gana un punto
		ronda.addPuntos(jugador, 1);
		System.out.println(jugador.getNombre()+" gana "+ronda.getPuntos(jugador)+" punto/s");
		// suponiendo que el jugador acertó un segundo pronostico suma un punto más
		ronda.addPuntos(jugador, ronda.getPuntos(jugador)+1);
		System.out.println(jugador.getNombre()+" gana "+ronda.getPuntos(jugador)+" punto/s");
		// suponiendo que el jugador acertó un segundo pronostico suma un punto más
		ronda.addPuntos(jugador, ronda.getPuntos(jugador)+1);
		System.out.println(jugador.getNombre()+" gana "+ronda.getPuntos(jugador)+" punto/s");
		//se espero que el jugador haya obtenido 3 puntos
		assertEquals(ronda.getPuntos(jugador), 3);
	}

}
