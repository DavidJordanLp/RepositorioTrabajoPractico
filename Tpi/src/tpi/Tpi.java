
package tpi;

import java.io.FileNotFoundException;

public class Tpi {
        public static void main(String[] args) throws FileNotFoundException {
           Partido partido = new Partido();
           ConsultaPronostico consultaPronostico = new ConsultaPronostico();
           Pronostico pronostico = new Pronostico();
           
           
           System.out.println("Resultados");
           System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
           partido.getArchivoResultado();
           System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
           
           System.out.println();
           
           System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
           consultaPronostico.cons1();
           System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
           
           System.out.println();
           
           System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
           partido.resultado();
           System.out.println("El jugador posee "+pronostico.consultarPronostico()+" en esta ronda");
           System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
           System.out.println();
           System.out.println();
           
           
            
           
            
        }
        
}
