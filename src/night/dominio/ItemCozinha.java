package night.dominio;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Access(AccessType.FIELD)
public class ItemCozinha extends Dominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="ENTRADA_COZINHA")
	private Date entradaCozinha;

	@Column(name="SAIDA_COZINHA")
	private Date saidaCozinha;

	@Column(name="STATUS")
	private int status;

	@ManyToOne
	@JoinColumn(name="ITE_ID")
	private ItemConsumo itemConsumo;

	public Date getEntradaCozinha() {
		return entradaCozinha;
	}

	public void setEntradaCozinha(Date entradaCozinha) {
		this.entradaCozinha = entradaCozinha;
	}

	public Date getSaidaCozinha() {
		return saidaCozinha;
	}

	public void setSaidaCozinha(Date saidaCozinha) {
		this.saidaCozinha = saidaCozinha;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ItemConsumo getItemConsumo() {
		return itemConsumo;
	}

	public void setItemConsumo(ItemConsumo itemConsumo) {
		this.itemConsumo = itemConsumo;
	}

}
