package model;

public class Contabilidade extends Departamento{

	//Atributos
	private String nomeContador;
	
	//Construtores (Sobrecarga de construtores)Polimorfismo
	public Contabilidade() {
	}
	public Contabilidade(String nomeContador) {
		this.nomeContador = nomeContador;
	}
	public Contabilidade(String codDepto, String localidade, String nomeGestor) {
		super(codDepto, localidade, nomeGestor);
	}
	public Contabilidade(String codDepto, String localidade, String nomeGestor,String nomeContador) {
		super(codDepto, localidade, nomeGestor);
		this.nomeContador = nomeContador;
	}
	
	//Métodos GETs & SETs
	public String getNomeContador() {
		return nomeContador;
	}

	public void setNomeContador(String nomeContador) {
		this.nomeContador = nomeContador;
	}
	
	//Sobrescrita de métodos (Polimorfismo)
	public String getNomeDepto() {
		return "Contabilidade";
	}
	
	public void showContabilidade() {
		System.out.println("Nome departamento: "+getNomeDepto());
		System.out.println("Código departamento: "+getCodDepto());
		System.out.println("Localidade: "+getLocalidade());
		System.out.println("Nome Gestor: "+getNomeGestor());
		System.out.println("Nome Contador: "+getNomeContador()+"\n");
	}
}
