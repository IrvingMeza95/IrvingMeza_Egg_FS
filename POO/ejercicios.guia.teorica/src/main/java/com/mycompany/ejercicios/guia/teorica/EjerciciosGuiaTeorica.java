
package com.mycompany.ejercicios.guia.teorica;

import servicios.LibroServicios;


public class EjerciciosGuiaTeorica {

    public static void main(String[] args) {
        LibroServicios libro1 = new LibroServicios();
        libro1.cargarLibro();
        System.out.println(libro1.toString());
    }
}
