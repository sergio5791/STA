package pl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import bl.LogicaNegocio;
import dl.ListaProductos;
import dl.Producto;

@Named
@ApplicationScoped
public class ManagedShopList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private LogicaNegocio logica;
	private ListaProductos lista= new ListaProductos();
	
	
	public List<Producto> getLista() {
		
		lista=ClientBuilder
		.newClient()
		.target("http://localhost:8080/MyServlet/rest/servicios")
		.path("lista")
		.request(MediaType.APPLICATION_JSON)
		.get(ListaProductos.class);

		return lista.getLista();
	}

	/*public void setLista(List<Producto> lista) {
		lista.setLista(lista);
	}*/


	public String toString() {
		return lista.toString();
	}

	public List<Producto> devuelveLista (){
		
		return(logica.leerXML().getLista());
		
	}
	
	
	
	
}
