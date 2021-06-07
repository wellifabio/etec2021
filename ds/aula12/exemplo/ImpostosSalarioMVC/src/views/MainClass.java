package views;

import java.util.Locale;

import controllers.ProcessaSalarios;
import controllers.ProcessaTabelaINSS;
import controllers.ProcessaTabelaIRRF;
import models.Salario;


public class MainClass {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		//Inicia as tabelas INSS e IRRF
		ProcessaTabelaINSS.preencherTabelaINSS();
		ProcessaTabelaIRRF.preencherTabelaIRRF();
		//Inicia a lista de funcionários com alguns dados para teste
		ProcessaSalarios.getSalarios().add(new Salario(1, "Ana Maria",1000));
		ProcessaSalarios.getSalarios().add(new Salario(4, "Maria Ana",2000));
		ProcessaSalarios.getSalarios().add(new Salario(7, "João Maria",3000));
		ProcessaSalarios.getSalarios().add(new Salario(2, "Maria João",4000));
		ProcessaSalarios.getSalarios().add(new Salario(5, "José Maria",5000));
		ProcessaSalarios.getSalarios().add(new Salario(6, "Maria José",6000));
		ProcessaSalarios.getSalarios().add(new Salario(3, "Ana Silva",7000));
		ProcessaSalarios.getSalarios().add(new Salario(8, "Maria Silva",8000));
		
		FormSalarios fm = new FormSalarios();
		fm.setVisible(true);
		
	}

}
