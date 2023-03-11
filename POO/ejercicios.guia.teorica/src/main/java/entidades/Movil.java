
package entidades;

import java.util.Scanner;

public class Movil {
    private String marca;
    private float precio;
    private String modelo;
    private float memoriaRam;
    private float almacenamiento;
    private int codigo[] = new int[7];

    public Movil() {
    }

    public Movil(String marca, float precio, String modelo, float memoriaRam, float almacenamiento,int codigo) {
        this.marca = marca;
        this.precio = precio;
        this.modelo = modelo;
        this.memoriaRam = memoriaRam;
        this.almacenamiento = almacenamiento;
        this.setCodigo(codigo);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(float memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public float getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(float almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getCodigo() {
        String codigo="";
        for (int i = 0; i < this.codigo.length; i++) {
            codigo+= String.valueOf(this.codigo[i]);
        }
        return codigo;
    }

    public void setCodigo(int codigo) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        if(String.valueOf(codigo).length()!=7) {   
            do{
               if(String.valueOf(codigo).length()!=7) 
                   System.out.print("\nEl codigo ingresado debe ser de 7 digitos, por ingreselo de nuevo: ");
               codigo = leer.nextInt();
            }while(String.valueOf(codigo).length()!=7);
        }
        
        for (int i = 0; i < this.codigo.length; i++) {
            this.codigo[i] = Integer.parseInt(String.valueOf(codigo).substring(i,i+1));
        }
        
    }

    @Override
    public String toString() {
        return "\nMarca: " + marca + "\nPrecio: $" + precio + "\nModelo: " + modelo + "\nMemoria Ram: " + memoriaRam + 
                "\nAlmacenamiento: " + almacenamiento + "\nCodigo: " + this.getCodigo();
    }

    
    
}
