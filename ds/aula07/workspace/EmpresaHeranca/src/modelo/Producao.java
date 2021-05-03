package modelo;

public class Producao extends Departamento {
	
	//Atributo
	private String nomeEncarregado;

	//Métodos GET e SET
	public String getNomeEncarregado() {
		return nomeEncarregado;
	}

	public void setNomeEncarregado(String nomeEncarregado) {
		this.nomeEncarregado = nomeEncarregado;
	}
	
	//Sobrescrita de método, sobrescreve um método com o mesmo nome em sua superclasse
	public String obterNomeDepto() {
		return "Produção";
	}
}
