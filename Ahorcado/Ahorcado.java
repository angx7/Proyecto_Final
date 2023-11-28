package Ahorcado;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

// Adios tonotos

public class Ahorcado {
    private static boolean[] letrasIngresadas = new boolean[26];

    public static boolean IsInteger(String text) {
        int v;
        try {
            // Convierte la cadena de texto en un valor entero
            v = Integer.parseInt(text);
            return true;
            // Si el usuario ingreso un caracter devuelve un false
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void main(String[] args) {/// Void
        Scanner teclado = new Scanner(System.in);
        String defaultcolor = "\u001B[37m";

        int maxscore = 0;
        int score1 = 0;
        int score2 = 0;
        String j1 = "", j2 = "";
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
        String option = teclado.next();
        while (!IsInteger(option)) {
            System.out.print(
                    "El valor ingresado no es un entero\n\nIntente nuevamente: ");
            option = teclado.next();
        }
        int op = Integer.parseInt(option);
        while (op == 0 || op > 2) {
            System.out.println("Elige una opción válida");
            option = teclado.next();
            while (!IsInteger(option)) {
                System.out.print(
                        "El valor ingresado no es un entero\n\nIntente nuevamente: ");
                option = teclado.next();
            }
            op = Integer.parseInt(option);
        }
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
                option = teclado.next();
                limpiarConsola();
                while (!IsInteger(option)) {
                    System.out.print(
                            "El valor ingresado no es un entero\n\nIntente nuevamente: ");
                    option = teclado.next();
                }
                op = Integer.parseInt(option);
                while (op == 0 || op > 5) {
                    System.out.println("Elige una opción válida");
                    option = teclado.next();
                    while (!IsInteger(option)) {
                        System.out.print(
                                "El valor ingresado no es un entero\n\nIntente nuevamente: ");
                        option = teclado.next();
                    }
                    op = Integer.parseInt(option);
                }

                switch (op) {
                    case 1:
                        limpiarConsola();
                        System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 1: " + defaultcolor);
                        j1 = teclado.next();
                        System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 2: " + defaultcolor);
                        j2 = teclado.next();
                        limpiarConsola();

                        do {
                            score1 = jugador1(j1, j2, score1, score2, op);
                            if (score1 == 3) {
                                break;
                            }
                            score2 = jugador2(j1, j2, score1, score2, op);

                            if (score2 < score1) {
                                maxscore = score1;
                            } else {
                                maxscore = score2;
                            }
                        } while (maxscore < 3);
                        break;
                    case 2:
                        limpiarConsola();
                        System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 1: " + defaultcolor);
                        j1 = teclado.next();
                        System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 2: " + defaultcolor);
                        j2 = teclado.next();
                        limpiarConsola();

                        do {
                            score1 = jugador1(j1, j2, score1, score2, op);
                            if (score1 == 3) {
                                break;
                            }
                            score2 = jugador2(j1, j2, score1, score2, op);

                            if (score2 < score1) {
                                maxscore = score1;
                            } else {
                                maxscore = score2;
                            }
                        } while (maxscore < 3);
                        break;
                    case 3:
                        limpiarConsola();
                        System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 1: " + defaultcolor);
                        j1 = teclado.next();
                        System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 2: " + defaultcolor);
                        j2 = teclado.next();
                        limpiarConsola();

                        do {
                            score1 = jugador1(j1, j2, score1, score2, op);
                            if (score1 == 3) {
                                break;
                            }
                            score2 = jugador2(j1, j2, score1, score2, op);

                            if (score2 < score1) {
                                maxscore = score1;
                            } else {
                                maxscore = score2;
                            }
                        } while (maxscore < 3);
                        break;
                    case 4:
                        limpiarConsola();
                        System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 1: " + defaultcolor);
                        j1 = teclado.next();
                        System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 2: " + defaultcolor);
                        j2 = teclado.next();
                        limpiarConsola();

                        do {
                            score1 = jugador1(j1, j2, score1, score2, op);
                            if (score1 == 3) {
                                break;
                            }
                            score2 = jugador2(j1, j2, score1, score2, op);

                            if (score2 < score1) {
                                maxscore = score1;
                            } else {
                                maxscore = score2;
                            }
                        } while (maxscore < 3);
                        break;
                    case 5:
                        limpiarConsola();
                        System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 1: " + defaultcolor);
                        j1 = teclado.next();
                        System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 2: " + defaultcolor);
                        j2 = teclado.next();
                        limpiarConsola();

                        do {
                            score1 = jugador1(j1, j2, score1, score2, op);
                            if (score1 == 3) {
                                break;
                            }
                            score2 = jugador2(j1, j2, score1, score2, op);

                            if (score2 < score1) {
                                maxscore = score1;
                            } else {
                                maxscore = score2;
                            }
                        } while (maxscore < 3);
                        break;
                }
                break;
            case 2:
                limpiarConsola();
                System.out.println("Gracias por jugar\n");
                System.out.println("Presiona enter para continuar...");
                teclado.nextLine(); teclado.nextLine();
                
                limpiarConsola();
                System.out.println(
                        "\t\t\t\tCréditos\n\n* Angel Alejandro Becerra Rojas\r\n* Christian Axel Moreno Flores\r\n* Andrés Aguilera Hernández");
                System.out.println("\n\n Presiona enter para continuar...");
                teclado.nextLine();
                limpiarConsola();
                System.exit(0);
                break;
        }

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

    private static int jugador1(String j1, String j2, int score1, int score2, int op) {

        int puntuacion = score1, fallosPermitidos = 6, fallos = 0, encontrados, numeroAleatorio;
        char letra;
        String PalabraAdivinar = "", letrasEncontradas = "", Mensaje = "", defaultcolor = "\u001B[37m";
        boolean adivinado = false;

        // letrasEncontradas = iniciarLetrasEncontradas(PalabraAdivinar.length());
        Random random = new Random();
        Scanner teclado = new Scanner(System.in);
        System.out.println("\u001B[32m" + "Turno de " + j1 + 
        "\n----------------------- \n" + defaultcolor);

        // Diccionario del juego
        String[] animales = { "perro", "gato", "caballo", "vaca", "oveja", "pollo", "pez", "mariposa", "abeja",
                "mono" };
        String[] frutas = { "manzana", "pera", "platano", "naranja", "uva", "sandia", "melon", "fresa", "mandarina",
                "aguacate" };
        String[] nombres = { "juan", "maria", "jose", "ana", "luis", "isabel", "pedro", "paula", "miguel", "daniela" };
        String[] sitiosWeb = { "google", "youtube", "facebook", "twitter", "amazon", "netflix", "instagram", "whatsapp",
                "mercadolibre" };
        String[] ciudadesMexico = { "cdmx", "guadalajara", "monterrey", "puebla", "leon", "tijuana", "juarez", "merida",
                "aguascalientes", "queretaro" };

        do {
            adivinado = false;
            switch (op) {
                case 1:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = ciudadesMexico[numeroAleatorio];
                    System.out.println(PalabraAdivinar);
                    break;
                case 2:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = animales[numeroAleatorio];
                    System.out.println(PalabraAdivinar);
                    break;
                case 3:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = frutas[numeroAleatorio];
                    System.out.println(PalabraAdivinar);
                    break;
                case 4:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = nombres[numeroAleatorio];
                    System.out.println(PalabraAdivinar);
                    break;
                case 5:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = sitiosWeb[numeroAleatorio];
                    System.out.println(PalabraAdivinar);
                    break;
            }

            letrasEncontradas = iniciarLetrasEncontradas(PalabraAdivinar.length());

            do {
                System.out.print("Introduce una letra: ");
                String entrada = teclado.next().toLowerCase();
                letra = entrada.charAt(0);
                if (letrasIngresadas[letra - 'a']) {
                    System.out.println("Ya has ingresado esa letra. Intenta con otra.");
                    continue; // Vuelve al inicio del bucle sin procesar el resto del código
                } else {
                    letrasIngresadas[letra - 'a'] = true; // Marca la letra como ingresada
                }

                encontrados = actualizarFallos(PalabraAdivinar, letra);
                if (encontrados == 0) {
                    fallos++;
                }
                // intento de verificacion de letras

                Mensaje += "La palabra contiene " + encontrados + " '" + letra + "' en la palabra buscada";
                Mensaje += "\n" + "Te restan " + (6 - fallos) + " intentos";
                letrasEncontradas = actualizarLetrasEncontradas(PalabraAdivinar, letra, letrasEncontradas);
                Mensaje += "\nLetras encontradas: " + letrasEncontradas;
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
            Arrays.fill(letrasIngresadas, false);
        } while (adivinado == true && puntuacion < 3);

        return puntuacion;
    }

    private static int jugador2(String j1, String j2, int score1, int score2, int op) {

        int puntuacion = score2, fallosPermitidos = 6, fallos = 0, encontrados, numeroAleatorio;
        char letra;
        String PalabraAdivinar = "", letrasEncontradas = "", Mensaje = "", defaultcolor = "\u001B[37m";;
        boolean adivinado = false;

        // letrasEncontradas = iniciarLetrasEncontradas(PalabraAdivinar.length());
        Random random = new Random();
        Scanner teclado = new Scanner(System.in);
        System.out.println("\u001B[32m" + "Turno de " + j2 + 
        "\n----------------------- \n\n" + defaultcolor);

        // Diccionario del juego
        String[] animales = { "perro", "gato", "caballo", "vaca", "oveja", "pollo", "pez", "mariposa", "abeja",
                "mono" };
        String[] frutas = { "manzana", "pera", "platano", "naranja", "uva", "sandia", "melon", "fresa", "mandarina",
                "aguacate" };
        String[] nombres = { "juan", "maria", "jose", "ana", "luis", "isabel", "pedro", "paula", "miguel", "daniela" };
        String[] sitiosWeb = { "google", "youtube", "facebook", "twitter", "amazon", "netflix", "instagram", "whatsapp",
                "mercadolibre" };
        String[] ciudadesMexico = { "cdmx", "guadalajara", "monterrey", "puebla", "leon", "tijuana", "juarez", "merida",
                "aguascalientes", "queretaro" };

        do {
            adivinado = false;
            switch (op) {
                case 1:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = ciudadesMexico[numeroAleatorio];
                    System.out.println(PalabraAdivinar);
                    break;
                case 2:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = animales[numeroAleatorio];
                    System.out.println(PalabraAdivinar);
                    break;
                case 3:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = frutas[numeroAleatorio];
                    System.out.println(PalabraAdivinar);
                    break;
                case 4:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = nombres[numeroAleatorio];
                    System.out.println(PalabraAdivinar);
                    break;
                case 5:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = sitiosWeb[numeroAleatorio];
                    System.out.println(PalabraAdivinar);
                    break;
            }

            letrasEncontradas = iniciarLetrasEncontradas(PalabraAdivinar.length());

            do {
                System.out.print("Introduce una letra: ");
                String entrada = teclado.next().toLowerCase();
                letra = entrada.charAt(0);
                if (letrasIngresadas[letra - 'a']) {
                    System.out.println("Ya has ingresado esa letra. Intenta con otra.");
                    continue; // Vuelve al inicio del bucle sin procesar el resto del código
                } else {
                    letrasIngresadas[letra - 'a'] = true; // Marca la letra como ingresada
                }

                encontrados = actualizarFallos(PalabraAdivinar, letra);
                if (encontrados == 0) {
                    fallos++;
                }
                // intento de verificacion de letras

                Mensaje += "La palabra contiene " + encontrados + " '" + letra + "' en la palabra buscada";
                if (encontrados == 0) {
                Mensaje += "\n" + "Te restan " + (6 - fallos) + " intentos";   
                }
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
                System.out.println("Puntuaciones \n" + j1 + " " + score1 + "\n" + j2 + " " + puntuacion);
            } else {
                puntuacion++;
                System.out.println("Ganaste bro" + " llevas " + puntuacion + " puntos ");
                System.out.println("Puntuaciones \n" + j1 + " " + score1 + "\n" + j2 + " " + puntuacion);
            }
            Arrays.fill(letrasIngresadas, false);
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

    private static int actualizarFallos(String PalabraAdivinar, char letra) {
        int encontrado = 0;
        for (int i = 0; i < PalabraAdivinar.length(); i++) {
            if (PalabraAdivinar.charAt(i) == letra) {
                encontrado++;
            }
        }
        return encontrado;
    }

    private static String actualizarLetrasEncontradas(String PalabraAdivinar, char letra, String letrasEncontradas) {
        String actualizacionLetras = "";
        for (int i = 0; i < PalabraAdivinar.length(); i++) {
            if (letra == PalabraAdivinar.charAt(i)) {
                actualizacionLetras += letra;
            } else {
                actualizacionLetras += letrasEncontradas.charAt(i);
            }

        }
        return actualizacionLetras;
    }
}