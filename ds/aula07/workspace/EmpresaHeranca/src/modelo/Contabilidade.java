package modelo;

public class Contabilidade extends Departamento{
	
	private String nomeContador;

	//GETs & SETs
	public String getNomeContador() {
		return nomeContador;
	}

	public void setNomeContador(String nomeContador) {
		this.nomeContador = nomeContador;
	}
	
	//Sobrescrita de m�todo, sobrescreve um m�todo com o mesmo nome em sua superclasse
	public String obterNomeDepto() {
		return "Contabilidade";
	}
	
}
