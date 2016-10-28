package empresajava;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String apellidos;
    private int telefono;
    private boolean vip;
    private ListaPresupuestos listaPresupuesto;
    
    public Cliente(){
    }
    public Cliente(String nombre, String apellidos, int telefono, boolean vip) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.vip = vip;
        listaPresupuesto = new ListaPresupuestos();
    }

    public ListaPresupuestos getListaPresupuesto() {
        return listaPresupuesto;
    }

    public void setListaPresupuesto(ListaPresupuestos listaPresupuesto) {
        this.listaPresupuesto = listaPresupuesto;
    }


    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        String respuesta = "Cliente --> " + "Nombre=" + nombre + ", Apellidos=" + apellidos + ", telefono=" + telefono + ", vip= ";
        if(vip){
            respuesta= respuesta + "es Vip";
        }else{
            respuesta= respuesta + "no es Vip";
        }
       return respuesta;
    }

}
