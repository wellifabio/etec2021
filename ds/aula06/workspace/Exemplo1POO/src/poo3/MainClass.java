package poo3;

public class MainClass {

	public static void main(String[] args) {
		Produto p1 = new Produto();
		Produto p2 = new Produto(true);
		Produto p3 = new Produto(false);

		System.out.println("id\t nome");
		System.out.println(p1.getId() + "\t" + p1.getNome());
		System.out.println(p2.getId() + "\t" + p2.getNome());
		System.out.println(p3.getId() + "\t" + p3.getNome());
	}
}
