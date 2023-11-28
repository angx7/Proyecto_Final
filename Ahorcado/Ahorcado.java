package Ahorcado;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Ahorcado {
    private static Scanner teclado = new Scanner(System.in);
    private static boolean[] letrasIngresadas = new boolean[26];

    // Método para validar solo números
    public static boolean IsInteger(String text) {
        int v;
        try {
            // Convierte la cadena de texto en un valor entero
            v = Integer.parseInt(text);
            if (v < 0) {
                return false;
            }
            return true;
            // Si el usuario ingreso un caracter devuelve un false
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    // Método para válidar solo letras
    public static char Esletra() {
        char inputChar;
        while (true) {
            String userInput = teclado.next();
            if (userInput.length() == 1 && Character.isLetter(userInput.charAt(0))
                    && Character.isLowerCase(userInput.charAt(0))) {
                inputChar = userInput.charAt(0);
                break;
            } else {
                System.out.print("\u001B[31mEs una entrada inválida.\nIntente de nuevo: \u001B[37m");
            }
        }
        return inputChar;
    }

    public static void main(String[] args) {/// Void
        int op;
        String defaultcolor = "\u001B[37m";
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
        do {
            int maxscore = 0;
            int score1 = 0;
            int score2 = 0;
            String j1 = "", j2 = "";
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
            op = Integer.parseInt(option);
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
                    while (!IsInteger(option)) {
                        System.out.print("\u001B[31m" +
                                "El valor ingresado no es un entero\n\nIntente nuevamente: " + defaultcolor);
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
                                limpiarConsola();
                                score1 = jugador1(j1, j2, score1, score2, op);
                                if (score1 == 3) {
                                    break;
                                }
                                limpiarConsola();
                                score2 = jugador2(j1, j2, score1, score2, op);

                                if (score2 < score1) {
                                    maxscore = score1;
                                } else {
                                    maxscore = score2;
                                }
                            } while (maxscore < 3);
                            op = 1;
                            break;
                        case 2:
                            limpiarConsola();
                            System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 1: " + defaultcolor);
                            j1 = teclado.next();
                            System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 2: " + defaultcolor);
                            j2 = teclado.next();
                            limpiarConsola();

                            do {
                                limpiarConsola();
                                score1 = jugador1(j1, j2, score1, score2, op);
                                if (score1 == 3) {
                                    break;
                                }
                                limpiarConsola();
                                score2 = jugador2(j1, j2, score1, score2, op);

                                if (score2 < score1) {
                                    maxscore = score1;
                                } else {
                                    maxscore = score2;
                                }
                            } while (maxscore < 3);
                            op = 1;
                            break;
                        case 3:
                            limpiarConsola();
                            System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 1: " + defaultcolor);
                            j1 = teclado.next();
                            System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 2: " + defaultcolor);
                            j2 = teclado.next();
                            limpiarConsola();

                            do {
                                limpiarConsola();
                                score1 = jugador1(j1, j2, score1, score2, op);
                                if (score1 == 3) {
                                    break;
                                }
                                limpiarConsola();
                                score2 = jugador2(j1, j2, score1, score2, op);

                                if (score2 < score1) {
                                    maxscore = score1;
                                } else {
                                    maxscore = score2;
                                }
                            } while (maxscore < 3);
                            op = 1;
                            break;
                        case 4:
                            limpiarConsola();
                            System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 1: " + defaultcolor);
                            j1 = teclado.next();
                            System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 2: " + defaultcolor);
                            j2 = teclado.next();
                            limpiarConsola();

                            do {
                                limpiarConsola();
                                score1 = jugador1(j1, j2, score1, score2, op);
                                if (score1 == 3) {
                                    break;
                                }
                                limpiarConsola();
                                score2 = jugador2(j1, j2, score1, score2, op);

                                if (score2 < score1) {
                                    maxscore = score1;
                                } else {
                                    maxscore = score2;
                                }
                            } while (maxscore < 3);
                            op = 1;
                            break;
                        case 5:
                            limpiarConsola();
                            System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 1: " + defaultcolor);
                            j1 = teclado.next();
                            System.out.print("\u001B[33m" + "Ingrese el nombre del jugador 2: " + defaultcolor);
                            j2 = teclado.next();
                            limpiarConsola();

                            do {
                                limpiarConsola();
                                score1 = jugador1(j1, j2, score1, score2, op);
                                if (score1 == 3) {
                                    break;
                                }
                                limpiarConsola();
                                score2 = jugador2(j1, j2, score1, score2, op);

                                if (score2 < score1) {
                                    maxscore = score1;
                                } else {
                                    maxscore = score2;
                                }
                            } while (maxscore < 3);
                            op = 1;
                            break;
                    }
                    break;
                case 2:
                    limpiarConsola();
                    System.out.println("Gracias por jugar\n");
                    System.out.println("Presiona enter para continuar...");
                    teclado.nextLine();
                    teclado.nextLine();

                    limpiarConsola();
                    System.out.println(
                            "\t\t\t\tCréditos\n\n* Angel Alejandro Becerra Rojas\r\n* Christian Axel Moreno Flores\r\n* Andrés Aguilera Hernández");
                    System.out.println("\n\n Presiona enter para continuar...");
                    teclado.nextLine();
                    limpiarConsola();
                    teclado.close();
                    System.exit(0);
                    break;
            }

            if (score1 > score2) {
                limpiarConsola();
                System.out.println("\u001B[33m" + "Gana el jugador 1\n\nFelicidades " + j1 +
                        "\u001B[31m" + "\n\nSuerte para la proxima " + j2 + defaultcolor);
            } else {
                limpiarConsola();
                System.out.println("\u001B[33m" + "Gana el jugador 2\n\nFelicidades " + j2 +
                        "\u001B[31m" + "\n\nSuerte para la proxima " + j1 + defaultcolor);
            }
            System.out.println("\n\n Presiona enter para continuar...");
            teclado.nextLine();
            teclado.nextLine();
            limpiarConsola();
        } while (op == 1);
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
        System.out.println("\u001B[32mTurno de " + j1 +
                "\n----------------------- \n" + defaultcolor);
        System.out.println("\u001B[31mTienes 6 intentos\n" + defaultcolor);

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
                    break;
                case 2:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = animales[numeroAleatorio];
                    break;
                case 3:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = frutas[numeroAleatorio];
                    break;
                case 4:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = nombres[numeroAleatorio];
                    break;
                case 5:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = sitiosWeb[numeroAleatorio];
                    break;
            }

            letrasEncontradas = iniciarLetrasEncontradas(PalabraAdivinar.length());

            do {

                System.out.print("\u001B[35mIntroduce una letra: " + defaultcolor);
                String entrada = "" + Esletra();
                // teclado.next().toLowerCase();
                letra = entrada.charAt(0);
                if (letrasIngresadas[letra - 'a']) {
                    System.out.print("\u001B[31mYa has ingresado esa letra.\nIntenta con otra\n" + defaultcolor);
                    continue; // Vuelve al inicio del bucle sin procesar el resto del código
                } else {
                    letrasIngresadas[letra - 'a'] = true; // Marca la letra como ingresada
                }

                encontrados = actualizarFallos(PalabraAdivinar, letra);
                // intento de verificacion de letras

                Mensaje += "\u001B[32m" + "\nLa palabra contiene " + encontrados + " '" + letra
                        + "' en la palabra buscada\n" + defaultcolor;
                if (encontrados == 0) {
                    fallos++;
                    Mensaje += "\u001B[31m" + "\n" + "Te restan " + (6 - fallos) + " intentos\n" + defaultcolor;
                }
                letrasEncontradas = actualizarLetrasEncontradas(PalabraAdivinar, letra, letrasEncontradas);
                Mensaje += "\u001B[32m" + "\nLetras encontradas: " + defaultcolor + letrasEncontradas + "\n" +
                        "\u001B[32m" + "\n----------------------- \n\n" + defaultcolor;
                System.out.println(Mensaje);
                Mensaje = "";
                if (PalabraAdivinar.equals(letrasEncontradas)) {
                    adivinado = true;
                }
            } while (fallos < fallosPermitidos && adivinado == false);

            if (adivinado == false) {
                System.out.println("\u001B[31m" + "Fin de tu turno\n" + "\u001B[32m" + "\n\nLa palabra oculta era: "
                        + PalabraAdivinar + defaultcolor);
                System.out.println("\u001B[33m" + "\nPuntuaciones \n" + j1 + " " + puntuacion + "\n" + j2 + " " + score2
                        + defaultcolor);
                System.out.println("\n\nPresiona enter para continuar...");
                teclado.nextLine();
                teclado.nextLine();
            } else {
                puntuacion++;
                fallos = 0;
                System.out.println("\u001B[33m" + "Felicidades acertaste\n" + defaultcolor);
                System.out.println("\u001B[33m" + "Puntuaciones \n" + j1 + " " + puntuacion + "\n" + j2 + " " + score2
                        + defaultcolor);
                System.out.println("\n\nPresiona enter para continuar...");
                teclado.nextLine();
                teclado.nextLine();
            }
            Arrays.fill(letrasIngresadas, false);
        } while (adivinado == true && puntuacion < 3);

        return puntuacion;
    }

    private static int jugador2(String j1, String j2, int score1, int score2, int op) {

        int puntuacion = score2, fallosPermitidos = 6, fallos = 0, encontrados, numeroAleatorio;
        char letra;
        String PalabraAdivinar = "", letrasEncontradas = "", Mensaje = "", defaultcolor = "\u001B[37m";
        boolean adivinado = false;

        // letrasEncontradas = iniciarLetrasEncontradas(PalabraAdivinar.length());
        Random random = new Random();
        System.out.println("\u001B[32m" + "Turno de " + j2 +
                "\n----------------------- \n" + defaultcolor);
        System.out.println("\u001B[31m" + "Tienes " + (6) + " intentos\n" + defaultcolor);

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
                    break;
                case 2:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = animales[numeroAleatorio];
                    break;
                case 3:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = frutas[numeroAleatorio];
                    break;
                case 4:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = nombres[numeroAleatorio];
                    break;
                case 5:
                    numeroAleatorio = random.nextInt(10);
                    PalabraAdivinar = sitiosWeb[numeroAleatorio];

                    break;
            }

            letrasEncontradas = iniciarLetrasEncontradas(PalabraAdivinar.length());

            do {

                System.out.print("\u001B[35m" + "Introduce una letra: " + defaultcolor);
                String entrada = "" + Esletra();
                letra = entrada.charAt(0);
                if (letrasIngresadas[letra - 'a']) {
                    System.out.print("\u001B[31m" + "Ya has ingresado esa letra.\nIntenta con otra\n " + defaultcolor);
                    continue; // Vuelve al inicio del bucle sin procesar el resto del código
                } else {
                    letrasIngresadas[letra - 'a'] = true; // Marca la letra como ingresada
                }

                encontrados = actualizarFallos(PalabraAdivinar, letra);
                // intento de verificacion de letras

                Mensaje += "\u001B[32m" + "\nLa palabra contiene " + encontrados + " '" + letra
                        + "' en la palabra buscada\n" + defaultcolor;
                if (encontrados == 0) {
                    fallos++;
                    Mensaje += "\u001B[31m" + "\n" + "Te restan " + (6 - fallos) + " intentos\n" + defaultcolor;
                }
                letrasEncontradas = actualizarLetrasEncontradas(PalabraAdivinar, letra, letrasEncontradas);
                Mensaje += "\u001B[32m" + "\nLetras encontradas: " + defaultcolor + letrasEncontradas + "\n" +
                        "\u001B[32m" + "\n----------------------- \n\n" + defaultcolor;
                System.out.println(Mensaje);
                Mensaje = "";
                if (PalabraAdivinar.equals(letrasEncontradas)) {
                    adivinado = true;
                }
            } while (fallos < fallosPermitidos && adivinado == false);

            if (adivinado == false) {
                System.out.println("\u001B[31m" + "Fin de tu turno\n" + "\u001B[32m" + "\n\nLa palabra oculta era: "
                        + PalabraAdivinar + defaultcolor);
                System.out.println("\u001B[33m" + "\nPuntuaciones \n" + j1 + " " + score1 + "\n" + j2 + " " + puntuacion
                        + defaultcolor);
                System.out.println("\n\nPresiona enter para continuar...");
                teclado.nextLine();
                teclado.nextLine();
            } else {
                puntuacion++;
                fallos = 0;
                System.out.println("\u001B[33m" + "Felicidades acertaste\n" + defaultcolor);
                System.out.println("\u001B[33m" + "Puntuaciones \n" + j1 + " " + score1 + "\n" + j2 + " " + puntuacion
                        + defaultcolor);
                System.out.println("\n\nPresiona enter para continuar...");
                teclado.nextLine();
                teclado.nextLine();
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