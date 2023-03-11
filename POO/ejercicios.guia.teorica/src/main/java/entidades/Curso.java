
package entidades;

import java.util.Scanner;

public class Curso {
    private String nombreCurso;
    private int cantidadHorasPorDia;
    private int cantidadDiasPorSemana;
    private String turno;
    private float precioPorHora;
    private String alumnos[] = new String[5];

    public Curso() {
    }

    public Curso(String nombreCurso, int cantidadHorasPorDia, int cantidadDiasPorSemana, String turno, float precioPorHora) {
        this.nombreCurso = nombreCurso;
        this.cantidadHorasPorDia = cantidadHorasPorDia;
        this.cantidadDiasPorSemana = cantidadDiasPorSemana;
        this.turno = turno;
        this.precioPorHora = precioPorHora;
        this.setAlumnos();
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getCantidadHorasPorDia() {
        return cantidadHorasPorDia;
    }

    public void setCantidadHorasPorDia(int cantidadHorasPorDia) {
        this.cantidadHorasPorDia = cantidadHorasPorDia;
    }

    public int getCantidadDiasPorSemana() {
        return cantidadDiasPorSemana;
    }

    public void setCantidadDiasPorSemana(int cantidadDiasPorSemana) {
        this.cantidadDiasPorSemana = cantidadDiasPorSemana;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String turno;
        do {
            System.out.print("\nSeleccione el turno del curso...\n"
            + "[1] Matutino\n"
            + "[2] Despertino\n"
            + "Opcion: ");
            turno = leer.next();
            if(!turno.substring(0,1).toLowerCase().equals("m") &&
                    !turno.substring(0,1).toLowerCase().equals("1") &&
                    !turno.substring(0,1).toLowerCase().equals("d") &&
                    !turno.substring(0,1).toLowerCase().equals("2"))
                System.out.println("\nOpcion no valida, por favor intentelo de nuevo.");
        } while (!turno.substring(0,1).toLowerCase().equals("m") &&
                    !turno.substring(0,1).toLowerCase().equals("1") &&
                    !turno.substring(0,1).toLowerCase().equals("d") &&
                    !turno.substring(0,1).toLowerCase().equals("2"));
        
        switch (turno.substring(0,1).toLowerCase()) {
            case "1":
            case "m": 
                this.turno = "Matutino";
                break;
            case "2":
            case "d": 
                this.turno = "Despertino";
        }
        System.out.println("");
    }

    public float getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(float precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

    public String getAlumnos() {
        String alumnos="\nLista de alumnos del curso:";
        
        for (int i = 0; i < this.alumnos.length; i++) {
            alumnos+= "\n" + String.valueOf(i+1) + ". " + this.alumnos[i];
        }
        
        return alumnos;
    }

    public void setAlumnos() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("\nCargando alumnos:");
        for (int i = 0; i < this.alumnos.length; i++) {
            System.out.print("Digite el nombre del alumno "+(i+1)+": ");
            this.alumnos[i] = leer.next();
        }
    }
    
    public int getCantidadAlumnosCurso(){
        return this.alumnos.length;
    }

    @Override
    public String toString() {
        return "\nNombre del curso: " + nombreCurso + "\nCantidad de horas por dia: " + cantidadHorasPorDia + "\nCantidad dias por semana: " + 
                cantidadDiasPorSemana + "\nTurno: " + turno + "\nPrecio por hora: " + precioPorHora + this.getAlumnos();
    }
    
    
    
}
