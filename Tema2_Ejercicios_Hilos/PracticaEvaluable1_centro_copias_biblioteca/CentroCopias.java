package PracticaEvaluable1_centro_copias_biblioteca;

public class CentroCopias {

    private int maquinasDisponibles;

    //Constructor
    public CentroCopias(int totalMaquinas) {
        this.maquinasDisponibles = totalMaquinas;
    }


    //METODOS RELATIVAS A LAS MAQUINAS
    public synchronized void solicitarMaquina(int idEstudiante) throws InterruptedException {

        while (maquinasDisponibles == 0) {
            System.out.println("Estudiante " + idEstudiante + " espera una máquina");
            wait();
        }
        maquinasDisponibles--;  //Si hay máquina libre, la usa
        System.out.println("Estudiante " + +idEstudiante + " esta usando la máquina");

    }

    public synchronized void liberarMaquina(int idEstudiante) {
        maquinasDisponibles++;
        System.out.println("Estudiante " + idEstudiante + " termina y libera la máquina");
        notifyAll();
    }

}
