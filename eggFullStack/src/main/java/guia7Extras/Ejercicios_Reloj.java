/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia7Extras;

/**
 *
 * @author iamf_
 */
public class Ejercicios_Reloj {
    private int segundos=0;
    private int minutos=0;
    private int horas=0;
    private int dias=0;

    public Ejercicios_Reloj() {
    }
    
    public void init(int totalDias){
        String reloj="00:00:00:00";
        System.out.println("Mostrando cronometro...");
        while(dias<totalDias){
            System.out.println(reloj);
            segundos++;
            if (segundos>59) {
                this.minutos++;
                this.segundos=0;
                if (this.minutos>59) {
                    this.horas++;
                    this.minutos=0;
                    if (this.horas>23) {
                        this.dias++;
                        this.horas=0;
                    }
                }
            }
            
            reloj = String.valueOf(this.dias) + ":" + String.valueOf(this.horas) + ":" + String.valueOf(this.minutos) + ":" + String.valueOf(this.segundos);
        }
    }
    
    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
    
    
    
}
