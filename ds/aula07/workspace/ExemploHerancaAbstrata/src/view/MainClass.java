package view;

import model.Contabilidade;

public class MainClass {

	static Contabilidade cont;
	
	public static void main(String[] args) {

		cont = new Contabilidade(); //Obter um objeto com Construtor Vazio
		cont.showContabilidade(); //Método que mostra os dados
		//É necessário configurar os campos através dos métodos SETs
		cont.setCodDepto("CONT01");
		cont.setLocalidade("1º Andar");
		cont.setNomeGestor("Márcio");
		cont.setNomeContador("Murilo");
		cont.showContabilidade(); //Mostrar novamente
		
		cont = new Contabilidade("Marcelino");
		cont.showContabilidade();
		
		cont = new Contabilidade("CONT02","2º ANdar","Otávio");
		cont.showContabilidade();
		
		cont = new Contabilidade("CONT02","2º ANdar","Otávio","Bernardo");
		cont.showContabilidade();
		
	}

}
