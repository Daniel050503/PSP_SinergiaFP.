package Sesiones_Grabadas;

import java.util.Scanner;

public class Maquina_Turnos {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("PID: " + ProcessHandle.current().pid());

        int turno = 100;
        System.out.println("Turno inicial: " + turno);

        for (int i = 0; i < 2; i++) {
            System.out.println("Pulsa Intro para avanzar...");
            teclado.nextLine();
            turno++;

            System.out.println("Nuevo turno: " + turno);
        }

        teclado.close();
    }
}
