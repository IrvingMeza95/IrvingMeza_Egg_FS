
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_20 {
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("¿Cual sera el tamaño del vector?, ");
        int t = leer.nextInt();
        int vector[] = new int[t];
        
        rellenarVector(vector);
        mostrarVector(vector);
        
    }
    
    public static void rellenarVector(int vector[]){
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int)((Math.random()*10));
        }
    }
    
    private static void mostrarVector(int vector[]){
        System.out.println("\nMostrando vector...");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]+" ");
        }
    }
    
}
