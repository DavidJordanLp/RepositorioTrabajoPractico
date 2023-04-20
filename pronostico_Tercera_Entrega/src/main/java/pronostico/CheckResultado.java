
package pronostico;
import java.util.regex.*;

public class CheckResultado {

    public CheckResultado() {
    }
    
   
    public boolean esEntero(String golesEquipo) {
        return golesEquipo.matches("\\-?[0-9]+");
    }
    
    
}
