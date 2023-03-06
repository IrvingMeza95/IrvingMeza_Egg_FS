
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_Calculadora {

    public Ejercicio_Calculadora() {
        do {
        } while (this.MENU());
    }
    
    public boolean MENU(){
        Scanner leer = new Scanner(System.in);
        boolean band=true;
        int opc,numeroFilas,numeroColumnas,fila,columna;
        float numero1,numero2,vector[],tabla[][];
        
        do {
            System.out.print("\n¿Que operacion desea realizar?\n"
            + "[1] Sumar 2 numeros\n"
            + "[2] Restar 2 numeros\n"
            + "[3] Multiplicar 2 numeros\n"
            + "[4] Division\n"
            + "[5] Sumar numeros de un vector\n"
            + "[6] Sumar columnad e una tabla\n"
            + "[7] Sumar fila de una tabla\n"
            + "[8] Salir\n"
            + "Opcion: ");
            opc = leer.nextInt();
            if(opc<1 || opc>8)
                System.out.println("\nOpcion no valida.");
        } while (opc<1 || opc>8);
                
        switch (opc) {
            case 1:
                System.out.println("\nDigite dos numeros: ");
                numero1 = leer.nextFloat();
                numero2 = leer.nextFloat();
                System.out.println("\nEl resultado es = "+this.sumar(numero1, numero2));
                break;
            case 2:
                System.out.println("\nDigite dos numeros: ");
                numero1 = leer.nextFloat();
                numero2 = leer.nextFloat();
                System.out.println("\nEl resultado es = "+this.restar(numero1, numero2));
                break;
            case 3:
                System.out.println("\nDigite dos numeros: ");
                numero1 = leer.nextFloat();
                numero2 = leer.nextFloat();
                System.out.println("\nEl resultado es = "+this.multiplicar(numero1, numero2));
                break;
            case 4:
                System.out.println("\nDigite dos numeros: ");
                numero1 = leer.nextFloat();
                numero2 = leer.nextFloat();
                System.out.println("\nEl resultado es = "+this.division(numero1, numero2));
                break;
            case 5:
                System.out.print("\nDigite el tamaño del vector: ");
                numeroColumnas = leer.nextInt();
                vector = new float[numeroColumnas];
                for (int i = 0; i < numeroColumnas; i++) {
                    System.out.print((i+1)+". Digite un numero: ");
                    vector[i] = leer.nextFloat();
                }
                System.out.println("\nEl resultado es = "+this.sumar(vector));
                break;
            case 6:
                System.out.print("\nDigite el numero de filas: ");
                numeroFilas = leer.nextInt();
                System.out.print("Digite el numero de columnas: ");
                numeroColumnas = leer.nextInt();
                tabla = new float[numeroFilas][numeroColumnas];
                for (int i = 0; i < numeroFilas; i++) {
                    for (int j = 0; j < numeroColumnas; j++) {
                        System.out.print((i+1)+"|"+(j+1)+". Digite un numero: ");
                        tabla[i][j] = leer.nextFloat();
                    }
                }
                System.out.print("\nDigite el numero de columna que desea sumar: ");
                columna = leer.nextInt();
                System.out.println("\nEl resultado es = "+this.sumarColumna(tabla, columna));
                break;
            case 7:
                System.out.print("\nDigite el numero de filas: ");
                numeroFilas = leer.nextInt();
                System.out.print("Digite el numero de columnas: ");
                numeroColumnas = leer.nextInt();
                tabla = new float[numeroFilas][numeroColumnas];
                for (int i = 0; i < numeroFilas; i++) {
                    for (int j = 0; j < numeroColumnas; j++) {
                        System.out.print((i+1)+"|"+(j+1)+". Digite un numero: ");
                        tabla[i][j] = leer.nextFloat();
                    }
                }
                System.out.print("\nDigite el numero de fila que desea sumar: ");
                fila = leer.nextInt();
                System.out.println("\nEl resultado es = "+this.sumarFila(tabla, fila));
                break;
            case 8:
                band=false;
        }
        
        return band;
    }
    
    public float sumar(float numero1,float  numero2){
        return numero1+numero2;
    }
    
    public float sumar(float numeros[]){
        float suma=0;
        for (int i = 0; i < numeros.length; i++) {
            suma+=numeros[i];
        }
        return suma;
    }
    
    public float sumarColumna(float tabla[][],int columna){
        float suma=0;
        for (int i = 0; i < tabla.length; i++) {
            suma+=tabla[i][columna];
        }
        return suma;
    }
    
    public float sumarFila(float tabla[][],int fila){
        float suma=0;
        for (int i = 0; i < tabla.length; i++) {
            suma+=tabla[fila][i];
        }
        return suma;
    }
    
    public float restar(float numero1,float  numero2){
        return numero1-numero2;
    }
    
    public float multiplicar(float numero1,float  numero2){
        return numero1*numero2;
    }
    
    public float division(float dividendo,float  divisor){
        if(divisor!=0){
            return dividendo/divisor;
        }
        else{
            return 0;
        }
    }
        
}
