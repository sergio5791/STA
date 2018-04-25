package pl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;


import dl.EscribirCSV;
import dl.EscribirXML;
import dl.GenerarNumAleatorio;
import dl.Producto;

/**
 * Servlet implementation class ServletAdmin
 */
@WebServlet("/ServletAdmin")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		MensajeGet mget = new MensajeGet();
		mget.escibir(response);

		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		GenerarNumAleatorio numRan=new GenerarNumAleatorio();
		
		Producto articulo = new Producto();
		articulo.setCategoria(request.getParameter("categoria"));
		articulo.setDescripcion(request.getParameter("descripcion"));
		articulo.setPrecio(request.getParameter("precio"));
		articulo.setIdentificador(numRan.opera());

		//EscribirCSV escribir=new EscribirCSV(articulo);
		//escribir.escribir();
		
		//EscribirXML escrxml=new EscribirXML(articulo);
		//escrxml.escribir();

		ClientBuilder.newClient().target("http://localhost:8080/MyServlet/rest/servicios")
				     .path("anadir")
				     .request()
				     .post(Entity.entity(articulo, MediaType.APPLICATION_XML));
		
	
		MensajePost mpost = new MensajePost(articulo);
		mpost.escibir(response);

		return;

	}

}
