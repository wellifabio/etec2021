package visao;

import modelo.Contabilidade;

public class ExemploPrincipal2 {

	static Contabilidade cont;
	
	public static void main(String []args) {
		cont = new Contabilidade();
		cont.setNomeContador("Ant�nio");
		cont.setNomeGestor("Marcos");
		cont.setCodDepto("CT01");
		cont.setLocalidade("2� Andar");
		System.out.println("Nome do contador: "+cont.getNomeContador());
		System.out.println("Nome do gestor: "+cont.getNomeGestor());
		System.out.println("C�digo do Depto: "+cont.getCodDepto());
		System.out.println("Localidade: "+cont.getLocalidade());
	}
}
