
package entidades.ejercicio6;

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
    
    public int getLongitudPalabra(){
        return this.palabra.length;
    }
        
    public char[][] getPalabra() {
        return palabra;
    }

    public void setPalabra(int longitudPalabra) {
        this.palabra = new char[longitudPalabra][2];
    }
    
    public void setElementoPalabra(char letra,int posicion){
        this.palabra[posicion][0] = letra;
        this.palabra[posicion][1] = '1';
    }
    
    public void letraEncontrada(int posicion){
        this.palabra[posicion][1]='2';
    }
    
    public char getElementoPalabra(int posicion){
        return this.palabra[posicion][0];
    }
    
    public char getValidadorElementoPalabra(int posicion){
        return this.palabra[posicion][1];
    }

    public char[][] getEntidadAhorcado() {
        return entidadAhorcado;
    }

    public void setEntidadAhorcado(char[][] entidadAhorcado) {
        this.entidadAhorcado = entidadAhorcado;
    }
    
    public void setElementoEntidadAhorcado(int fila,int columna,char letra){
        this.entidadAhorcado[fila][columna] = letra;
    }
    
    public char getElementoEntidadAhorcado(int fila,int columna){
        return this.entidadAhorcado[fila][columna];
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
    
    public String getPalabraCadena(){
        String palabraBuscar="";
        for (int i = 0; i < this.getLongitudPalabra(); i++) {
            palabraBuscar+= this.palabra[i][0];
        }
        return palabraBuscar;
    }
    
}
