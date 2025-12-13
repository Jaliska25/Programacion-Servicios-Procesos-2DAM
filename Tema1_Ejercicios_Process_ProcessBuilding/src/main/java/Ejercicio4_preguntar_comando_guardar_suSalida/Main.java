package Ejercicio4_preguntar_comando_guardar_suSalida;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * PREGUNTAR UN COMANDO Y GUARDAR SU SALIDA
 * Haz que el programa pida al usuario un comando del sistema, lo ejecute y guarde tanto la
 * salida como los errores en el archivo resultado.txt.
 */

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un comando del sistema: ");
        String comando = sc.nextLine();

        try {
            //Creamos el archivo
            File archivoDestino = new File("resultados.txt");

            //Averiguar sistema operativo
            String so = System.getProperty("os.name").toLowerCase();
            ProcessBuilder pb = so.contains("win")
                    ? new ProcessBuilder("cmd", "/c", comando)
                    : new ProcessBuilder("bash", "-c", comando);

            //Configuramos el destino de los resultados del proceso
            pb.redirectErrorStream(true);
            pb.redirectOutput(ProcessBuilder.Redirect.appendTo(archivoDestino));

            Process process = pb.start();  //Iniciamos proceso
            process.waitFor();

            System.out.println("Resultado guardado en resultado.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
