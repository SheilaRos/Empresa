package empresajava;

import java.util.ArrayList;

public class ListaCliente {
    private ArrayList<Cliente> lista = new ArrayList<>();
    
    
    public ArrayList<Cliente> getLista() {
	return lista;
    }
    public void setLista(ArrayList<Cliente> lista) {
	this.lista = lista;
    }
    public Cliente obtenerClienteTelefono(int telefono){
	for (Cliente g : lista){
            if(g.getTelefono()==telefono){
		return g;
            }
	}	
        return null;
    }
    public void altaCliente(Cliente g){
		lista.add(g);
	}
}
