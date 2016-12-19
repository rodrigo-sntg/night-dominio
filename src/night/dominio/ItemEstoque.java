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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Access(AccessType.FIELD)
public class ItemEstoque extends Item {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name = "STATUS") 
	private int status;

	@Column(name = "QUANTIDADE_ESTOQUE") 
	private long qtdEstoque;
	
	@Column(name = "VOLUME_ESTOQUE") 
	private double volumeEstoque;

	@Column(name = "QUANTIDADE_CRITICA") 
	private long qtdCritica;

	@Column(name = "CUSTO_TOTAL_ESTOQUE") 
	private double custoTotalEstoque;

	@Column(name = "CUSTO_UNITARIO") 
	private double custoUnitario;

	
//	@JoinTable(name = "EST_ENT", joinColumns = { @JoinColumn(name = "ITE_EST_ID") }, inverseJoinColumns = { @JoinColumn(name = "ENT_ID") })
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Entrada> historicoPrecosCompra;

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "MEDIDA_ID")
	private Medida medida;

	public ItemEstoque() {
		super();
		this.subCategoria = new SubCategoria();
		this.medida = new Medida();
		historicoPrecosCompra = new ArrayList<>();
	}

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(long qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public long getQtdCritica() {
		return qtdCritica;
	}

	public void setQtdCritica(long qtdCritica) {
		this.qtdCritica = qtdCritica;
	}

	public double getCustoTotalEstoque() {
		return custoTotalEstoque;
	}
	
	public String getCustoTotalEstoqueView() {
		DecimalFormat df = new DecimalFormat("####0.00");
		return df.format(custoTotalEstoque);
	}

	public void setCustoTotalEstoque(double valorTotalEstoque) {
		this.custoTotalEstoque = valorTotalEstoque;
	}

	

	public List<Entrada> getHistoricoPrecosCompra() {
		return historicoPrecosCompra;
	}

	public void setHistoricoPrecosCompra(List<Entrada> historicoPrecosCompra) {
		this.historicoPrecosCompra = historicoPrecosCompra;
	}

	public Medida getMedida() {
		return medida;
	}

	public void setMedida(Medida medida) {
		this.medida = medida;
	}

	public double getCustoUnitario() {
		if(this.custoTotalEstoque != 0 && qtdEstoque != 0)
			this.setCustoUnitario(custoTotalEstoque/qtdEstoque);
		return custoUnitario;
	}
	
	public String getCustoUnitarioView() {
		DecimalFormat df = new DecimalFormat("####0.00");
		return df.format(this.getCustoUnitario());
	}

	private void setCustoUnitario(double custoUnitario) {
		this.custoUnitario = custoUnitario;
	}


	public double getVolumeEstoque() {
		return volumeEstoque;
	}


	public void setVolumeEstoque(double volumeEstoque) {
		this.volumeEstoque = volumeEstoque;
	}

}
