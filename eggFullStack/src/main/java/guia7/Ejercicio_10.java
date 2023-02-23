
package guia7;

import java.util.Scanner;

public class Ejercicio_10 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int n1,n2,opcion=0;
        char op='n';
        
        System.out.println("Digite el primer numero:");
        n1 = leer.nextInt();
        System.out.println("Digite el segundo numero:");
        n2 = leer.nextInt();
        
        do {
            System.out.println("MENU:\n"
            + "[1] Sumar\n"
            + "[2] Restar\n"
            + "[3] Multiplicar\n"
            + "[4] Dividir\n"
            + "[5] Salir");
            System.out.println("Opcion: ");
            opcion = leer.nextInt();
            
            switch(opcion){
                case 1: System.out.println("El resultado de la suma es: "+(n1+n2));
                        break;
                case 2: System.out.println("El resultado de la resta es: "+(n1-n2));
                        break;
                case 3: System.out.println("El resultado de la multiplicacion es: "+(n1*n2));
                        break;
                case 4: 
                        if(n2!=0){
                            System.out.println("El resultado de la division es: "+(n1/n2));
                        }
                        else{
                            System.out.println(n2+" es 0, por lo tanto no e sposible realizar la division.");
                        }
                        break;
                case 5: 
                        System.out.println("¿Desea salir del programa?\n"
                        + "Si\n"
                        +"No");
                        op = leer.next( ).charAt(0);
                    break;
                default: System.out.println("La opcion seleccionada no es valida.");
                    
            }
            
        } while (op=='n');
        
    }
}
