
package guia7;

import java.util.Scanner;

public class Ejercicio_6 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int numero;
        
        System.out.println("Digite un numero: ");
        numero = leer.nextInt();
        
        if(numero % 2 ==0){
            System.out.println("El numero "+numero+" es par.");
        }
        else{
            System.out.println("El numero "+numero+" es impar.");
        }
        
    }
}
