package logica;
import java.io.File;

public class RutaArchivos {
    protected String rutaPronostico = "C:\\Users\\djord\\Documents\\NetBeansProjects\\Tpi\\recursos\\pronostico.csv";
    protected String rutaResultados = "C:\\Users\\djord\\Documents\\NetBeansProjects\\Tpi\\recursos\\resultados.csv";
        
    protected String getRutaPronostico() {
        return rutaPronostico;
    }
    
    protected String getRutaResultados() {
        return rutaResultados;
    }
    
    protected void consultarArchivos() {
        File rutaPronostico = new File(this.rutaPronostico);
        File rutaResultados = new File(this.rutaResultados);
        if(!rutaPronostico.exists() || !rutaResultados.exists())
        {
            System.out.println("No se encontro la ruta o los archivos, verifique que el archivo exista y su ruta sea la correcta.\nRuta y archivos se declaran en: \nClase RutaRecursos, String rutaPronostico y String rutaResultados");
            System.exit(0);
        } 
    }
}
