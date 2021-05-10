package model;

public class Ave extends Animal implements Comportamento{
	
	private int numPenas;

	public Ave() {
	}

	public Ave(int idAminal, String nome, String especie, int numPenas) {
		super(idAminal, nome, especie);
		this.numPenas = numPenas;
	}

	public int getNumPenas() {
		return numPenas;
	}

	public void setNumPenas(int numPenas) {
		this.numPenas = numPenas;
	}
	
	public void showAtributes() {
		System.out.print(super.getIdAminal() +"\t"+super.getNome()+"\t"+super.getEspecie()+"\tpenas:"+numPenas+"\n");
	}

	@Override
	public void comer(String comida) {
		System.out.println("Estou comendo "+comida+".");
		
	}

	@Override
	public void evacuar(int vezes) {
		System.out.println("Estou me vingando de vocês humanos "+(n+vezes)+" vezes.");
	}

}
