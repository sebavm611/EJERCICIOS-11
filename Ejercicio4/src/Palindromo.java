/*
 4. Un palíndromo es una palabra o frase que se lee igual de izquierda a derecha, que de derecha a
izquierda. Escriba un programa que verifique si una cadena ingresada es un palíndromo. El
programa debe ignorar mayúsculas, tildes, espacios en blanco y signos de puntuación

 * @author Pablo Vélez y Rodrigo Ortiz  MARZO - JULIO 2023
 */

import java.util.Scanner;

public class Palindromo {

    public static boolean palindromo(String cadena) {

        cadena = cadena.toLowerCase();

        cadena = cadena.replaceAll("\\.", "");

        cadena = cadena.replaceAll(",", "");

        cadena = cadena.replaceAll("á", "a");

        cadena = cadena.replaceAll("é", "e");

        cadena = cadena.replaceAll("í", "i");

        cadena = cadena.replaceAll("ó", "o");

        cadena = cadena.replaceAll("ú", "u");

        cadena = cadena.replaceAll(" ", "");

        System.out.println(cadena);

        char array[] = cadena.toCharArray();

        int tamanio;

        if (array.length % 2 == 0) {

            tamanio = array.length / 2;

        } else {

            tamanio = (array.length / 2) + 1;
        }

        boolean palindromo = true;

        for (int i = 0; i < tamanio; i++) {

            if (array[i] != array[array.length - 1 - i]) {

                palindromo = false;

                break;
            }
        }

        return palindromo;
    }

    public static void main(String[] args) {

        String op = "";
        Scanner s = new Scanner(System.in, "ISO-8859-1");

        do {

            System.out.print("Ingrese la palabra a verificar: ");

            String cadena = s.nextLine();

            while (!cadena.matches("([A-Za-z\u00E1\u00E9\u00ED\u00F3\u00FA\u00C1\u00C9\u00CD\u00D3\u00DA\u00F1\u00D1,\\.]+ ?)+")) {

                System.out.print("ERROR! La cadena solo puede contener letras y signos de puntuacion: ");
                cadena = s.nextLine();

            }

            if (palindromo(cadena)) {

                System.out.println("La cadena es un palindromo");

            } else {

                System.out.println("La cadena no es un palindromo");

            }

            System.out.print("Desea continuar S/N: ");
            op = s.nextLine();

            while (!op.matches("[nNsS]")) {
                System.out.print("ERROR! Ingrese S/N: ");
                op = s.nextLine();

            }

        }while(!op.matches("[nN]"));
 
        
    }
}
