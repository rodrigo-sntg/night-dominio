package night.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Inheritance(strategy=InheritanceType.JOINED)
@Access(AccessType.FIELD)
public class Pessoa extends Dominio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@ Table(name="pessoa", catalog = "night") para caso essa classe seja uma tabela
	
	
	@Column(name="NOME") 
	private String nome;
	
	@Column(name="RG", unique=true )
	private long rg;
	
	@Column(name="CPF", unique=true)
	private long cpf;

	@Column(name="TELEFONE") 
	private long telefone;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_NASCIMENTO") 
	private Date dtNascimento;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="END_ID")
	protected Endereco endereco;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getRg() {
		return rg;
	}

	public void setRg(long rg) {
		this.rg = rg;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
