package string;

import java.util.Arrays;

public class Reverse {

	public static void main(String[] args) {
		String palavra = "Batmobile";
		char[] letras = palavra.toCharArray();
		System.out.println("Inicial: " + palavra);
		System.out.println("Reverse: " + inverter2(letras));
		System.out.println("**********************************");
		System.out.println("Inicial: " + Arrays.toString(letras));
		System.out.println("Reverse: " + Arrays.toString(inverter(letras)));
	}

	public static String inverter2(char[] letras) {
		String inverso = "";
		for (int i = letras.length - 1; i >= 0; i--) {
			inverso += letras[i];
		}
		return inverso;
	}

	public static char[] inverter(char[] letras) {
		int len = letras.length - 1;
		for (int i = 0; i < letras.length / 2; i++) {
			char primeira = letras[i];
			letras[i] = letras[len - i];
			letras[len - i] = primeira;
		}
		return letras;
	}

}
