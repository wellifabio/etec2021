package view;

import model.Ave;
import model.Mamifero;

public class MainClass {

	public static void main(String[] args) {
		
		Ave galinha = new Ave(1,"Jurema","Galinha",4000);
		Mamifero cachorro = new Mamifero(2, "Totó", "Cachorro", 6);
		
		System.out.println("Id\tNome\tEspécie\tPeculiaridade");
		galinha.showAtributes();
		cachorro.showAtributes();
		
		//Utilizando um método herdado
		System.out.println("O cachorro faz "+cachorro.emitirSom("Au, au, au."));
		
		//Utilizando os métodos herdados da interface
		galinha.comer("milho");
		galinha.evacuar(3);
		
	}

}
