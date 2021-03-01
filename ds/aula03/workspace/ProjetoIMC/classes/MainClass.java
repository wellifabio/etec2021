package classes;
import java.util.Scanner;

class MainClass{
	
	static Scanner read = new Scanner(System.in);
	
	public static void main(String[] args){
		System.out.println("Digite os campos abaixo separados por espaço:");
		System.out.println("id\tnome\tpeso\taltura");
		String pessoa = read.nextLine(); //Entrada de dados em uma linha apenas
		
		String[] dados = pessoa.split(" ");
		
		Pessoa p = new Pessoa();
		p.id = Integer.parseInt(dados[0]);
		p.nome = dados[1];
		p.peso = Float.parseFloat(dados[2]);
		p.altura = Float.parseFloat(dados[3]);
		
		System.out.println(p.calcularIMC());
	}
}