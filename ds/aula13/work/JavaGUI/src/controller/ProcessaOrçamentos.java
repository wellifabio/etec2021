package controller;
import java.util.ArrayList;

import models.Or�amento;

public class ProcessaOr�amentos {
public static ArrayList<Or�amento> orcamentos = new ArrayList<>();
	
	public static int getMaisBarato() {
		int mb = 0;
		for(Or�amento o: orcamentos) {
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
