package night.dominio;

import java.util.List;

public class ChartSerie {
	String name;
	String id;
	private List<ChartData> data;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<ChartData> getData() {
		return data;
	}
	public void setData(List<ChartData> data) {
		this.data = data;
	}
}
