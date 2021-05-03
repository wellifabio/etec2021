package model;

public class Procucao {
	private String nomeEncarregado;

	public String getNomeEncarregado() {
		return nomeEncarregado;
	}

	public void setNomeEncarregado(String nomeEncarregado) {
		this.nomeEncarregado = nomeEncarregado;
	}
	
	//Sobrescrita de métodos (Polimorfismo)
	public String getNomeDepto() {
		return "Procução";
	}
}
