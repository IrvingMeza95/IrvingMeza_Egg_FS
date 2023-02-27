
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_21 {
    private float trabajoPracticoUno=0;
    private float trabajoPracticoDos=0;
    private float integradorUno=0;
    private float integradorDos=0;
    
    private float porcentajeTrabajoPracticoUno=0.15f;
    private float porcentajeTrabajoPracticoDos=0.15f;
    private float porcentajeIntegradorUno=0.25f;
    private float porcentajeIntegradorDos=0.55f;

    public Ejercicio_21() {
    }
    
    public void init(){
        Scanner leer = new Scanner(System.in);
        System.out.print("¿Cuantos alumnos hay en el curso?, ");
        int numeroAlumnos = leer.nextInt();
        Ejercicio_21 alumnos[] = new Ejercicio_21[numeroAlumnos];
        float aprobados[] = new float[numeroAlumnos];
        int numeroAprobaddos=0;
        float desaprobados[] = new float[numeroAlumnos];
        int numeroDesaprobaods=0;
        String opc;
        
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("\nAlumno "+(i+1)+":");
            alumnos[i] = new Ejercicio_21();
            alumnos[i].setNotas();
            if (alumnos[i].calcPromedio(alumnos[i])>=7) {
                aprobados[numeroAprobaddos] = alumnos[i].calcPromedio(alumnos[i]);
                numeroAprobaddos++;
            }
            else{
                desaprobados[numeroDesaprobaods] = alumnos[i].calcPromedio(alumnos[i]);
                numeroDesaprobaods++;
            }
        }
        
        System.out.println("\nRESUMEN..."
        + "\nAlumnos aprobados: "+numeroAprobaddos
        + "\nAlumnos desaprobados: "+numeroDesaprobaods);
        
        do {
            System.out.print("\n¿Desea ver el resumen de los promedios?\n"
            + "Si\n"
            + "No\n"
            + "Opcion: ");
            opc = leer.next();
            if(!opc.substring(0,1).toUpperCase().equals("S") &&
                !opc.substring(0,1).toUpperCase().equals("N"))
                System.out.println("\nOpcion no valida, por favor intentelo de nuevo.");
        } while (!opc.substring(0,1).toUpperCase().equals("S") &&
                !opc.substring(0,1).toUpperCase().equals("N"));
        
        switch(opc.substring(0,1).toUpperCase()){
            case "S":
                System.out.println("\nNotas de alumnos aprobados...");
                for (int i = 0; i < numeroAprobaddos; i++) {
                    System.out.println("Alumno "+(i+1)+": "+aprobados[i]);
                }
                System.out.println("\nNotas de alumnos desaprobados...");
                for (int i = 0; i < numeroDesaprobaods; i++) {
                    System.out.println("Alumno "+(i+1)+": "+desaprobados[i]);
                }
                break;
        }
        
    }
    
    public void setNotas(){
        Scanner leer = new Scanner(System.in);
        
        System.out.print("Digite la nota del trabajo practico 1: ");
        this.setTrabajoPracticoUno(this.nota(leer.nextFloat()));
        System.out.print("Digite la nota del trabajo practico 2: ");
        this.setTrabajoPracticoDos(this.nota(leer.nextFloat()));
        System.out.print("Digite la nota del integrador 1: ");
        this.setIntegradorUno(this.nota(leer.nextFloat()));
        System.out.print("Digite la nota del integrador 2: ");
        this.setIntegradorDos(this.nota(leer.nextFloat()));
        
    }
    
    public float nota(float calificacion){
        Scanner leer = new Scanner(System.in);
        do {
            if (calificacion<0 || calificacion>10) {
                System.out.print("La nota digitada no es valida, por favor ingrese una nota de entre 0 y 10: ");
                calificacion = leer.nextFloat();
            }
        } while (calificacion<0 || calificacion>10);
        return calificacion;
    }
    
    public float calcPromedio(Ejercicio_21 alumno){
        float promedio= (alumno.trabajoPracticoUno*alumno.porcentajeTrabajoPracticoUno) + 
                        (alumno.trabajoPracticoDos*alumno.porcentajeTrabajoPracticoDos) + 
                        (alumno.integradorUno*alumno.porcentajeIntegradorUno) + (alumno.integradorDos*alumno.porcentajeIntegradorDos);
        
        return promedio;
    }

    public float getTrabajoPracticoUno() {
        return trabajoPracticoUno;
    }

    public void setTrabajoPracticoUno(float trabajoPracticoUno) {
        this.trabajoPracticoUno = trabajoPracticoUno;
    }

    public float getTrabajoPracticoDos() {
        return trabajoPracticoDos;
    }

    public void setTrabajoPracticoDos(float trabajoPracticoDos) {
        this.trabajoPracticoDos = trabajoPracticoDos;
    }

    public float getIntegradorUno() {
        return integradorUno;
    }

    public void setIntegradorUno(float integradorUno) {
        this.integradorUno = integradorUno;
    }

    public float getIntegradorDos() {
        return integradorDos;
    }

    public void setIntegradorDos(float integradorDos) {
        this.integradorDos = integradorDos;
    }

    public float getPorcentajeTrabajoPracticoUno() {
        return porcentajeTrabajoPracticoUno;
    }

    public void setPorcentajeTrabajoPracticoUno(float porcentajeTrabajoPracticoUno) {
        this.porcentajeTrabajoPracticoUno = porcentajeTrabajoPracticoUno;
    }

    public float getPorcentajeTrabajoPracticoDos() {
        return porcentajeTrabajoPracticoDos;
    }

    public void setPorcentajeTrabajoPracticoDos(float porcentajeTrabajoPracticoDos) {
        this.porcentajeTrabajoPracticoDos = porcentajeTrabajoPracticoDos;
    }

    public float getPorcentajeIntegradorUno() {
        return porcentajeIntegradorUno;
    }

    public void setPorcentajeIntegradorUno(float porcentajeIntegradorUno) {
        this.porcentajeIntegradorUno = porcentajeIntegradorUno;
    }

    public float getPorcentajeIntegradorDos() {
        return porcentajeIntegradorDos;
    }

    public void setPorcentajeIntegradorDos(float porcentajeIntegradorDos) {
        this.porcentajeIntegradorDos = porcentajeIntegradorDos;
    }
    
    
    
}
