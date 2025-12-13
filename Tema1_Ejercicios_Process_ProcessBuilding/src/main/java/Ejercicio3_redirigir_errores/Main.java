package Ejercicio3_redirigir_errores;

import java.io.File;

/** REDIRIGIR ERRORES
 * Crea un programa que intente ejecutar un comando inexistente y redirija los mensajes de
 * error a un archivo llamado errores.txt.
 */
public class Main {
    public static void main(String[] args) {

        try {
            //Averiguar el sistema operativo
            String so = System.getProperty("os.name").toLowerCase();
            String comando = "adfjaosd";

            ProcessBuilder pb = so.contains("win") ? new ProcessBuilder("cmd", "/c", comando) : new ProcessBuilder("bash", "-c", comando);

            //Destino
            pb.redirectError(new File("errores.txt"));
            pb.start();
            pb.wait();

            //Aviso
            System.out.println("Comando finalizado. Revisa archivo correspondiente.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
