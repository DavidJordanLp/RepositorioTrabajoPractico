
package tpi;

import java.io.FileNotFoundException;

public class Tpi {
        public static void main(String[] args) throws FileNotFoundException {
            
           Partido partido = new Partido();
           Pronostico pronostico = new Pronostico();
            partido.resultado();
            System.out.println("El jugador posee "+pronostico.consultarPronostico()+" en esta ronda");
           }
        
}
