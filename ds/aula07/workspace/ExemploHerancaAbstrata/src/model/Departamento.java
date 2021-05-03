package model;

public abstract class Departamento {

	//Atributos
	private String codDepto;
	private String localidade;
	private String nomeGestor;
	
	//Construtores	
	public Departamento() {
	}
	public Departamento(String codDepto, String localidade, String nomeGestor) {

		this.codDepto = codDepto;
		this.localidade = localidade;
		this.nomeGestor = nomeGestor;
	}

	//GET & SET
	public String getCodDepto() {
		return codDepto;
	}
	public void setCodDepto(String codDepto) {
		this.codDepto = codDepto;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getNomeGestor() {
		return nomeGestor;
	}
	public void setNomeGestor(String nomeGestor) {
		this.nomeGestor = nomeGestor;
	}

	//Metodo para obter o nome do departamento por Sobrescrita
	public String getNomeDepto() {
		return null;
	}
	
}
