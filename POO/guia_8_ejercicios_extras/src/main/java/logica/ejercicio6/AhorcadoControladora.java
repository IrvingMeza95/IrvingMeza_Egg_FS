
package logica.ejercicio6;

import entidades.ejercicio6.Ahorcado;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class AhorcadoControladora {
    private Ahorcado ahorcado = new Ahorcado();

    public AhorcadoControladora() {
    }

    public void juegar(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        char letra;
        char opc;
        int totIntentos;
        
        do {
            this.crearJuego();
            totIntentos = ahorcado.getNumeroIntentosMaximos();
            do {
                intentos();
                System.out.print("Digite una letra: ");
                letra = leer.next().charAt(0);
                buscarLetra(letra);
                this.dibujarAhorcado(totIntentos);
                this.mostrarProgreso();
            } while (ahorcado.getNumeroLetrasEncontradas()<(ahorcado.getLongitudPalabra()-ahorcado.getNumeroEspaciosEncontrados()) &&
                    ahorcado.getNumeroIntentosMaximos()>0);

            if (ahorcado.getNumeroLetrasEncontradas()==(ahorcado.getLongitudPalabra()-ahorcado.getNumeroEspaciosEncontrados())) {
                System.out.println("\n!FELICIDADES¡!Lo haz logrado¡");
            }else if(ahorcado.getNumeroIntentosMaximos()==0){
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
                ahorcado.setNumeroLetrasEncontradas(0);
        } while (opc=='1' || Character.toLowerCase(opc)=='s');
    }
    
    private void crearJuego(){
        Scanner leer = new Scanner(System.in);
        //System.out.print("¿Cual sera la palabra a buscar en el juego?, ");
        String palabra = JOptionPane.showInputDialog("Digite la palabra a buscar:");
        ahorcado.setPalabra(palabra.length());
        for (int i = 0; i < palabra.length(); i++) {
            ahorcado.setElementoPalabra(palabra.charAt(i), i);
            if(palabra.charAt(i)==' ')
                ahorcado.setNumeroEspaciosEncontrados(ahorcado.getNumeroEspaciosEncontrados()+1);
        }
        System.out.print("\nhola"
                + ""
                + "¿Cual sera el maximo de intentos para adivinar la palabra?, ");
        ahorcado.setNumeroIntentosMaximos(leer.nextInt());
    }
    
    private void buscarLetra(char letra){
        if(letra!='@'){
            if (this.encontradas(letra)) {
                System.out.println("\nLa letra ["+letra+"] SI forma parte de la palabra a buscar.");
            }
            else{
                System.out.println("\nLa letra ["+letra+"] NO forma parte de la palabra a buscar.");
                ahorcado.setNumeroIntentosMaximos(ahorcado.getNumeroIntentosMaximos()-1);
            }
        }
        else{
            String palabraBuscar="";
            for (int i = 0; i < ahorcado.getLongitudPalabra(); i++) {
                palabraBuscar+= ahorcado.palabra[i][0];
            }
            JOptionPane.showMessageDialog(null, "La palabra a buscar es: "+palabraBuscar);
        }   
    }
    
    private boolean encontradas(char letra){
        boolean band=false;
        for (int i = 0; i < ahorcado.getLongitudPalabra(); i++) {
            if(Character.toUpperCase(ahorcado.getElementoPalabra(i))==Character.toUpperCase(letra) && 
                    ahorcado.getValidadorElementoPalabra(i)=='1'){
                ahorcado.letraEncontrada(i);
                ahorcado.setNumeroLetrasEncontradas(ahorcado.getNumeroLetrasEncontradas()+1);
                System.out.println("Numero de letras encontradas: "+ahorcado.getNumeroLetrasEncontradas()
                + "\nNumero de letras faltants de encontrar: "+(ahorcado.getLongitudPalabra()-ahorcado.getNumeroLetrasEncontradas()-ahorcado.getNumeroEspaciosEncontrados()));
                band=true;
            }
                
        }
        return band;
    }
    
    private void intentos(){
        System.out.println("\nIntentos restantes: "+ahorcado.getNumeroIntentosMaximos());
    }
    
    private void mostrarProgreso(){
        System.out.println("\nProgreso...");
        for (int i = 0; i < ahorcado.getLongitudPalabra(); i++) {
            if (ahorcado.getValidadorElementoPalabra(i)=='1') {
                System.out.print("_ ");
            }else if(ahorcado.getValidadorElementoPalabra(i)=='2'){
                System.out.print(ahorcado.getElementoPalabra(i) + " ");
            }
        }
        System.out.println("");
    }
    
    private void dibujarAhorcado(int totIntentos){
        float porcentajeFaoos = 10-((ahorcado.getNumeroIntentosMaximos()*10)/totIntentos);
             
        //Inicializar el dibujo en vacios
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                ahorcado.setElementoEntidadAhorcado(i, j, ' ');
            }
        }
        
        if(porcentajeFaoos>0){
            //Tubo que va de la parte inferior a la superior
            ahorcado.setElementoEntidadAhorcado(1, 0, '|');
            ahorcado.setElementoEntidadAhorcado(2, 0, '|');
            ahorcado.setElementoEntidadAhorcado(3, 0, '|');
            ahorcado.setElementoEntidadAhorcado(4, 0, '|');
            ahorcado.setElementoEntidadAhorcado(5, 0, '|');
            ahorcado.setElementoEntidadAhorcado(6, 0, '|');
            ahorcado.setElementoEntidadAhorcado(7, 0, '|');

            //Tubo que sostiene al mono
            ahorcado.setElementoEntidadAhorcado(0, 0, '_');
            ahorcado.setElementoEntidadAhorcado(0, 1, '_');
            ahorcado.setElementoEntidadAhorcado(0, 2, '_');
            ahorcado.setElementoEntidadAhorcado(0, 3, '_');
            
            if(porcentajeFaoos>=2.5){
                //Cuerda que sostiene al mono
                ahorcado.setElementoEntidadAhorcado(1, 3, '|');
                
                if(porcentajeFaoos>3.5){
                    //Cabeza y cuello del mono
                    if(porcentajeFaoos!=10){
                        ahorcado.setElementoEntidadAhorcado(2, 3, 'O');
                    }
                    else if(porcentajeFaoos==10){
                        ahorcado.setElementoEntidadAhorcado(2, 3, 'X');
                    }
                    ahorcado.setElementoEntidadAhorcado(3, 3, '¡');
                }
            }
        }
        
        if(porcentajeFaoos>=6){
            //Torso
            ahorcado.setElementoEntidadAhorcado(4, 3, '|');
            ahorcado.setElementoEntidadAhorcado(5, 3, '!');
            
            if(porcentajeFaoos>7.4){
                //Brazo izquierdo
                ahorcado.setElementoEntidadAhorcado(3, 4, '_');
                ahorcado.setElementoEntidadAhorcado(4, 4, '|');
                //Brazo derecho del mono
                ahorcado.setElementoEntidadAhorcado(3, 2, '_');
                ahorcado.setElementoEntidadAhorcado(4, 1, '|');
            }
        }
        
        if(porcentajeFaoos>=9){
            //Pierna izquierda
            ahorcado.setElementoEntidadAhorcado(5, 2, '_');
            ahorcado.setElementoEntidadAhorcado(6, 1, '|');
            ahorcado.setElementoEntidadAhorcado(7, 1, '|');

            //Pierna derecha
            ahorcado.setElementoEntidadAhorcado(5, 4, '_');
            ahorcado.setElementoEntidadAhorcado(6, 4, '|');
            ahorcado.setElementoEntidadAhorcado(7, 4, '|');
        }
        
        //Dibujar
        System.out.println("\nMostrando grafico de progreso...");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(ahorcado.getElementoEntidadAhorcado(i, j));
            }
            System.out.println("");
        }
        
        System.out.println("");
    }
    
}
