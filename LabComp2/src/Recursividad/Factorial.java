package Recursividad;

import java.util.Scanner;
public class Factorial {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int x, i;
        i=0;
        System.out.println("Ingrese un número --->");
        x = teclado.nextInt();
        System.out.println("Iterativo:");
        System.out.println(x+"!= "+factorial(x,i));
        System.out.println("Recursivo:");
        System.out.println(x+"!= "+factorial(x));
    }

    public static int factorial(int x, int i){
        for(i=x-1;i>=1;i--){
            x=x*i;
        }
        return x;
    }

    public static int factorial(int x){
        int aux;
        aux=x;
        if (aux<=1){
            return 1;
        }
        return (x * factorial(aux-1));
    }
}