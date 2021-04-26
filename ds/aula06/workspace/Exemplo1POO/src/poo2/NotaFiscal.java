package poo2;

//Classe encapsulada
//Classe é um tipo
public class NotaFiscal {
	
	private int numero; //atributo
	private String produto; //atributo instância
	private double valor; //atributo
	
	//Métodos de acesso GETs e SETs (Encapsulamento)
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
