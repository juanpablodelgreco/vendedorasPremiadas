package vendedorasPremiadas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LeerEscribirArchivo {

	public static int LeerCantidad(String path) throws FileNotFoundException {
		int cantVendedoras = 0;
		Scanner sc = new Scanner(new File(path));
		cantVendedoras = sc.nextInt();
		sc.close();
		return cantVendedoras;
	}

	public static int Leer(String path, Vendedora[] vendedoras, int _cantidadVendedoras) throws FileNotFoundException {
		int cantVendedoras = _cantidadVendedoras, busquedasConsecutivas = 0;
		Scanner sc = new Scanner(new File(path));
		int[] ventas;
		sc.nextInt();
		for (int i = 0; i < cantVendedoras; i++) {
			Vendedora v = new Vendedora();
			v.setId(i + 1);
			v.setVentasConsecutivas(sc.nextInt());
			ventas = new int[v.getVentasConsecutivas()];
			for (int j = 0; j < v.getVentasConsecutivas(); j++) {
				ventas[j] = sc.nextInt();
			}
			ordenarVentas(ventas);
			v.setVentas(ventas);
			vendedoras[i] = v;

		}
		busquedasConsecutivas = sc.nextInt();
		sc.close();
		return busquedasConsecutivas;
	}

	private static void ordenarVentas(int[] ventas) {
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

	public static void Escribir(String path, Vendedora vendedora_premiada, String desempate)
			throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(path));
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
		System.out.println("Archivo " + path + " generado con exito!");
		pw.close();
	}

	public static void casoFatiga() throws FileNotFoundException {
		String path = "casos_de_prueba/Input/7.in";
		PrintWriter pw = new PrintWriter(new File(path));
		pw.println(3);
		pw.println(1000);
		for (int i = 1; i <= 1000; i++) {
			pw.println(i + 500);
		}
		pw.println(100);
		for (int i = 1; i <= 100; i++) {
			pw.println(i + 500);
		}
		pw.println(500);
		for (int i = 1; i <= 500; i++) {
			pw.println(i + 9000);
		}
		pw.println(100);
		pw.close();
		System.out.println("Caso de fatiga " + path + " generado con exito!");
	}

	public static void main(String[] args) throws FileNotFoundException {
		casoFatiga();
	}
}
