package controller;
import java.util.ArrayList;

import models.Orçamento;

public class ProcessaOrçamentos {
public static ArrayList<Orçamento> orcamentos = new ArrayList<>();
	
	public static int getMaisBarato() {
		int mb = 0;
		for(Orçamento o: orcamentos) {
			if(mb == 0) {
				mb = o.getPreco();
			}
			if(mb >= o.getPreco()) {
				mb = o.getPreco();
			}
		}
		return mb;
	}

}
