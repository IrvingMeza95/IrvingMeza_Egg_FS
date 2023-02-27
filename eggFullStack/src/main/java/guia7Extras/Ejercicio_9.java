
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_9 {
    private int dividendo;
    private int divisor;

    public Ejercicio_9() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Digite el dividendo: ");
        this.dividendo = leer.nextInt();
        System.out.print("Digite el divisor: ");
        this.divisor = leer.nextInt();
    }

    public int getDividendo() {
        return dividendo;
    }

    public void setDividendo(int dividendo) {
        this.dividendo = dividendo;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }
    
    public void calcResiduoCociente(){
        float residuo=dividendo;
        int cociente=0;
        
        while(residuo>divisor){
            residuo-=divisor;
            cociente++;
        }
        
        System.out.println("\nResiduo: "+residuo
                        + "\nCociente: "+cociente);
        
    }
    
}
