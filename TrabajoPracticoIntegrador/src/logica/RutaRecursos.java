package logica;
import java.io.File;

public class RutaRecursos {
    private String rutaRecursos = "C:\\Users\\djord\\Documents\\RepositorioTrabajoPractico\\TrabajoPracticoIntegrador\\recursos\\";
        File rutaPronostico = new File("C:\\Users\\djord\\Documents\\RepositorioTrabajoPractico\\TrabajoPracticoIntegrador\\recursoss\\pronostico.csv");
        File rutaResultados = new File("C:\\Users\\djord\\Documents\\RepositorioTrabajoPractico\\TrabajoPracticoIntegrador\\recursos\\resultados.csv");
        

    public String getRutaRecursos() {
        return rutaRecursos;
    }
    
    protected boolean consultarArchivos() {
            boolean retornar = false;
            if(!rutaPronostico.exists() || !rutaResultados.exists()) {
                System.out.println("No se encontro la ruta o los archivos, verifique que el archivo exista y su ruta sea la correcta");
                retornar = false;
            } 
            else
            {
                retornar = true;
            }
 
            
            
            return retornar;
    }
    
    
    
    
}
