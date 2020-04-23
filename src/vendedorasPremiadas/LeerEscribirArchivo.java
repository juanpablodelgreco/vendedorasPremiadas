package vendedorasPremiadas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LeerEscribirArchivo {
	private String inputPath;
	private String outputPath;
	
	
	public LeerEscribirArchivo(String input, String output) {
		this.inputPath = input;
		this.outputPath = output;
	}
	
	public void leerVendedoras(Competencia c) {
		int cantVendedoras = 0;
		try {
			Scanner sc = new Scanner(new File(this.inputPath));
			int[] ventas;
			cantVendedoras = sc.nextInt();
			Vendedora[] vendedoras = new Vendedora[cantVendedoras];
			for (int i = 0; i < cantVendedoras; i++) {
				Vendedora v = new Vendedora();
				v.setId(i + 1);
				v.setVentasConsecutivas(sc.nextInt());
				ventas = new int[v.getVentasConsecutivas()];
				for (int j = 0; j < v.getVentasConsecutivas(); j++) {
					ventas[j] = sc.nextInt();
				}
				this.ordenarVentas(ventas);
				v.setVentas(ventas);
				vendedoras[i] = v;
			}
			c.setVentasConsecutivas(sc.nextInt());
			c.setVendedoras(vendedoras);
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir el archivo "+this.inputPath);
		}
		
	}

	public void escribir(Vendedora vendedora_premiada, String desempate)
			throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(this.outputPath));
		if (vendedora_premiada.getVentasConsecutivas() == 0 && desempate.compareTo("No hay vendedora premiada") == 0) {
			pw.println("No hay vendedora premiada");
		} else {
			if (vendedora_premiada.getVentasConsecutivas() == 0 && desempate.compareTo("No se puede desempatar") == 0) {
				pw.println("No se puede desempatar");
			}
		}
		if (vendedora_premiada.getVentasConsecutivas() > 0) {
			pw.println(vendedora_premiada.getId());
			pw.println(vendedora_premiada.getVentasConsecutivas() + " " + vendedora_premiada.getImporteVentas());
		}
		System.out.println("Archivo " + this.outputPath + " generado con exito!");
		pw.close();
	}
	
	private void ordenarVentas(int[] ventas) {
		int i, j, tmp;
		for (i = 0; i < ventas.length - 1; i++) {
			for (j = 0; j < ventas.length - 1; j++) {
				if (ventas[j] < ventas[j + 1]) {
					tmp = ventas[j + 1];
					ventas[j + 1] = ventas[j];
					ventas[j] = tmp;
				}
			}
		}

	}


}
