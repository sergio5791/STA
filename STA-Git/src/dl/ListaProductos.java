package dl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ListaProductos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Producto> lista;

	@XmlElement(name = "catalogo")
	public List<Producto> getLista() {

		if (lista == null) {
			lista = new ArrayList<Producto>();
		}

		return lista;
	}

	public void setLista(List<Producto> lista) {
		this.lista = lista;
	}

}
