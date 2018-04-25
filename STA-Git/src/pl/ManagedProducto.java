package pl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

import bl.LogicaNegocio;
import dl.Producto;

@Named
@RequestScoped
public class ManagedProducto implements Serializable{


	private static final long serialVersionUID = 1L;
	private Producto articulo= new Producto();
	private boolean check=false;
	@EJB
	private LogicaNegocio logica;
	private String[] array={"Automovil","Electronica","Deportes"};
	
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
	public String[] getArray() {
		return array;
	}
	
	public void setArray(String[] array) {
		this.array = array;
	}
	
	public String toString() {
		
		StringBuilder str=new StringBuilder();
		str.append(articulo.getCategoria()+" ");
		str.append(articulo.getDescripcion()+" ");
		str.append(articulo.getPrecio());
		
		return str.toString();
	}
	
	public void anadir(){
		
		ClientBuilder
		.newClient()
		.target("http://localhost:8080/MyServlet/rest/servicios/")
		.path("anadir")
		.request()
		.post(Entity.json(articulo));
		this.check=true;
		
	}
	
	public boolean checkAdd(){
		
		return(this.check);
	}
	
	public void anadirEJB(){
		
	logica.darAlta(articulo);
	this.check=true;
	}
	
}
