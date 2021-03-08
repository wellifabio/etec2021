package basico;

import java.util.ArrayList;
import java.util.Scanner;

public class MainList {

	static ArrayList<Animal> animais;//Atributo, instância da classe Animais tipo Lista
	static Scanner leia;//Atributo, instância da classe Scanner
	static Animal animal;//Atributo da classe Animal, para ler um animal por vez
	
	public static void main(String[] args) {		 
		leia = new Scanner(System.in); //Objeto da classe Scanner para leitura a partir do teclado
		animais = new ArrayList<>(); //Objeto da lista de animais
		int controle = 0; //Controle para repetir a leitura e parar caso digite outro número
		String leitura = "";//String vazia para leitura de uma linha inteira
		//Procedimento para a leitura da lista de animais em forma de tabela
		System.out.println("Especie\tRaça\tNome\tPeso\tcontrole"); //Cabeçalho
		while(controle == 0) {//Laço para cada linha da tabela se digitar 0 no controle continua senão termina.
			leitura = leia.nextLine(); //le a linha digitada em uma string
			String[] vetor = leitura.split(","); //Esplode a string separando por vírgulas em um vetor de 0 a 4 
			animal = new Animal(); //Cria um novo objeto animal
			animal.especie = vetor[0]; //Atribui a posição 0 do vetor para o atributo "espécie" de Animal 
			animal.raca = vetor[1];
			animal.nome = vetor[2];
			animal.peso = Float.parseFloat(vetor[3]); //Converte de string para float
			animais.add(animal); //Adiciona o animal preecnhido à lista de animais			
			controle = Integer.parseInt(vetor[4]); //0 para continuar e qualquer número para sair
		}	
		for(int i = 0; i < animais.size(); i++) { //Laço que percorrer e exibir a lista
			System.out.println(animais.get(i).show());
		}	
	}
}
