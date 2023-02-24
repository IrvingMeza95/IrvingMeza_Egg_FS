
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_5 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String opc;
        
        do {
            System.out.println("Ingresa el tipo de socio:\n"
            + "[A] Socio A\n"
            + "[B] Socio B\n"
            + "[C] Socio C");
            System.out.print("Opcion: ");
            opc = leer.nextLine();
            if(!opc.substring(0,1).toUpperCase().equals("A") &&
                !opc.substring(0,1).toUpperCase().equals("B") &&
                !opc.substring(0,1).toUpperCase().equals("C"))
                System.out.println("Valor no valido, por favor intente de nuevo.");
        } while (!opc.substring(0,1).toUpperCase().equals("A") &&
                !opc.substring(0,1).toUpperCase().equals("B") &&
                !opc.substring(0,1).toUpperCase().equals("C"));
        
        System.out.print("\nIngrese la cantidad a pagar: ");
        float monto = leer.nextFloat();
        
        System.out.println("\nSu cuota a pagar por ser socio tipo "+opc.toUpperCase()+" es de $"+cuota(monto,opc));
        
    }
    
    public static float cuota(float monto,String tipoSocio){
        float montoFinal=0;
        
        switch(tipoSocio.toUpperCase()){
            case "A": montoFinal = (float)(monto*0.5); break;
            case "B": montoFinal = (float)(monto*0.65); break;
            case "C": montoFinal = monto; break;
        }
        
        return montoFinal;
        
    }
    
}
