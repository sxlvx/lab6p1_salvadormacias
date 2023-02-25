package com.mycompany.lab6p1_salvadormacias;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Lab6p1_salvadormacias {

    public static Scanner lea = new Scanner(System.in);
    public static Scanner str = new Scanner(System.in);
    public static Random aleatorio = new Random();

    public static void main(String[] args) {
        menu();
    }//fin main

    public static void menu() {
        boolean salida = true;
        do {
            System.out.println("Bienvenido al menu!");
            System.out.println("Estas son las opciones disponibles: ");
            System.out.println("1.Suma de arreglos\n2.Vocales y consonantes\n3.Floor and ceiling\n4.Salir");
            System.out.println("Ingrese opcion : ");
            int opc = lea.nextInt();
            switch (opc) {
                case 1: {
                    System.out.println("-------------------------------------------------------------");
                    int cant1;
                    int cant2;
                    System.out.print("Ingrese cantidad de clases de estudiante 1: ");
                    cant1 = lea.nextInt();
                    int[] n1 = n_aleatorias(cant1);
                    System.out.println("Notas estudiante 1: " + print_n(n1));

                    System.out.print("Ingrese cantidad de clases de estudiante 2: ");
                    cant2 = lea.nextInt();
                    int[] n2 = n_aleatorias(cant2);
                    System.out.println("Notas estudiante 2: " + print_n(n2));
                    double prom = Promedio(n1, n2);

                    System.out.println("Promedio de notas de ambos estudiantes: " + prom);
                    System.out.println("-------------------------------------------------------------");

                }//fin case 1
                break;

                case 2: {
                    System.out.println("-------------------------------------------------------------");
                    int i = 0;
                    System.out.println("Ingrese una cadena: ");
                    String cadena = str.nextLine();
                    char[] resultado = voc_con(cadena);
                    System.out.print("Resultado: [");
                    do {
                        System.out.print(resultado[i]);
                        if (i < resultado.length - 1) {
                            System.out.print("][");
                        }
                        i++;
                    } while (i < resultado.length - 1);
                    System.out.println("]");
                    System.out.println("-------------------------------------------------------------");

                }//fin case 2
                break;

                case 3: {
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Ingrese tamaño del arreglo : ");
                    int tamano = lea.nextInt();
                    int[] altura = new int[tamano];

                    System.out.println("-------------------------------------------------------------");
                }//fin case 3
                break;
                case 4: {
                    salida = false;
                    System.out.println("Se abandonara el programa");
                    ;
                }//fin case 4
                break;

                default:
                    System.out.println("Opcion ingresada no es valida");
                    System.out.println("--------------------------------------------------------------------------------");

            }//fin switch

        } while (salida != false);//fin while
    }//fin menu

    public static int[] n_aleatorias(int cantClases) {
        int[] notas = new int[cantClases];
        int i = 0;
        while (i < notas.length) {
            notas[i] = (int) (Math.random() * 100 + 1);

            i++;
        }
        return notas;
    }//metodo para generar las notas aleatorias

    public static double Promedio(int[] n1, int[] n2) {
        int tot_n;
        double prom;
        int sum1 = sum_n(n1);
        int sum2 = sum_n(n2);
        tot_n = sum1 + sum2;
        double dem = (n1.length + n2.length);
        prom = (double) tot_n / dem;
        return prom;
    }//metodo para el calculo del promedio

    public static int sum_n(int[] notas) {
        int sum = 0;
        int i = 0;
        do {
            sum += notas[i];
            i++;
        } while (i < notas.length);
        return sum;
    }//metodo para almacenar la suma de los valores

    public static String print_n(int[] notas) {
        int x = 0;
        String string_n = "[";
        do {
            string_n += notas[x];
            if (x < notas.length - 1) {
                string_n += ",";
            }
            x++;
        } while (x < notas.length);
        string_n += "]";
        return string_n;
    }//metodo para imprimir el array de notas

    public static char[] voc_con(String y) {
        int x = y.length();
        int j = 0;
        int z = 0;
        char[] array = new char[y.length()];
        int c = 0;
        do {
            char a = y.charAt(j);
            if (Vocal(a)) {
                array[c] = a;
                c++;
            }
            j++;
        } while (j < x);

        while (z < x) {
            char b = y.charAt(z);
            if (!Vocal(b)) {
                array[c] = b;
                c++;
            }
            z++;
        }
        return array;
    }//metodo para recorrer la cadena 

    public static boolean Vocal(char v) {
        v = Character.toLowerCase(v);
        return (v == 'a'
                || v == 'e'
                || v == 'i'
                || v == 'o'
                || v == 'u');
    }

}//fin clase
