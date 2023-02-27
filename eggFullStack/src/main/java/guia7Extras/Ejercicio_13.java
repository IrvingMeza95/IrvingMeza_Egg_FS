
package guia7Extras;

public class Ejercicio_13 {

    public Ejercicio_13() {
    }
    
    public void crearPiramide(int nivel){
        System.out.println("PIRAMIDE...");
        for (int i = 1; i <= nivel; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println("");
        }
    }
    
}
