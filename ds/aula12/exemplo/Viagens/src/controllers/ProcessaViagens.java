package controllers;

import java.util.ArrayList;

import models.Viagem;

public class ProcessaViagens {
	
	public static ArrayList<Viagem> viagens = new ArrayList<>();
	
	public static double getTotalTempos() {
		double tot = 0;
		for(Viagem v: viagens) {
			tot += v.getTempo();
		}
		return tot;
	}
}
