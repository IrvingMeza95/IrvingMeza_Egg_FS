
package entidades;

import java.util.Scanner;

public class Circunferencia {
    private double radio;

    public Circunferencia() {
    }

    public Circunferencia(double radio) {
        this.radio = radio;
    }
    
    public void crearCircunferencia(){
        Scanner leer = new Scanner(System.in);
        System.out.print("Digite el radio de la circunferencia: ");
        this.setRadio(leer.nextDouble());
    }
    
    public double calcArea(){
        return 3.1416*(Math.pow(radio, radio));
    }
    
    public double calcPerimetro(){
        return 2*3.1416*this.radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Circunferencia{" + "radio=" + radio + '}';
    }
    
}
