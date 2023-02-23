
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_23 {
    public static String[][] sopa = new String[20][20];
    public static int[] filas = new int[5];
    public static int[] columna = new int[5];
    public static int nc;
    public static boolean band;
    public static String[] palabra= new String[5];
    private static int numeroPalabra=0;
        
    public static void main(String[] args) {
        
        generarFilas();

        generarSopa();
                
        dibujarSopa();
        
        mostrarCoordenadas();
        
    }
    
    private static void generarFilas(){
        int fila=0;
        for (int i = 0; i < 5; i++) {
            do {
                band=false;
                fila=(int)((Math.random()*10)+(Math.random()*10));
                for (int j = 0; j <= i; j++) {
                   if(filas[j]!=fila)
                       continue;
                   
                   band=true;
                   break;
                }
            } while (band);
            filas[i]=fila;
        }
    }
    
    private static void generarSopa(){
        System.out.println("");
        for (int i = 0; i < 20; i++) {
            if(verificarFila(i)){
                pedirPalabra();
                numeroPalabra++;
            }
            else{
                for (int j = 0; j < 20; j++) {
                   rellenarFila(i,j);
                }
            }
        }
    }
    
    private static boolean verificarFila(int i){
        boolean band=false;
        
        for (int j = 0; j < filas.length; j++) {
            if(filas[j]==i){
                band=true;
                break;
            }
        }
        
        return band;
    }
    
    private static void pedirPalabra(){
        Scanner leer = new Scanner(System.in);
        
        do {
            System.out.print((numeroPalabra+1)+". Ingresa una palabra de maximo 5 caractereses:");
            palabra[numeroPalabra] = leer.next();
            if(palabra[numeroPalabra].length()>5)
                System.out.println("Error, excediste la numero de caractereses.");
        } while (palabra[numeroPalabra].length()>5);

        band = false;
        while(!band){
            columna[numeroPalabra]=(int)((Math.random()*10)+(Math.random()*10));
            if((columna[numeroPalabra]+palabra[numeroPalabra].length())<20)
                band=true;
        }
        
        nc=0;
        for (int j = 0; j < 20; j++) {
            if (j<columna[numeroPalabra] || j>=(columna[numeroPalabra]+palabra[numeroPalabra].length())) {
                rellenarFila(filas[numeroPalabra],j);
            }
            else{
                sopa[filas[numeroPalabra]][j] = palabra[numeroPalabra].substring(nc,nc+1);
                nc++;
            }
        }
    }
    
    private static void rellenarFila(int i,int j){
        sopa[i][j] = String.valueOf(Math.round(Math.random()*10));
        switch(sopa[i][j]){
            case"0":
            case"1":if(sopa[i][j].equals("0")){
                        sopa[i][j] = "A";
                    }
                    else{
                        sopa[i][j] = "a";
                    }
                    break;
            case"2":
            case"3":if(sopa[i][j].equals("2")){
                        sopa[i][j] = "E";
                    }
                    else{
                        sopa[i][j] = "e";
                    }
                    break;
            case"4":
            case"5":if(sopa[i][j].equals("4")){
                        sopa[i][j] = "I";
                    }
                    else{
                        sopa[i][j] = "i";
                    }
                    break;
            case"6":
            case"7":if(sopa[i][j].equals("6")){
                        sopa[i][j] = "O";
                    }
                    else{
                        sopa[i][j] = "o";
                    }
                    break;
            case"8":
            case"9":
            case"10":if(sopa[i][j].equals("8")){
                        sopa[i][j] = "U";
                    }
                    else{
                        sopa[i][j] = "u";
                    }
                    break;
        }
    }
    
    private static void dibujarSopa(){
        System.out.println("\nSOPA DE LETRAS:");
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(sopa[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    private static void mostrarCoordenadas(){
        Scanner leer = new Scanner(System.in);
        String opc;
        
        do {
            System.out.println("\n¿Desea que se muestren la coordenada inicial de cada palabra?\n"
            + "[1] Si\n"
            + "[2] No");
            System.out.print("Opcion: ");
            opc = leer.next();
            if(!opc.substring(0,1).toUpperCase().equals("S") &&
                !opc.substring(0,1).toUpperCase().equals("1") &&
                !opc.substring(0,1).toUpperCase().equals("N") &&
                !opc.substring(0,1).toUpperCase().equals("2"))
                System.out.println("La opcion seleccionada no es valida, por favor vuelva a intentar.");
        } while (!opc.substring(0,1).toUpperCase().equals("S") &&
                !opc.substring(0,1).toUpperCase().equals("1") &&
                !opc.substring(0,1).toUpperCase().equals("N") &&
                !opc.substring(0,1).toUpperCase().equals("2"));
        
        switch(opc.substring(0,1).toUpperCase()){
            case "S":
            case "1":System.out.println("\nCOORDENADAS:");
                    for (int i = 0; i < 5; i++) {
                        System.out.println((i+1)+". "+palabra[i]+": "+filas[i]+","+columna[i]+".");
                    }
            case "N":
            case "2": System.out.println("\nFIN DEL PROGRAMA.");
        }
        
    }
    
}
