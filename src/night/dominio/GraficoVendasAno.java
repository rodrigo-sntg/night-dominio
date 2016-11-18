package night.dominio;

import java.util.Map;

public class GraficoVendasAno extends Dominio{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Integer,Double> vendas;

	public Map<Integer,Double> getVendas() {
		return vendas;
	}

	public void setVendas(Map<Integer,Double> vendas) {
		this.vendas = vendas;
	}
}
