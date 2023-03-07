
package entidades;

import java.util.Date;

public class Usuario {
    public String nombre;
    public String apellido;
    public String id;
    public Date fechaNac;
    public String pais;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String id, Date fechaNac, String pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.fechaNac = fechaNac;
        this.pais = pais;
    }
    
    
    
}
