package model;

public class Procucao {
	private String nomeEncarregado;

	public String getNomeEncarregado() {
		return nomeEncarregado;
	}

	public void setNomeEncarregado(String nomeEncarregado) {
		this.nomeEncarregado = nomeEncarregado;
	}
	
	//Sobrescrita de m�todos (Polimorfismo)
	public String getNomeDepto() {
		return "Procu��o";
	}
}
