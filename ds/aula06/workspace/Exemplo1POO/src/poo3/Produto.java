package poo3;

public class Produto {
	//Atributos
	private int id;
	private String nome;
	
	//Construtores
	Produto(){}
	Produto(boolean inicio){
		if(inicio) {
			this.id = 1;
			this.nome = "Blusa";
		}else {
			this.id = 0;
			this.nome = "Genérico";			
		}
	}
	
	//Métodos de acesso Get e Set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
