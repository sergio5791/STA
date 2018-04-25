package dl;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;

public class LeerFicheroJSON implements LeerFichero{

	
	private ListaProductos lista;
	
	@Override
	public ListaProductos leer() {
		// TODO Auto-generated method stub
		
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(ListaProductos.class);
			Unmarshaller unmarshall =contexto.createUnmarshaller();
			unmarshall.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
			lista=(ListaProductos) unmarshall.unmarshal(new File("/home/sergio/ArticuloJSON.json"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return lista;
	}
	
	
	

}
