
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_16 {
    private String nombre;
    private int edad;

    public Ejercicio_16() {
    }
    
    public void init(){
        Scanner leer = new Scanner(System.in);
        String opc;
        int i=0;
        do {
            i++;
            System.out.println("\nPersona "+i+":");
            System.out.print("Digite el nombre: ");
            this.nombre = leer.nextLine();
            System.out.print("Digite la edad: ");
            this.edad = leer.nextInt();
            if (edad>18) {
                System.out.println("\n"+nombre+" es mayor de edad.");
            }
            else{
                System.out.println("\n"+nombre+" no es mayor de edad.");
            }
            do {
                System.out.println("\n¿Desea ingresar los datos de otra persona?\n"
                + "Si\n"
                + "No");
                System.out.print("Opcion: ");
                opc = leer.next();
                if(!opc.substring(0,1).toUpperCase().equals("S") &&
                    !opc.substring(0,1).toUpperCase().equals("N"))
                    System.out.println("Opcion no valida, por favor intentelo de nuevo.");
            } while (!opc.substring(0,1).toUpperCase().equals("S") &&
                    !opc.substring(0,1).toUpperCase().equals("N"));
        } while (opc.substring(0,1).toUpperCase().endsWith("S"));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + "\n Edad: " + edad;
    }
        
}
