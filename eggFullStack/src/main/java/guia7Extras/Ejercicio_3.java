
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_3 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String letra;
        
        System.out.print("Digite una letra: ");
        letra = leer.next();
        
        if (letra.substring(0,1).toUpperCase().equals("A") ||
                letra.substring(0,1).toUpperCase().equals("E") ||
                letra.substring(0,1).toUpperCase().equals("I") ||
                letra.substring(0,1).toUpperCase().equals("O") ||
                letra.substring(0,1).toUpperCase().equals("U")) {
            System.out.println("\nLa letra ["+letra+"] SI es vocal.");
        }
        else{
            System.out.println("\nLa letra ["+letra+"] NO es vocal.");
        }
        
    }
    
    public static void vocal(String letra){
        switch(letra.substring(0,1).toUpperCase()){
            case "A":
            case "E":
            case "I":
            case "O":
            case "U": 
                System.out.println("\nLa letra ["+letra+"] SI es vocal.");
                break;
            default:
                System.out.println("\nLa letra ["+letra+"] NO es vocal.");
        }
    }
    
}
