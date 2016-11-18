package night.dominio;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Access(AccessType.FIELD)
public class ItemComanda extends Dominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private int quantidade;
	
	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	private ItemConsumo item;
	
	
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public ItemConsumo getItem() {
		return item;
	}
	public void setItem(ItemConsumo item) {
		this.item = item;
	}

}
