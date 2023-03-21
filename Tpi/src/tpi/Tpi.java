
package tpi;

import java.io.FileNotFoundException;

public class Tpi {
        public static void main(String[] args) throws FileNotFoundException {
           Partido partido = new Partido();
           ConsultaPronostico consultaPronostico = new ConsultaPronostico();
           Pronostico pronostico = new Pronostico();
                  
           System.out.println("Resultados");
           System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
           partido.partido();
           System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
           
           System.out.println();
           
           System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
           consultaPronostico.consultarPronostico();
           System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
           
           System.out.println();
           
           System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
           pronostico.consultarPronostico();
           System.out.println("El jugador posee "+pronostico.consultarPronostico()+ " Puntos");
           System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
           
           
           
            
           
            
        }
        
}
