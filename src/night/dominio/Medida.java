package night.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Medida extends Dominio {
	
	public static String UNIDADE_LITRO = "L";
	public static String UNIDADE_MILILITRO = "ml";
	public static String UNIDADE_KILO = "kg";
	public static String UNIDADE_GRAMA = "g";
	public static String UNIDADE_MILIGRAMA = "mg";
	public static String UNIDADE_UNIDADE = "un";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="UNIDADE_MEDIDA")
	public double medidaPorUnidade;
	@Column(name="UNIDADE_MEDIDA")
	public String unidadeMedida;


	public double getMedidaPorUnidade() {
		return medidaPorUnidade;
	}

	public void setMedidaPorUnidade(double medidaPorUnidade) {
		this.medidaPorUnidade = medidaPorUnidade;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public static double converteLitrosParaMl(double valor){
		return valor*(Math.pow(10, 3));
	}
	
	public static double converteMlParaLitros(double valor){
		return valor/(Math.pow(10, 3));
	}
	
	public static double converte(String de, String para, double valor){
		switch(de){
		case "L":
			switch(para){
			case "L":
				return valor;
			case "ml":
				converteLitrosParaMl(valor);
			case "kg":
				return valor;
			case "g":
				converteKilosParaGramas(valor);
			case "mg":
				return 0;
			case "un":
				return valor;
			}
			break;
		case "ml":
			switch(para){
			case "L":
				return converteMlParaLitros(valor);
			case "ml":
				return valor;
			case "kg":
				return converteMlParaLitros(valor);
			case "g":
				return valor;
			case "mg":
				return converteGramasParaMiliGramas(valor);
			case "un":
				return valor;
			}
			break;
		case "kg":
			switch(para){
			case "L":
				return valor;
			case "ml":
				return converteGramasParaKilos(valor);
			case "kg":
				return valor;
			case "g":
				return converteKilosParaGramas(valor);
			case "mg":
				return converteKiloParaMiliGramas(valor);
			case "un":
				return valor;
			}
			break;
		case "g":
			switch(para){
			case "L":
				return converteGramasParaKilos(valor);
			case "ml":
				return valor;
			case "kg":
				return converteGramasParaKilos(valor);
			case "g":
				return valor;
			case "mg":
				return converteGramasParaMiliGramas(valor);
			case "un":
				return valor;
			}
			break;
		case "mg":
			switch(para){
			case "L":
				return converteMiliGramasParaKilos(valor);
			case "ml":
				return converteMiliGramasParaGramas(valor);
			case "kg":
				return converteMiliGramasParaKilos(valor);
			case "g":
				return converteMiliGramasParaGramas(valor);
			case "mg":
				return valor;
			case "un":
				return valor;
			}
			break;
		case "un":
			switch(para){
			case "L":
				return valor;
			case "ml":
				return valor;
			case "kg":
				return valor;
			case "g":
				return valor;
			case "mg":
				return valor;
			case "un":
				return valor;
			}
			break;
		}
		return 0;
	}
	public static double converteKilosParaGramas(double valor){
		return valor*(Math.pow(10, 3));
	}
	
	public static double converteGramasParaKilos(double valor){
		return valor/(Math.pow(10, 3));
	}
	
	public static double converteGramasParaMiliGramas(double valor){
		return valor*(Math.pow(10, 3));
	}
	
	public static double converteMiliGramasParaGramas(double valor){
		return valor/(Math.pow(10, 3));
	}
	
	public static double converteKiloParaMiliGramas(double valor){
		return valor*(Math.pow(10, 6));
	}
	
	public static double converteMiliGramasParaKilos(double valor){
		return valor/(Math.pow(10, 6));
	}
	
}
