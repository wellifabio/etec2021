package poo2;

public class MainClass {

	public static void main(String[] args) {
		
		NotaFiscal nf; //Inst�ncia
		nf = new NotaFiscal(); //Objeto
		
		nf.setNumero(1);
		nf.setProduto("Sapato");
		nf.setValor(99.9);
		
		System.out.println("O n�mero da Nota Fical �  "+nf.getNumero());
		System.out.println("O produto da Nota Fical � "+nf.getProduto());
		System.out.println("O valor da Nota Fical � "+nf.getValor());
	}

}
