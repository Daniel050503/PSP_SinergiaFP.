# Sesion 1

Esta es la primera clase de introducción, se ve el contenido de la 
asignatura y también se comienza con el temario.

## Distribucion de los contenidos

| Tema                                                                       | Contenidos                                                           |
|----------------------------------------------------------------------------|----------------------------------------------------------------------|
| Tema 1. Programacion<br/>Multiproceso                                      | Procesos, su gestion y programación concurrente.                     |
| Tema 2. Programación multihilo                                             | Hilos, sincronización, la concurrencia avanzada.                     |
| Tema 3. Programación de comunicaciones en red                              | Programación de sockets y protocolos de comunicación.                |
| Tema 4. Generación de servicios en red                                     | Servidores concurrentes.                                             |
| Tema 5. Utilización de técnicas de programación<br/>segura y criptografía. | Vulnerabilidades, desarrollo seguro, buenas prácticas y criptografía |

## Evaluación

* 60-70% examen - Tipo test.
* 40-30% practicas. (Entregar en formato txt)
Van a ser contenidos de los diferentes temas. 5 prácticas.

## Contenido de la sesión 1

| Trabajo                      | Concepto                      |
|------------------------------|-------------------------------|
| Observar procesos reales     | Programa y proceso            |
| Crear un programa mínimo     | Código almacenado y ejecución |
| Mantener un programa abierto | Proceso vivo y espera         |

## Ciclo de vida de un programa

Nuevo - Listo - En ejecucion - Terminado
                     |
                Bloqueado
                     |
                Listo

## Ejercicio con el que se va introducir la sesion2 grabada

Crea un programa llamado MaquinaTurnos.
Cada ejecución representar una máquina que entrega turnos.

El programa debe:
* Mostrar su PID.
* Crear una variable llamada turno con valor inicial 100.
* Mostrar el turno inicial.
* Esperar a que pulses Intro y aumentar su turno de uno en uno.
* Mostrar su nuevo turno.
* Repetir una vez mas ese proceso.

Solución:

| Momento                     | Turno A / Turno B |
|-----------------------------|-------------------|
| al iniciar ambas            | 100 / 100         |
| tras avanzar dos veces en A | 102 / 100         |
| tras avanzar una bezz en B  | 102 / 101         |


## Objetivo sesion 2

Concurrencia y paralelismo.