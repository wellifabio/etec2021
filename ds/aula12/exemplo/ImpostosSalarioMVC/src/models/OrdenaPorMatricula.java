package models;

import java.util.Comparator;

public class OrdenaPorMatricula implements Comparator<Salario>{

	@Override
	public int compare(Salario a, Salario b) {
		return a.getMatricula() - b.getMatricula();
	}

}
