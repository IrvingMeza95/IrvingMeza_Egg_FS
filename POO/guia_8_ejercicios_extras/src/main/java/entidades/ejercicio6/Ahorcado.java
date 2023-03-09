
package entidades.ejercicio6;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Ahorcado {
    private char palabra[][];
    private char entidadAhorcado[][] = new char[8][6];
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
        char opc;
        int totIntentos;
        
        do {
            this.crearJuego();
            totIntentos = this.numeroIntentosMaximos;
            do {
                this.intentos();
                System.out.print("Digite una letra: ");
                letra = leer.next().charAt(0);
                this.buscarLetra(letra);
                this.dibujarAhorcado(totIntentos);
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
                opc = leer.next().charAt(0);
                if(opc!='1' && opc!='2' && Character.toLowerCase(opc)!='s' && Character.toLowerCase(opc)!='n')
                    System.out.println("\nOpcion no valida. intentelo de nuevo.");
            } while (opc!='1' && opc!='2' && Character.toLowerCase(opc)!='s' && Character.toLowerCase(opc)!='n');
            if(opc=='1' || Character.toLowerCase(opc)=='s')
                this.numeroLetrasEncontradas=0;
        } while (opc=='1' || Character.toLowerCase(opc)=='s');
    }
    
    private void crearJuego(){
        Scanner leer = new Scanner(System.in);
        //System.out.print("¿Cual sera la palabra a buscar en el juego?, ");
        String palabra = JOptionPane.showInputDialog("Digite la palabra a buscar:");
        this.palabra = new char[palabra.length()][2];
        for (int i = 0; i < palabra.length(); i++) {
            this.palabra[i][0] =  palabra.charAt(i);
            this.palabra[i][1] = '1';
            if(palabra.charAt(i)==' ')
                this.numeroEspaciosEncontrados++;
        }
        System.out.print("\nhola"
                + ""
                + "¿Cual sera el maximo de intentos para adivinar la palabra?, ");
        this.numeroIntentosMaximos = leer.nextInt();
    }
    
    private int getLongitudPalabra(){
        return this.palabra.length;
    }
    
    private void buscarLetra(char letra){
        if(letra!='@'){
            if (this.encontradas(letra)) {
                System.out.println("\nLa letra ["+letra+"] SI forma parte de la palabra a buscar.");
            }
            else{
                System.out.println("\nLa letra ["+letra+"] NO forma parte de la palabra a buscar.");
                this.numeroIntentosMaximos--;
            }
        }
        else{
            String palabraBuscar="";
            for (int i = 0; i < this.getLongitudPalabra(); i++) {
                palabraBuscar+= palabra[i][0];
            }
            JOptionPane.showMessageDialog(null, "La palabra a buscar es: "+palabraBuscar);
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
    
    private void dibujarAhorcado(int totIntentos){
        float porcentajeFaoos = 10-((this.numeroIntentosMaximos*10)/totIntentos);
             
        //Inicializar el dibujo en vacios
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                this.entidadAhorcado[i][j] = ' ';
            }
        }
        
        if(porcentajeFaoos>0){
            //Tubo que va de la parte inferior a la superior
            this.entidadAhorcado[1][0]='|';
            this.entidadAhorcado[2][0]='|';
            this.entidadAhorcado[3][0]='|';
            this.entidadAhorcado[4][0]='|';
            this.entidadAhorcado[5][0]='|';
            this.entidadAhorcado[6][0]='|';
            this.entidadAhorcado[7][0]='|';

            //Tubo que sostiene al mono
            this.entidadAhorcado[0][0]='_';
            this.entidadAhorcado[0][1]='_';
            this.entidadAhorcado[0][2]='_';
            this.entidadAhorcado[0][3]='_';
            
            if(porcentajeFaoos>=2.5){
                //Cuerda que sostiene al mono
                this.entidadAhorcado[1][3]='|';
                
                if(porcentajeFaoos>3.5){
                    //Cabeza y cuello del mono
                    if(porcentajeFaoos!=10){
                        this.entidadAhorcado[2][3]='O';
                    }
                    else if(porcentajeFaoos==10){
                        this.entidadAhorcado[2][3]='X';
                    }
                    this.entidadAhorcado[3][3]='¡';
                }
            }
        }
        
        if(porcentajeFaoos>=6){
            //Torso
            this.entidadAhorcado[4][3]='|';
            this.entidadAhorcado[5][3]='!';
            
            if(porcentajeFaoos>7.4){
                //Brazo izquierdo
                this.entidadAhorcado[3][4]='_';
                this.entidadAhorcado[4][4]='|';
                //Brazo derecho del mono
                this.entidadAhorcado[3][2]='_';
                this.entidadAhorcado[4][1]='|';
            }
        }
        
        if(porcentajeFaoos>=9){
            //Pierna izquierda
            this.entidadAhorcado[5][2]='_';
            this.entidadAhorcado[6][1]='|';
            this.entidadAhorcado[7][1]='|';

            //Pierna derecha
            this.entidadAhorcado[5][4]='_';
            this.entidadAhorcado[6][4]='|';
            this.entidadAhorcado[7][4]='|';
        }
        
        //Dibujar
        System.out.println("\nMostrando grafico de progreso...");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(this.entidadAhorcado[i][j]);
            }
            System.out.println("");
        }
        
        System.out.println("");
    }

    public char[][] getPalabra() {
        return palabra;
    }

    public void setPalabra(char[][] palabra) {
        this.palabra = palabra;
    }

    public char[][] getEntidadAhorcado() {
        return entidadAhorcado;
    }

    public void setEntidadAhorcado(char[][] entidadAhorcado) {
        this.entidadAhorcado = entidadAhorcado;
    }

    public int getNumeroLetrasEncontradas() {
        return numeroLetrasEncontradas;
    }

    public void setNumeroLetrasEncontradas(int numeroLetrasEncontradas) {
        this.numeroLetrasEncontradas = numeroLetrasEncontradas;
    }

    public int getNumeroIntentosMaximos() {
        return numeroIntentosMaximos;
    }

    public void setNumeroIntentosMaximos(int numeroIntentosMaximos) {
        this.numeroIntentosMaximos = numeroIntentosMaximos;
    }

    public int getNumeroEspaciosEncontrados() {
        return numeroEspaciosEncontrados;
    }

    public void setNumeroEspaciosEncontrados(int numeroEspaciosEncontrados) {
        this.numeroEspaciosEncontrados = numeroEspaciosEncontrados;
    }
    
    
    
}
