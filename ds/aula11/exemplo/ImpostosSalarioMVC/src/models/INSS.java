package models;

public class INSS {

	private double contribuicao;
	private double aliquota;

	public INSS() {
	}

	public INSS(double contribuicao, double aliquota) {
		this.contribuicao = contribuicao;
		this.aliquota = aliquota;
	}

	public double getContribuicao() {
		return contribuicao;
	}

	public void setContribuicao(double contribuicao) {
		this.contribuicao = contribuicao;
	}

	public double getAliquota() {
		return aliquota;
	}

	public void setAliquota(double aliquota) {
		this.aliquota = aliquota;
	}

	@Override
	public String toString() {
		return "R$ "+contribuicao + "\t" + String.format("%.1f",(aliquota * 100)) + "%;";
	}
	
	

}
