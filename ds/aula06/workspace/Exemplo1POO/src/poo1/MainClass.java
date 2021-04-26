package poo1;

import java.util.Date;

public class MainClass {

	public static void main(String[] args) {
		
		NotaFiscal nf; //Instância
		Date data; //Instância
		
		data = new Date(); //Objeto
		nf = new NotaFiscal(false); //Objeto
		//nf.numero = 1;
		//nf.produto = "Sapato";
		
		System.out.println("Hoje é "+data);
		System.out.println("A Nota Fical é de um "+nf.produto);

	}

}
