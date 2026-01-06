package PracticaEvaluable1_centro_copias_biblioteca;

public class Main {
    public static void main(String[] args) {

        CentroCopias centro = new CentroCopias(2);   //Creo un centro de copias con 2 máquinas fotocopiadoras (recurso crítico)
        Estudiantes[] estudiantes = new Estudiantes[5];     // Creo los 5 estudiantes
        Thread[] hilos = new Thread[5];     // y los hilos

        System.out.println("-- 🏦 LA BIBLIOTECA HA ABIERTO SUS PUERTAS 🏦 --");
        //Inicio los hilos
        for (int i = 0; i < 5; i++) {
            estudiantes[i] = new Estudiantes(i + 1, centro);
            hilos[i] = new Thread(estudiantes[i]);
            hilos[i].start();
        }

        // Duermo el main 20 segundos para que los hilos trabajen
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Detengo los hilos de los estudiantes
        System.out.println("⚠️ AVISO ⚠️ --> IR TERMINANDO QUE CERRAMOS LA BIBLIOTECA");
        for (Estudiantes e : estudiantes) {
            e.detener();
        }

        // Barrera para que terminen los hilos antes que el main
        try {
            for (int i = 0; i < hilos.length; i++) {
                hilos[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Muestro los resultados finales
        System.out.println("--- RESULTADO FINAL ---");
        for (int i = 0; i < 5; i++) {
            System.out.println("Estudiante " + (i + 1) + " hizo copias "
                    + estudiantes[i].getContadorCopias() + " veces.");
        }
    }// Llave main
}