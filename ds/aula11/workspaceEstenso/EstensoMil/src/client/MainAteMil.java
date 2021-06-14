package client;

/*
 * Escrever N�meros por estenso inteiros at� 1000
 * */

import javax.swing.JOptionPane;

import process.EstensoAteMil;

public class MainAteMil {

	private static EstensoAteMil num;
	private static String entrada;
	private static String saida;

	public static void main(String[] args) {
		num = new EstensoAteMil();
		int val = 0;
		while (val >= 0 && val <= 1000) {
			entrada = JOptionPane
					.showInputDialog("Digite um inteiro entre 0 e 1000 para escrev�lo ou maior que 1000 para sair:");
			try {
				val = Integer.parseInt(entrada);
			} catch (Exception e) {
				val = 1001;
			}
			saida = num.getValor(val);
			saida = saida.substring(0, 1).toUpperCase().concat(saida.substring(1));
			System.out.println(val + ", " + saida);
		}

	}

}
