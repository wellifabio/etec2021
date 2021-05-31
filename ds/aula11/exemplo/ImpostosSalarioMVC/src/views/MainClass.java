package views;

import java.util.Locale;

import controllers.ProcessaTabelaINSS;


public class MainClass {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		ProcessaTabelaINSS.preencherTabelaINSS();
		FormSalarios fm = new FormSalarios();
		fm.setVisible(true);
		
	}

}
