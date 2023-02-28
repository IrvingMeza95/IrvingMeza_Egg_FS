
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_4 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int numero;
        
        do {
            System.out.print("\nDigite un numero entre 1 y 10: ");
            numero = leer.nextInt();
            if(numero<0 || numero>10)
                System.out.println("El valor ingresado no es valido, por favor intentelo de nuevo.");
        } while (numero<0 || numero>10);
        
        System.out.println("\n"+numero+" en numero romano es "+numeroRomano(numero));
        
    }
    
    public static String numeroRomano(int numero){
        String numRomano="";
        switch(numero){
            case 1:numRomano = "I";
                break;
            case 2: numRomano = "II";
                break;
            case 3: numRomano = "III";
                break;
            case 4: numRomano = "IV";
                break;
            case 5: numRomano = "V";
                break;
            case 6:numRomano = "VI";
                break;
            case 7:numRomano = "VII";
                break;
            case 8:numRomano = "VIII";
                break;
            case 9:numRomano = "IX";
                break;
            case 10:numRomano = "X";
                break;
        }
        
        return numRomano;
    }
    
}
