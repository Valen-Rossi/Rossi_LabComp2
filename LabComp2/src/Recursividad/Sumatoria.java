package Recursividad;

import java.util.Scanner;
public class Sumatoria {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int x, i;
        i=0;
        System.out.println("Ingrese un número --->");
        x = teclado.nextInt();
        System.out.println("Iterativo:");
        System.out.println(x+"∑= "+sumatoria(x,i));
        System.out.println("Recursivo:");
        System.out.println(x+"∑= "+sumatoria(x));
    }

    public static int sumatoria(int x, int i){
        for(i=x-1;i>=0;i--){
            x=x+i;
        }
        return x;
    }

    public static int sumatoria(int x){
        int aux;
        aux=x;
        if (aux<=0){
            return 0;
        }
        return x + sumatoria(aux-1);
    }
}