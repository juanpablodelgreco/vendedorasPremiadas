package vendedorasPremiadas;

public class Vendedora {
	
	int id,
		cantVentas,
		importeVentas,
		ventasConsecutivas;
	boolean descalificada;
	int []ventas;
	
	public Vendedora() {
		this.id = 0;
		this.cantVentas = 0;
		this.importeVentas = 0;
		this.descalificada = false;	
	}
	
	public boolean isDescalificada() {
		return descalificada;
	}

	public void setDescalificada(boolean descalificada) {
		this.descalificada = descalificada;
	}

	public int getCantVentas() {
		return cantVentas;
	}

	public void setCantVentas(int cantVentas) {
		this.cantVentas = cantVentas;
	}

	public int getImporteVentas() {
		return importeVentas;
	}

	public void setImporteVentas(int importeVentas) {
		this.importeVentas = importeVentas;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public int sumarImporte(int []ventas, int ventasConsecutivas) {
		int importe = 0;
		for(int i = 0; i<ventasConsecutivas ; i++) {
			importe += ventas[i];
		}
		return importe;
	}

	public int[] getVentas() {
		return ventas;
	}

	public void setVentas(int[] ventas) {
		this.ventas = ventas;
	}

	public int getVentasConsecutivas() {
		return ventasConsecutivas;
	}

	public void setVentasConsecutivas(int ventasConsecutivas) {
		this.ventasConsecutivas = ventasConsecutivas;
	}
}
