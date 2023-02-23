
package guia7;

import javax.swing.JOptionPane;

public class Ejercicio_16 {
    public static void main(String[] args) {
        int[] vector;
        int t = Integer.parseInt(JOptionPane.showInputDialog("Digite el tamaño del vector:"));
        int numero,repeticiones=0;
        String mensaje=":";
        boolean band=false;
        int[] posiciones;
        vector = new int[t];
        posiciones = new int[t];
        
        for (int i = 0; i < t; i++) {
            vector[i] = (int)(Math.random()*10);
        }
        JOptionPane.showMessageDialog(null, "Vector rellenado correctamente.",
                "Info",JOptionPane.INFORMATION_MESSAGE);
        numero = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero que desee buscar en el vector:"));
        
        int i=0;
        for(int V:vector){
            if (V==numero) {
                if (band) {
                    repeticiones++;
                }
                else{
                    band=true;
                    repeticiones++;
                }
                posiciones[repeticiones-1] = i;
            }
            i++;
        }
        
        for (int j = 0; j < repeticiones; j++) {
            mensaje= mensaje.concat(posiciones[j]+" ");
        }
        
        if (band) {
            JOptionPane.showMessageDialog(null, "El numero se ha encontrado en el vector "+repeticiones
                    +" veces en las posiciones"+mensaje+".",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "El numero no se ha encontrado en el vector.",
                    "Info", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
