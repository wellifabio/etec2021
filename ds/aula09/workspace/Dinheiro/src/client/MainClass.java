/*
 * Criar um programa que receba como entrada um valor.
E retorne como sa�da o menor n�mero de notas e ou moedas.
Exemplo:
Entrada
245.47
Sa�da
2 notas de cem reais
2 notas de vinte reais
1 nota de cinco reais
1 moeda de vinte e cinco centavos
2 moedas de dez centavos
2 moedas de 1 centavo

Pensamento computacional
Decompor, Encontrar padr�es, Abtrair e ou Algoritmo
 * 
 * */

package client;

import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import domain.Cedula;
import domain.Moeda;

public class MainClass {

	public static ArrayList<Cedula> cedulas;
	public static ArrayList<Moeda> coins;

	public static void main(String[] args) {

		Locale.setDefault(Locale.US); // Configurar as entradas no pad�o internacional.
		// Configurar as vari�veis ou Objetos
		cedulas = new ArrayList<>();// Iniciar a lista
		cedulas.add(new Cedula("Duzentos Reais R$ 200,00", 0, 200));
		cedulas.add(new Cedula("Cem Reais R$ 100,00", 0, 100));
		cedulas.add(new Cedula("Cinquenta Reais R$ 50,00", 0, 50));
		cedulas.add(new Cedula("Vinte Reais R$ 20,00", 0, 20));
		cedulas.add(new Cedula("Dez Reais R$ 10,00", 0, 10));
		cedulas.add(new Cedula("Cinco Reais R$ 5,00", 0, 5));
		cedulas.add(new Cedula("Dois Reais R$ 2,00", 0, 2));
		coins = new ArrayList<>();
		coins.add(new Moeda("Um Real R$ 1,00", 0, 100));
		coins.add(new Moeda("Cinquenta centavos R$ 0,50", 0, 50));
		coins.add(new Moeda("Vinte e cinco centavos R$ 0,25", 0, 25));
		coins.add(new Moeda("Dez centavos R$ 0,10", 0, 10));
		coins.add(new Moeda("Cinco centavos R$ 0,05", 0, 5));
		coins.add(new Moeda("Um centavo R$ 0,01", 0, 1));

		// Entrada, com uma caixa gr�fica
		String valor = JOptionPane.showInputDialog("Digite um valor monetario, utiliza ponto para centavos");

		// Converter a entrada de string para float
		float val = Float.parseFloat(valor);
		int notas = (int) val;
		int moedas = (int) ((val - (float) notas) * 100);

		// Sa�das provis�rias
		JOptionPane.showMessageDialog(null, "Em notas (c�dulas) temos: " + notas);
		JOptionPane.showMessageDialog(null, "Em moedas temos: " + moedas);

		// Processamento
		while (notas > 0) { // Enquanto tiver notas
			for (Cedula c : cedulas) {// Percorra todas as cedulas da lista [para cada c�dula]
				if (notas >= c.getValor()) {
					c.setQuantity(c.getQuantity() + 1);
					notas = notas - c.getValor();
				}
			}
			if(notas == 1) {
				coins.get(0).setQuantity(1);
				notas--;
			}
		}
		while (moedas > 0) { // Enquanto tiver notas
			for (Moeda c : coins) {// Percorra todas as cedulas da lista [para cada c�dula]
				if (moedas >= c.getValor()) {
					c.setQuantity(c.getQuantity() + 1);
					moedas = moedas - (int)c.getValor();
				}
			}
		}

		// Sa�das definitivas
		for (Cedula c : cedulas) {
			if (c.getQuantity() > 0)
				System.out.println(c.getQuantity() + " " + c.getLabel());
		}
		for (Moeda c : coins) {
			if (c.getQuantity() > 0)
				System.out.println(c.getQuantity() + " " + c.getLabel());
		}

	}

}
