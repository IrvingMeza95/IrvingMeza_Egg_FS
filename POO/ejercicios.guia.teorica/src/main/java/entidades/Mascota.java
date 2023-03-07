
package entidades;

public class Mascota {
    public String nombre;
    public String apodo;
    public int edad;
    public String tipoMascota;
    public boolean cola;
    public String raza;
    public String color;

    public Mascota() {
    }

    public Mascota(String nombre, String apodo, int edad, String tipoMascota, boolean cola, String raza, String color) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.edad = edad;
        this.tipoMascota = tipoMascota;
        this.cola = cola;
        this.raza = raza;
        this.color = color;
    }
    
    
    
}
