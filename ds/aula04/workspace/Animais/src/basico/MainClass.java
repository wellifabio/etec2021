package basico;

public class MainClass {

	public static void main(String[] args) {
		
		Animal animal1 = new Animal("Cachorro","Vira Latas","Tot�",2);
		Animal animal2 = new Animal();
		Animal animal3 = new Animal("Tico");
		Animal animal4 = new Animal("Teco", (float)0.3);
			
		System.out.println(animal1.show());
		System.out.println(animal2.show());
		System.out.println(animal3.show("vertical"));
		System.out.println(animal4.show("vertical"));

	}

}
