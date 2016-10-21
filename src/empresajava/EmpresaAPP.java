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
			 		
			break;
			case 3:
			break;
			case 4:
			break;
                        case 5:
			break;
                        case 6:
			break;
                        case 7:
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
    
    public static void newCliente(){
        int telefono = pedirTelefono("Introduce el teléfono:");
        if(telefono==0){
            System.out.println("Ya existe un usuario con este teléfono.");
        }else{
            String name = pedirCadenaNoVacia("Introduce el nombre del cliente:");
            String apellidos = pedirCadenaNoVacia("Introduce los apellidos del cliente:");
            boolean vip= pedirBoolean();
            Cliente g = new Cliente(name, apellidos, telefono, vip);
            misClientes.altaCliente(g);
            miFicheroCliente.grabar(misClientes);
            System.out.println("Cliente dado de alta.");
        }
    }
    public static int pedirTelefono(String msg){
	int entero;
        String enteroString;
	do{
            entero=EntradaDatos.pedirEntero(msg);
            if(entero<0){
		System.out.println("No se puede dejar en blanco.");
            }
            enteroString = String.valueOf(entero);
            if(enteroString.length()<9){
                System.out.println("El telefono ha de tener 9 carácteres.");
            }
	}while(entero<0 && enteroString.length()<9);
       
        if(misClientes.obtenerClienteTelefono(entero)!=null){
            return 0;
        }
	return entero;
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
     
     
    public static Cliente pedirTelefonoCliente(String msg){
	int entero;
	do{
            entero=EntradaDatos.pedirEntero(msg);
            if(entero<0){
		System.out.println("No se puede dejar en blanco");
            }
	}while(entero<0);
       Cliente g = misClientes.obtenerClienteTelefono(entero);
	if(g!=null){
            return g; 
        }
        return null;
    }
    
     public static void nuevoPresupuesto(){
        Cliente g = null;
        do{
            g = pedirTelefonoCliente("Introduce el teléfono del cliente:");
            if(g==null){
                newCliente();
            }
           
         }while(g==null);
        
     }
}