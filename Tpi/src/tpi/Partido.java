
package tpi;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Partido {
        private String equipo1;
        private String equipo2;
        private int golesEquipo1;
        private int golesEquipo2;
        
        String archivoResultado = "resultados.csv";
        String nombreArchivo = "C:\\Users\\djord\\Documents\\NetBeansProjects\\Tpi\\recursos\\"+archivoResultado;
        Path ruta = Paths.get(nombreArchivo);
        
        private void getArchivoResultado() {
             try {
	            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.ISO_8859_1);
	            for (String linea : lineas) {
	                String[] textoSeparado = linea.split(";");
                        equipo1 = textoSeparado[0];
                        golesEquipo1 = parseInt(textoSeparado[1]);
                        golesEquipo2 = parseInt(textoSeparado[2]);
                        equipo2 = textoSeparado[3];
                    }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
        }
        
        protected String resultado() {
            String resultado = null;
            if(golesEquipo1==golesEquipo2) {
                resultado = "Empate";
            } else {
                if(golesEquipo1>golesEquipo2) {
                    resultado = "Ganador";
                } else {
                    resultado = "Perdedor";
                }
            }
            return resultado;
        }
        
        
        
        
        
        /*
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        ResultadoEnum resultado = new ResultadoEnum();
        int golesEquipo1;
        int golesEquipo2;
        
        public Partido() {
        }

        public Partido(int golesEquipo1, int golesEquipo2) {
            this.golesEquipo1 = golesEquipo1;
            this.golesEquipo2 = golesEquipo2;
        }

        public Equipo getEquipo1() {
            return equipo1;
        }

        public void setEquipo1(Equipo equipo1) {
            this.equipo1 = equipo1;
        }

        public Equipo getEquipo2() {
            return equipo2;
        }

        public void setEquipo2(Equipo equipo2) {
            this.equipo2 = equipo2;
        }

        public int getGolesEquipo1() {
            return golesEquipo1;
        }

        public void setGolesEquipo1(int golesEquipo1) {
            this.golesEquipo1 = golesEquipo1;
        }

        public int getGolesEquipo2() {
            return golesEquipo2;
        }

        public void setGolesEquipo2(int golesEquipo2) {
            this.golesEquipo2 = golesEquipo2;
        }
        
        public String resultado() {
            var resu = "";
            if(golesEquipo1==golesEquipo2) {
                resu = resultado.getEmpate();
            } else {
                if(golesEquipo1>golesEquipo2){
                    resu = resultado.getGanador();
                } else {
                   resu =  resultado.getPerdedor();
                }
            }
            return resu;
        }
        
        
        
        */
        
        
        
        
        
        
        
    }

    
    
    

