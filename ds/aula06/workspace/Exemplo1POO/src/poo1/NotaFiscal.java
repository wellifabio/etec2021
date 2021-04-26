package poo1;

//Classe não encapsulada
//Classe é um tipo
public class NotaFiscal {
	
	int numero; //atributo
	String produto; //atributo instância
	double valor; //atributo
	
	//Método Construtor vazio
	NotaFiscal(){
	}
	
	//Método Construtor com dois estados V ou F
	NotaFiscal(boolean inicio){
		if (inicio) {
			this.numero = 1;
			this.produto = "Sapato";
			this.valor = 99.9;
		} else {
			this.numero = 0;
			this.produto = "Genérico";
			this.valor = 0;
		}
	}
	
	/*
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
	*/
	
}
