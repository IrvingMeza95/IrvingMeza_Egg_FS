
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_10 {
    private int numeroAleatorio;

    public Ejercicio_10() {
        this.numeroAleatorio = (int)((Math.random()*10)*(Math.random()*10));
    }
            
    public void adivinarNumeroAleatorio(){
        Scanner leer = new Scanner(System.in);
        int numero,intentos=0;
        System.out.println("Adivinando numero aleatorio...");
        do {
            intentos++;
            System.out.print(intentos+". Digite un numero: ");
            numero = leer.nextInt();
            if(numero>numeroAleatorio){
                System.out.println("El numero a adivinar es menor.");
            }
            else if(numero<numeroAleatorio){
                System.out.println("El numero a adivinar es mayor.");
            }
        } while (numeroAleatorio!=numero);
        
        System.out.println("\n¡FELICIDADES! el numero a adivinar era "+numeroAleatorio+".");
        
    }
    
}
