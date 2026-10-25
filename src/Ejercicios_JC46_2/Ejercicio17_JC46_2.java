/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios_JC46_2;

/**
 *
 * @author Joan
 */

 import java.util.Scanner;

public class Ejercicio17_JC46_2 {

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

    public static int LeerNumero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println(mensaje + " [-1000..1000]:");
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
        return numero;
    }

    public static void MostrarMenu() {
        System.out.println("\nMENU:");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Potenciación");
        System.out.println("6. Raíz cuadrada");
        System.out.println("7. Salir");
    }

    public static void EjecutarEjercicio() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            MostrarMenu();
            System.out.print("¿Opción?: ");
            try {
                opcion = Integer.parseInt(scanner.next());

                if (opcion < 1 || opcion > 7) {
                    MensajeErrorRango();
                    continue;
                }

                if (opcion == 7) {
                    System.out.println("Saliendo del programa...");
                    break;
                }

                int num1 = LeerNumero("Ingrese el primer número");
                int num2 = LeerNumero("Ingrese el segundo número");

                switch (opcion) {
                    case 1:
                        System.out.println("Resultado: " + (num1 + num2));
                        break;
                    case 2:
                        System.out.println("Resultado: " + (num1 - num2));
                        break;
                    case 3:
                        System.out.println("Resultado: " + (num1 * num2));
                        break;
                    case 4:
                        if (num2 != 0) {
                            System.out.println("Resultado: " + ((double) num1 / num2));
                        } else {
                            System.out.println("Error: División por cero no permitida.");
                        }
                        break;
                    case 5:
                        System.out.println("Resultado: " + Math.pow(num1, num2));
                        break;
                    case 6:
                        if (num1 >= 0) {
                            System.out.println("Raíz cuadrada de " + num1 + ": " + Math.sqrt(num1));
                        } else {
                            System.out.println("Error: No se puede calcular la raíz cuadrada de un número negativo.");
                        }
                        if (num2 >= 0) {
                            System.out.println("Raíz cuadrada de " + num2 + ": " + Math.sqrt(num2));
                        } else {
                            System.out.println("Error: No se puede calcular la raíz cuadrada de un número negativo.");
                        }
                        break;
                }
            } catch (NumberFormatException e) {
                MensajeErrorLetras(e);
                opcion = 0;
            }
        } while (opcion != 7);

        scanner.close();
    }

    public static void main(String[] args) {
        EjecutarEjercicio();
    }
}

    

