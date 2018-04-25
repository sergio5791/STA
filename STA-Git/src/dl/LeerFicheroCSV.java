package dl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerFicheroCSV implements LeerFichero{

	@Override
	public ListaProductos leer() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String linea;
		String[]datos;
		File fichero= new File("datos.csv");
		ListaProductos lista= new ListaProductos();

		try {
			FileReader read = new FileReader(fichero);
			BufferedReader bufread =new BufferedReader(read);
			
			while((linea=bufread.readLine())!=null){
				datos=linea.split(";");
				Producto elemento=new Producto();
				elemento.setCategoria(datos[0]);
				elemento.setDescripcion(datos[1]);
				elemento.setPrecio(datos[2]);
				elemento.setIdentificador(datos[3]);
				lista.getLista().add(elemento);
			}
			bufread.close();
			read.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Error al abrir el fichero");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Error durante la lectura del fichero");
		}
		
		return lista;
	}

}
