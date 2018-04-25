package dl;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class LeerFicheroXML implements LeerFichero{

	private ListaProductos lista= new ListaProductos();
	
	
	public ListaProductos leer() {
		// TODO Auto-generated method stub
		
			try {
				JAXBContext contextoJAXB = JAXBContext.newInstance(ListaProductos.class);
				Unmarshaller unmarshaller=contextoJAXB.createUnmarshaller();
				lista=(ListaProductos) unmarshaller.unmarshal(new File("/home/sergio/ArticuloXML.xml"));
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return lista;
	}

	
	
	
}
