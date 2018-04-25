package pl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

import dl.Producto;

@Named
@RequestScoped
public class anadirREST implements Serializable {


	private static final long serialVersionUID = 1L;
	@EJB //Indico que se va a usar EJB por lo que no hace falta hacer un new de Producto
	private Producto articulo;
	private boolean check = false;
	
	
	public String getCategoria() {
		return articulo.getCategoria();
	}
	public void setCategoria(String categoria) {
		articulo.setCategoria(categoria);
	}
	public String getPrecio() {
		return articulo.getPrecio();
	}
	public void setPrecio(String precio) {
		articulo.setPrecio(precio);
	}
	public String getDescripcion() {
		return articulo.getDescripcion();
	}
	public void setDescripcion(String descripcion) {
		articulo.setDescripcion(descripcion);
	}
	public String getIdentificador() {
		return articulo.getIdentificador();
	}
	public void setIdentificador(String identificador) {
		articulo.setIdentificador(identificador);
	}

	public String toString() {
		return articulo.toString();
	}
	
	public void anadirRest (){
		ClientBuilder
		.newClient()
		.target("http://localhost:8080/MyServlet/rest/servicios/")
		.path("anadir")
		.request()
		.post(Entity.xml(articulo));
		
		this.check=true;
		
	}
	
	public boolean checkAdd(){
		
		return(this.check);
	}
	
	
	
}
