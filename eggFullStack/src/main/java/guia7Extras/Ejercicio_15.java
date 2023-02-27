
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_15 {
    private int numeroUno;
    private int numeroDos;

    public Ejercicio_15() {
    }
    
    public void init(){
        Scanner leer = new Scanner(System.in);
        String opc;
        System.out.print("Digite el primer numero: ");
        this.setNumeroUno(leer.nextInt());
        System.out.print("Digite el segundo numero: ");
        this.setNumeroDos(leer.nextInt());
        do {
            System.out.print("\nSeleccione alguna de las siguientes operaciones: \n"
            + "[1] Sumar\n"
            + "[2] Restar\n"
            + "[3] Multiplicar\n"
            + "[4] Dividir\n"
            + "Opcion: ");
            opc = leer.next();
            if(verificarOpcion(opc))
                System.out.println("Opcion no valida, por favor intente de nuevo.");
        } while (verificarOpcion(opc));
        
        switch(opc.substring(0,1).toUpperCase()){
            case "1":
            case "S":
                System.out.println("\n"+this.numeroUno+" + "+this.numeroDos+" = "+this.sumar());
                break;
            case "2":
            case "R":
                System.out.println("\n"+this.numeroUno+" - "+this.numeroDos+" = "+this.restar());
                break;
            case "3":
            case "M":
                System.out.println("\n"+this.numeroUno+" * "+this.numeroDos+" = "+this.multiplicar());
                break;
            case "4":
            case "D":
                System.out.println("\n"+this.numeroUno+" / "+this.numeroDos+" = "+this.dividir());
                break;
        }
        
    }
    
    private boolean verificarOpcion(String opc){
        boolean band=false;
        if(!opc.substring(0,1).toUpperCase().equals("1") &&
                !opc.substring(0,1).toUpperCase().equals("S") &&
                !opc.substring(0,1).toUpperCase().equals("2") &&
                !opc.substring(0,1).toUpperCase().equals("R") &&
                !opc.substring(0,1).toUpperCase().equals("3") &&
                !opc.substring(0,1).toUpperCase().equals("M") &&
                !opc.substring(0,1).toUpperCase().equals("4") &&
                !opc.substring(0,1).toUpperCase().equals("D"))
            band = true;
            
        return band;
    }
    
    public int sumar(){
        return this.numeroDos + this.numeroUno;
    }
    
    public int restar(){
        return this.numeroUno - this.numeroDos;
    }
    
    public int multiplicar(){
        return this.numeroUno * this.numeroDos;
    }
    
    public float dividir(){
        return (float)(this.numeroUno/this.numeroDos);
    }

    public int getNumeroUno() {
        return numeroUno;
    }

    public void setNumeroUno(int numeroUno) {
        this.numeroUno = numeroUno;
    }

    public int getNumeroDos() {
        return numeroDos;
    }

    public void setNumeroDos(int numeroDos) {
        this.numeroDos = numeroDos;
    }
        
}
