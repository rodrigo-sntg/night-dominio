package night.dominio;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Access(AccessType.FIELD)
public class Pagamento extends Dominio{
	
	public final static String PAGAMENTO_CREDITO = "credito";
	public final static String PAGAMENTO_DEBITO = "debito";
	public final static String PAGAMENTO_DINHEIRO = "dinheiro";
	
	public final static String BANDEIRA_VISA = "visa";
	public final static String BANDEIRA_MASTERCARD = "mastercard";
	public final static String BANDEIRA_DINNERSCLUB = "dinners club";
	public final static String BANDEIRA_AMEX = "american express";
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "FORMA_PAGAMENTO") 
	private String formaPagamento;

	@Column(name = "BANDEIRA") 
	private String bandeira;
	
	@Column(name = "COUVER") 
	private double couver;
	
	@Column(name = "TAXA_SERVICO") 
	private double taxaServico;
	
	@Column(name = "DESCONTO") 
	private double desconto;
	
	@Column(name = "VALOR_RECEBIDO") 
	private double valorRecebido;
	
	@Column(name = "VALOR_TROCO") 
	private double valorTroco;

	@Column(name = "VALOR") 
	private double valor;
	

	@Fetch(FetchMode.SELECT)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COM_ID", nullable = false, columnDefinition="BIGINT(20)")
	private Comanda comanda;

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public double getTaxaServico() {
		return taxaServico;
	}

	public void setTaxaServico(double taxaServico) {
		this.taxaServico = taxaServico;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public double getValorTroco() {
		return valorTroco;
	}

	public void setValorTroco(double valorTroco) {
		this.valorTroco = valorTroco;
	}

	public double getCouver() {
		return couver;
	}

	public void setCouver(double couver) {
		this.couver = couver;
	}

}
