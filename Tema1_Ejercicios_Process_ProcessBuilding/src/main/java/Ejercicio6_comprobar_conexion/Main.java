package Ejercicio6_comprobar_conexion;

/*
Haz un programa que ejecute el comando ping a una dirección (por ejemplo, ping
google.com) y muestre si la conexión fue exitosa o no en base al código de salida del proceso.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        String web = "www.google.com";

        //Comprobamos sistema operativo y abrimos terminal
        try {
            String so = System.getProperty("os.name").toLowerCase();
            ProcessBuilder pb = so.contains("win")
                    ? new ProcessBuilder("cmd", "/c", "ping " + web)
                    : new ProcessBuilder("bash", "-c", "ping " + web);

            Process process = pb.start();

            //Leemos los resultados del comando
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            // Esperamos el resultado
            int codigo = process.waitFor();

            //Aviso final
            System.out.println("\nCódigo de salida: " + codigo);
            if (codigo == 0) {
                System.out.println("Conexión exitosa a " + web);
            } else {
                System.out.println("Conexión fallida a " + web);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
