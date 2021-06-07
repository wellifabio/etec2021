package controllers;

import java.util.ArrayList;

import models.IRRF;

public class ProcessaTabelaIRRF {
	
	private static ArrayList<IRRF> irrfs = new ArrayList<>();

	public static ArrayList<IRRF> getIrrfs() {
		return irrfs;
	}

	public static void setIrrfs(ArrayList<IRRF> irrfs) {
		ProcessaTabelaIRRF.irrfs = irrfs;
	}
	
	public static void preencherTabelaIRRF() {
		irrfs.add(new IRRF(1903.99,0,0));
		irrfs.add(new IRRF(2826.66,0.075,142.8));
		irrfs.add(new IRRF(3751.06,0.15,354.8));
		irrfs.add(new IRRF(4664.68,0.225,636.13));
		irrfs.add(new IRRF(999999,0.275,869.36));
	}
	
	public static double getAliquota(double salario) {
		double result = 0;
		for(IRRF i:irrfs) {
			if(salario < i.getSalarioBase()) {
				result = i.getAliquota() * 100;
				break;
			}
		}
		return result;
	}
	
	public static double getDeduzir(double salario) {
		double result = 0;
		for(IRRF i:irrfs) {
			if(salario < i.getSalarioBase()) {
				result = i.getDeduzir();
				break;
			}
		}
		return result;
	}
	
	public static double calculaIRRF(double salario) {
		double result = 0;
		for(IRRF i:irrfs) {
			if(salario < i.getSalarioBase()) {
				result = salario * i.getAliquota() - i.getDeduzir();
				break;
			}
		}
		return result;
	}
}
