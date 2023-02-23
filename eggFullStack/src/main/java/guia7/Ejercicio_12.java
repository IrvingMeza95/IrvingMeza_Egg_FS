
package guia7;

import javax.swing.JOptionPane;

public class Ejercicio_12 {
    public static void main(String[] args) {
        String mensaje,FDE="&&&&&";
        int numeroFallas=0,numeroAciertos=0;
        
        do {
            mensaje = JOptionPane.showInputDialog("Digite una cadena de maximo 5 cractereses:");
            if(mensaje.length()>5){
                JOptionPane.showMessageDialog(null, "La cadena introducida supero el "
                        + "niumero de caractereses requeridos.", "Mensaje", JOptionPane.ERROR_MESSAGE);
                numeroFallas++;
            }
            else{
                if (mensaje.substring(0,1).toUpperCase().equals("X") && 
                        mensaje.substring(4,5).toUpperCase().equals("O") &&
                        !"&&&&&".equals(mensaje)) {
                    numeroAciertos++;
                }
                else{
                    numeroFallas++;
                }
            }
        } while (!FDE.equals(mensaje));
        
        JOptionPane.showMessageDialog(null, "Total Aciertos: "+numeroAciertos+"\n"
                + "Total Fallos: "+numeroFallas, "Informe", JOptionPane.INFORMATION_MESSAGE);
        
    }
}
