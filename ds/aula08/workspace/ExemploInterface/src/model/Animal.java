package model;

public abstract class Animal {
	
	private int idAminal;
	private String nome;
	private String especie;
	
	//Contrutor vazio
	public Animal() {
	}

	//Construtor com todos os atributos
	public Animal(int idAminal, String nome, String especie) {
		this.idAminal = idAminal;
		this.nome = nome;
		this.especie = especie;
	}
	
	//GETs && SETs
	public int getIdAminal() {
		return idAminal;
	}
	public void setIdAminal(int idAminal) {
		this.idAminal = idAminal;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}

	//Metodo comum
	public String emitirSom(String som){
		return som;
	}
	
	public void showAtributes() {
		System.out.print(idAminal +"\t"+nome+"\t"+especie);
	}
}
