
package entidades.ejercicio6;

import java.util.Scanner;

public class Ahorcado {
    private char palabra[][];
    private int numeroLetrasEncontradas=0;
    private int numeroIntentosMaximos;
    private int numeroEspaciosEncontrados=0;

    public Ahorcado() {
    }
    
    public Ahorcado(String palabra) {
        this.palabra = new char[palabra.length()][2];
        for (int i = 0; i < palabra.length(); i++) {
            this.palabra[i][0] =  palabra.charAt(i);
            this.palabra[i][1] = '1';
        }
    }

    public Ahorcado(char[][] palabra, int numeroLetrasEncontradas, int numeroIntentosMaximos) {
        this.palabra = palabra;
        this.numeroLetrasEncontradas = numeroLetrasEncontradas;
        this.numeroIntentosMaximos = numeroIntentosMaximos;
    }
    
    public void juego(){
        Scanner leer = new Scanner(System.in);
        char letra;
        int opc;
        
        this.crearJuego("irving alfonso meza flores");
        
        do {
            do {
                this.intentos();
                System.out.print("Digite una letra: ");
                letra = leer.next().charAt(0);
                this.buscarLetra(letra);
                this.mostrarProgreso();
            } while (this.numeroLetrasEncontradas<(this.getLongitudPalabra()-this.numeroEspaciosEncontrados) &&
                    this.numeroIntentosMaximos>0);

            if (this.numeroLetrasEncontradas==(this.getLongitudPalabra()-this.numeroEspaciosEncontrados)) {
                System.out.println("\n!FELICIDADES¡!Lo haz logrado¡");
            }else if(this.numeroIntentosMaximos==0){
                System.out.println("\nLo siento, has llegado al limite de intentos, si gustas puedes volverlo a intentar.");
            }
            
            System.out.print("\n¿Desea volver a jugar?\n"
            + "[1] Si\n"
            + "[2] No\n"
            + "Opcion: ");
            do {
                opc = leer.nextInt();
                if(opc<1 || opc>2)
                    System.out.println("\nOpcion no valida. intentelo de nuevo.");
            } while (opc<1 || opc>2);
        } while (opc==1);
    }
    
    private void crearJuego(String palabra){
        Scanner leer = new Scanner(System.in);
//        System.out.print("¿Cual sera la palabra a buscar en el juego?, ");
//        String palabra = leer.nextLine();
        this.palabra = new char[palabra.length()][2];
        for (int i = 0; i < palabra.length(); i++) {
            this.palabra[i][0] =  palabra.charAt(i);
            this.palabra[i][1] = '1';
            if(palabra.charAt(i)==' ')
                this.numeroEspaciosEncontrados++;
        }
        System.out.print("¿Cual sera el maximo de intentos para adivinar la palabra?, ");
        this.numeroIntentosMaximos = leer.nextInt();
    }
    
    private int getLongitudPalabra(){
        return this.palabra.length;
    }
    
    private void buscarLetra(char letra){
        if (this.encontradas(letra)) {
            System.out.println("\nLa letra ["+letra+"] SI forma parte de la palabra a buscar.");
        }
        else{
            System.out.println("\nLa letra ["+letra+"] NO forma parte de la palabra a buscar.");
            this.numeroIntentosMaximos--;
        }
    }
    
    private boolean encontradas(char letra){
        boolean band=false;
        for (int i = 0; i < this.getLongitudPalabra(); i++) {
            if(Character.toUpperCase(this.palabra[i][0])==Character.toUpperCase(letra) && this.palabra[i][1]=='1'){
                this.palabra[i][1]='2';
                this.numeroLetrasEncontradas++;
                System.out.println("Numero de letras encontradas: "+this.numeroLetrasEncontradas
                + "\nNumero de letras faltants de encontrar: "+(this.getLongitudPalabra()-this.numeroLetrasEncontradas-this.numeroEspaciosEncontrados));
                band=true;
            }
                
        }
        return band;
    }
    
    private void intentos(){
        System.out.println("\nIntentos restantes: "+this.numeroIntentosMaximos);
    }
    
    private void mostrarProgreso(){
        System.out.println("\nProgreso...");
        for (int i = 0; i < this.getLongitudPalabra(); i++) {
            if (this.palabra[i][1]=='1') {
                System.out.print("_ ");
            }else if(this.palabra[i][1]=='2'){
                System.out.print(this.palabra[i][0] + " ");
            }
        }
        System.out.println("");
    }
    
}
