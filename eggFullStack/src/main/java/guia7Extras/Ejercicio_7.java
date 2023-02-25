
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_7 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Digite el tamaño del vector: ");
        int tamanio = leer.nextInt();
        float vector[] = new float[tamanio];
                
        pedirNumerosWhile(vector);
        pedirNumerosDoWhile(vector);
        
    }
    
    public static void pedirNumerosWhile(float vector[]){
        Scanner leer = new Scanner(System.in);
        int i=0;
        System.out.println("\nPidiendo valores:");
        while(i<vector.length){
            
            do {
                System.out.print((i+1)+". Digite un numero: ");
                vector[i] = leer.nextFloat();
                if(vector[i]<0)
                    System.out.println("Los valores negativos no son validos, por favor ingrese otro.");
            } while (vector[i]<0);
            i++;
        }
        
        System.out.println("RESULTADOS...");
        System.out.println("Valor maximo> "+numeroMaximo(vector)
        + "\nValor minimo: "+numeroMimino(vector)
        + "\nPromedio: "+calcPromedio(vector));
    }
    
    public static void pedirNumerosDoWhile(float vector[]){
        Scanner leer = new Scanner(System.in);
        int i=0;
        System.out.println("\nPidiendo valores:");
        do {
            do {
                System.out.print((i+1)+". Digite un numero: ");
                vector[i] = leer.nextFloat();
                if(vector[i]<0)
                    System.out.println("Los valores negativos no son validos, por favor ingrese otro.");
            } while (vector[i]<0);
            i++;
        } while (i<vector.length);
        
        System.out.println("RESULTADOS...");
        System.out.println("Valor maximo> "+numeroMaximo(vector)
        + "\nValor minimo: "+numeroMimino(vector)
        + "\nPromedio: "+calcPromedio(vector));
    }
    
    public static float numeroMaximo(float[] vector){
        float maximo=vector[0];
        for (int i = 0; i < vector.length; i++) {
            if(vector[i]>maximo)
                maximo = vector[i];
        }
        
        return maximo;
    }
    
    public static float numeroMimino(float[] vector){
        float minimo=vector[0];
        for (int i = 0; i < vector.length; i++) {
            if(vector[i]<minimo)
                minimo = vector[i];
        }
        
        return minimo;
    }
    
    public static float calcPromedio(float vector[]){
        float promedio=0;
        
        for (int i = 0; i < vector.length; i++) {
            promedio+=vector[i];
        }
      
        promedio/=vector.length;
        
        return promedio;
    }
    
}
