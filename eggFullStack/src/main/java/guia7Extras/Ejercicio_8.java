
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_8 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int contador[] = new int[3];
        int numero;
        
        do {
            System.out.print((contador[0]+1)+". Digite un numero entero positivo que no sea multiplo de 5: ");
            numero = leer.nextInt();
            if (numero%5!=0) {
                if(numero<0)
                    continue;
                
                if (numero%2==0) {
                    contador[1]++;
                }
                else{
                    contador[2]++;
                }
                contador[0]++;
            }
        } while (numero%5!=0);
        
        System.out.println("""
                           RESULTADOS
            Cantidad de numeros pares: """+contador[1]
        + "\nCantidad de numeros impares: "+contador[2]
        + "\nCantidad total de numeros: "+contador[0]);
        
    }
}
