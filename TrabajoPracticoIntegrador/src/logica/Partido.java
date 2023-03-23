
package logica;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Partido {
    ResultEnum resultadoEnum = new ResultEnum();
    Ronda ronda = new Ronda();
    private String equipo1;
    private String equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private int puntos = 0;
    
    protected List<String> addPartido () {
        
        List<String> arrayResultado = new ArrayList();
        
        String archivo = "resultados.csv";
        //cambiar ruta por ruta propia
        String nombreArchivo = "C:\\Users\\David\\Documents\\NetBeansProjects\\TrabajoPracticoIntegrador_GRUPO F\\recursos\\"+archivo;
        Path ruta = Paths.get(nombreArchivo);
        try {
            List<String> files = Files.readAllLines(ruta, StandardCharsets.ISO_8859_1);
            for (String f : files) {
                String[] fila = f.split(", ");
                for (String celda : fila) {
                    String[] textoCelda = celda.split(";");
                    equipo1 = textoCelda[0];
                    golesEquipo1 = parseInt(textoCelda[1]);
                    golesEquipo2 = parseInt(textoCelda[2]);
                    equipo2 = textoCelda[3];
                    
                    ronda.partidos.add(textoCelda[0]+";"+textoCelda[1]+";"+textoCelda[2]+";"+textoCelda[3]);
                    
                    
                    if(golesEquipo1==golesEquipo2) {
                        resultadoEnum.setEmpate("Empate");
                        arrayResultado.add(resultadoEnum.getEmpate());
                    } 
                    else 
                    {
                        if(golesEquipo1>golesEquipo2) {
                            resultadoEnum.setGanador("Ganador");
                            arrayResultado.add(resultadoEnum.getGanador());
                        } 
                        else 
                        {
                            resultadoEnum.setPerdedor("Perdedor");
                            arrayResultado.add(resultadoEnum.getPerdedor());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
    }
    
    return arrayResultado;
}
    
        
    
}
