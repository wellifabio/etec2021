package controllers;

import java.util.ArrayList;

import models.Salario;

public class ProcessaSalarios {

	private static ArrayList<Salario> salarios = new ArrayList<>();

	public static ArrayList<Salario> getSalarios() {
		return salarios;
	}

	public static void setSalarios(ArrayList<Salario> salarios) {
		ProcessaSalarios.salarios = salarios;
	}

}
