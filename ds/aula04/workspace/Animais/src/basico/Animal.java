package basico;

public class Animal {

	//Atributos
	String especie;
	String raca;
	String nome;
	float peso;
	
	//Construtor simples
	public Animal() {
		especie = "Gato";
		nome = "Mimi";
		raca = "Angor�";
		peso = (float) 1.2;
	}
	
	//Construtor com par�metros, personalizar
	public Animal(String esp, String nom, String rac, float pes) {
		especie = esp;
		nome = nom;
		raca = rac;
		peso = pes;
	}
	
	//Construtor com par�metros, personalizar
	public Animal(String nom) {
		nome = nom;
	}	
	
	public Animal(String nome, float peso) {
		this.nome = nome;
		this.peso = peso;
	}

	//Metodo que obtem todos os par�metros
	public String show(String orientacao) {
		if(orientacao == "vertical") {
			return especie+"\n"+raca+"\n"+nome+"\n"+peso;	
		}else {
			return especie+"\t"+raca+"\t"+nome+"\t"+peso;
		}	
	}
	
	//Metodo que obtem todos os par�metros
	public String show() {
		return especie+"\t"+raca+"\t"+nome+"\t"+peso;
	}
	
}
