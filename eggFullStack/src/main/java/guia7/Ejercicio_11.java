
package guia7;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Ejercicio_11 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int numero,suma=0,i=0;
        int limite = Integer.parseInt(JOptionPane.showInputDialog("Digite el limite:"));
        
        do {
            i++;
            numero = Integer.parseInt(JOptionPane.showInputDialog("Iteracion # "+i+"...\nDgite un numero:"));
            suma += numero;
        } while (suma<limite);
        
        JOptionPane.showMessageDialog(null,"El totoal de la sumatoria fue de "+suma);
        
    }
}
