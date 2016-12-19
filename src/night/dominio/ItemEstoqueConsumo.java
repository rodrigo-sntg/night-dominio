package night.dominio;

import java.text.DecimalFormat;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Access(AccessType.FIELD)
public class ItemEstoqueConsumo extends Dominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade=CascadeType.ALL , fetch = FetchType.EAGER)
	private Medida medida;
	
	@ManyToOne(cascade=CascadeType.ALL , fetch = FetchType.EAGER)
	private ItemEstoque itemEstoque;
	

	public ItemEstoqueConsumo() {
		super();
		itemEstoque = new ItemEstoque();
		medida = new Medida();
	}
	public Medida getMedida() {
		return medida;
	}
	public void setMedida(Medida medida) {
		this.medida = medida;
	}

	public ItemEstoque getItemEstoque() {
		return itemEstoque;
	}

	public void setItemEstoque(ItemEstoque itemEstoque) {
		this.itemEstoque = itemEstoque;
	}
	
	public double getCusto(){
		double custo = 0;
		
		if(this.getItemEstoque() != null)
			switch (this.getItemEstoque().getMedida().getUnidadeMedida()){
				case "L":  	// Medida.UNIDADE_LITRO
					if(this.medida.getUnidadeMedida().equals(Medida.UNIDADE_LITRO)){
						double porcentagem = this.getMedida().getMedidaPorUnidade() / this.getItemEstoque().getMedida().getMedidaPorUnidade();
						custo = porcentagem * this.getItemEstoque().getCustoUnitario();
						
					}else if(this.medida.getUnidadeMedida().equals(Medida.UNIDADE_MILILITRO)){
						
						double porcentagem = Medida.converteMlParaLitros(this.getMedida().getMedidaPorUnidade()) / this.getItemEstoque().getMedida().getMedidaPorUnidade();
						custo = porcentagem * this.getItemEstoque().getCustoUnitario();
					}else if(this.medida.getUnidadeMedida().equals(Medida.UNIDADE_UNIDADE)){
						custo = this.getItemEstoque().getCustoUnitario();
					}
					break;
				case "ml":	// Medida.UNIDADE_MILILITRO
					if(this.medida.getUnidadeMedida().equals(Medida.UNIDADE_LITRO)){
						double porcentagem = Medida.converteLitrosParaMl(this.getMedida().getMedidaPorUnidade()) / this.getItemEstoque().getMedida().getMedidaPorUnidade();
						custo = porcentagem * this.getItemEstoque().getCustoUnitario();
						
					}else if(this.medida.getUnidadeMedida().equals(Medida.UNIDADE_MILILITRO)){
						double porcentagem = this.getMedida().getMedidaPorUnidade() / this.getItemEstoque().getMedida().getMedidaPorUnidade();
						custo = porcentagem * this.getItemEstoque().getCustoUnitario();
					}else if(this.medida.getUnidadeMedida().equals(Medida.UNIDADE_UNIDADE)){
						custo = this.getItemEstoque().getCustoUnitario();
					}
					
					break;
				case "kg":	// Medida.UNIDADE_KILO
					
					break;
				case "g":	// Medida.UNIDADE_GRAMAS
					
					break;
				case "mg":	// Medida.UNIDADE_MILIGRAMAS
					
					break;
			
			
			}
		
		
		return custo;
	}
	
	public String getCustoView() {
		DecimalFormat df = new DecimalFormat("####0.00");
		return df.format(this.getCusto());
	}
	

}
