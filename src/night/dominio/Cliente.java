package night.dominio;


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
import javax.persistence.PrimaryKeyJoinColumn;


@Entity 
@PrimaryKeyJoinColumn(name="ID")
@Access(AccessType.FIELD)
public class Cliente extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="ATIVO")
	private boolean ativo;

	
//    @JoinTable(name = "COMANDA", joinColumns = { @JoinColumn(name = "CLI_ID") }, inverseJoinColumns = { @JoinColumn(name = "COM_ID") })
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Comanda.class)
	private List<Comanda> comandas;
	
	public Cliente(){
		comandas = new ArrayList<Comanda>();
		this.endereco = new Endereco();
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
	}
	
}
