package Ejercicios_JC46_1;

import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio3_JC46 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalEstudiantes = 100;

        
        
        
        int calificacionMenor50 = 0;
        int calificacionMayorIgual80 = 0;

        int notasImpares = 0;
        int notasPares = 0;
        int notasMultiplos3 = 0;

        double sumaNotas50a80 = 0;
        int contNotas50a80 = 0;

        double sumaNotas70a80 = 0;
        int contNotas70a80 = 0;

        HashSet<String> codigosEstudiantes = new HashSet<>(); // Para almacenar códigos únicos

        for (int i = 1; i <= totalEstudiantes; i++) {
            System.out.println("\nEstudiante #" + i);
            String codigo;

            // Validar que el código del estudiante sea único
            while (true) {
                System.out.print("Ingrese código del estudiante: ");
                codigo = sc.nextLine();
                if (codigosEstudiantes.contains(codigo)) {
                    System.out.println("Error: El código ya ha sido ingresado. Ingrese un código único.");
                } else {
                    codigosEstudiantes.add(codigo);
                    break; // Salir del bucle si el código es único
                }
            }

            int nota;
            // Validar que la calificación esté entre 0 y 100
            while (true) {
                System.out.print("Ingrese calificación (0 - 100): ");
                nota = sc.nextInt();
                sc.nextLine(); // Limpiar buffer

                if (nota < 0 || nota > 100) {
                    System.out.println("Error: La calificación debe estar entre 0 y 100. Intente de nuevo.");
                } else {
                    break; // Salir del bucle si la nota es válida
                }
            }

            // Contar calificaciones según las condiciones
            if (nota < 50) {
                calificacionMenor50++;
            }

            if (nota >= 50 && nota < 80) {
                sumaNotas50a80 += nota;
                contNotas50a80++;
            }

            if (nota >= 70 && nota < 80) {
                sumaNotas70a80 += nota;
                contNotas70a80++;
            }

            if (nota >= 80) {
                calificacionMayorIgual80++;
            }

            if (nota % 2 == 0) {
                notasPares++;
            } else {
                notasImpares++;
            }

            if (nota % 3 == 0) {
                notasMultiplos3++;
            }
        }

        // Mostrar resultados
        System.out.println("\n--- Resultados del Examen de Física ---");
        System.out.println("Cantidad de estudiantes con calificación < 50: " + calificacionMenor50);
        System.out.println("Promedio de notas entre 50 y <80: " + (contNotas50a80 > 0 ? (sumaNotas50a80 / contNotas50a80) : "No hay datos"));
        System.out.println("Promedio de notas entre 70 y <80: " + (contNotas70a80 > 0 ? (sumaNotas70a80 / contNotas70a80) : "No hay datos"));
        System.out.println("Cantidad de estudiantes con calificación >= 80: " + calificacionMayorIgual80);
        System.out.println("Cantidad de estudiantes con notas impares: " + notasImpares);
        System.out.println("Cantidad de estudiantes con notas pares: " + notasPares);
        System.out.println("Cantidad de estudiantes con notas múltiplos de 3: " + notasMultiplos3);
    }
}