
package guia7Extras;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ejercicio_Registros_Almacen {
    final float porcentajeGanancia=0.2f;
    final int numeroColumnas=4;
    private Object Almacen[][];
    final int numeroColumnasTablaHistorial=8;
    final int numeroRegistrosTablaHistorial=100;
    final Object Historial[][] = new Object[numeroRegistrosTablaHistorial+1][numeroColumnasTablaHistorial];
    private int numeroProductos=0;

    public Ejercicio_Registros_Almacen() {
    }
        
    public void init(){
        Scanner leer = new Scanner(System.in);
        this.construirTablaHistorial();
        System.out.print("¿Para cuantos productos deseas iniciar el registro?, ");
        this.numeroProductos = leer.nextInt();
        this.Almacen = new Object[this.numeroProductos+1][this.numeroColumnas];
        construirTablaProductos(numeroProductos);
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
            + "[2] Mostrar stock general\n"
            + "[3] Buscar producto en stock\n"
            + "[4] Registrar compra de producto\n"
            + "[5] Registrar venta de producto\n"
            + "[6] Mostrar historial\n"
            + "[7] Buscar registros en historial\n"
            + "[8] Salir\n"
            + "Opcion: ");
           opc = leer.nextInt();
           if(opc <1 || opc>8)
                System.out.println("Opcion no valida, por favor intentelo de nuevo.");
        } while (opc <1 || opc>8);
        
        switch (opc) {
            case 1:
                if(!this.agregarProducto())
                    System.out.println("Se han agregado el maximo de productos disponibles.");
                break;
            case 2:
                this.mostrarTablaProductos();
                break;
            case 3:
                fila=this.obtenerFila();
                if (fila!=0) {
                    this.encabezadosTablaProductos();
                    this.registrosTablaProductos(fila);
                }
                else{
                    System.out.println("\nEl producto no fue encontrado.");
                }
                break;
            case 4:
                this.registrarCompraProducto();
                break;
            case 5:
                
                break;
            case 6:
                this.mostrarTablaHistorial();
                break;
            case 7:
                fila=this.obtenerFila();
                if (fila!=0) {
                    this.encabezadosTablaHistorial();
                    this.buscandoRegistrosTablaHistorial(fila);
                }
                else{
                    System.out.println("\nEl producto no fue encontrado.");
                }
                break;
            case 8:
                band=false;
        }
        
        return band;
    }
    
    private void buscandoRegistrosTablaHistorial(int f){
        int numeroEspacios=0;
        for (int i = 0; i < this.numeroColumnasTablaHistorial; i++) {
            if(String.valueOf(this.Historial[0][i]).length()>numeroEspacios)
                numeroEspacios = String.valueOf(this.Historial[0][i]).length();
        }
        for (int i = 1; i < this.Historial.length; i++) {
            if(String.valueOf(this.Historial[i][0]).length()>numeroEspacios)
                numeroEspacios = String.valueOf(this.Historial[i][0]).length();
        }
        
        numeroEspacios/=2;
        
        for (int l = 1; l <= this.numeroRegistrosTablaHistorial; l++) {
            if(!String.valueOf(this.Historial[l][0]).equals(" ") && (int)this.Historial[l][2]==f){
                for (int i = 0; i < this.numeroColumnasTablaHistorial; i++) {
                    for (int k = 0; k < (numeroEspacios-(String.valueOf(this.Historial[l][i]).length()/2)); k++) {
                        System.out.print(" ");
                    }
                    System.out.print(this.Historial[l][i]);
                    for (int k = 0; k < (numeroEspacios-(String.valueOf(this.Historial[l][i]).length()/2)); k++) {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                }
                System.out.println("");
            }
        }
        
    }
    
    private void registrarCompraProducto(){
        Scanner leer = new Scanner(System.in);
        int filaProducto=this.obtenerFila();
        if(filaProducto!=0){
            Date fechaActual = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = sdf.format(fechaActual);
            System.out.print("¿Que cantidad del producto "+this.Almacen[filaProducto][0]+" se ha comprado?, ");
            int cantidadProducto = leer.nextInt();
            System.out.print("¿Cual fue el precio de compra?, ");
            float precioCompra = leer.nextFloat();
            float precioVenta = (float)(precioCompra*(1+this.porcentajeGanancia));
            for (int i = 1; i <= this.Historial.length; i++) {
                if (String.valueOf(this.Historial[i][0]).equals(" ")) {
                    this.Historial[i][0] = fecha;
                    this.Historial[i][1] = this.Almacen[filaProducto][0];
                    this.Historial[i][2] = filaProducto;
                    this.Historial[i][3] = "Compra";
                    this.Historial[i][4] = cantidadProducto;
                    this.Historial[i][5] = precioCompra;
                    this.Historial[i][6] = precioVenta;
                    this.Historial[i][7] = 0;
                    this.Almacen[filaProducto][3] = ((float)this.Almacen[filaProducto][3]+precioVenta)/2;;
                    System.out.println("\nRegistro de compra realizado correctamente.");
                    break;
                }
            }
        }
        else{
            System.out.println("\nEl producto digitado no se ha encontrado en la base de datos.");
        }
        
    }
    
    private void registrarAltaProducto(int filaProducto,String nombre,int cantidadProducto,float precioCompra,float precioVenta){
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(fechaActual);
        for (int i = 1; i <= this.Historial.length; i++) {
            if (String.valueOf(this.Historial[i][0]).equals(" ")) {
                this.Historial[i][0] = fecha;
                this.Historial[i][1] = nombre;
                this.Historial[i][2] = filaProducto;
                this.Historial[i][3] = "Alta";
                this.Historial[i][4] = cantidadProducto;
                this.Historial[i][5] = precioCompra;
                this.Historial[i][6] = precioVenta;
                this.Historial[i][7] = 0;
                System.out.println("\nProducto dado de alta correctamente.");
                break;
            }
        }
        
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
                nombre = leer.nextLine();
                this.Almacen[i][0] = nombre;
                System.out.print("Digite la cantidad de stock inicial: ");
                stock = leer.nextInt();;
                this.Almacen[i][1] = stock;
                System.out.print("Digite el precio de compra: ");
                precioCompra = leer.nextFloat();
                this.Almacen[i][2] = precioCompra;
                precioVenta = (float)this.Almacen[i][2]*(1+this.porcentajeGanancia);
                this.Almacen[i][3] = precioVenta;
                this.registrarAltaProducto(i, nombre,stock,precioCompra,precioVenta);
                band=true;
                break;
            }
        }
        return band;
    }
    
    private void mostrarTablaProductos(){
        encabezadosTablaProductos();
        for (int i = 1; i <= this.numeroProductos; i++) {
            this.registrosTablaProductos(i);
        }
    }
    
    private void mostrarTablaHistorial(){
        encabezadosTablaHistorial();
        for (int i = 1; i <= this.numeroRegistrosTablaHistorial; i++) {
            this.registrosTablaHistorial(i);
        }
    }
    
    private void encabezadosTablaProductos(){
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
        
        System.out.println("\nTabla de productos...");
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
    
    private void registrosTablaProductos(int f){
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
        
        for (int i = 1; i <= this.numeroProductos; i++) {
            if (String.valueOf(this.Almacen[i][0]).toLowerCase().equals(nombre.toLowerCase())) {
                fila=i;
                break;
            }
        }
        
        return fila;
    }
    
    private void construirTablaProductos(int numeroProductos){
        Scanner leer = new Scanner(System.in);
        this.Almacen[0][0] = "Nombre";
        this.Almacen[0][1] = "Stock";
        this.Almacen[0][2] = "Precio Compra";
        this.Almacen[0][3] = "Precio Venta";
        for (int i = 1; i <= numeroProductos; i++) {
            for (int j = 0; j < this.numeroColumnas; j++) {
                this.Almacen[i][j] = " ";
            }
        }
    }
    
    private void construirTablaHistorial(){
        Scanner leer = new Scanner(System.in);
        this.Historial[0][0] = "Fecha";
        this.Historial[0][1] = "Nombre";
        this.Historial[0][2] = "ID Producto"; //Numero de fila
        this.Historial[0][3] = "Concepto";
        this.Historial[0][4] = "Cantidad";
        this.Historial[0][5] = "Precio Compra";
        this.Historial[0][6] = "Precio Venta";
        this.Historial[0][7] = "Total $";
        for (int i = 1; i <= 100; i++) {
            for (int j = 0; j < this.numeroColumnasTablaHistorial; j++) {
                this.Historial[i][j] = " ";
            }
        }
    }
    
    private void encabezadosTablaHistorial(){
        int numeroEspacios=0;
        for (int i = 0; i < this.numeroColumnasTablaHistorial; i++) {
            if(String.valueOf(this.Historial[0][i]).length()>numeroEspacios)
                numeroEspacios = String.valueOf(this.Historial[0][i]).length();
        }
        for (int i = 1; i < this.numeroColumnasTablaHistorial; i++) {
            if(String.valueOf(this.Historial[i][0]).length()>numeroEspacios)
                numeroEspacios = String.valueOf(this.Historial[i][0]).length();
        }
        
        numeroEspacios/=2;
        
        System.out.println("\nTabla de historial...");
        for (int i = 0; i < this.numeroColumnasTablaHistorial; i++) {
            for (int j = 0; j < (numeroEspacios-(String.valueOf(this.Historial[0][i]).length()/2)); j++) {
                System.out.print(" ");
            }
            System.out.print(this.Historial[0][i]);
            for (int j = 0; j < (numeroEspacios-(String.valueOf(this.Historial[0][i]).length()/2)); j++) {
                System.out.print(" ");
            }
            System.out.print("|");
        }
        System.out.println("");
    }
    
    private void registrosTablaHistorial(int f){
        int numeroEspacios=0;
        for (int i = 0; i < this.numeroColumnasTablaHistorial; i++) {
            if(String.valueOf(this.Historial[0][i]).length()>numeroEspacios)
                numeroEspacios = String.valueOf(this.Historial[0][i]).length();
        }
        for (int i = 1; i < this.Historial.length; i++) {
            if(String.valueOf(this.Historial[i][0]).length()>numeroEspacios)
                numeroEspacios = String.valueOf(this.Historial[i][0]).length();
        }
        
        numeroEspacios/=2;
        
        if(!String.valueOf(this.Historial[f][0]).equals(" ")){
            for (int i = 0; i < this.numeroColumnasTablaHistorial; i++) {
                for (int k = 0; k < (numeroEspacios-(String.valueOf(this.Historial[f][i]).length()/2)); k++) {
                    System.out.print(" ");
                }
                System.out.print(this.Historial[f][i]);
                for (int k = 0; k < (numeroEspacios-(String.valueOf(this.Historial[f][i]).length()/2)); k++) {
                    System.out.print(" ");
                }
                System.out.print("|");
            }
            System.out.println("");
        }
    }
            
}
