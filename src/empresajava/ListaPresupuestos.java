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
     public Presupuesto obtenerPresupuestoPorNum(int num){
	for (Presupuesto c : lista){
            if(c.getNumpresupuesto()==num){
		return c;
            }
	}	
        return null;
    }
     public Presupuesto obtenerPresupuestoPorEstado(String estado){
	for (Presupuesto c : lista){
            if(c.getEstado().equalsIgnoreCase(estado)){
		return c;
            }
	}	
        return null;
    }
    public void altaPresupuesto(Presupuesto p){
	lista.add(p);
    }
}
