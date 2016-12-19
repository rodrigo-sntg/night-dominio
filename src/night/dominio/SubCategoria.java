package night.dominio;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Access(AccessType.FIELD)
public class SubCategoria extends Categoria {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private CategoriaPrincipal categoria;

	public SubCategoria(CategoriaPrincipal categoria) {
		super();
		this.categoria = categoria;
	}
	
	public SubCategoria() {
		super();
		this.categoria = new CategoriaPrincipal();
	}

	public CategoriaPrincipal getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaPrincipal categoria) {
		this.categoria = categoria;
	}

}
