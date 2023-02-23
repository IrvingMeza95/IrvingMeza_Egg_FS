
package guia7;

import java.util.Scanner;

public class Ejercicio_7 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String frase;
        
        System.out.println("Digite una frase: ");
        frase = leer.nextLine();
        
        if(frase.equals("eureka")){
            System.out.println("Correcto");
        }
        else{
            System.out.println("Incorrecto");
        }
        
    }
}
