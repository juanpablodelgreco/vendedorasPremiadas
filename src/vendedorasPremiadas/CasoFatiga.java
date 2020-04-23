package vendedorasPremiadas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CasoFatiga {

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
