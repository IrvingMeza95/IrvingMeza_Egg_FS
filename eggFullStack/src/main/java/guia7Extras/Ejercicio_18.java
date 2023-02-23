
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_18 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Digite el tamaño del vector: ");
        int t = leer.nextInt();
        int[] vector = new int[t];
        
        System.out.println("");
        for (int i = 0; i < t; i++) {
            System.out.print((i+1)+". Digite un numero entero: ");
            vector[i] = leer.nextInt();
        }
        
        System.out.println("\nLa suma de los elementos es: "+suma(vector));
        
    }
    
    public static int suma(int[] v1){
        int resultado=0;
        
        for (int i = 0; i < v1.length; i++) {
            resultado+=v1[i];
        }
        
        return resultado;
        
    }
    
}
