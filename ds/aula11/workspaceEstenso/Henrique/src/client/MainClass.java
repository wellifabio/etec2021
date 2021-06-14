package client;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import domain.Unidades;

import domain.Dez;

import domain.Dezenas;

public class MainClass {

	public static ArrayList<Unidades> algUnidades;

	public static ArrayList<Dez> algDez;

	public static ArrayList<Dezenas> algDezenas;

	public static void main(String args[]) {

		algUnidades = new ArrayList<>();
		algUnidades.add(new Unidades("zero"));
		algUnidades.add(new Unidades("um"));
		algUnidades.add(new Unidades("dois"));
		algUnidades.add(new Unidades("três"));
		algUnidades.add(new Unidades("quatro"));
		algUnidades.add(new Unidades("cinco"));
		algUnidades.add(new Unidades("seis"));
		algUnidades.add(new Unidades("sete"));
		algUnidades.add(new Unidades("oito"));
		algUnidades.add(new Unidades("nove"));

		algDez = new ArrayList<>();
		algDez.add(new Dez("dez"));
		algDez.add(new Dez("onze"));
		algDez.add(new Dez("doze"));
		algDez.add(new Dez("treze"));
		algDez.add(new Dez("catorze"));
		algDez.add(new Dez("quinze"));
		algDez.add(new Dez("dezesseis"));
		algDez.add(new Dez("dezessete"));
		algDez.add(new Dez("dezoito"));
		algDez.add(new Dez("dezenove"));

		algDezenas = new ArrayList<>();
		algDezenas.add(new Dezenas(""));
		algDezenas.add(new Dezenas("dez"));
		algDezenas.add(new Dezenas("vinte"));
		algDezenas.add(new Dezenas("trinta"));
		algDezenas.add(new Dezenas("quarenta"));
		algDezenas.add(new Dezenas("cinquenta"));
		algDezenas.add(new Dezenas("sessenta"));
		algDezenas.add(new Dezenas("setenta"));
		algDezenas.add(new Dezenas("oitenta"));
		algDezenas.add(new Dezenas("noventa"));
		algDezenas.add(new Dezenas("cem"));

		int num;
		String resp = "";
		String valor = JOptionPane.showInputDialog("Digite um valor entre 0 e 100: ");
		float val = Float.parseFloat(valor);
		num = (int) val;
		char[] algarismos = valor.toCharArray();
		int i;
		if (algarismos.length == 3) {
			resp = "cem";
		} else if (algarismos.length == 1) {
			i = Character.getNumericValue(algarismos[0]);
			resp = algUnidades.get(i).getUnidades();
		} else if (algarismos.length == 2) {
			i = Character.getNumericValue(algarismos[1]);
			if (algarismos[0] == '0') {
				resp = algUnidades.get(i).getUnidades();
			} else if (algarismos[1] == '0') {
				i = Character.getNumericValue(algarismos[0]);
				resp = algDezenas.get(i).getDezenas();
			} else if (algarismos[0] == '1') {
				resp = algDez.get(i).getDez();
			} else
				// Utilizando a estrutura for para realizar a comparação dos primeiros dígitos
				for (int cont = 2; cont < 10; cont++) {
					String contString = Integer.toString(cont); // Transformando o contador em um string
					char[] contChar = contString.toCharArray(); // Transformando a string em char
					if (algarismos[0] == contChar[0]) {
						resp = algDezenas.get(cont).getDezenas() + " e " + algUnidades.get(i).getUnidades();
					}
				}
		}
		resp = resp.toUpperCase();
		if (num > 100 || num < 0) {
			System.out.println("O valor digitado não está entre 0 e 100");
		} else {
			System.out.println("O número digitado, escrito por extenso é: " + resp);
		}
	}
}
