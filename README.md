# Services and Processes Programming (PSP) - Exercises

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) 
<br>![Status](https://img.shields.io/badge/Status-In%20Progress-green?style=for-the-badge)
<br>![Course](https://img.shields.io/badge/Course-2nd%20DAM-blue?style=for-the-badge)

Welcome to my repository for the **Services and Processes Programming** (*Programación de Servicios y Procesos*) subject!

This collection contains practical exercises and projects developed during my **Higher Technician in Multi-platform Application Development (DAM)** studies.

> **🚧 Work in Progress:**
> This repository is actively updated. New exercises and topics (like Multithreading, Networking, and Security) will be uploaded progressively as the course advances.

---

## 🇪🇸 Language Notice 

> **Please Note:**
> While this documentation is written in English for accessibility, the **source code comments**, **variable names**, and **problem statements** are written in **Spanish**, following the academic requirements of the course.

---

## 📂 Repository Structure

The project is organized by topics using directories to keep concepts isolated and clean:

### 🔹 Topic 1: Process Management
Located in: `src/main/java/Tema1_Ejercicios_Process_ProcessBuilding`
* **Process Creation:** Executing system commands using `ProcessBuilder` and `Runtime`.
* **I/O Redirection:** capturing standard output and error streams to `.txt` files.
* **OS Detection:** Writing cross-platform code (Windows/Linux compatibility).
* **Security:** Implementation of data sanitization (avoiding absolute paths in logs).

### 🔹 Topic 2: Multithreaded Programming
Located in: `src/main/java/Tema2_Ejercicios_Hilos`

* **Thread Creation:** Implementation using the Runnable interface and the Thread class.
* **Lifecycle Management:** Controlling states using start(), join() for synchronization, and sleep() for execution delays.
* **Synchronization:** Utilizing synchronized blocks and methods to prevent Race Conditions.
* **Thread Priorities:** Managing execution importance using the setPriority() method.

---

## 🚀 Key Concepts Demonstrated

Within the first module, I explore the fundamental concepts of handling external system tasks:

* **`java.lang.ProcessBuilder`**: Advanced management of external processes.
* **`java.io`**: File handling, streams, and log generation.
* **Exception Handling**: Ensuring robust execution and proper error logging.
* **Defensive Programming**: Sanitizing inputs and managing sensitive data (e.g., preventing metadata leaks).

The second module shifts focus toward internal execution flows and concurrency within the JVM:

* **Concurrency vs. Parallelism:** Understanding the difference between time-slicing on a single core versus simultaneous execution on multiple cores.
* **Shared Resources:** Strategies for safe access to common objects by multiple threads.
* **Thread Scheduling:** How the JVM manages which thread gets CPU time.
