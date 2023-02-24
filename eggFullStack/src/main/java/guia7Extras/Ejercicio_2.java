
package guia7Extras;

public class Ejercicio_2 {
    public static void main(String[] args) {
        int a=1;
        int b=2;
        int c=3;
        int d=4;
        int aux;
        
        System.out.println("a:"+a
        + "\nb: "+b
        + "\nc:"+c
        + "\nd:"+d);
        
        aux = b;
        b=c;
        c=a;
        a=d;
        d=aux;  
        
        System.out.println("NUEVOS VALORES...");
        System.out.println("a:"+a
        + "\nb: "+b
        + "\nc:"+c
        + "\nd:"+d);
        
    }
}
