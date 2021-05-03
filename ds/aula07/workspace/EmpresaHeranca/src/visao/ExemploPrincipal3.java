package visao;

import modelo.Contabilidade;
import modelo.Producao;

public class ExemploPrincipal3 {

	static Producao prod; //Instância e Atributo
	static Contabilidade cont;
	
	public static void main(String[] args) {
		
		prod = new Producao();
		cont = new Contabilidade();
		System.out.println(prod.obterNomeDepto());
		System.out.println(prod.obterNomeDepto("Produção"));
		System.out.println(cont.obterNomeDepto());
		System.out.println(cont.obterNomeDepto("Contabilidade"));

	}

}
