package pronostico;
import java.io.File;

public class RutaArchivos {
    final static protected String raiz = "C:\\Users\\David\\Documents\\RepositorioTrabajoPractico\\pronostico_Tercera_Entrega\\recursos\\";
    final static protected String rutaResultados = raiz + "resultados.csv";
    final static protected String rutaPronostico = raiz + "pronostico.csv";
    final static protected String configuracion = raiz + "configuracion.csv";
        
    protected String getRutaPronostico() {
        return rutaPronostico;
    }
    
    protected String getRutaResultados() {
        return rutaResultados;
    }
    
    protected String getConfiguracion() {
        return configuracion;
    }
    
    
 }
