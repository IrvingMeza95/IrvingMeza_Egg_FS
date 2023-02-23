
package guiaTeorica7;

import java.util.Scanner;

public class Ejercicio_11 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        char[] caracter = new char[100];
        int i=0;
        
        System.out.println("Digite como maximo 100 caracteres individuales:");
        do {
            System.out.print((i+1)+". ");
            caracter[i] = leer.next().charAt(0);
            i++;
        } while (caracter[i-1]!='.' && i<99);
        
        for (int j = 0; j < 100; j++) {
            switch(Character.toUpperCase(caracter[j])){
                case 'A': caracter[j] = '@';
                        break;
                case 'E': caracter[j] = '#';
                        break;
                case 'I': caracter[j] = '$';
                        break;
                case 'O': caracter[j] = '%';
                        break;
                case 'U': caracter[j] = '*';
                        break;
            }
        }
        
        System.out.println("El mensaje codificado es: ");
        for(char carac: caracter){
            System.out.print(carac);
        }
        
    }
}
