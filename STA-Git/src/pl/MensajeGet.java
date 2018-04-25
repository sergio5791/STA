package pl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import dl.Escritura;

public class MensajeGet implements Escritura {

	@Override
	public void escibir(HttpServletResponse response) {
		// TODO Auto-generated method stub
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<link rel='stylesheet' href='Estilo.css'>");
			out.println("<title> Admin </title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1> NO Funciona por GET !!!</h1>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Escribir el codigo HTML en el HTTP-response
	}

}
