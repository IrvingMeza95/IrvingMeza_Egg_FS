
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_1 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Digite la cantidad de minutos: ");
        int minutos = leer.nextInt();
        int dias,horas;
        
        dias = minutos/1440;
        //minutos = minutos % 1440;
        minutos %=1440;
        horas = minutos/60;
        
        System.out.println("Dias: "+dias
        + "\nHoras: "+horas);
        
    }
}
