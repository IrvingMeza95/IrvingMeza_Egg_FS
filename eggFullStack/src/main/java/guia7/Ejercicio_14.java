
package guia7;

import javax.swing.JOptionPane;

public class Ejercicio_14 {
    public static void main(String[] args) {
        float dinero = Float.parseFloat(JOptionPane.showInputDialog("Digite la cantidad de euros que desea conertir:"));
        String moneda;
        
        do {
            moneda = JOptionPane.showInputDialog("MENU:\n"
            + "[1] Dolares\n"
            + "[2] Libras\n"
            + "[3] Yenes\n"
            + "[4] Salir");
            if(verificacionMonedas(moneda))
                JOptionPane.showMessageDialog(null, "Moneda seleccionada no disponible.",
                        "Error", JOptionPane.ERROR_MESSAGE);
        } while (verificacionMonedas(moneda));
        
        convertidorDivisas(dinero,moneda);
        
    }
    
    public static void convertidorDivisas(float dinero,String moneda){
        
        if(moneda.substring(0,1).toUpperCase().equals("D") || 
                moneda.substring(0,1).toUpperCase().equals("1")){
            JOptionPane.showMessageDialog(null, dinero+" euros = "+(dinero*1.28611)+" USD.",
                    "Conversor",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(moneda.substring(0,1).toUpperCase().equals("L") ||
                moneda.substring(0,1).toUpperCase().equals("2")){
            JOptionPane.showMessageDialog(null, dinero+" euros = "+(dinero*0.86)+" LB.",
                    "Conversor",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(moneda.substring(0,1).toUpperCase().equals("Y") ||
                moneda.substring(0,1).toUpperCase().equals("3")){
            JOptionPane.showMessageDialog(null, dinero+" euros = "+(dinero*129.852)+" Yens.",
                    "Conversor",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Fin del programa.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public static boolean verificacionMonedas(String moneda){
        String[] caractereses = {"D","L","Y","S","1","2","3","4"};
        boolean D=true;
        
        for(String C:caractereses){
            if(C.equals(moneda.substring(0,1).toUpperCase())){
                D=false;
                break;
            }
        }
        
        return D;
        
    }
    
}
