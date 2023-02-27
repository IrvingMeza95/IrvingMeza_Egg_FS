
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_14 {
    private int numeroHijos;

    public Ejercicio_14() {
    }
    
    //METODO PARA INICIAR EL EJERCICIO 14
    public void init(int numeroFamilias){
        Ejercicio_14 familias[] = new Ejercicio_14[numeroFamilias];
        for (int i = 0; i < numeroFamilias; i++) {
            System.out.print((i+1)+". ");
            familias[i] = new Ejercicio_14();
            familias[i].setNumeroHijos();
        }
        
        System.out.println("\nEl promedio de edades de los hijos de las  "+familias.length
                +" familias es de "+calcPromedioEdadHijosVariasFamilias(familias)+" años.");
        
    }        
            
    public float calcPromedioEdadHijos(){
        Scanner leer = new Scanner(System.in);
        float sumatoria=0;
        System.out.println("\nPidiendo edades...");
        for (int i = 0; i < numeroHijos; i++) {
            System.out.println((i+1)+". Digite la edad: ");
            sumatoria+= leer.nextFloat();
        }
        
        return sumatoria/numeroHijos;
    }
    
    public float calcPromedioEdadHijosVariasFamilias(Ejercicio_14[] familias){
        float sumatoria=0;
        int i=1;
        for(Ejercicio_14 fams:familias){
            System.out.print("Familia "+i+":");
            sumatoria+=fams.calcPromedioEdadHijos();
            i++;
        }
        
        return sumatoria/familias.length;
        
    }

    public int getNumeroHijos() {
        return numeroHijos;
    }

    public void setNumeroHijos() {
        Scanner leer = new Scanner(System.in);
        System.out.println("¿Cuantos hijos tiene la familia?");
        this.numeroHijos = leer.nextInt();
    }
    
}
