package views;

/*
 * Sistema que calcula em formato MVC
 * 
 * 
 * */

import java.util.Locale;
import java.util.Scanner;

import controllers.ProcessaSalarios;
import controllers.ProcessaTabelaINSS;
import models.INSS;
import models.Salario;

public class CRUDSalarios {

	public static Scanner leia = new Scanner(System.in);
	public static Salario salario;
	public static int menu;

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		ProcessaTabelaINSS.preencherTabelaINSS();
		menu = 0;

		while (menu != 5) {
			System.out.println("1.Cadastrar Salario;\n2.Listar Sal�rios\n3.Alterar\n4.Excluir\n5.Sair");
			menu = leia.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Matricula: Funcion�rio: Salario:");
				salario = new Salario();
				salario.setMatricula(leia.nextInt());
				salario.setFuncionario(leia.next());
				salario.setSalario(leia.nextDouble());
				ProcessaSalarios.getSalarios().add(salario);
				break;
			case 2:
				for(Salario s: ProcessaSalarios.getSalarios()) {
					System.out.println(s.toString());	
				}
				System.out.println("Sal.Cont.\tAl�quota");
				for(INSS i: ProcessaTabelaINSS.getTabINSS()) {
					System.out.print(i.getContribuicao()+"\t\t");
					System.out.println(i.getAliquota());
				}
				break;
			case 3:
				System.out.println("Digite a matr�cula:");
				salario = new Salario();
				salario.setMatricula(leia.nextInt());
				if(ProcessaSalarios.getSalarios().contains(salario)) {
					System.out.println(ProcessaSalarios.getSalarios().get(ProcessaSalarios.getSalarios().indexOf(salario)));
					System.out.println("Digite Funcion�rio: Salario:");
					salario.setFuncionario(leia.next());
					salario.setSalario(leia.nextDouble());
					ProcessaSalarios.getSalarios().set(ProcessaSalarios.getSalarios().indexOf(salario),salario);
				}else {
					System.out.println("Matr�cula n�o encontrada");
				}				
				break;
			case 4:
				System.out.println("Digite a matr�cula:");
				salario = new Salario();
				salario.setMatricula(leia.nextInt());
				if(ProcessaSalarios.getSalarios().contains(salario)) {
					System.out.println(ProcessaSalarios.getSalarios().get(ProcessaSalarios.getSalarios().indexOf(salario)));
					ProcessaSalarios.getSalarios().remove(ProcessaSalarios.getSalarios().indexOf(salario));
				}else {
					System.out.println("Matr�cula n�o encontrada");
				}
				break;
			case 5:
				System.out.println("Valews, Falows...");
				break;
			default:
				System.out.println("Op��o inv�lida");
				break;
			}
		}
	}

}
