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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(contribuicao);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		INSS other = (INSS) obj;
		if (Double.doubleToLongBits(contribuicao) != Double.doubleToLongBits(other.contribuicao))
			return false;
		return true;
	}

}
