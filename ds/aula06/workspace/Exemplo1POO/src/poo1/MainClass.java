package poo1;

import java.util.Date;

public class MainClass {

	public static void main(String[] args) {
		
		NotaFiscal nf; //Inst�ncia
		Date data; //Inst�ncia
		
		data = new Date(); //Objeto
		nf = new NotaFiscal(false); //Objeto
		//nf.numero = 1;
		//nf.produto = "Sapato";
		
		System.out.println("Hoje � "+data);
		System.out.println("A Nota Fical � de um "+nf.produto);

	}

}
