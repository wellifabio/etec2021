package view;

import model.Contabilidade;

public class MainClass {

	static Contabilidade cont;
	
	public static void main(String[] args) {

		cont = new Contabilidade(); //Obter um objeto com Construtor Vazio
		cont.showContabilidade(); //M�todo que mostra os dados
		//� necess�rio configurar os campos atrav�s dos m�todos SETs
		cont.setCodDepto("CONT01");
		cont.setLocalidade("1� Andar");
		cont.setNomeGestor("M�rcio");
		cont.setNomeContador("Murilo");
		cont.showContabilidade(); //Mostrar novamente
		
		cont = new Contabilidade("Marcelino");
		cont.showContabilidade();
		
		cont = new Contabilidade("CONT02","2� ANdar","Ot�vio");
		cont.showContabilidade();
		
		cont = new Contabilidade("CONT02","2� ANdar","Ot�vio","Bernardo");
		cont.showContabilidade();
		
	}

}
