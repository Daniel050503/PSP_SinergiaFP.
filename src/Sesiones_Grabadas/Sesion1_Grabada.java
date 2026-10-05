package Sesiones_Grabadas;

import java.util.Scanner;

public class Sesion1_Grabada {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("PID: " + ProcessHandle.current().pid());

        System.out.println("El programa ha comenzado.");
        System.out.println("Pulsa intro para terminar");

        teclado.nextLine();

        System.out.println("El programa ha terminado.");
        teclado.close();
    }
}
