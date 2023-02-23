
package guia7;

import java.util.Scanner;

public class Ejercicio_9 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Digite una frase:");
        String frase = leer.nextLine();
        
        if(frase.substring(0,1).equals("A")){
            System.out.println("Correcto");
        }
        else{
            System.out.println("Incorrecto");
        }
        
    }
}
