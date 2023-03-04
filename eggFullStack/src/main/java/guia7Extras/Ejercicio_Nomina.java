
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_Nomina {
    private static int topeSalarial=200;
    
    public static void main(String[] args) {
        do {
        } while (MENU());
    }
    
    public static boolean MENU(){
        boolean band=true;
        Scanner leer = new Scanner(System.in);
        String opc;
        int op;
        int totalHoras;
        
        do {
            System.out.print("\n¿Cual es su puesto?\n"
            + "[1] Obreros\n"
            + "[2] Oficinista\n"
            + "[3] Ejecutivo\n"
            + "[4] Salir\n"
            + "Opcion: ");
            opc = leer.next();
            if(!opc.substring(0,1).equals("1") &&
                !opc.substring(0,1).equals("2") &&
                !opc.substring(0,1).equals("3") &&
                !opc.substring(0,1).equals("4"))
                System.out.println("Opcion no valida, por favor intentelo de nuevo.");
        } while (!opc.substring(0,1).equals("1") &&
                !opc.substring(0,1).equals("2") &&
                !opc.substring(0,1).equals("3") &&
                !opc.substring(0,1).equals("4"));
        
        if(opc.substring(0,1).equals("4"))
            band=false;
        
        if (band) {
            System.out.print("\n¿Cuantas horas laboro en al ultima semana?, ");
            totalHoras = leer.nextInt();
            
            System.out.println("\nSu sueldo neta seria de $"+calcSueldo(opc,totalHoras));
        
            do {
                System.out.print("\n¿Deseas ver el desgloce del sueldo?\n"
                        + "[1] Si\n"
                        + "[2] No\n"
                        + "Opcion: ");
                        op = leer.nextInt();
                        if(op!=1 && op!=2)
                            System.out.println("Opcion no valida, por favor intentelo de nuevo.");
            } while (op!=1 && op!=2);

            if(op==1)
                desgloceSueldo(opc, totalHoras);
        }
        
        return band;
    }
    
    public static float calcSueldo(String opc,int totHoras){
        float totSueldo=0;
        float sueldoFijo;
        switch(opc.substring(0,1)){
            case "1":
                sueldoFijo=10;
                if (totHoras<=35) {
                    totSueldo+= sueldoFijo*totHoras;
                }
                else{
                    totSueldo+= sueldoFijo*35;
                    totHoras-=35;
                    totSueldo+= (sueldoFijo*1.5)*totHoras;
                }
                if (totSueldo>topeSalarial) {
                    totSueldo*=0.8;
                }
                break;
            case "2":
                sueldoFijo=15;
                if (totHoras<=35) {
                    totSueldo+= sueldoFijo*totHoras;
                }
                else{
                    totSueldo+= sueldoFijo*35;
                    totHoras-=35;
                    totSueldo+= (sueldoFijo*1.5)*totHoras;
                }
                if (totSueldo>topeSalarial) {
                    totSueldo*=0.8;
                }
                break;
            case "3":
                sueldoFijo=20;
                if (totHoras<=35) {
                    totSueldo+= sueldoFijo*totHoras;
                }
                else{
                    totSueldo+= sueldoFijo*35;
                    totHoras-=35;
                    totSueldo+= (sueldoFijo*1.5)*totHoras;
                }
                if (totSueldo>topeSalarial) {
                    totSueldo*=0.8;
                }
                
        }
        
        return totSueldo;
    }
    
    public static void desgloceSueldo(String opc,int totHoras){
        float totSueldo=0;
        float sueldoFijo;
        switch(opc.substring(0,1)){
            case "1":
                sueldoFijo=10;
                System.out.println("\nDesgloce de sueldo....\n"
                + "Antes de impouestos:");
                if (totHoras<=35) {
                    totSueldo+= sueldoFijo*totHoras;
                    System.out.println("Sueldo base: $"+ totSueldo);
                }
                else{
                    totSueldo+= sueldoFijo*35;
                    System.out.println("Sueldo base: $"+ totSueldo);
                    totHoras-=35;
                    totSueldo+= (sueldoFijo*1.5)*totHoras;
                    System.out.println("Sueldo por horas extras: $"+(totSueldo-(sueldoFijo*35)));
                }
                System.out.println("Despues de impuestos:");
                if (totSueldo>topeSalarial) {
                    totSueldo*=0.8;
                    System.out.println("Sueldo neto: "+totSueldo);
                }
                break;
            case "2":
                sueldoFijo=15;
                System.out.println("\nDesgloce de sueldo....\n"
                + "Antes de impouestos:");
                if (totHoras<=35) {
                    totSueldo+= sueldoFijo*totHoras;
                    System.out.println("Sueldo base: $"+ totSueldo);
                }
                else{
                    totSueldo+= sueldoFijo*35;
                    System.out.println("Sueldo base: $"+ totSueldo);
                    totHoras-=35;
                    totSueldo+= (sueldoFijo*1.5)*totHoras;
                    System.out.println("Sueldo por horas extras: $"+(totSueldo-(sueldoFijo*35)));
                }
                System.out.println("Despues de impuestos:");
                if (totSueldo>topeSalarial) {
                    totSueldo*=0.8;
                    System.out.println("Sueldo neto: "+totSueldo);
                }
                break;
            case "3":
                sueldoFijo=20;
                System.out.println("\nDesgloce de sueldo....\n"
                + "Antes de impouestos:");
                if (totHoras<=35) {
                    totSueldo+= sueldoFijo*totHoras;
                    System.out.println("Sueldo base: $"+ totSueldo);
                }
                else{
                    totSueldo+= sueldoFijo*35;
                    System.out.println("Sueldo base: $"+ totSueldo);
                    totHoras-=35;
                    totSueldo+= (sueldoFijo*1.5)*totHoras;
                    System.out.println("Sueldo por horas extras: $"+(totSueldo-(sueldoFijo*35)));
                }
                System.out.println("Despues de impuestos:");
                if (totSueldo>topeSalarial) {
                    totSueldo*=0.8;
                    System.out.println("Sueldo neto: "+totSueldo);
                }
                
        }
    }
    
}
