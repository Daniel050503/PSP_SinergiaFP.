package Codigo_Ejercicios_Dudas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Sesion1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=======================================");
        System.out.println("JAVA PROCESS MANAGER");
        System.out.println("=======================================");

        System.out.print("\nComando > ");
        String comando = scanner.nextLine();
        ejecutarProceso(comando);
    }

    public static void ejecutarProceso(String comando){
        try {
            boolean windows = System.getProperty("os.name").toLowerCase().contains("win");
            ProcessBuilder builder;
            if (windows){
                builder = new ProcessBuilder("cmd", "/c", comando);

                //Mezclamos la salida normal y la salida del error
                System.out.println("Iniciando el proceso");
                long inicio = System.currentTimeMillis();

                Process proceso = builder.start();
                long pid = proceso.pid();
                System.out.println("PID: " + pid);

                BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

                String linea;
                while ((linea = reader.readLine()) != null){
                    System.out.println(linea);
                }
            }
        }catch (IOException e) {
            System.out.println("Hay un error");
        }
    }
}
