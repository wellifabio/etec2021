/*Exemplo de Classe e SubClasse*/

//Classe principal "Inicial maiúscula"
class Agua {
	
	//Método comum com nome composto (static para que possa ser utilizado sem a necessidade de instância)
	public static String aguaMole(){
		return "Agua mole";
	}
	
	//Método principal executavel "main"
	public static void main(String args[]) {
		Dura dura = new Dura(); //Instância da classe Dura. Objeto "dura"
		System.out.println(aguaMole()); //Exibe e executa o método
		System.out.println(dura.dura()); //Exibe e executa o objeto dura e método .dura()
	}
	
	//Sub Classe, Classe dentro da classe principal
	class Dura {
		public String dura(){
			return "Agua dura";
		}
	}
}

//Podemos ter mais de uma classe paralela em um mesmo arquivo,
//mas não é uma boa prática
