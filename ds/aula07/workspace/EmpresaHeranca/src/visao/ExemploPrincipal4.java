package visao;

import modelo.Contabilidade;
import modelo.Departamento;
import modelo.Producao;

public class ExemploPrincipal4 {

	static Departamento depto;
	static Producao prod;
	static Contabilidade cont;
	
	public static void main(String[] args) {

		depto = new Departamento();
		prod = new Producao();
		cont = new Contabilidade();
		
		System.out.println("Nome do departamento: "+depto.obterNomeDepto());
		System.out.println("Nome do departamento: "+prod.obterNomeDepto());
		System.out.println("Nome do departamento: "+cont.obterNomeDepto());
		
		System.out.println("Nome do departamento: "+depto.obterNomeDepto("Geral"));
		System.out.println("Nome do departamento: "+prod.obterNomeDepto("Prod"));
		System.out.println("Nome do departamento: "+cont.obterNomeDepto("Cont"));

	}

}
