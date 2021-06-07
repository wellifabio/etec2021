package controllers;

import java.util.ArrayList;

import models.INSS;
import models.Salario;

public class ProcessaTabelaINSS {
	

	private static ArrayList<INSS> tabINSS = new ArrayList<>();

	//Getters && Setters
	public static ArrayList<INSS> getTabINSS() {
		return tabINSS;
	}

	public static void setTabINSS(ArrayList<INSS> tabINSS) {
		ProcessaTabelaINSS.tabINSS = tabINSS;
	}

	//Preencher a tabela com dados padrão
	public static void preencherTabelaINSS() {
		ProcessaTabelaINSS.getTabINSS().add(new INSS(1100.01,0.075));
		ProcessaTabelaINSS.getTabINSS().add(new INSS(2203.49,0.09));
		ProcessaTabelaINSS.getTabINSS().add(new INSS(3305.23,0.12));
		ProcessaTabelaINSS.getTabINSS().add(new INSS(6433.57,0.14));
	}
	
	//Calculo
	public static double calculaINSS(Salario salario) {
		double calculo = 900.7;
		for(INSS i: ProcessaTabelaINSS.getTabINSS()) {
			if(salario.getSalario() < i.getContribuicao()) {
				calculo = salario.getSalario() * i.getAliquota();
				break;
			}
		}
		return calculo;
	}
	
}
