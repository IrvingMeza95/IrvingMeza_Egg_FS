
package servicios;

import entidades.Libro;
import java.util.Scanner;

public class LibroServicios {
    private Libro libro1;

    public LibroServicios() {
        this.libro1 = new Libro();
    }
    
    public void cargarLibro(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Digite el isbn: ");
        this.libro1.setIsbn(leer.next());
        System.out.print("Digite el titulo: ");
        this.libro1.setTitulo(leer.next());
        System.out.print("Digite el autor: ");
        this.libro1.setAutor(leer.next());
        System.out.print("Digite el numero de paginas: ");
        this.libro1.setNumeroPaginas(leer.nextInt());
    }

    @Override
    public String toString() {
        return libro1.toString();
    }
    
    
    
}
