package models;

import controllers.ProcessaTabelaINSS;

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

	public double getINSS() {
		return ProcessaTabelaINSS.calculaINSS(this);
	}

	public double getSalarioBase() {
		return salario - ProcessaTabelaINSS.calculaINSS(this);
	}

	@Override
	public String toString() {
		return matricula + "\t" + funcionario + "\t" + String.format("%.2f", salario)
				+ "\t" + String.format("%.2f", getINSS()) + "\t" + String.format("%.2f", getSalarioBase());
	}

}
