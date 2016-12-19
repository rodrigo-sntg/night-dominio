package night.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode; 


@Entity
@Access(AccessType.FIELD)
public class Comanda extends Dominio{

	public Comanda() {
		super();
		setListaItemComanda(new ArrayList<>());
		setPagamento(new ArrayList<>());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ENTRADA") 
	private Date dataEntrada;

	@Column(name = "STATUS") 
	private boolean status;

	@Column(name = "NUMERO_COMANDA") 
	private int numeroComanda;

	@Column(name = "VALOR_TOTAL")
	private double valorTotal;

	@Column(name = "VALOR_PAGO") 
	private double valorPago;

	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ItemConsumo.class)
//	private List<ItemConsumo> listaItemConsumo;
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = ItemComanda.class)
	private List<ItemComanda> listaItemComanda;
	
	
	@ManyToOne
	@JoinColumn(name="CLI_ID")
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="comanda", targetEntity = Pagamento.class)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Pagamento> pagamento;

	
	/**
	 * getters and setters
	 * 
	 */
	
	
	
	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getNumeroComanda() {
		return numeroComanda;
	}

	public void setNumeroComanda(int numeroComanda) {
		this.numeroComanda = numeroComanda;
	}
	public double getValorTotal() {
		double total = 0;
		for (ItemComanda itemComanda : getListaItemComanda()) {
			total += (itemComanda.getItem().getPrecoVenda()) * itemComanda.getQuantidade();
		}
		valorTotal = total;
		return valorTotal;
	}
	
	public String getValorTotalView(){
		DecimalFormat df = new DecimalFormat("####0.00");
		return df.format(this.getValorTotal());
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

//	public List<ItemConsumo> getListaItemConsumo() {
//		return listaItemConsumo;
//	}
//
//	public void setListaItemConsumo(List<ItemConsumo> listaItemConsumo) {
//		this.listaItemConsumo = listaItemConsumo;
//	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Pagamento> getPagamento() {
		return pagamento;
	}

	public void setPagamento(List<Pagamento> pagamento) {
		this.pagamento = pagamento;
	}

	public List<ItemComanda> getListaItemComanda() {
		return listaItemComanda;
	}

	public void setListaItemComanda(List<ItemComanda> listaItemComanda) {
		this.listaItemComanda = listaItemComanda;
	}
}
