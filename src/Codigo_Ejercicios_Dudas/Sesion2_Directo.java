package Codigo_Ejercicios_Dudas;

public class Sesion2_Directo {
    public static void main(String[]args) throws Exception {
        //Comprobamos si el programa que se ejecuta como trabajador

        if(args.length > 0 && args[0].equals("trabajador")){
            String nombre = args[1];
            long duracion = Long.parseLong(args[2]);

            //Muestra el PID del trabajador
            System.out.println("Trabajador " + nombre + " | " + ProcessHandle.current().pid());

            //Simulamos el trabajo del trabajador
            Thread.sleep(duracion);  //ESTO NO LO ENTIENDO

            System.out.println( nombre + " ha terminado.");

            //Termina el proceso con codigo 0
            System.exit(0);
        }

        //Modo padre : secuencial o concurrente
        //Si ejecutas el programa sin indicar nada, funcionará en modo secuencial.
        //Si ejecutas el programa indicando concurrente, funcionará en modo concurrente.
        String modo = args.length > 0 ? args[0] : "secuencial";

        //Duración por defecto de mil milisegundos
        long duracion = args.length > 1 ? Long.parseLong(args[1]) : 1000;

        System.out.println("PID del padre: " + ProcessHandle.current().pid());

        //Nombre de los tres trabajadores
        String[] trabajadores = {"Trabajo1","Trabajo2","Trabajo3"};

        //Guardamos en un array los procesos que se van a ejecutar
        Process[] procesos = new Process[3];

        //Ruta del ejecutable de java
        String java = System.getProperty("java.home") + "/bin/java.exe";

        if(modo.equals("secuencial")) {
            for (int i = 0; i < 3; i++) {
                //Creo el proceso hijo
                procesos[i] = new ProcessBuilder(
                        java, "-cp", System.getProperty("java.class.path"),
                        "Codigo_Ejercicios_Dudas.Sesion2_Directo", "trabajador", trabajadores[i],
                        String.valueOf(duracion)
                ).inheritIO().start();

                //Muestro el PID del hijo
                System.out.println("PID del hijo : " + procesos[i].pid());

                //Esperamos que termine un proceso para crear el siguiente
                int codigo = procesos[i].waitFor();

                System.out.println(trabajadores[i] + "| Codigo de salida " + codigo);
            }
        }else if(modo.equals("concurrente")){
                for (int i = 0; i<3; i++) {
                    //Creo el proceso hijo
                    procesos[i] = new ProcessBuilder(
                            java, "-cp", System.getProperty("java.class.path"),
                            "Codigo_Ejercicios_Dudas.Sesion2_Directo", "trabajador", trabajadores[i],
                            String.valueOf(duracion)
                    ).inheritIO().start();

                    //Muestro el PID del hijo
                    System.out.println("PID del hijo : " + procesos[i].pid());

                }
                //Una vez que hemos creado los tres, esperamos a que terminen para mostrar el código
                for (int i =0;i<3;i++){
                    //Esperamos que termine un proceso para crear el siguiente
                    int codigo = procesos[i].waitFor();

                    System.out.println(trabajadores[i] + "| Codigo de salida " + codigo);
                }
        }

    }
}
