
package servicios;

import entidades.Movil;
import java.util.Scanner;

public class MovilServicios {
    private Movil movil = new Movil();
    
    public void cargarCelular(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Digite la marca del movil: ");
        movil.setMarca(leer.next());
        System.out.print("Digite el modelo: ");
        movil.setModelo(leer.next());
        System.out.print("Digite el precio: ");
        movil.setPrecio(leer.nextFloat());
        System.out.print("Digite la cantidad de memoria ram en gigas: ");
        movil.setMemoriaRam(leer.nextFloat());
        System.out.print("Digite la cantidad de almacenamiento en gigas: ");
        movil.setAlmacenamiento(leer.nextFloat());
        System.out.print("Digite el codigo: ");
        movil.setCodigo(leer.nextInt());
    }

    @Override
    public String toString() {
        return "Datos del Movil: \n" + movil;
    }
    
    
    
}
