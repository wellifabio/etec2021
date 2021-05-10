package model;

public class Mamifero extends Animal {

	private int numMamilos;

	public Mamifero() {
	}

	public Mamifero(int idAminal, String nome, String especie, int numMamilos) {
		super(idAminal, nome, especie);
		this.numMamilos = numMamilos;
	}

	public int getNumMamilos() {
		return numMamilos;
	}

	public void setNumMamilos(int numMamilos) {
		this.numMamilos = numMamilos;
	}
	
	public void showAtributes() {
		System.out.print(super.getIdAminal() +"\t"+super.getNome()+"\t"+super.getEspecie()+"\tmamilos:"+numMamilos+"\n");
	}
	
}
