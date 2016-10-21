package empresajava;

import java.util.ArrayList;

public class ListaPresupuestos {
    private ArrayList<Presupuesto> lista;
    
    public ListaPresupuestos(){
	lista = new ArrayList<>();
    }
    public ArrayList<Presupuesto> getLista() {
	return lista;
    }
    public void setLista(ArrayList<Presupuesto> lista) {
	this.lista = lista;
    }
}
