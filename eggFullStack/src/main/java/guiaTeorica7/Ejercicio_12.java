
package guiaTeorica7;

import java.util.Scanner;

public class Ejercicio_12 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Digite dos numeros:");
        int n1 = leer.nextInt();
        int n2 = leer.nextInt();
        
        esMultiplo(n1,n2);
        
    }
    
    public static void esMultiplo(int n1,int n2){
        if (n1 % n2 ==0) {
            System.out.println(n1+" si es multiplo de "+n2+".");
        }
        else{
            System.out.println(n1+" no es multiplo de "+n2+".");
        }
    }
    
}
