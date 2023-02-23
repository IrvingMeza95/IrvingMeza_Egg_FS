
package guia7;

import java.util.Scanner;

public class Ejercicio_17 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Digite el tamaño del vector:");
        int t = leer.nextInt();
        String[] vector = new String[t];
        int digitos=0;
        int tContador=0;
        
        for (int i = 0; i < t; i++) {
            digitos = (int)(Math.random()*10);
            switch(digitos){
                case 0:
                case 1: vector[i] = String.valueOf((Math.random()*10));
                        if(vector[i].length()>tContador)
                            tContador = vector[i].length();
                        break;
                case 2:
                case 3: vector[i] = String.valueOf((int)(Math.random()*100));
                        if(vector[i].length()>tContador)
                            tContador = vector[i].length();
                        break;
                case 4:
                case 5: vector[i] = String.valueOf((int)(Math.random()*1000));
                        if(vector[i].length()>tContador)
                            tContador = vector[i].length();
                        break;
                case 6:
                case 7: vector[i] = String.valueOf((int)(Math.random()*10000));
                        if(vector[i].length()>tContador)
                            tContador = vector[i].length();
                        break;
                case 8:
                case 9:
                case 10: vector[i] = String.valueOf((int)(Math.random()*100000));
                        if(vector[i].length()>tContador)
                            tContador = vector[i].length();
                        break;
                
            }
        }
        
        int[] contador = new int[tContador];
        for(String v:vector){
            contador[v.length()-1]++;
        }
        System.out.println("");
        
        System.out.println("INFORME DE RESULTADOS:");
        for (int i = 0; i < contador.length; i++) {
            System.out.println((i+1)+" digitos: "+contador[i]);
        }
        
    }
}
