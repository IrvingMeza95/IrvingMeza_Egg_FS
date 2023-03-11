
package servicios;

import entidades.Curso;
import java.util.Scanner;

public class CursoServicios {
    private Curso curso = new Curso();
    private CursoServicios cursos[];

    public CursoServicios() {
    }
    
    public CursoServicios(int cantidadDeCursos) {
        this.cursos = new CursoServicios[cantidadDeCursos];
        for (int i = 0; i < this.cursos.length; i++) {
            this.cursos[i] = new CursoServicios();
        }
    }
    
    public void cargarCurso(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Digite el nombre del curso: ");
        curso.setNombreCurso(leer.next());
        System.out.print("Digite la cantidad de horas por dia: ");
        curso.setCantidadHorasPorDia(leer.nextInt());
        System.out.print("Digite la cantidad de dias por semana: ");
        curso.setCantidadDiasPorSemana(leer.nextInt());
        curso.setTurno();
        System.out.print("Digite el precio por hora: ");
        curso.setPrecioPorHora(leer.nextFloat());
        curso.setAlumnos();
    }
    
    public void cargarArregloDeCursos(){
        if(this.cursos==null){
            System.out.println("\nError, para utilizar este metodo es necesario instanciar con el constructor que le solicita la cantidad de cursos.");
        }
        else{
            for (int i = 0; i < this.cursos.length; i++) {
                System.out.println("\nCurso " + (i+1) + ":");
                this.cursos[i].cargarCurso();
            }
        }
    }
    
    public float getGananciasCurso(Curso curso){
        return ((curso.getPrecioPorHora() * curso.getCantidadHorasPorDia()) * curso.getCantidadAlumnosCurso()) * curso.getCantidadDiasPorSemana();
    }
    
    public void calcularGananciasSemanales(){
        if(!curso.getNombreCurso().equals("")){
            System.out.println("\nLa ganancia semanal del curso seria de $" + this.getGananciasCurso(curso));
        }
        else{
            System.out.println("\nError, el curso seleccionado no ha sido cargado.");
        }
    }
    
    public void calcularGananciasSemanalesDeArregloDeCursos(){
        float ganancias=0;
        for (int i = 0; i < this.cursos.length; i++) {
            ganancias+= cursos[i].getGananciasCurso(cursos[i].getCurso());
        }
        System.out.println("\nGanancia semanal por todos los cursos es de $" + ganancias);
    }
    
    public void mostrarArregloDeCursos(){
        for (int i = 0; i < this.cursos.length; i++) {
            System.out.println("\n" + this.cursos[i].toString());
            this.cursos[i].calcularGananciasSemanales();
        }
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public CursoServicios[] getCursos() {
        return cursos;
    }

    public void setCursos(CursoServicios[] cursos) {
        this.cursos = cursos;
    }
    
    

    @Override
    public String toString() {
        return "Datos del curso: " + curso;
    }
    
    
    
}
