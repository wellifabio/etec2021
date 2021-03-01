package poo;

import java.util.Scanner;
import java.util.ArrayList;

class MainClass{
  
	//Atributos
  	static Scanner read = new Scanner(System.in);
  	static ArrayList<Item> itens = new ArrayList();

  	public static void main(String[] args) {
    
		Item item; //Instância da classe ítem vazia
		int menu = 0; //Controle para o menú
		
		while(menu == 0){
		item = new Item();//Objeto em branco da Classe ítem
		
		//Entrada de dados
		System.out.println("Digite o código do ítem:");
		item.id = read.nextInt();
		System.out.println("Digite o nome do ítem:");
		item.name = read.next();
		System.out.println("Digite a data de Aquisição:");
		item.acquisition = read.next();
		System.out.println("Digite o preço do ítem:");
		item.price = read.nextFloat();

		//Adicionar o ítem a list de ítens
		itens.add(item);

		System.out.println("Continuar adicionando ítens? digite 0 para sim ou qualquer outro número inteiro para não.");
		menu = read.nextInt();
		}

		//Saída de dados
		System.out.println("Id\tName\tData de Aquisição\tPrice");
		for(int i = 0; i < itens.size(); i++){
		System.out.println(itens.get(i).id +"\t"+ itens.get(i).name +"\t"+ itens.get(i).acquisition  +"\t"+ itens.get(i).getPriceReais());
		}
	}
}