package controllers;

import java.util.ArrayList;
import models.Orcamento;

public class ProcessaOrcamentos {

	public static ArrayList<Orcamento> orcamentos = new ArrayList<>();

	public static Orcamento getMaisBarato() {
		Orcamento maisBarato = orcamentos.get(0);
		for (Orcamento orc : orcamentos) {
			if (orc.getPreco() < maisBarato.getPreco()) {
				maisBarato = orc;
			}
		}
		return maisBarato;
	}
}
