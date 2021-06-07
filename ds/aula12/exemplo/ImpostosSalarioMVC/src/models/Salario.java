package models;

import controllers.ProcessaTabelaINSS;
import controllers.ProcessaTabelaIRRF;

public class Salario {

	private int matricula;
	private String funcionario;
	private double salario;

	// Construtores
	public Salario() {
	}

	public Salario(int matricula, String funcionario, double salario) {
		this.matricula = matricula;
		this.funcionario = funcionario;
		this.salario = salario;
	}

	// Getters && Setters
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	// HashCode && Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricula;
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
		Salario other = (Salario) obj;
		if (matricula != other.matricula)
			return false;
		return true;
	}

	public String getAliquotaINSS() {
		String aliquota = "Teto";
		if (ProcessaTabelaINSS.getAliquota(salario) != 0) {
			aliquota = String.format("%.1f", ProcessaTabelaINSS.getAliquota(salario)) + "%";
		}
		return aliquota;
	}

	public double getINSS() {
		return ProcessaTabelaINSS.calculaINSS(salario);
	}

	public double getSalarioBase() {
		return salario - getINSS();
	}

	public String getAliquotaIRRF() {
		return String.format("%.1f", ProcessaTabelaIRRF.getAliquota(getSalarioBase())) + "%";
	}

	public double getIRRFDeduzir() {
		return ProcessaTabelaIRRF.getDeduzir(getSalarioBase());
	}

	public double getIRRF() {
		return ProcessaTabelaIRRF.calculaIRRF(getSalarioBase());
	}

	public double getSalarioLiquido() {
		return getSalarioBase() - getIRRF();
	}

	@Override
	public String toString() {
		return matricula + "\t" + funcionario + "\t" + String.format("%.2f", salario) + "\t" + getAliquotaINSS() + "\t"
				+ String.format("%.2f", getINSS()) + "\t" + String.format("%.2f", getSalarioBase()) + "\t"
				+ getAliquotaIRRF() + "\t" + String.format("%.2f", getIRRF()) + "\t" + getIRRFDeduzir() + "\t"
				+ String.format("%.2f", getSalarioLiquido());
	}

}
