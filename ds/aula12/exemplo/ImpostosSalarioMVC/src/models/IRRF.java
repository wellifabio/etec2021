package models;

import controllers.ProcessaTabelaIRRF;

/*
 * Imposto de Renda Retido na Fonte (IRRF)
 * 
 * */

public class IRRF {

	private double salarioBase;
	private double aliquota;
	private double deduzir;

	public IRRF() {
	}

	public IRRF(double salarioBase, double aliquota, double deduzir) {
		this.salarioBase = salarioBase;
		this.aliquota = aliquota;
		this.deduzir = deduzir;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getAliquota() {
		return aliquota;
	}

	public void setAliquota(double aliquota) {
		this.aliquota = aliquota;
	}

	public double getDeduzir() {
		return deduzir;
	}

	public void setDeduzir(double deduzir) {
		this.deduzir = deduzir;
	}

	@Override
	public String toString() {
		if (aliquota < ProcessaTabelaIRRF.getAliquota(salarioBase))
			return "menor do que R$" + salarioBase + "\t" + String.format("%.1f", (aliquota * 100)) + "%\tR$" + deduzir;
		else
			return "igual ou maior que R$" + ProcessaTabelaIRRF.getIrrfs().get(ProcessaTabelaIRRF.getIrrfs().size()-2).getSalarioBase() + "\t" + String.format("%.1f", (aliquota * 100)) + "%\tR$" + deduzir;
	}

}
