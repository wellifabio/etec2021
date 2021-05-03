package visao;

import modelo.Departamento;

public class ExemploPrincipal1 {

	//Atributo
	static Departamento depto; //Instância da classe Departamento
	
	public static void main(String[] args) {

		depto = new Departamento(); //Construtor vazio
		depto.setCodDepto(""); //Em branco é diferente de null
		depto.setLocalidade(""); // Null é sem nenhum dado
		depto.setNomeGestor(""); //Em branco é alguma coisa
		System.out.println("Codigo do Departamento: "+depto.getCodDepto());
		System.out.println("Localidade do Departamento: "+depto.getLocalidade());
		System.out.println("Gestor do Departamento: "+depto.getNomeGestor()+"\n");

		depto = new Departamento(true); //Construtor Genérico
		System.out.println("Codigo do Departamento: "+depto.getCodDepto());
		System.out.println("Localidade do Departamento: "+depto.getLocalidade());
		System.out.println("Gestor do Departamento: "+depto.getNomeGestor()+"\n");

		depto = new Departamento("FI01","1º Andar","Joaquin"); //Construtor configurado
		System.out.println("Codigo do Departamento: "+depto.getCodDepto());
		System.out.println("Localidade do Departamento: "+depto.getLocalidade());
		System.out.println("Gestor do Departamento: "+depto.getNomeGestor()+"\n");
	}

}
