package domain;

public class Moeda extends Dinheiro {
	
	//Atributos
	private float valor;

	//Construtores
	public Moeda() {
	}

	public Moeda(String label, int quantity, float valor) {
		super(label, quantity);
		this.valor = valor;
	}

	//Gets & Sets
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
}
