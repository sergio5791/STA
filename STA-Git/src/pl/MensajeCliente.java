package pl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import dl.Escritura;
import dl.Producto;

public class MensajeCliente implements Escritura {

	private final List<Producto> lista;

	public MensajeCliente(List<Producto> lista) {
		this.lista = lista;
	}

	@Override
	public void escibir(HttpServletResponse response) {
		// TODO Auto-generated method stub
		int i = 0;

		PrintWriter out;
		try {
			out = response.getWriter();

			out.write("<!DOCTYPE html>");
			out.write("<html lang='en-US'>");
			out.write("<head>");
			out.write("<link rel='stylesheet' href='Estilo.css'>");
			out.write("<meta charset='UTF-8'>");
			out.write("<title>Cliente</title>");
			out.write("</head>");

			out.write("<body>");
			out.write("<h1>Bienvenido a la pagina del cliente</h1>");

			out.write("<table>");
			out.write("<tr>");
			out.write("<th>Tipo de producto</th>");
			out.write("<th>Descripcion</th>");
			out.write("<th>Precio</th>");
			out.write("<th>Numero Referencia</th>");
			out.write("</tr>");
			for (i = 0; i < lista.size(); i++) {
				out.write("<tr>");
				out.write("<td>" + lista.get(i).getCategoria() + "</td>");
				out.write("<td>" + lista.get(i).getDescripcion() + "</td>");
				out.write("<td>" + lista.get(i).getPrecio() + "</td>");
				out.write("<td>+" + lista.get(i).getIdentificador() + "</td>");
				out.write("</tr>");

			}
			out.write("</table>");
			out.write("</body>");
			out.write("</html>");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
