package night.dominio;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
@Access(AccessType.FIELD)
public class Item extends Dominio  {

	public Item() {
		super();
		subCategoria = new SubCategoria();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "NOME_ITEM") 
	protected String nomeItem;

	@Column(name = "DESCRICAO") 
	protected String descricao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	protected SubCategoria subCategoria;;

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public SubCategoria getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}


}
