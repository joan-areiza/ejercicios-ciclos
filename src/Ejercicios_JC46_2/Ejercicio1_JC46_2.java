package Ejercicios_JC46_2;

import java.util.Scanner;

public class Ejercicio1_JC46_2 {

    public static void MensajeErrorLetras(NumberFormatException e) {
        System.out.println("\n--------------*---------------"
                + "\n¡Error! Entrada de datos inválida."
                + "\nSolo se pueden ingresar números."
                + "\nInténtelo nuevamente."
                + "\n--------------*---------------");
    }

    public static void MensajeErrorRango() {
        System.out.println("\n--------------*---------------"
                + "\n¡Error! Entrada de datos inválida."
                + "\nDato fuera de rango."
                + "\nInténtelo nuevamente."
                + "\n--------------*---------------");
    }

    public static void EjecutarEjercicio() {
        Scanner scanner = new Scanner(System.in);
        int N = 0;
        boolean entradaValida = false;

        // Solicitar cantidad de números a procesar
        while (!entradaValida) {
            try {
                System.out.println("Ingrese cantidad de números a procesar [1..50]:");
                N = Integer.parseInt(scanner.next());
                if (N >= 1 && N <= 50) {
                    entradaValida = true;
                } else {
                    MensajeErrorRango();
                }
            } catch (NumberFormatException e) {
                MensajeErrorLetras(e);
            }
        }

        int pares = 0, impares = 0, positivos = 0, negativos = 0;
        int sumaPares = 0, sumaImpares = 0, sumaPositivos = 0, sumaNegativos = 0;
        int mayorPar = Integer.MIN_VALUE, menorPar = Integer.MAX_VALUE;
        int mayorImpar = Integer.MIN_VALUE, menorImpar = Integer.MAX_VALUE;
        int mayorPositivo = Integer.MIN_VALUE, menorPositivo = Integer.MAX_VALUE;
        int mayorNegativo = Integer.MIN_VALUE, menorNegativo = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int numero = 0;
            entradaValida = false;

            while (!entradaValida) {
                try {
                    System.out.println("Ingrese número " + i + " [-1000..1000]:");
                    numero = Integer.parseInt(scanner.next());
                    if (numero >= -1000 && numero <= 1000) {
                        entradaValida = true;
                    } else {
                        MensajeErrorRango();
                    }
                } catch (NumberFormatException e) {
                    MensajeErrorLetras(e);
                }
            }

            // Clasificación
            if (numero % 2 == 0) { // Par
                pares++;
                sumaPares += numero;
                if (numero > mayorPar) mayorPar = numero;
                if (numero < menorPar) menorPar = numero;
            } else { // Impar
                impares++;
                sumaImpares += numero;
                if (numero > mayorImpar) mayorImpar = numero;
                if (numero < menorImpar) menorImpar = numero;
            }

            if (numero >= 0) { // Positivo
                positivos++;
                sumaPositivos += numero;
                if (numero > mayorPositivo) mayorPositivo = numero;
                if (numero < menorPositivo) menorPositivo = numero;
            } else { // Negativo
                negativos++;
                sumaNegativos += numero;
                if (numero > mayorNegativo) mayorNegativo = numero;
                if (numero < menorNegativo) menorNegativo = numero;
            }
        }

        // Resultados
        System.out.println("\nResultados:");
        System.out.println("Cantidad de pares: " + pares);
        System.out.println("Cantidad de impares: " + impares);
        System.out.println("Cantidad de positivos: " + positivos);
        System.out.println("Cantidad de negativos: " + negativos);
        System.out.println("Promedio de pares: " + (pares > 0 ? (double) sumaPares / pares : 0));
        System.out.println("Promedio de impares: " + (impares > 0 ? (double) sumaImpares / impares : 0));
        System.out.println("Promedio de positivos: " + (positivos > 0 ? (double) sumaPositivos / positivos : 0));
        System.out.println("Promedio de negativos: " + (negativos > 0 ? (double) sumaNegativos / negativos : 0));
        System.out.println("Mayor número par: " + mayorPar);
        System.out.println("Menor número par: " + menorPar);
        System.out.println("Mayor número impar: " + mayorImpar);
        System.out.println("Menor número impar: " + menorImpar);
        System.out.println("Mayor número positivo: " + mayorPositivo);
        System.out.println("Menor número positivo: " + menorPositivo);
        System.out.println("Mayor número negativo: " + mayorNegativo);
        System.out.println("Menor número negativo: " + menorNegativo);

        scanner.close();
    }

    public static void main(String[] args) {
        EjecutarEjercicio();
    }
}
