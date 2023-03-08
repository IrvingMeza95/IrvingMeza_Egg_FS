
package com.mycompany.ejercicios.guia.teorica;

import entidades.Circunferencia;

public class EjerciciosGuiaTeorica {

    public static void main(String[] args) {
        Circunferencia circ1 = new Circunferencia();
        circ1.crearCircunferencia();
        System.out.println("El perimetro de la circunferencia 1 es: "+circ1.calcPerimetro());
        System.out.println("El area de la circunferencia es: "+circ1.calcArea());
    }
}
