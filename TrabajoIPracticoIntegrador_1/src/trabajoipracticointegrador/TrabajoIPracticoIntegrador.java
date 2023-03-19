
package trabajoipracticointegrador;

import java.io.IOException;
import java.util.Scanner;




public class TrabajoIPracticoIntegrador {

    public static void main(String[] args) throws IOException {
        Scanner ent = new Scanner(System.in); //metodo Scanner
        Partido partido1 = new Partido(); //instancio objeto partido
        partido1.equipo1 = new Equipo(); //mediante objeto partido creo un objeto equipo1 de Equipo
        partido1.equipo2 = new Equipo(); //mediante objeto partido creo un objeto equipo2 de Equipo
        CheckRonda checkRonda = new CheckRonda();
        if(checkRonda.checkLineas()>=2) {
            Consultas cons1 = new Consultas();
            System.out.println(cons1.cons1());
        } else {
            System.out.print("Ingrese equipo N° 1: ");
            partido1.equipo1.setNombre(ent.next());

            System.out.print("Ingrese equipo N° 2: ");
            partido1.equipo2.setNombre(ent.next());

            System.out.print("Igrese cantidad de goles de "+partido1.equipo1.getNombre()+" : ");
            partido1.setGolesEquipo1(ent.nextInt());

            System.out.print("Igrese cantidad de goles de "+partido1.equipo2.getNombre()+" : ");
            partido1.setGolesEquipo2(ent.nextInt());

            System.out.println();

            partido1.resultados();
        }
    }
}
