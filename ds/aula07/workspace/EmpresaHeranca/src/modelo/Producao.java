package modelo;

public class Producao extends Departamento {
	
	//Atributo
	private String nomeEncarregado;

	//M�todos GET e SET
	public String getNomeEncarregado() {
		return nomeEncarregado;
	}

	public void setNomeEncarregado(String nomeEncarregado) {
		this.nomeEncarregado = nomeEncarregado;
	}
	
	//Sobrescrita de m�todo, sobrescreve um m�todo com o mesmo nome em sua superclasse
	public String obterNomeDepto() {
		return "Produ��o";
	}
}
