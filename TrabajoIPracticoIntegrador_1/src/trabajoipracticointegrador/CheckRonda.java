package trabajoipracticointegrador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckRonda {
    protected long checkLineas() throws FileNotFoundException {
        long resultado = 0;
        String archivo = "resultados.csv";
        String ruta = "C:\\Users\\djord\\Documents\\NetBeansProjects\\TrabajoIPracticoIntegrador_1\\recursos\\";
        String nombreArchivo = ruta+archivo;
        File getArchivo = new File(nombreArchivo);
        if(getArchivo.exists()) {
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader bf = new BufferedReader(fr);
            resultado = bf.lines().count();
        } else {
            resultado = 0;
        }
        return resultado;
    }
    
    
}
