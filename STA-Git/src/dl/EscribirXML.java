package dl;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class EscribirXML implements EscribirFichero {

	@Override
	public void escribir(Producto articulo) {
		
		// TODO Auto-generated method stub
		LeerFicheroXML leer = new LeerFicheroXML();
		File fichero = new File("/home/sergio/ArticuloXML.xml");
		ListaProductos lista=new ListaProductos();
		GenerarNumAleatorio numRan= new GenerarNumAleatorio();
		
		articulo.setIdentificador(numRan.opera());
		if (fichero.exists()) {
			lista.setLista(leer.leer().getLista());
		}
		lista.getLista().add(articulo);

		try {
			JAXBContext contexto = JAXBContext.newInstance(ListaProductos.class);
			Marshaller marshaller = contexto.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(lista, fichero);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al escribir el XML");
		}

	}

}
