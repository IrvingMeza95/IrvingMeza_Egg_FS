
package com.mycompany.ejercicios.guia.teorica;

import servicios.CursoServicios;

public class EjerciciosGuiaTeorica {
    public static void main(String[] args) {
        CursoServicios cursos = new CursoServicios(2);
        cursos.cargarArregloDeCursos();
        cursos.mostrarArregloDeCursos();
        cursos.calcularGananciasSemanalesDeArregloDeCursos();
    }
}
