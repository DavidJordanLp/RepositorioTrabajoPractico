package logica;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        RutaRecursos rutaRecursos = new RutaRecursos();
        
        if(rutaRecursos.consultarArchivos()==false) 
        {   
            System.exit(0);
        }
        
        ConsultaResultados r = new ConsultaResultados();
        r.getArchivo();
        System.out.println();
        
        ConsultaPronostico p = new ConsultaPronostico();
        p.getArchivo();
        System.out.println();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"); 
       
        Pronostico prono = new Pronostico();
        System.out.println("El jugador obtuvo "+prono.getPronostico()+" punto/s");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -"); 
        System.out.println();
        
       
        
        
        
       
        
    }
    
}