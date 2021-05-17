package domain;

//Classe abstrata, só serve para ser herdada
public abstract class Dinheiro {
	
	//Atributos
	private String label;
	private int quantity;
	
	
	//Construtores
	public Dinheiro() {
	}

	public Dinheiro(String label, int quantity) {
		super();
		this.label = label;
		this.quantity = quantity;
	}
	
	//Métodos de acesso (Gets & Sets)
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
