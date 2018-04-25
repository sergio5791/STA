package bl;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dl.EscribirJSON;
import dl.EscribirXML;
import dl.LeerFicheroJSON;
import dl.LeerFicheroXML;
import dl.ListaProductos;
import dl.Producto;
import pl.anadirREST;

@Path("/servicios")


@Stateless
@LocalBean
@DenyAll
public class LogicaNegocio {


		
	@PermitAll
	@Path("lista")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ListaProductos leerXML(){
		
		ListaProductos lista=new ListaProductos();
		LeerFicheroXML leer=new LeerFicheroXML();
		//LeerFicheroJSON leer = new LeerFicheroJSON();		

		lista=leer.leer();
		
		return lista;
	}
	
	@RolesAllowed("Administrador")
	@Path("anadir")
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void darAlta(Producto articulo){
		
		EscribirXML escribir=new EscribirXML();
		//EscribirJSON escribir=new EscribirJSON();
		escribir.escribir(articulo);
		//em.persist(articulo);
		//em.flush();
		
	}
	
}
