package modelo;

public class Departamento {
	
	private String codDepto;
	private String localidade;
	private String nomeGestor;
	
	//Sobrecarga de Construtores
	public Departamento() {
	}

	public Departamento(boolean generico) {
		if(generico) {
			codDepto = "DE00";
			localidade = "Gen�rica";
			nomeGestor = "Gen�rico";
		}
	}
	
	public Departamento(String codDepto, String localidade, String nomeGestor) {
		this.codDepto = codDepto;
		this.localidade = localidade;
		this.nomeGestor = nomeGestor;
	}

	//GETs & SETs
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
	
	//M�todos que obtem e configura o nome do departamento
	//Sobrecarga de M�todos na mesma Classe
	public String obterNomeDepto() {
		return "Gen�rico";
	}
	
	public String obterNomeDepto(String nome) {
		return nome;
	}
}
