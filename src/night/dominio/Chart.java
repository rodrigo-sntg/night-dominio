package night.dominio;

import java.util.ArrayList;
import java.util.List;

public class Chart extends Dominio{
	
	public Chart() {
		super();
		this.series = new ArrayList<ChartSerie>();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ChartSerie> series;

	public List<ChartSerie> getSeries() {
		return series;
	}

	public void setSeries(List<ChartSerie> serie) {
		this.series = serie;
	}
}
