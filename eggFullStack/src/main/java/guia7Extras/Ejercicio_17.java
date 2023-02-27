
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_17 {
    private int numero=0;

    public Ejercicio_17() {
    }
    
    public void esPrimo(){
        Scanner leer = new Scanner(System.in);
        int contador=0;
        
        System.out.print("Digite un numero: ");
        this.setNumero(leer.nextInt());
        
        for (int i = 1; i < 7; i++) {
            if(numero%i==0)
                contador++;
            
            if(contador>2){
                break;
            }
        }
        
        if (contador>=2) {
            System.out.println("\n"+numero+" no es numero primo.");
        }
        else{
            System.out.println("\n"+numero+" si es numero primo.");
        }
        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
        
}
