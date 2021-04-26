package poo2;

//Classe encapsulada
//Classe � um tipo
public class NotaFiscal {
	
	private int numero; //atributo
	private String produto; //atributo inst�ncia
	private double valor; //atributo
	
	//M�todos de acesso GETs e SETs (Encapsulamento)
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
