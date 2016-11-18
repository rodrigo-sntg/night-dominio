package night.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class Dominio implements IEntidade, Serializable {

	public static final String DATA_CADASTRO = "DATA_CADASTRO";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected long id;
	protected Date dtCadastro;
	
	@Override
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID") 
	public long getId() {
		return this.id;
	}
	
	@Override
	public void setId(long id) {
		this.id = id;
		
	}
	
	
	@Override
	@Temporal(TemporalType.DATE)
	@Column(name = DATA_CADASTRO) 
	public Date getDtCadastro() {
		return this.dtCadastro;
	}

	@Override
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
		
	}
}
