
package pronostico;
import java.util.regex.Pattern;

public class CheckResultado {

    public CheckResultado() {
    }
    
   
    public boolean esEntero(String golesEquipo) {
        return golesEquipo.matches("\\-?[0-9]+");
    }
    
    
}
