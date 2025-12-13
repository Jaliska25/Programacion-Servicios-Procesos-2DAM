package Ejercicio2_guardar_fecha_sistema;

/*   GUARDAR LA FECHA DEL SISTEMA
Crea un programa que ejecute el comando que muestra la fecha (date) y guarde la salida
en un fichero llamado fecha.txt.
*/

import java.io.*;

public class Main {
    public static void main(String[] args) {

        try {
            //Creamos archivo destino y escribimos en él
            File archivoDestino = new File("fecha.txt");

            try(FileWriter writer = new FileWriter(archivoDestino)){
                writer.write("La fecha de hoy es: ");
            }

            //Averiguamos Sistema Operativo
            String so = System.getProperty("os.name").toLowerCase();
            String comando = "date";

            ProcessBuilder pb = so.contains("win")
                    ? new ProcessBuilder("cmd", "/c", comando +" /T")
                    : new ProcessBuilder("bash", "-c", comando);

            //Destino
            pb.redirectOutput(ProcessBuilder.Redirect.appendTo(archivoDestino));

            //Inicio del proceso
            Process process = pb.start();
            process.waitFor();

            //Aviso proceso terminado
            System.out.println("Comando ejecutado con éxito. Revise archivo.");

        } catch (Exception e) {
           e.printStackTrace();
        }


    }
}
