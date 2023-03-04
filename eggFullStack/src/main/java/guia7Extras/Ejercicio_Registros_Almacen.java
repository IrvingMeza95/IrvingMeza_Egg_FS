
package guia7Extras;

import java.util.Scanner;

public class Ejercicio_Registros_Almacen {
    private Object Almacen[][];
    private int numeroProductos=0;
    private int numeroColumnas=4;

    public Ejercicio_Registros_Almacen() {
    }

    public Ejercicio_Registros_Almacen(int numeroProductos) {
        this.numeroProductos = numeroProductos;
        this.Almacen = new Object[this.numeroProductos][4];
    }

    public Ejercicio_Registros_Almacen(Object[][] Almacen) {
        this.Almacen = Almacen;
    }
        
    public void init(){
        Scanner leer = new Scanner(System.in);
        System.out.print("¿Para cuantos productos deseas iniciar el registro?, ");
        this.numeroProductos = leer.nextInt();
        this.Almacen = new Object[this.numeroProductos+1][this.numeroColumnas];
        construirTabla(numeroProductos);
        do {
        } while (this.MENU());
    }
    
    private boolean MENU(){
        Scanner leer = new Scanner(System.in);
        boolean band=true;
        int opc,fila;
        
        do {
            System.out.print("\nDigite el numero de la opcion que desee:\n"
            + "[1] Agregar producto\n"
            + "[2] Check out de registros\n"
            + "[3] Buscar producto\n"
            + "[4] Salir\n"
            + "Opcion: ");
           opc = leer.nextInt();
           if(opc!=1 && opc!=2 && opc!=3 && opc!=4)
                System.out.println("Opcion no valida, por favor intentelo de nuevo.");
        } while (opc!=1 && opc!=2 && opc!=3 && opc!=4);
        
        switch (opc) {
            case 1:
                if(!this.agregarProducto())
                    System.out.println("Se han agregado el maximo de productos disponibles.");
                break;
            case 2:
                this.mostrarTabla();
                break;
            case 3:
                fila=this.obtenerFila();
                if (fila!=0) {
                    this.encabezadosTabla();
                    this.registrosTabla(fila);
                }
                else{
                    System.out.println("\nEl producto no fue encontrado.");
                }
                break;
            case 4:
                band=false;
        }
        
        return band;
    }
    
    private boolean agregarProducto(){
        Scanner leer = new Scanner(System.in);
        boolean band=false;
        String nombre;
        int stock;
        float precioCompra;
        float precioVenta;
        System.out.println("\nAGREGANDO NUEVO PRODUCTO...");
        for (int i = 1; i <= this.numeroProductos; i++) {
            if (this.Almacen[i][0].equals(" ")) {
                System.out.print("Digite el nombre del producto: ");
                this.Almacen[i][0] = leer.nextLine();
                System.out.print("Digite la cantidad de stock inicial: ");
                this.Almacen[i][1] = leer.next();
                System.out.print("Digite el precio de compra: ");
                this.Almacen[i][2] = leer.nextFloat();
                System.out.print("Digite el precio de venta del producto: ");
                this.Almacen[i][3] = leer.nextFloat();
                band=true;
                break;
            }
        }
        return band;
    }
    
    private void mostrarTabla(){
        encabezadosTabla();
        for (int i = 1; i <= this.numeroProductos; i++) {
            this.registrosTabla(i);
        }
    }
    
    private void encabezadosTabla(){
        int numeroEspacios=0;
        for (int i = 0; i < this.numeroColumnas; i++) {
            if(String.valueOf(this.Almacen[0][i]).length()>numeroEspacios)
                numeroEspacios = String.valueOf(this.Almacen[0][i]).length();
        }
        for (int i = 1; i < this.numeroProductos; i++) {
            if(String.valueOf(this.Almacen[i][0]).length()>numeroEspacios)
                numeroEspacios = String.valueOf(this.Almacen[i][0]).length();
        }
        
        numeroEspacios/=2;
        
        System.out.println("\nTabla de registros...");
        for (int i = 0; i < this.numeroColumnas; i++) {
            for (int j = 0; j < (numeroEspacios-(String.valueOf(this.Almacen[0][i]).length()/2)); j++) {
                System.out.print(" ");
            }
            System.out.print(this.Almacen[0][i]);
            for (int j = 0; j < (numeroEspacios-(String.valueOf(this.Almacen[0][i]).length()/2)); j++) {
                System.out.print(" ");
            }
            System.out.print("|");
        }
        System.out.println("");
    }
    
    private void registrosTabla(int f){
        int numeroEspacios=0;
        for (int i = 0; i < this.numeroColumnas; i++) {
            if(String.valueOf(this.Almacen[0][i]).length()>numeroEspacios)
                numeroEspacios = String.valueOf(this.Almacen[0][i]).length();
        }
        for (int i = 1; i < this.numeroProductos; i++) {
            if(String.valueOf(this.Almacen[i][0]).length()>numeroEspacios)
                numeroEspacios = String.valueOf(this.Almacen[i][0]).length();
        }
        
        numeroEspacios/=2;
        
        if(!String.valueOf(this.Almacen[f][0]).equals(" ")){
            for (int i = 0; i < this.numeroColumnas; i++) {
                for (int k = 0; k < (numeroEspacios-(String.valueOf(this.Almacen[f][i]).length()/2)); k++) {
                    System.out.print(" ");
                }
                System.out.print(this.Almacen[f][i]);
                for (int k = 0; k < (numeroEspacios-(String.valueOf(this.Almacen[f][i]).length()/2)); k++) {
                    System.out.print(" ");
                }
                System.out.print("|");
            }
            System.out.println("");
        }

    }
    
    private int obtenerFila(){
        Scanner leer = new Scanner(System.in);
        int fila=0;
        String nombre;
        
        System.out.print("\nDigite el nombre del producto que desee buscar: ");
        nombre = leer.nextLine();
        
        for (int i = 1; i < this.numeroProductos; i++) {
            if (String.valueOf(this.Almacen[i][0]).toLowerCase().equals(nombre.toLowerCase())) {
                fila=i;
                break;
            }
        }
        
        return fila;
    }
    
    private void construirTabla(int numeroProductos){
        Scanner leer = new Scanner(System.in);
        this.Almacen[0][0] = "Nombre";
        this.Almacen[0][1] = "Stock";
        this.Almacen[0][2] = "Precio Compra";
        this.Almacen[0][3] = "Compra Venta";
        for (int i = 1; i <= numeroProductos; i++) {
            for (int j = 0; j < this.numeroColumnas; j++) {
                this.Almacen[i][j] = " ";
            }
        }
    }

    public int getNumeroProductos() {
        return numeroProductos;
    }

    public void setNumeroProductos(int numeroProductos) {
        this.numeroProductos = numeroProductos;
    }

    public Object[][] getAlmacen() {
        return Almacen;
    }

    public void setAlmacen(Object[][] Almacen) {
        this.Almacen = Almacen;
    }
            
}
