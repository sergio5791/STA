package pl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;


import dl.LeerFicheroCSV;
import dl.LeerFicheroXML;
import dl.ListaProductos;
import dl.Producto;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//LeerFicheroCSV lectura=new LeerFicheroCSV();
		//LeerFicheroXML lectura=new LeerFicheroXML();
		ListaProductos lista= new ListaProductos();
		//lista=lectura.leer();
		
		
		lista=ClientBuilder.newClient()
				.target("http://localhost:8080/MyServlet/rest/servicios")
				.path("lista")
				.request(MediaType.APPLICATION_JSON)
				.get(ListaProductos.class);
		
		MensajeCliente mclient = new MensajeCliente(lista.getLista());
		mclient.escibir(response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
