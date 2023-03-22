
package logica;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Equipo {
    private String equipo;
    private String descripcion;
    
    public void addPartido() throws IOException {
        String archivo = "resultados.csv";
        Scanner ent = new Scanner(System.in);
            //cambiar ruta por ruta propia
        String nombreArchivo = "C:\\Users\\David\\Documents\\NetBeansProjects\\Tpi\\recursos\\"+archivo;
        Path ruta = Paths.get(nombreArchivo);
        File f = new File(nombreArchivo);
        if(!f.exists()) {
            System.out.print("No se encuentra archivo de resultados, desea crear uno S/N?: ");
            char c = ent.next().charAt(0);
            if(c != 's' && c != 'S' && c != 'n' && c != 'N'){
                System.out.println("Ingrese caracter valido");
                addPartido();
            }
            else 
            {
            
            }
        } else {
            Pronostico prono = new Pronostico();
            Ronda ronda = new Ronda();
            System.out.println("El jugador obtuvo "+prono.getPronostico()+" puntos");
        }
        
    
    }
}
