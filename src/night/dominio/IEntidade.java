
package night.dominio;

import java.util.Date;

public interface IEntidade {
	
	public abstract long getId();
	public abstract void setId(long id);
	public abstract Date getDtCadastro();
	public abstract void setDtCadastro(Date dtCadastro);

}
