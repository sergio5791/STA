package dl;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.persistence.jaxb.MarshallerProperties;


public class EscribirJSON implements EscribirFichero {


	@Override
	public void escribir(Producto articulo) {
		// TODO Auto-generated method stub

		File fichero = new File("/home/sergio/ArticuloJSON.json");
		LeerFicheroJSON leer= new LeerFicheroJSON();
		ListaProductos lista= new ListaProductos();
		GenerarNumAleatorio numRan= new GenerarNumAleatorio();
		
		articulo.setIdentificador(numRan.opera());
		if(fichero.exists()){
		lista.setLista(leer.leer().getLista());	
		}

		lista.getLista().add(articulo);
		
		try {
			JAXBContext contexto = JAXBContext.newInstance(ListaProductos.class);
			Marshaller marshall = contexto.createMarshaller();
			marshall.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
			marshall.marshal(lista, fichero);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
