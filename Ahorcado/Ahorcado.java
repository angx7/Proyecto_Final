package Ahorcado;

import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {/// Void

        int fallosPermitidos = 7;
        int fallos = 0;
        // int i;
        int encontrados;
        String letra;
        String PalabraAdivinar;
        String letrasEncontradas = "";
        String Mensaje = "";
        boolean adivinado = false;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce la palabra a adivinar");
        PalabraAdivinar = teclado.next();
        PalabraAdivinar = PalabraAdivinar.toLowerCase();
        letrasEncontradas = iniciarLetrasEncontradas(PalabraAdivinar.length());
        do {
            System.out.println("Introduce una letra");
            letra = teclado.next();
            letra = letra.toLowerCase();
            encontrados = actualizarFallos(PalabraAdivinar, letra);
            if (encontrados == 0) {
                fallos++;
            }
            Mensaje += "La palabra contiene " + encontrados + "" + letra.charAt(0) + " en la palabra buscada";
            Mensaje += "\n" + dibujarAhorcado(fallos);
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
        } else {
            System.out.println("Ganaste bro");
        }
        teclado.close();
    }

    private static String iniciarLetrasEncontradas(int longitud) {
        String letras = "";
        int i;
        for (i = 0; i < longitud; i++) {
            letras = letras + 0;

        }
        return letras;
    }

    private static int actualizarFallos(String PalabraAdivinar, String letra) {
        int i;
        int encontrado = 0;
        for (i = 0; i < PalabraAdivinar.length(); i++) {
            if (PalabraAdivinar.charAt(i) == letra.charAt(0)) {
                encontrado++;
            }
        }
        return encontrado;
    }

    // Modificando ando
    private static String actualizarLetrasEncontradas(String PalabraAdivinar, String letra, String letrasEncontradas) {
        int i;
        String actualizacionLetras = "";
        for (i = 0; i < PalabraAdivinar.length(); i++) {
            if (letra.charAt(0) == PalabraAdivinar.charAt(i)) {
                actualizacionLetras += letra.charAt(0);
            } else {
                actualizacionLetras += letrasEncontradas.charAt(i);
            }

        }
        return actualizacionLetras;
    }

    private static String dibujarAhorcado(int fallos) {
        String dibujo = "";
        switch (fallos) {
            case 0:
                dibujo = "";
                break;
            case 1:
                dibujo = " °O)";
                break;
            case 2:
                dibujo = "(°O) ";
                break;
            case 3:
                dibujo = " (°_O) ";
                break;
            case 4:
                dibujo = " |(°_o) ";
                break;
            case 5:
                dibujo = " |(°_O)/ ";
                break;
            case 6:
                dibujo = " |(°_O)/¯ ";
                break;
            case 7:
                dibujo = " ¯|(x.x)/¯ ";
                break;
        }
        return dibujo;
    }

}