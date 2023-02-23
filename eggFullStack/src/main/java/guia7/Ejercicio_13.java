
package guia7;

import javax.swing.JOptionPane;

public class Ejercicio_13 {
    public static void main(String[] args) {
        int numeroLados = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de lados:"));
        
        for (int i = 0; i < numeroLados; i++) {
            for (int j = 0; j < numeroLados; j++) {
                if (i==0 || j==0 || i==(numeroLados-1) || j==(numeroLados-1)) {
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
        
    }
}
