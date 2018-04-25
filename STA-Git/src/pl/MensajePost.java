package pl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import dl.Escritura;
import dl.Producto;

public class MensajePost implements Escritura {

	private final Producto articulo;

	public MensajePost(Producto articulo) {
		this.articulo = articulo;
	}

	@Override
	public void escibir(HttpServletResponse response) {
		// TODO Auto-generated method stub

		try {
			PrintWriter out = response.getWriter(); // Escribir el codigo HTML
													// en el HTTP-response
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<link rel='stylesheet' href='Estilo.css'>");
			out.println("<title> Admin </title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1> Articulo Introducido</h1>");
			out.println("<p> El articulo " + articulo.getCategoria() + " con la descripcion "
					+ articulo.getDescripcion() + " tiene un valor de " + articulo.getPrecio() + "</p>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
