/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios_JC46_1;

/**
 *
 * @author Joan
 */
import java.util.Scanner;

public class Ejercicio1_JC46 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cantidadNumeros = 50;
        int pares = 0, impares = 0, positivos = 0, negativos = 0;
        int sumaPares = 0, sumaImpares = 0, sumaPositivos = 0, sumaNegativos = 0;
        int maxPar = Integer.MIN_VALUE, minPar = Integer.MAX_VALUE;
        int maxImpar = Integer.MIN_VALUE, minImpar = Integer.MAX_VALUE;
        int maxPositivo = Integer.MIN_VALUE, minPositivo = Integer.MAX_VALUE;
        int maxNegativo = Integer.MIN_VALUE, minNegativo = Integer.MAX_VALUE;

        for (int i = 0; i < cantidadNumeros; i++) {
            System.out.print("Ingrese un número natural: ");
            int numero = scanner.nextInt();

            if (numero >= 0) {
                if (numero % 2 == 0) {
                    pares++;
                    sumaPares += numero;
                    if (numero > maxPar) {
                        maxPar = numero;
                    }
                    if (numero < minPar) {
                        minPar = numero;
                    }
                } else {
                    impares++;
                    sumaImpares += numero;
                    if (numero > maxImpar) {
                        maxImpar = numero;
                    }
                    if (numero < minImpar) {
                        minImpar = numero;
                    }
                }
                positivos++;
                sumaPositivos += numero;
                if (numero > maxPositivo) {
                    maxPositivo = numero;
                }
                if (numero < minPositivo) {
                    minPositivo = numero;
                }
            } else {
                negativos++;
                sumaNegativos += numero;
                if (numero > maxNegativo) {
                    maxNegativo = numero;
                }
                if (numero < minNegativo) {
                    minNegativo = numero;
                }
            }
        }

        // Cálculo de promedios
        double promedioPares = (pares > 0) ? (double) sumaPares / pares : 0;
        double promedioImpares = (impares > 0) ? (double) sumaImpares / impares : 0;
        double promedioPositivos = (positivos > 0) ? (double) sumaPositivos / positivos : 0;
        double promedioNegativos = (negativos > 0) ? (double) sumaNegativos / negativos : 0;

        // Resultados
        System.out.println("Cantidad de pares: " + pares + ", Promedio: " + promedioPares + ", Mayor: " + maxPar + ", Menor: " + minPar);
        System.out.println("Cantidad de impares: " + impares + ", Promedio: " + promedioImpares + ", Mayor: " + maxImpar + ", Menor: " + minImpar);
        System.out.println("Cantidad de positivos: " + positivos + ", Promedio: " + promedioPositivos + ", Mayor: " + maxPositivo + ", Menor: " + minPositivo);
        System.out.println("Cantidad de negativos: " + negativos + ", Promedio: " + promedioNegativos + ", Mayor: " + maxNegativo + ", Menor: " + minNegativo);

        scanner.close();
    }
}
