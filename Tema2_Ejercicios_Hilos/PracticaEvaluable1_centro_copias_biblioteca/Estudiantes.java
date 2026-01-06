package PracticaEvaluable1_centro_copias_biblioteca;

import java.util.Random;

public class Estudiantes implements Runnable{

    private int idEstudiante;
    private CentroCopias centro;
    private int contadorCopias;
    private volatile boolean activo;    //para interrumpir el metodo run()
    private Random random;


    public Estudiantes (int idEstudiante, CentroCopias c){
        this.centro = c;
        this.idEstudiante = idEstudiante;
        this.contadorCopias = 0;
        this.activo = true;
        this.random = new Random();   // Para que cada estudiante tarde tiempos diferentes
    }

    // METODO PARA APAGAR EL INTERRUPTOR DEL BUCLE EN run()
    public void detener() {
        activo = false;
    }

    public int getContadorCopias() {
        return contadorCopias;
    }

    @Override
    public void run() {
        try {
            while (activo) {
                estudiar();

                System.out.println("Estudiante " + idEstudiante + " solicita máquina.");
                centro.solicitarMaquina(idEstudiante);

                haceCopias();
                contadorCopias++;

                centro.liberarMaquina(idEstudiante);
            }
        } catch (InterruptedException e) {}
    }


    // METODOS QUE SIMULAN LAS TAREAS QUE HACEN LOS ESTUDIANTES

    private void estudiar() throws InterruptedException {
        System.out.println("Estudiante " + idEstudiante + " está estudiando.");
        Thread.sleep(500 + random.nextInt(1500));  //Simula el tiempo que está estudiando
    }

    private void haceCopias() throws InterruptedException {
        System.out.println("Estudiante " + idEstudiante + " está haciendo copias.");
        Thread.sleep(500 + random.nextInt(1000));  //Simula el tiempo que ocupa la máquina
    }

}
