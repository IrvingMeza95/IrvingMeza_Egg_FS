
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_6 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Digite el numero de personas: ");
        int numeroPersonas = leer.nextInt();
        float[] personas = new float[numeroPersonas];
        float[] promedio = new float[2];
        int contadorSecundarior=0;
        
        System.out.println("Pidiendo alturas...");
        for (int i = 0; i < numeroPersonas; i++) {
            System.out.print((i+1)+". Digite la altura: ");
            personas[i] = leer.nextFloat();
            if (personas[i]<=1.6){
                promedio[0]+=personas[i];
                contadorSecundarior++;
            }
            promedio[1]+=personas[i];
        }
        
        System.out.println("\nRESULTADOS...");
        System.out.print("Promedio de alturas de personas menores o iguales a 1.60 metros: "+calcPromedio(contadorSecundarior,promedio[0])+" metros\n"
        + "Promedio de alturas de personas en geneneral: "+calcPromedio(personas.length,promedio[1])+" metros");
        
    }
    
    public static float calcPromedio(int totalPersonas,float altuas){
        float promedio=0;
        
        promedio =(float)(altuas/totalPersonas);
        
        return promedio;
    }
    
}
