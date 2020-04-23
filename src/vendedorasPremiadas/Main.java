package vendedorasPremiadas;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		try {
			Competencia c = new Competencia();
			c.Competir("8");
		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo");
		}
	}
}
