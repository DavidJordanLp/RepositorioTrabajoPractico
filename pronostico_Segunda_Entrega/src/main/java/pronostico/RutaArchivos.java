package pronostico;
import java.io.File;

public class RutaArchivos {
    final static protected String rutaResultados = "C:\\Users\\djord\\Documents\\repositorioTrabajoPractico\\pronostico_Segunda_Entrega\\recursos\\resultados.csv";
    final static protected String rutaPronostico = "C:\\Users\\djord\\Documents\\repositorioTrabajoPractico\\pronostico_Segunda_Entrega\\recursos\\pronostico.csv";
        
    protected String getRutaPronostico() {
        return rutaPronostico;
    }
    
    protected String getRutaResultados() {
        return rutaResultados;
    }
 }
