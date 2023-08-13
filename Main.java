import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner telcado = new Scanner(System.in);
        int nums[]= new int[3];
        int aux=0;

        for (int x=0; x<3; x++) {
            System.out.printf("Ingrese un número --->");
            nums[x]= telcado.nextInt();
        }

        for (int y=0; y<2; y++) {
            for (int z=0; z<2; z++) {
                if(nums[z]<nums[z+1]){
                    aux=nums[z];
                    nums[z]=nums[z+1];
                    nums[z+1]=aux;
                }
            }
        }

        System.out.println("Números ingresados ordenados de mayor a menor:");
        for (int i=0; i<3; i++) {
            System.out.printf("["+nums[i]+"]");
        }
    }
}