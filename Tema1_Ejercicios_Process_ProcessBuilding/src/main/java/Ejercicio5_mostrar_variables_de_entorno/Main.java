package Ejercicio5_mostrar_variables_de_entorno;

import java.io.*;
import java.util.*;

/**
 * Crea un programa que utilice pb.environment() para listar todas las variables de entorno
 * del sistema
 */

public class Main {
    public static void main(String[] args) {

        try {
            //Averiguamos sistema operativo
            String so = System.getProperty("os.name").toLowerCase();
            ProcessBuilder pb = so.contains("win")
                    ? new ProcessBuilder("cmd")
                    : new ProcessBuilder("bash"); //Linux, mac...

            //Obtengo el mapa con las variables de entorno
            Map<String, String> entorno = pb.environment();
            System.out.println("Variables de entorno del sistema:\n");

            // Recorremos el mapa e imprimimos cada par clave=valor
            for (String clave : entorno.keySet()) {
                System.out.println(clave + " = " + entorno.get(clave));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
