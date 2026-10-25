package Ejercicios_JC46_2;

import java.util.Scanner;

public class Ejercicio3_JC46_2 {

    public static void MensajeErrorLetras(NumberFormatException e) {
        System.out.println("\n--------------*---------------"
                + "\n¡Error! Entrada de datos inválida."
                + "\nSolo se pueden ingresar números enteros."
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

    public static int LeerNumero(String mensaje, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println(mensaje + " [" + min + ".." + max + "]:");
                numero = Integer.parseInt(scanner.next());
                if (numero >= min && numero <= max) {
                    entradaValida = true;
                } else {
                    MensajeErrorRango();
                }
            } catch (NumberFormatException e) {
                MensajeErrorLetras(e);
            }
        }
        return numero;
    }

    public static void EjecutarEjercicio() {
        Scanner scanner = new Scanner(System.in);

        int estudiantes = 10;
        int calificacionesMenores50 = 0;
        int sumaCalificaciones50_80 = 0, cantidadCalificaciones50_80 = 0;
        int sumaCalificaciones70_80 = 0, cantidadCalificaciones70_80 = 0;
        int cantidadCalificaciones80 = 0;
        int cantidadImpares = 0, cantidadPares = 0, cantidadMultiplosDe3 = 0;

        for (int i = 1; i <= estudiantes; i++) {
            int codigo = LeerNumero("Ingrese código del estudiante " + i, 1, 9999);
            int calificacion = LeerNumero("Ingrese calificación obtenida", 0, 100);

            // Clasificaciones
            if (calificacion < 50) {
                calificacionesMenores50++;
            }
            if (calificacion >= 50 && calificacion < 80) {
                sumaCalificaciones50_80 += calificacion;
                cantidadCalificaciones50_80++;
            }
            if (calificacion >= 70 && calificacion < 80) {
                sumaCalificaciones70_80 += calificacion;
                cantidadCalificaciones70_80++;
            }
            if (calificacion >= 80) {
                cantidadCalificaciones80++;
            }
            if (calificacion % 2 == 0) {
                cantidadPares++;
            } else {
                cantidadImpares++;
            }
            if (calificacion % 3 == 0) {
                cantidadMultiplosDe3++;
            }
        }

        // Resultados
        System.out.println("\nResultados:");
        System.out.println("Cantidad de estudiantes con calificación < 50: " + calificacionesMenores50);
        System.out.println("Promedio de calificaciones >= 50 y < 80: " + 
            (cantidadCalificaciones50_80 > 0 ? (double) sumaCalificaciones50_80 / cantidadCalificaciones50_80 : 0));
        System.out.println("Promedio de calificaciones >= 70 y < 80: " + 
            (cantidadCalificaciones70_80 > 0 ? (double) sumaCalificaciones70_80 / cantidadCalificaciones70_80 : 0));
        System.out.println("Cantidad de estudiantes con calificación >= 80: " + cantidadCalificaciones80);
        System.out.println("Cantidad de estudiantes con notas impares: " + cantidadImpares);
        System.out.println("Cantidad de estudiantes con notas pares: " + cantidadPares);
        System.out.println("Cantidad de estudiantes con notas múltiplos de 3: " + cantidadMultiplosDe3);

        scanner.close();
    }

    public static void main(String[] args) {
        EjecutarEjercicio();
    }
}
