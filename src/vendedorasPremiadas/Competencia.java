package vendedorasPremiadas;
import java.io.FileNotFoundException;

public class Competencia {
	private Vendedora[] vendedoras;
	private int ventasConsecutivas;
	
	
	public  void Competir(String numero) throws FileNotFoundException {
		String pathInput = "casos_de_prueba/Input/" + numero + ".in";
		String pathOutput = "casos_de_prueba/Output/" + numero + ".out";
		Vendedora vendedora = new Vendedora();
		LeerEscribirArchivo l = new LeerEscribirArchivo(pathInput, pathOutput);
		String resultado;
		l.leerVendedoras(this);
		resultado = vendedoraPremiada(vendedora);
		l.escribir(vendedora, resultado);
	}

	public String vendedoraPremiada(Vendedora vendedora) {
		int maxImporte = 0, contador = 0, id = 0, noHayMasVendedoras = 0;
		String resultado = "";
		while (noHayMasVendedoras == 0) {

			for (int j = 0; j < this.vendedoras.length; j++) {
				if (this.vendedoras[j].isDescalificada() == false
						&& this.vendedoras[j].getVentasConsecutivas() >= this.ventasConsecutivas) {
					if (this.vendedoras[j].sumarImporte(this.vendedoras[j].getVentas(),
							this.ventasConsecutivas) > maxImporte) {
						maxImporte = this.vendedoras[j].sumarImporte(this.vendedoras[j].getVentas(),
								this.ventasConsecutivas);

					}

				}
				if (maxImporte == 0) {
					noHayMasVendedoras = 1;
				} else {
					contador = 0;
				}
			}

			for (int z = 0; z < this.vendedoras.length; z++) {
				if (this.vendedoras[z].isDescalificada() == false
						&& this.vendedoras[z].getVentasConsecutivas() >= this.ventasConsecutivas) {
					if (this.vendedoras[z].sumarImporte(this.vendedoras[z].getVentas(),
							this.ventasConsecutivas) == maxImporte) {
						id = this.vendedoras[z].getId();
						contador++;
					} else if (this.vendedoras[z].sumarImporte(this.vendedoras[z].getVentas(),
							this.ventasConsecutivas) < maxImporte) {
						this.vendedoras[z].setDescalificada(true);
					}
				}
			}

			if (contador == 1) {
				noHayMasVendedoras = 1;
			}
			if (contador > 1) {
				this.ventasConsecutivas++;
				id = 0;
				maxImporte = 0;
			}
		}

		if (noHayMasVendedoras == 1 && contador == 0) {
			resultado = "No hay vendedora premiada";

		}
		if (noHayMasVendedoras == 1 && contador == 1) {
			vendedora.setId(id);
			vendedora.setVentasConsecutivas(this.ventasConsecutivas);
			vendedora.setImporteVentas(maxImporte);
		}
		if (noHayMasVendedoras == 1 && contador > 1) {
			resultado = "No se puede desempatar";
		}

		return resultado;
	}

	public void setVendedoras(Vendedora[] vendedoras) {
		this.vendedoras = vendedoras;
	}

	public void setVentasConsecutivas(int ventasConsecutivas) {
		this.ventasConsecutivas = ventasConsecutivas;
	}

	public int getVentasConsecutivas() {
		return ventasConsecutivas;
	}
}
