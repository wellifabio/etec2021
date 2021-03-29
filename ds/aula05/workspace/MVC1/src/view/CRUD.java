package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Animal;

//Cadastro, consulta, alteração e exclusão
public class CRUD {

	static Scanner scan = new Scanner(System.in);
	static Animal animal;
	static ArrayList<Animal> animais = new ArrayList<Animal>();

	public static void main(String[] args) {

		// Cama menu básico
		int menu = 1;
		while (menu != 0) {
			System.out.println("1 Cadastrar animal\n2 Listar todos");
			System.out.println("3 Alterar animal\n4 Excluir\n0 Sair");
			menu = scan.nextInt();

			switch (menu) {
			case 1:
				//Create CRUD
				System.out.println("Id e Name:");
				animal = new Animal(); //Cria um objeto novo
				animal.setId(scan.nextInt()); //Configura id
				animal.setName(scan.next()); //Configura name
				animais.add(animal); //Adiciona o novo animal a lista
				break;
			case 2:
				//Read CRUD
				for(Animal a: animais) {
					System.out.println(a.getId()+"\t"+a.getName());
				}
				break;
			case 3:
				//Update CRUD
				System.out.println("Id e Name:");
				animal = new Animal(); //Cria um objeto novo
				animal.setId(scan.nextInt()); //Configura id
				animal.setName(scan.next()); //Configura name
				if(animais.contains(animal)) {
					animais.set(animais.indexOf(animal),animal); //Sobrescrever
				}
				break;
			case 4:
				//Delete CRUD
				System.out.println("Id:");
				animal = new Animal(); //Cria um objeto novo
				animal.setId(scan.nextInt()); //Configura id
				if(animais.contains(animal)) {
					animais.remove(animais.indexOf(animal)); //Excluir
				}				
				break;
			default:
				System.out.println("Bye");
				break;
			}

		}

	}

}
