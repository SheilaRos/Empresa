package empresajava;
import tools.*;
public class EmpresaAPP {
    private static ListaCliente misClientes;
    private static Fichero miFicheroCliente;
    public static void main(String[] args) {	 
            miFicheroCliente =new Fichero("Clientes.xml");
            misClientes=(ListaCliente) miFicheroCliente.leer();
            if(misClientes == null){
		misClientes = new ListaCliente();
            }
           
            int opcion=-1;
		 
		 do{
                    menu();
                    opcion= EntradaDatos.pedirEntero("Escoge una opción");
                    switch(opcion){
			case 1:
                            newCliente();
			break;
			case 2:
                            nuevoPresupuesto();
			break;
			case 3:
                            presupuestosPorAceptaroRechazar();
			break;
			case 4:
			break;
                        case 5:
                            presupuestosRechazados();
			break;
                        case 6:
                            listaClientesTotalP();
			break;
                        case 7:
                            cambiarEstadoPresupuesto();
			break;
			case 8:
                            System.out.println("Hasta luego :D");
                            break;
			default: System.out.println("opción incorrecta.");
                    }
		 }while(opcion!=8);
    }   
    public static void menu(){
        System.out.println("<~~ Menú ~~>");
        System.out.println("[1]~ Alta.");
        System.out.println("[2]~ Nuevo Presupuesto.");
        System.out.println("[3]~ Presupuestos pendientes de aceptar o rechazar.");
        System.out.println("[4]~ Listado de presupuestos de un cliente determinado.");
        System.out.println("[5]~ Listado de presupuestos rechazados.");
        System.out.println("[6]~ Listado de clientes, donde aparezca también el total de presupuestos que tiene cada uno.");
        System.out.println("[7]~ Cambiar el estado de un presupuesto.");
        System.out.println("[8]~ Salir.");
    }
    public static int pedirTelefono(String msg){
	int entero;
        String enteroString;
	do{
            entero=EntradaDatos.pedirEntero(msg);
            if(entero<=0){
		System.out.println("No se puede dejar en blanco.");
            }
            enteroString = String.valueOf(entero);
            if(enteroString.length()!=9){
                System.out.println("El telefono ha de tener 9 carácteres.");
            }
	}while(entero<=0 || enteroString.length()!=9);
    
	return entero;
    }
    public static Boolean comprobarTelefono(int telefono){
        if(misClientes.obtenerClienteTelefono(telefono)!=null){
            return false; //hay un cliente con ese telefono
        }
        return true; //no hay un cliente con ese telefono
    }
    public static String pedirCadenaNoVacia(String msg){
        String cadena;
	do{
            cadena=EntradaDatos.pedirCadena(msg);
            if(cadena.equals("")){
                System.out.println("No se puede dejar en blanco");
            }
	}while(cadena.equals(""));
	return cadena;
    }
    public static boolean pedirBoolean(){
	boolean enPropiedad=false;
	String respuesta=pedirCadenaNoVacia("¿Es vip?[Si/No]");
	do{
            if(respuesta.equalsIgnoreCase("si")){
		enPropiedad=true;
            }
            else if(respuesta.equalsIgnoreCase("no")){
		enPropiedad=false;
            }else{
		System.out.println("Respuesta incorrecta, indica Si o No.");
            }
	}while(!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no"));
	return enPropiedad;
    }
    public static void newCliente(){
        int telefono = pedirTelefono("Introduce el teléfono:");
        boolean comprobarT = comprobarTelefono(telefono);
        if(comprobarT==false){
            System.out.println("Ya existe un usuario con este teléfono.");
        }else{
            newCliente(telefono);
        }
    }
    public static void newCliente(int telefono){
            String name = pedirCadenaNoVacia("Introduce el nombre del cliente:");
            String apellidos = pedirCadenaNoVacia("Introduce los apellidos del cliente:");
            boolean vip= pedirBoolean();
            Cliente g = new Cliente(name, apellidos, telefono, vip);
            misClientes.altaCliente(g);
            miFicheroCliente.grabar(misClientes);
            System.out.println("Cliente dado de alta.");
    }
    public static int numpresupuesto(String msg){
        int entero;
        boolean comprobar=false;
	do{
            entero=EntradaDatos.pedirEntero(msg);
            if(entero<0){
		System.out.println("No se puede dejar en blanco.");
            }
           else{
                comprobar=comprobarPresupuesto(entero);
                if(!comprobar){
                    System.out.println("El número de presupuesto ya existe.");
                }
            }
	}while(entero<0 || !comprobar);
	return entero;
    }
    public static Boolean comprobarPresupuesto(int num){
         Presupuesto p=null;
         for (Cliente c : misClientes.getLista()) {
            p = c.getListaPresupuesto().obtenerPresupuestoPorNum(num);
            if(p!=null){
                return false;
            }
        }
         return true;
    }
    public static double pedirDoubleNoVacio(String msg){
	double Double;
	do{
            Double=EntradaDatos.pedirDouble(msg);
            if(Double<0){
		System.out.println("No se puede dejar en blanco");
            }
	}while(Double<0);
            return Double;
    }
    public static String pedirEstado(){
       String estado="";
       do{
          estado=  pedirCadenaNoVacia("Introduca el estado del presupuesto:");
       }while(!estado.equalsIgnoreCase("aceptado") && !estado.equalsIgnoreCase("rechazado") && !estado.equalsIgnoreCase("pendiente"));
       return estado;
    }
    public static void nuevoPresupuesto(){
        Cliente g = null;
        int telefono;
        boolean comprobar;
        do{
            telefono = pedirTelefono("Introduce el teléfono del cliente:");
            comprobar = comprobarTelefono(telefono);
            if(comprobar){
                newCliente(telefono);
                g = misClientes.obtenerClienteTelefono(telefono);
            }else{
                g = misClientes.obtenerClienteTelefono(telefono);
            }
         }while(g==null);
        
        int numPresupuesto = numpresupuesto("Introduce el número del presupuesto:");
        String concepto = pedirCadenaNoVacia("Introduce el concepto:");
        String estado = pedirEstado();
        double precioTotal= pedirDoubleNoVacio("Introduce el precio.");
        Presupuesto p = new Presupuesto(numPresupuesto, concepto, precioTotal, estado);
        g.getListaPresupuesto().altaPresupuesto(p);
        miFicheroCliente.grabar(misClientes);
        System.out.println("Presupuesto dado de alta.");
     }
    public static String precioDescuentoIVA(boolean vip, double precio){
       String texto="";
       double precioDescuento;
       double precioIVA;
           if(vip==true){
               precioDescuento= precio*0.95;
               precioIVA = precioDescuento*1.21;
               texto=" el precio con descuento es de "+precioDescuento+" y el precio con IVA es de "+precioIVA;
               return texto;
           }else{
               precioIVA = precio*1.21;
               texto=" el precio con IVA es de "+precioIVA;
               return texto;
           }
    }
    public static void presupuestosPorAceptaroRechazar(){
        boolean vip=false;
        String texto="";
         Presupuesto p=null;
         for (Cliente c : misClientes.getLista()) {
            p = c.getListaPresupuesto().obtenerPresupuestoPorEstado("pendiente");
            if(p!=null){
                vip=c.isVip();
                texto=precioDescuentoIVA(vip, p.getPreciototal());
                System.out.println(c.getNombre()+": "+ p +texto);
            }
        }
     }
    public static void presupuestosRechazados(){
         boolean vip=false;
        String texto="";
         Presupuesto p=null;
         for (Cliente c : misClientes.getLista()) {
            p = c.getListaPresupuesto().obtenerPresupuestoPorEstado("rechazado");
            if(p!=null){
                vip=c.isVip();
                texto=precioDescuentoIVA(vip, p.getPreciototal());
                System.out.println(c.getNombre()+": "+ p +texto);
            }
        }
     }
    public static void listaClientesTotalP(){
        boolean vip=false;
        String texto="";
         for (Cliente c : misClientes.getLista()) {
             System.out.println(c);
             vip=c.isVip();
            for (Presupuesto p: c.getListaPresupuesto().getLista()){
                texto = precioDescuentoIVA(vip, p.getPreciototal());
                System.out.println(p+texto);
            }
        }
     }
    public static void cambiarEstadoPresupuesto(){
      int num = 0;
      Presupuesto presupuesto = null;
      Cliente cliente = null;
      boolean comprobar = true;
      do{
          num = EntradaDatos.pedirEntero("Introduce el número de presupuesto:");
      }while(num==0);
       comprobar=comprobarPresupuesto(num);
        if(comprobar){
            System.out.println("El número de presupuesto no existe");
        }else{
           for(Cliente c: misClientes.getLista()){
              presupuesto=c.getListaPresupuesto().obtenerPresupuestoPorNum(num);
              if(presupuesto!=null){
                cliente=c;
              }
           }   
           
        }
    }
    public static void presupuestosClienteX(){
        
    }
}
