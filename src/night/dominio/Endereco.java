package night.dominio;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity 
@Access(AccessType.FIELD)
public class Endereco extends Dominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "RUA") 
	private String rua;

	@Column(name = "COMPLEMENTO") 
	private String complemento;

	@Column(name = "CIDADE") 
	private String cidade;

	@Column(name = "ESTADO") 
	private String estado;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Pessoa entidade;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	
	public Endereco(String rua, String complement, String cidade, String estado, Pessoa entidade){
		this.cidade = cidade;
		this.complemento = complement;
		this.cidade = cidade;
		this.estado = estado;
		this.entidade = entidade;
	}
	
	
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Pessoa getEntidade() {
		return entidade;
	}

	public void setEntidade(Pessoa entidade) {
		this.entidade = entidade;
	}

}
