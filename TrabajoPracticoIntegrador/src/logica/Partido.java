
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
    RutaRecursos rutaRecursos = new RutaRecursos();
    ResultEnum resultadoEnum = new ResultEnum();
    Ronda ronda = new Ronda();
    private String equipo1;
    private String equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private int puntos = 0;
    private int indice = 0;
    
    
    protected List<String> addPartido () {
        
        List<String> arrayResultado = new ArrayList();
        Path ruta = Paths.get(rutaRecursos.getRutaResultados());
        try {
            List<String> files = Files.readAllLines(ruta, StandardCharsets.ISO_8859_1);
            for (String f : files) {
                String[] fila = f.split(", ");
                for (String celda : fila) {
                    String[] textoCelda = celda.split(";");
                    equipo1 = textoCelda[1];
                    golesEquipo1 = parseInt(textoCelda[2]);
                    golesEquipo2 = parseInt(textoCelda[3]);
                    equipo2 = textoCelda[4];
                    
                    
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
            indice++;
            if(indice==files.size()) {
                if(ronda.partidos.size()<1) {
                    files.add(0, "1");
                    ronda.partidos = files;
                }
                    
            }
        } catch (IOException e) {
        e.printStackTrace();
    }
    
    return arrayResultado;
}
    
        
    
}
