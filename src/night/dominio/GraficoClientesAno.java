package night.dominio;

import java.util.Map;

public class GraficoClientesAno extends Dominio{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Integer,Integer> clientes;

	public Map<Integer,Integer> getClientes() {
		return clientes;
	}

	public void setClientes(Map<Integer,Integer> vendas) {
		this.clientes = vendas;
	}
}
