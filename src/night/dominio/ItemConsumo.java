package night.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@Access(AccessType.FIELD)
public class ItemConsumo extends Item {

	public ItemConsumo() {
		super();
		listaItemEstoqueConsumo = new ArrayList<>();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "PRECO_VENDA")
	private double precoVenda;
	
	@Column(name = "CUSTO") 
	private double custoTotal;
	
	@Column(name = "PERCENTUAL_LUCRO") 
	private double percentualLucro;
	
	@Column(name = "FAVORITO") 
	private boolean favorito;
	
	@Column(name = "COZINHA") 
	private boolean cozinha;

	
//	@JoinTable(name = "ITE_EST_CON", joinColumns = { @JoinColumn(name = "ITE_CON_ID") }, inverseJoinColumns = { @JoinColumn(name = "ITE_EST_ID") })
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private List<ItemEstoqueConsumo> listaItemEstoqueConsumo;
	
	
	/**
	 * Getters and setters
	 * 
	 */
	
	
	public double getPrecoVenda() {
		return precoVenda;
	}
	
	public String getPrecoVendaView() {
		DecimalFormat df = new DecimalFormat("####0.00");
		return df.format(this.getPrecoVenda());
	}

	public void setPrecoVenda(double valorVenda) {
		this.precoVenda = valorVenda;
	}

	public double getCustoTotal() {
		double custo = 0;
		for (ItemEstoqueConsumo itemEstoqueConsumo : listaItemEstoqueConsumo) {
			if(itemEstoqueConsumo.getItemEstoque().getMedida().getUnidadeMedida() != null && itemEstoqueConsumo.getMedida().getUnidadeMedida() != null)
				custo += itemEstoqueConsumo.getCusto();
		}
		
		return custo;
	}
	
	public double getLucro(){
		
		return (this.getPrecoVenda() - this.getCustoTotal())/ this.getCustoTotal();
		
	}
	
	public String getCustoTotalView() {
		DecimalFormat df = new DecimalFormat("####0.00");
		return df.format(this.getCustoTotal());
	}
	
	public String getLucroView() {
		DecimalFormat df = new DecimalFormat("####0.00");
		return df.format(this.getLucro() * 100) + "%";
	}

	public void setCustoTotal(double custoTotal) {
		this.custoTotal = custoTotal;
	}
	public double getPercentualLucro() {
		return percentualLucro;
	}

	public void setPercentualLucro(double percentualLucro) {
		this.percentualLucro = percentualLucro;
	}

	public List<ItemEstoqueConsumo> getListaItemEstoqueConsumo() {
		return listaItemEstoqueConsumo;
	}

	public void setListaItemEstoqueConsumo(List<ItemEstoqueConsumo> listaItemEstoqueConsumo) {
		this.listaItemEstoqueConsumo = listaItemEstoqueConsumo;
	}

	public boolean isCozinha() {
		return cozinha;
	}

	public void setCozinha(boolean cozinha) {
		this.cozinha = cozinha;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}
}
