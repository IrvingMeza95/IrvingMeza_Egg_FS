
package guia7Extras;

public class Ejercicio_12 {

    public Ejercicio_12() {
    }
    
    public void mostrarEscalera(int nivel){
        char caracter[] = new char[nivel*2];
        
        caracter[0]='0';
        for (int i = 1; i < (nivel*2); i++) {
            if(i%2!=0){
                caracter[i-1]='0';
            }
            else{
                caracter[i-1]='-';
            }
        }
        
        System.out.println("\nSUCESION...");
        for (int i = (nivel-1); i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                if(j!=3){
                    caracter[i*2]=(char)(j+'0');
                }
                else{
                    caracter[i*2]='E';
                }
                
                if(i>0 && j==0)
                    continue;
                
                for (int k = 0; k < (nivel*2); k++) {
                    System.out.print(caracter[k]);
                }
                System.out.println("");
            }
        }
        
    }
    
}
