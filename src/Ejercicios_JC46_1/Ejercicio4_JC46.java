/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios_JC46_1;

/**
 *
 * @author 2025
 */

 import java.util.Scanner;

public class Ejercicio4_JC46 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Contadores y acumuladores
        int contadorHombres = 0, contadorMujeres = 0;
        double sumaEstaturaHombres = 0, sumaEstaturaMujeres = 0;
        double sumaPesoHombresImpar = 0, sumaPesoMujeresPar = 0;
        int contPesoHombresImpar = 0, contPesoMujeresPar = 0;
        double sumaPesoRango = 0;
        int contPesoRango = 0;
        double sumaEstMujerRango = 0, sumaEstHombreRango = 0;
        int contEstMujerRango = 0, contEstHombreRango = 0;

        // Variables para extremos
        String mujerMayorEdad = "", mujerMenorEdad = "";
        int mayorEdadMujer = Integer.MIN_VALUE, menorEdadMujer = Integer.MAX_VALUE;

        String hombreMayorPeso = "", hombreMenorPeso = "";
        double mayorPesoHombre = Double.MIN_VALUE, menorPesoHombre = Double.MAX_VALUE;

        String mujerMasAlta = "", mujerMasBaja = "";
        double estaturaMujerAlta = Double.MIN_VALUE, estaturaMujerBaja = Double.MAX_VALUE;

        String hombreMasAlto = "", hombreMasBajo = "";
        double estaturaHombreAlto = Double.MIN_VALUE, estaturaHombreBajo = Double.MAX_VALUE;

        String continuar;

        do {
            System.out.print("\nIngrese el nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese la estatura (en metros): ");
            double estatura = sc.nextDouble();

            System.out.print("Ingrese el peso (kg): ");
            double peso = sc.nextDouble();

            System.out.print("Ingrese la edad: ");
            int edad = sc.nextInt();

            System.out.print("Ingrese el género (1=Femenino, 2=Masculino): ");
            int genero = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            // Personas en rango de peso [65,80)
            if (peso >= 65 && peso < 80) {
                sumaPesoRango += peso;
                contPesoRango++;
            }

            if (genero == 1) { // Femenino
                contadorMujeres++;
                sumaEstaturaMujeres += estatura;

                // Mujer mayor y menor edad
                if (edad > mayorEdadMujer) {
                    mayorEdadMujer = edad;
                    mujerMayorEdad = nombre;
                }
                if (edad < menorEdadMujer) {
                    menorEdadMujer = edad;
                    mujerMenorEdad = nombre;
                }

                // Mujer más alta y más baja
                if (estatura > estaturaMujerAlta) {
                    estaturaMujerAlta = estatura;
                    mujerMasAlta = nombre;
                }
                if (estatura < estaturaMujerBaja) {
                    estaturaMujerBaja = estatura;
                    mujerMasBaja = nombre;
                }

                // Peso par
                if ((int) peso % 2 == 0) {
                    sumaPesoMujeresPar += peso;
                    contPesoMujeresPar++;
                }

                // Mujeres con estatura entre 1.60 y 1.75
                if (estatura >= 1.60 && estatura <= 1.75) {
                    sumaEstMujerRango += estatura;
                    contEstMujerRango++;
                }

            } else if (genero == 2) { // Masculino
                contadorHombres++;
                sumaEstaturaHombres += estatura;

                // Hombre mayor y menor peso
                if (peso > mayorPesoHombre) {
                    mayorPesoHombre = peso;
                    hombreMayorPeso = nombre;
                }
                if (peso < menorPesoHombre) {
                    menorPesoHombre = peso;
                    hombreMenorPeso = nombre;
                }

                // Hombre más alto y más bajo
                if (estatura > estaturaHombreAlto) {
                    estaturaHombreAlto = estatura;
                    hombreMasAlto = nombre;
                }
                if (estatura < estaturaHombreBajo) {
                    estaturaHombreBajo = estatura;
                    hombreMasBajo = nombre;
                }

                // Peso impar
                if ((int) peso % 2 != 0) {
                    sumaPesoHombresImpar += peso;
                    contPesoHombresImpar++;
                }

                // Hombres con estatura entre 1.77 y 1.98
                if (estatura >= 1.77 && estatura <= 1.98) {
                    sumaEstHombreRango += estatura;
                    contEstHombreRango++;
                }
            }

            System.out.print("¿Desea ingresar otra persona? (s/n): ");
            continuar = sc.nextLine().toLowerCase();

        } while (continuar.equals("s"));

        // Resultados finales
        System.out.println("\n--- Resultados ---");
        System.out.println("Promedio de estatura hombres: " + (contadorHombres > 0 ? (sumaEstaturaHombres / contadorHombres) : "No hay datos"));
        System.out.println("Promedio de estatura mujeres: " + (contadorMujeres > 0 ? (sumaEstaturaMujeres / contadorMujeres) : "No hay datos"));

        if (contadorMujeres > 0) {
            System.out.println("Mujer con mayor edad: " + mujerMayorEdad);
            System.out.println("Mujer con menor edad: " + mujerMenorEdad);
            System.out.println("Mujer más alta: " + mujerMasAlta);
            System.out.println("Mujer más baja: " + mujerMasBaja);
        }

        if (contadorHombres > 0) {
            System.out.println("Hombre con mayor peso: " + hombreMayorPeso);
            System.out.println("Hombre con menor peso: " + hombreMenorPeso);
            System.out.println("Hombre más alto: " + hombreMasAlto);
            System.out.println("Hombre más bajo: " + hombreMasBajo);
        }

        System.out.println("Promedio de hombres con peso impar: " + (contPesoHombresImpar > 0 ? (sumaPesoHombresImpar / contPesoHombresImpar) : "No hay datos"));
        System.out.println("Promedio de mujeres con peso par: " + (contPesoMujeresPar > 0 ? (sumaPesoMujeresPar / contPesoMujeresPar) : "No hay datos"));
        
        System.out.println("Promedio peso entre 65 y <80: " + (contPesoRango > 0 ? (sumaPesoRango / contPesoRango) : "No hay datos"));
        System.out.println("Promedio estatura mujeres (1.60 - 1.75): " + (contEstMujerRango > 0 ? (sumaEstMujerRango / contEstMujerRango) : "No hay datos"));
        System.out.println("Promedio estatura hombres (1.77 - 1.98): " + (contEstHombreRango > 0 ? (sumaEstHombreRango / contEstHombreRango) : "No hay datos"));
    }
}

    

