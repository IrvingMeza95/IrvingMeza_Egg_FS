/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia7;

import java.util.Scanner;

/**
 *
 * @author iamf_
 */
public class Ejercicio_3 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String frase;
        
        System.out.println("Digite una frase: ");
        frase = leer.nextLine();
        
        System.out.println("Mayusculas: "+frase.toUpperCase()); 
        System.out.println("Minusculas: "+frase.toLowerCase());
        
    }
}
