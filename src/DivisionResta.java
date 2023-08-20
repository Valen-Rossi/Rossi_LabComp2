import java.util.Scanner;

public class DivisionResta {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int dividendo, divisor, cociente = 0;
        
        System.out.print("Ingrese el dividendo --->");
        dividendo = teclado.nextInt();
        System.out.print("Ingrese el divisor --->");
        divisor = teclado.nextInt();

        System.out.println("Iterativo:");
        System.out.println(dividendo+"/"+divisor+"= " + divres(dividendo, divisor, cociente));

        System.out.println("Recursivo:");
        System.out.println(dividendo+"/"+divisor+"= " + divres(dividendo, divisor));
    }

    public static int divres(int dividendo, int divisor, int cociente) {

        while (dividendo >= divisor) {
            dividendo -= divisor;
            cociente++;
        }
        return cociente;
    }

    public static int divres(int dividendo, int divisor) {
        if (dividendo < divisor) {
            return 0;
        }
        return 1 + divres(dividendo - divisor, divisor);
    }
}
