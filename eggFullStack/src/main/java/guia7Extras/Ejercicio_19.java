
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_19 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("¿Cual es el tamaño de los vectores?");
        int t = leer.nextInt();
        int[] v1 = new int[t];
        int[] v2 = new int[t];
        
        System.out.println("\nRellenando vector A:");
        for (int i = 0; i < t; i++) {
            System.out.print((i+1)+". Digite un numero entero: ");
            v1[i] = leer.nextInt();
        }
        System.out.println("");
        
        System.out.println("Rellenando vector B:");
        for (int i = 0; i < t; i++) {
            System.out.print((i+1)+". Digite un numero entero: ");
            v2[i] = leer.nextInt();
        }
        
        if(compararVectores(v1,v2)){
            System.out.println("\nLos vectores son iguales.");
        }
        else{
            System.out.println("\nLos vectores no son iguales.");
        }
        
    }
    
    public static boolean compararVectores(int[] v1,int[] v2){
        boolean band=true;
        for (int i = 0; i < 5; i++) {
            if(v1[i]!=v1[i]){
                band=false;
                break;
            }
        }
        
        return band;
        
    }
    
}
