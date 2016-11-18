package night.dominio;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@Access(AccessType.FIELD)
public class Cozinha extends Dominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ItemCozinha.class)
	private List<ItemCozinha> itemCozinha;

	public List<ItemCozinha> getItemCozinha() {
		return itemCozinha;
	}

	public void setItemCozinha(List<ItemCozinha> itemCozinha) {
		this.itemCozinha = itemCozinha;
	}

}
