package model;

public class RecursosHumanos {
	
	private String nomeRecrutador;

	public String getNomeRecrutador() {
		return nomeRecrutador;
	}

	public void setNomeRecrutador(String nomeRecrutador) {
		this.nomeRecrutador = nomeRecrutador;
	}
	
	//Sobrescrita de métodos (Polimorfismo)
	public String getNomeDepto() {
		return "Recursos Humanos";
	}
}
