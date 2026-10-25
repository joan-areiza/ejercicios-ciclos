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

public class Ejercicio17_JC46 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número entero: ");
        int num1 = scanner.nextInt();
        System.out.print("Ingrese el segundo número entero: ");
        int num2 = scanner.nextInt();

        int opcion;
        do {
            System.out.println("\nMENU");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Potenciación");
            System.out.println("6. Raíz cuadrada");
            System.out.println("7. Salir");
            System.out.print("¿Opción?: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Resultado de la suma: " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("Resultado de la resta: " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("Resultado de la multiplicación: " + (num1 * num2));
                    break;
                case 4:
                    if (num2 != 0) {
                        System.out.println("Resultado de la división: " + ((double) num1 / num2));
                    } else {
                        System.out.println("Error: División por cero no permitida.");
                    }
                    break;
                case 5:
                    System.out.println("Resultado de la potenciación: " + Math.pow(num1, num2));
                    break;
                case 6:
                    System.out.print("¿Raíz cuadrada de cuál número? (1 para num1, 2 para num2): ");
                    int eleccionRaiz = scanner.nextInt();
                    if (eleccionRaiz == 1) {
                        if (num1 >= 0) {
                            System.out.println("Raíz cuadrada de " + num1 + ": " + Math.sqrt(num1));
                        } else {
                            System.out.println("Error: No se puede calcular la raíz cuadrada de un número negativo.");
                        }
                    } else if (eleccionRaiz == 2) {
                        if (num2 >= 0) {
                            System.out.println("Raíz cuadrada de " + num2 + ": " + Math.sqrt(num2));
                        } else {
                            System.out.println("Error: No se puede calcular la raíz cuadrada de un número negativo.");
                        }
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}
