package dl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirCSV implements EscribirFichero {

	@Override
	public void escribir(Producto articulo) {
		// TODO Auto-generated method stub
		File fichero = new File("datos.csv");
		ListaProductos lista=new ListaProductos();
		lista.getLista().add(articulo); //Aunque no lo escribo con la lista, esta seria otra forma
	
		try {
			FileWriter write=new FileWriter(fichero,true);
			write.write(articulo.getCategoria()+";"+articulo.getDescripcion()+";"+articulo.getPrecio()+";"+articulo.getIdentificador()+"\n");
			write.flush();
			
			write.close();		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al escribir");
		}
	}

}
