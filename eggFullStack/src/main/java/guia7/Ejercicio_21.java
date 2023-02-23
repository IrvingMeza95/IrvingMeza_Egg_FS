
package guia7;

public class Ejercicio_21 {
    private static int contador=0;
    
    public static void main(String[] args) {
        
        int[][] matrizA = { {1,26,36,47,5,6,72,81,95,10},
                            {11,12,13,21,41,22,67,20,10,61},
                            {56,78,87,90,9,90,17,12,87,67},
                            {41,87,24,56,97,74,87,42,64,35},
                            {32,76,79,1,36,5,67,96,12,11},
                            {99,13,54,88,89,90,75,12,41,76},
                            {67,78,87,45,14,22,26,42,56,78},
                            {98,45,34,23,32,56,74,16,19,18},
                            {24,67,97,46,87,13,67,89,93,24},
                            {21,68,78,98,90,67,12,41,65,12} };
        int[][] matrizB = { {36,5,67},
                            {89,90,75},
                            {14,22,26} };
        
        /*
        int[][] matrizA = new int[10][10];
        int[][] matrizB = new int[3][3];
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrizA[i][j] = (int)(Math.random()*10);
            }
        }
        */
        System.out.println("Matriz A rellenada correctmente:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matrizA[i][j]+" ");
            }
            System.out.println("");
        }
        
        System.out.println("");
        /*
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrizB[i][j] = (int)(Math.random()*10);
            }
        }
        */
        System.out.println("Matriz B rellenada correctamente:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrizB[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
        
        System.out.println("Buscando matriz B en submatrices de la natriz A...");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                subMatriz(matrizA,matrizB,i,j);
            }
        }
        
    }
    
    public static void subMatriz(int[][] matrizA,int[][] matrizB,int f,int c){
        boolean band=true;
        
        for (int i = f; i < (f+2); i++) {
            for (int j = c; j < (c+2); j++) {
                if (matrizA[i][j]!=matrizB[i-f][j-c]) {
                    band = false;
                    break;
                }
            }
        }
        
        if (band) {
            contador++;
            System.out.println(contador+". Coincidencia encontrada a partir de "
                    + "la coordenada: "+f+","+c);
        }
        
    }
    
}
