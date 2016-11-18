package night.dominio;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Categoria extends Dominio {
	
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
