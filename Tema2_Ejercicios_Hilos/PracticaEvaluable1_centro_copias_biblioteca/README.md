## 📚 Library Copy Center Simulation - Concurrent Programming

This project simulates the behavior of a group of students sharing a limited number of photocopiers in a library. 
It was developed to demonstrate the use of **Threads**, **Monitors**, and **Synchronization** in Java.

## 🚀 How it Works

The system consists of 5 students competing for 2 copying machines. Each student follows a continuous life cycle:
1.  **Studying:** The student spends a random amount of time studying independently.
2.  **Request:** The student attempts to access a machine. If none are available, they wait patiently.
3.  **Copying:** Once a machine is obtained, they occupy it for a specific duration.
4.  **Release:** The student releases the machine and notifies their peers that it is now free.

## 🛠️ Technical Details

### Concurrency and Synchronization
- **Monitor (`CentroCopias.java`):** Implements exclusive access using `synchronized` methods.
- **Wait Management:** Uses `wait()` when resources are unavailable to prevent unnecessary CPU consumption (busy waiting).
- **Notification:** Implements `notifyAll()` to efficiently wake up waiting threads.
- **Cycle Control:** Threads use a `volatile boolean` flag to ensure a clean shutdown after 20 seconds of execution.

### Project Structure
- `Main.java`: Sets up the environment, launches threads, and manages orderly shutdown using `join()`.
- `Estudiantes.java`: Defines the thread logic (`Runnable`) and simulates tasks with random timings.
- `CentroCopias.java`: Manages the critical resource (the machines).


## ⚙️ Execution
To run the program from the terminal:

1. Compile:
   ```bash
   javac PracticaEvaluable1_centro_copias_biblioteca/*.java
