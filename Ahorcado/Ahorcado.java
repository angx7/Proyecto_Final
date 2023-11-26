package Ahorcado;

import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {/// Void
        Scanner teclado = new Scanner(System.in);
        String defaultcolor = "\u001B[37m";
        int maxscore = 0;
        int score1 = 0;
        int score2 = 0;
        limpiarConsola();
        // Instrucciones de juego
        System.out.println("\u001B[36m"
                + " ----------------------------------------------------------------------------------------------------------------------------------\r\n"
                +
                "\t\t\tBienvenido al juego del ahorcado\n\n\t\t\t\tInstrucciones\n\n * Elige la temática del juego\r\n"
                +
                " * Ingresa el nombre de los jugadores\r\n" +
                " * Cada jugador tiene un máximo de 6 intentos para adivinar la palabra\r\n" +
                " * Inicia el jugador 1 a adivinar la palabra aleatoria según la temática elegida\r\n" +
                " * El jugador en turno solo puede poner una letra por intento\r\n" +
                " * Si adivina la palabra seguira jugando el mismo jugador y se le sumara un punto, pero si falla será turno del siguiente\r\n"
                +
                " **Nota: Las palabras no contienen espacios\r\n" +
                " * Gana el primero en llegar a 3 puntos\r\n\n"
                + " ----------------------------------------------------------------------------------------------------------------------------------\r\n"
                + defaultcolor);

        System.out.println("Presiona enter para continuar...");
        teclado.nextLine();
        limpiarConsola();

        // Menú de inicio
        System.out.println("\u001B[31m"
                + " -------------------------------------------------------------------------------------\r\n"
                +
                "\t\t\t\tMenú\n\n 1. Iniciar\r\n" +
                " 2. Cerrar\r\n\n"
                + " -------------------------------------------------------------------------------------\r\n"
                + defaultcolor);
        int op = teclado.nextInt();

        switch (op) {
            case 1:
                limpiarConsola();
                System.out.println("\u001B[32m"
                        + " -------------------------------------------------------------------------------------\r\n"
                        +
                        "\t\t\t\tMenú de temáticas\n\n 1. Ciudades de México\r\n" +
                        " 2. Animales\r\n 3. Frutas\r\n 4. Nombres de personas\r\n 5. Sitios Web\r\n\n"
                        + " -------------------------------------------------------------------------------------\r\n"
                        + defaultcolor);
                break;
            case 2:
                limpiarConsola();
                System.out.println("Gracias por jugar\n");
                System.out.println("Presiona enter para continuar...");
                teclado.nextLine();
                limpiarConsola();
                System.out.println(
                        "\t\t\t\tCréditos\n\n* Angel Alejandro Becerra Rojas\r\n* Christian Axel Moreno Flores\r\n* Andrés Aguilera");
                System.out.println("Presiona enter para continuar...");
                teclado.nextLine();
                limpiarConsola();
                System.exit(0);
                break;
        }

        System.out.print("Ingrese el nombre del jugador 1: ");
        String j1 = teclado.next();
        System.out.print("Ingrese el nombre del jugador 2: ");
        String j2 = teclado.next();

        do {
            score1 = jugador1(j1, j2, score1, score2);
            if (score1 == 3) {
                break;
            }
            score2 = jugador2(j1, j2, score1, score2);

            if (score2 < score1) {
                maxscore = score1;
            } else {
                maxscore = score2;
            }
        } while (maxscore < 3);

        if (score1 > score2) {
            System.out.println("Gana el jugador 1\nFelicidades " + j1);
        } else {
            System.out.println("Gana el jugador 2\nFelicidades " + j2);
        }
    }

    private static void limpiarConsola() {
        System.out.print("\033[2J");
        System.out.print("\033[H");
    }

    private static int jugador1(String j1, String j2, int score1, int score2) {
        int puntuacion = score1;
        int fallosPermitidos = 6, fallos = 0, encontrados;
        String letra, PalabraAdivinar, letrasEncontradas = "", Mensaje = "";
        boolean adivinado = false;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Turno de " + j1);
        do {
            adivinado = false;
            System.out.print("Introduce la palabra a adivinar: ");
            PalabraAdivinar = teclado.next().toLowerCase();
            letrasEncontradas = iniciarLetrasEncontradas(PalabraAdivinar.length());
            do {
                System.out.print("Introduce una letra: ");
                letra = teclado.next().toLowerCase();
                encontrados = actualizarFallos(PalabraAdivinar, letra);
                if (encontrados == 0) {
                    fallos++;
                }
                Mensaje += "La palabra contiene " + encontrados + " '" + letra.charAt(0) + "' en la palabra buscada";
                Mensaje += "\n" + "Te restan " + (6 - fallos) + " intentos";
                letrasEncontradas = actualizarLetrasEncontradas(PalabraAdivinar, letra, letrasEncontradas);
                Mensaje += "\n letras encontradas: " + letrasEncontradas;
                System.out.println(Mensaje);
                Mensaje = "";
                if (PalabraAdivinar.equals(letrasEncontradas)) {
                    adivinado = true;
                }
            } while (fallos < fallosPermitidos && adivinado == false);

            if (adivinado == false) {
                System.out.println("Lo siento, estás tonto. \n Perdiste bro");
                System.out.println("Puntuaciones \n" + j1 + " " + puntuacion + "\n" + j2 + " " + score2);
            } else {
                puntuacion++;
                System.out.println("Ganaste bro" + " llevas " + puntuacion + " puntos ");
                System.out.println("Puntuaciones \n" + j1 + " " + puntuacion + "\n" + j2 + " " + score2);
            }

        } while (adivinado == true && puntuacion < 3);

        return puntuacion;
    }

    private static int jugador2(String j1, String j2, int score1, int score2) {
        int puntuacion = score2;
        int fallosPermitidos = 6, fallos = 0, encontrados;
        String letra, PalabraAdivinar, letrasEncontradas = "", Mensaje = "";
        boolean adivinado = false;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Turno de: " + j2);
        do {
            adivinado = false;
            System.out.print("Introduce la palabra a adivinar: ");
            PalabraAdivinar = teclado.next().toLowerCase();
            letrasEncontradas = iniciarLetrasEncontradas(PalabraAdivinar.length());
            do {
                System.out.print("Introduce una letra: ");
                letra = teclado.next().toLowerCase();
                encontrados = actualizarFallos(PalabraAdivinar, letra);
                if (encontrados == 0) {
                    fallos++;
                }
                Mensaje += "La palabra contiene " + encontrados + " '" + letra.charAt(0) + "' en la palabra buscada";
                Mensaje += "\n" + "Te restan " + (6 - fallos) + " intentos";
                letrasEncontradas = actualizarLetrasEncontradas(PalabraAdivinar, letra, letrasEncontradas);
                Mensaje += "\nletras encontradas: " + letrasEncontradas;
                System.out.println(Mensaje);
                Mensaje = "";
                if (PalabraAdivinar.equals(letrasEncontradas)) {
                    adivinado = true;
                }
            } while (fallos < fallosPermitidos && adivinado == false);

            if (adivinado == false) {
                System.out.println("Lo siento, estás tonto. \n Perdiste bro");
                System.out.println("Puntuaciones \n" + j1 + " " + score1 + "\n" + j2 + " " + puntuacion);
            } else {
                puntuacion++;
                System.out.println("Ganaste bro" + " llevas " + puntuacion + " puntos ");
                System.out.println("Puntuaciones \n" + j1 + " " + score1 + "\n" + j2 + " " + puntuacion);
            }

        } while (adivinado == true && puntuacion < 3);

        return puntuacion;
    }

    private static String iniciarLetrasEncontradas(int longitud) {
        String letras = "";
        for (int i = 0; i < longitud; i++) {
            letras = letras + 0;
        }
        return letras;
    }

    private static int actualizarFallos(String PalabraAdivinar, String letra) {
        int encontrado = 0;
        for (int i = 0; i < PalabraAdivinar.length(); i++) {
            if (PalabraAdivinar.charAt(i) == letra.charAt(0)) {
                encontrado++;
            }
        }
        return encontrado;
    }

    private static String actualizarLetrasEncontradas(String PalabraAdivinar, String letra, String letrasEncontradas) {
        String actualizacionLetras = "";
        for (int i = 0; i < PalabraAdivinar.length(); i++) {
            if (letra.charAt(0) == PalabraAdivinar.charAt(i)) {
                actualizacionLetras += letra.charAt(0);
            } else {
                actualizacionLetras += letrasEncontradas.charAt(i);
            }

        }
        return actualizacionLetras;
    }

    private static String dibujarAhorcado(int fallos) {
        String dibujo = ".";
        return dibujo;
    }

}