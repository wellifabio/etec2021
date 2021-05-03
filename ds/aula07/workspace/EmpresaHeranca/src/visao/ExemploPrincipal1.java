package visao;

import modelo.Departamento;

public class ExemploPrincipal1 {

	//Atributo
	static Departamento depto; //Inst�ncia da classe Departamento
	
	public static void main(String[] args) {

		depto = new Departamento(); //Construtor vazio
		depto.setCodDepto(""); //Em branco � diferente de null
		depto.setLocalidade(""); // Null � sem nenhum dado
		depto.setNomeGestor(""); //Em branco � alguma coisa
		System.out.println("Codigo do Departamento: "+depto.getCodDepto());
		System.out.println("Localidade do Departamento: "+depto.getLocalidade());
		System.out.println("Gestor do Departamento: "+depto.getNomeGestor()+"\n");

		depto = new Departamento(true); //Construtor Gen�rico
		System.out.println("Codigo do Departamento: "+depto.getCodDepto());
		System.out.println("Localidade do Departamento: "+depto.getLocalidade());
		System.out.println("Gestor do Departamento: "+depto.getNomeGestor()+"\n");

		depto = new Departamento("FI01","1� Andar","Joaquin"); //Construtor configurado
		System.out.println("Codigo do Departamento: "+depto.getCodDepto());
		System.out.println("Localidade do Departamento: "+depto.getLocalidade());
		System.out.println("Gestor do Departamento: "+depto.getNomeGestor()+"\n");
	}

}
