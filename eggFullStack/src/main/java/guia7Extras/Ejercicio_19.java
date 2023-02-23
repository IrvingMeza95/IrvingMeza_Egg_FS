
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_19 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int[] v1 = {1,2,3,4,5};
        int[] v2 = {1,2,3,4,5};
        
        if(compararVectores(v1,v2)){
            System.out.println("Los vectores son iguales.");
        }
        else{
            System.out.println("Los vectores no son iguales.");
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
