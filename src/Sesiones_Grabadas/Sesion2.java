package Sesiones_Grabadas;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Sesion2 {
    // Es crear una función que lo que realiza es ejecutar un proceso
    static Process lanzar(String nombre, int pasos, int pausa) throws IOException {
        // Vamos a construir el comando java - cp de manera generica
        // "C:\Program Files\Java\jdk-17\bin\java.exe"
        String java = Path.of(System.getProperty("java.home"), "bin", "java").toString();
        // Definir el proceso o el archivo que queremos lanzar
        ProcessBuilder proceso_sin_lanzar = new ProcessBuilder(java, "-cp",
                System.getProperty("java.class.path"), "Sesion2", "hijo", nombre, "" + pasos, "" + pausa);
        // Ejecutamos el proceso ya lanzado y liberir la memoria
        return proceso_sin_lanzar.inheritIO().start();
    }
    public static void main(String[] args) throws Exception{
        if (args.length > 0 && args[0].equals("hijo")){
            // Si al proceso padre le estamos pasando parametros este mismo esta tomando la propia definicion de ellos
            String nombre = args[1];
            int pasos = Integer.parseInt(args[2]);
            int pausa = Integer.parseInt(args[3]);
            for (int i = 1; i<= pasos; i++){
                System.out.printf("%s PID= %d paso=%d%n", nombre, ProcessHandle.current().pid(), i);
                // Simulamos una espera
                Thread.sleep(pausa);
            }
        }
        // Si los argumentos son 0 quiere decir que el modo el secuencial si no args[0]
        String modo = args.length == 0 ? "secuencial": args[0];
        if(!modo.equals("secuencial") && !modo.equals("concurrente")){
            System.err.println("Uso: java Sesion2 secuencial|concurrente");
            // Con esto hacemos parar el proceso padre
            System.exit(2);
        }

        System.out.println("PADRE PID= " + ProcessHandle.current().pid());
        System.out.println("Procesador lógicos disponibles= " + Runtime.getRuntime().availableProcessors());

        // Creo una lista que crea los procesos hijos con lo que se ejecuta
        List<Process> procesos_hijos = new ArrayList<>();

        try {
            // Voy a definir una lista de nombres para el proceso
            List<String> lista_nombres = List.of("A", "B", "C");
            // Recorro la lista de los vector
            for (String nombre_proceso : List.of("A", "B", "C")){
                // Lanzamos cada uno de los procesos
                Process p = lanzar(nombre_proceso, 4, 500);
                // Añadimos cada proceso ejecutado a la lista
                procesos_hijos.add(p);
                // Muestra el PID de cada proceso hijo
                System.out.println("Creado hijo pid = " + p.pid());
            }

            // Si deseamos una programacion concurrente vamos a tener que utilizar hilos
            if (modo.equals("concurrente")){
                for (Process p : procesos_hijos){
                    System.out.printf("Hijo %d código=%d%n", p.pid(), p.waitFor());
                }
            }
        }finally {
            // Destruyo cada proceso si este esta ejecutando
            for (Process process : procesos_hijos){
                // Si aun el proceso esta ejecutando lo destruyes y haces que pare
                if (process.isAlive()){
                    process.destroyForcibly().waitFor();
                }
            }
        }
    }
}
