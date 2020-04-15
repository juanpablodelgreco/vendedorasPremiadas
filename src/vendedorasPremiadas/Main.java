package vendedorasPremiadas;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
	int numero=1;
	String pathInput = "casos_de_prueba/Input/"+numero+".in";
	String pathOutput = "casos_de_prueba/Output/"+numero+".out";
	int	cantidadVendedoras = 0,
		busquedasConsecutivas = 0;
	String resultado;
	cantidadVendedoras = LeerEscribirArchivo.LeerCantidad(pathInput);
	Vendedora []vendedoras = new Vendedora[cantidadVendedoras];
	Vendedora vendedora = new Vendedora();
	busquedasConsecutivas = LeerEscribirArchivo.Leer(pathInput, vendedoras, cantidadVendedoras);
	resultado = vendedoraPremiada(vendedoras, vendedora,busquedasConsecutivas);
	LeerEscribirArchivo.Escribir(pathOutput, vendedora, resultado);
	}
	
	public static String vendedoraPremiada(Vendedora[] vendedoras, Vendedora vendedora, int busquedasConsecutivas) {
		int maxImporte = 0, contador = 0, id = 0, noHayMasVendedoras = 0;
		String resultado = "";
		while (noHayMasVendedoras == 0) {

			for (int j = 0; j < vendedoras.length; j++) {
				if (vendedoras[j].isDescalificada() == false
						&& vendedoras[j].getVentasConsecutivas() >= busquedasConsecutivas) {
					if (vendedoras[j].sumarImporte(vendedoras[j].getVentas(), busquedasConsecutivas) > maxImporte) {
						maxImporte = vendedoras[j].sumarImporte(vendedoras[j].getVentas(), busquedasConsecutivas);

					}

				}
				if (maxImporte == 0) {
					noHayMasVendedoras = 1;
				} else {
					contador = 0;
				}
			}

			for (int z = 0; z < vendedoras.length; z++) {
				if (vendedoras[z].isDescalificada() == false
						&& vendedoras[z].getVentasConsecutivas() >= busquedasConsecutivas) {
					if (vendedoras[z].sumarImporte(vendedoras[z].ventas, busquedasConsecutivas) == maxImporte) {
						id = vendedoras[z].getId();
						contador++;
					} else if (vendedoras[z].sumarImporte(vendedoras[z].ventas, busquedasConsecutivas) < maxImporte) {
						vendedoras[z].setDescalificada(true);
					}
				}
			}

			if (contador == 1) {
				noHayMasVendedoras = 1;
			}
			if (contador > 1) {
				busquedasConsecutivas++;
				id = 0;
				maxImporte = 0;
			}
		}

		if (noHayMasVendedoras == 1 && contador == 0) {
			resultado = "No hay vendedora premiada";

		}
		if (noHayMasVendedoras == 1 && contador == 1) {
			vendedora.setId(id);
			vendedora.setVentasConsecutivas(busquedasConsecutivas);
			vendedora.setImporteVentas(maxImporte);
		}
		if (noHayMasVendedoras == 1 && contador > 1) {
			resultado = "No se puede desempatar";
		}

		return resultado;
	}
}
