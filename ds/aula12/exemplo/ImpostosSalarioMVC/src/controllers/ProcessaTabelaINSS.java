package controllers;

import java.util.ArrayList;

import models.INSS;

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
		//Conforme tabela vigente em 2021
		ProcessaTabelaINSS.getTabINSS().add(new INSS(1100.01,0.075));
		ProcessaTabelaINSS.getTabINSS().add(new INSS(2203.49,0.09));
		ProcessaTabelaINSS.getTabINSS().add(new INSS(3305.23,0.12));
		ProcessaTabelaINSS.getTabINSS().add(new INSS(6433.57,0.14));
	}
	
	//Calculo
	public static double calculaINSS(double salario) {
		double calculo = tabINSS.get(tabINSS.size()-1).getContribuicao() * tabINSS.get(tabINSS.size()-1).getAliquota();
		for(INSS i: tabINSS) {
			if(salario < i.getContribuicao()) {
				calculo = salario * i.getAliquota();
				break;
			}
		}
		return calculo;
	}
	//Retorna Porcentagem
	public static double getAliquota(double salario) {
		double aliquota = 0;
		for(INSS i: tabINSS) {
			if(salario < i.getContribuicao()) {
				aliquota = i.getAliquota() * 100;
				break;
			}
		}
		return aliquota;
	}
	
}
