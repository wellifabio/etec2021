package process;

import java.util.ArrayList;

import domain.Valor;

public class EstensoAteMil {

	// Lista de valores
	private ArrayList<Valor> valores = new ArrayList<>();

	// M�todo construtor que preenche a lista com os valores (num e estenso)
	public EstensoAteMil() {
		this.valores.add(new Valor(0, "zero"));
		this.valores.add(new Valor(1, "um"));
		this.valores.add(new Valor(2, "dois"));
		this.valores.add(new Valor(3, "tr�s"));
		this.valores.add(new Valor(4, "quatro"));
		this.valores.add(new Valor(5, "cinco"));
		this.valores.add(new Valor(6, "seis"));
		this.valores.add(new Valor(7, "sete"));
		this.valores.add(new Valor(8, "oito"));
		this.valores.add(new Valor(9, "nove"));
		this.valores.add(new Valor(10, "dez"));
		this.valores.add(new Valor(11, "onze"));
		this.valores.add(new Valor(12, "doze"));
		this.valores.add(new Valor(13, "treze"));
		this.valores.add(new Valor(14, "quatorze"));
		this.valores.add(new Valor(15, "quinze"));
		this.valores.add(new Valor(16, "dezesseis"));
		this.valores.add(new Valor(17, "dezessete"));
		this.valores.add(new Valor(18, "dezoito"));
		this.valores.add(new Valor(19, "dezenove"));
		this.valores.add(new Valor(20, "vinte"));
		this.valores.add(new Valor(30, "trinta"));
		this.valores.add(new Valor(40, "quarenta"));
		this.valores.add(new Valor(50, "cinquenta"));
		this.valores.add(new Valor(60, "sessenta"));
		this.valores.add(new Valor(70, "setenta"));
		this.valores.add(new Valor(80, "oitenta"));
		this.valores.add(new Valor(90, "noventa"));
		this.valores.add(new Valor(100, "cem"));
		this.valores.add(new Valor(200, "duzentos"));
		this.valores.add(new Valor(300, "trezentos"));
		this.valores.add(new Valor(400, "quatrocentos"));
		this.valores.add(new Valor(500, "quinhentos"));
		this.valores.add(new Valor(600, "seiscentos"));
		this.valores.add(new Valor(700, "setecentos"));
		this.valores.add(new Valor(800, "oitocentos"));
		this.valores.add(new Valor(900, "novecentos"));
		this.valores.add(new Valor(1000, "mil"));
	}

	// M�todos GETs && SETs
	public ArrayList<Valor> getValores() {
		return valores;
	}

	public void setValores(ArrayList<Valor> valores) {
		this.valores = valores;
	}

	// M�todo que escreve por estenso o valor recebido no par�metro num
	public String getValor(int num) {
		if (valores.contains(new Valor(num, null))) { // Se o n�mero estiver na lista retorna seu atributo estenso
			return valores.get(valores.indexOf(new Valor(num, null))).getEstenso();
		} else if (num >= 0 && num <= 100) { // Sen�o, se est� entre 0 e 1000
			int unidade = num % 10; // Obtem a unidade pegando o resto da divis�o por 10
			int dezena = num - unidade; // Obtem a dezena subtraindo a unidade do n�mero
			return getValor(dezena) + " e " + getValor(unidade); // Recursividade (chamar o pr�prio m�todo dentro dele)
		} else if (num > 100 && num <= 1000) {
			int dezena = num % 100;
			int centena = num - dezena;
			if (centena < 200)
				return "cento e " + getValor(dezena);
			else
				return getValor(centena) + " e " + getValor(dezena);
		} else {
			return new Valor(-1, "numero inv�lido").getEstenso(); // Sen�o � porque n�o est� entre 0 e 100
		}
	}
}
