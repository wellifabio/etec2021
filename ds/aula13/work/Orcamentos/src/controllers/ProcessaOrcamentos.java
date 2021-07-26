package controllers;

import models.Orcamento;
import java.util.ArrayList;

public class ProcessaOrcamentos {
	public static ArrayList<Orcamento> orcamentos = new ArrayList<>();
	
	public static double getMaisBarato() {
		double x = 0.0;
		int index = 0;
		
		for (Orcamento c : orcamentos) {
			if (index != 0) {
				if (Double.valueOf(c.getPreco()) < Double.valueOf(x)) {
					x = Double.valueOf(c.getPreco());
				}
			}else {
				x = Double.valueOf(c.getPreco());
			}
			index++;
		}
				
		return (double) x;
	}
}