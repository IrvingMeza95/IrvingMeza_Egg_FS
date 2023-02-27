
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_11 {
    private int numero;

    public Ejercicio_11() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Digite un numero: ");
        this.numero = leer.nextInt();
    }
    
    public void calcNumeroDigitos(){
        int n=numero;
        int numeroDigitos=0;
        while(n>0){
            n/=10;
            numeroDigitos++;
        }
        
        System.out.println("\nEl numero "+numero+" se conforma de "+numeroDigitos+" digitos.");
        
    }
    
}
