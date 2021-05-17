package domain;

//Classe herdando a super classe Dinheiro
public class Cedula extends Dinheiro {

	//Atribuito
	private int valor;
	
	//Construtores
	public Cedula() {
	}
	
	public Cedula(String label, int quantity, int valor) {
		super(label, quantity);
		this.valor = valor;
	}

	//Gets & Sets
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
}
