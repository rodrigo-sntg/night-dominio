package night.dominio;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Access(AccessType.FIELD)
public class Entrada extends Dominio{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA")
	private Date data;
	
	@Column(name="PRECO_COMPRA")
	private BigDecimal precoCompra;

	public BigDecimal getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(BigDecimal precoCompra) {
		this.precoCompra = precoCompra;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
