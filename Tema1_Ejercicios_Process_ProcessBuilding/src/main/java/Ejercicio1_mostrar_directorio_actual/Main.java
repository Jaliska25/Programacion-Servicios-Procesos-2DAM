package Ejercicio1_mostrar_directorio_actual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*  MOSTRAR DIRECTORIO ACTUAL
Crea un programa que ejecute el comando del sistema operativo que muestra el contenido
del directorio actual (dir en Windows o ls en Linux) y muestre la salida por pantalla.
*/
public class Main {
    public static void main(String[] args) {

        try {
            //Averiguamos si el sistema operativo es Windows o Linux
            String so = System.getProperty("os.name").toLowerCase();
            String comando = so.contains("win") ? "dir" : "ls";

            //Creamos el proceso
            ProcessBuilder pb = so.contains("win")
                    ? new ProcessBuilder("cmd", "/c", comando)
                    : new ProcessBuilder("bash", "-c", comando);

            pb.inheritIO();  //Usamos la consola de Java para que el proceso escriba directamente en ella
            Process process = pb.start();  //Ejecución del proceso
            process.waitFor();

//            --- SIN .inheritIO() ---
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String linea;
//
//            while ((linea = reader.readLine()) != null){
//                System.out.println(linea);
//            }
//            process.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
