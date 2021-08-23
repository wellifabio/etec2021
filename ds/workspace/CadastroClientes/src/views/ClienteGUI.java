package views;

import controlers.ClienteProcess;
import models.Cliente;

public class ClienteGUI {

	public static void main(String[] args) {
		ClienteProcess.abrir();
		for(Cliente c: ClienteProcess.clientes) {
			System.out.print(c.toString());
		}
	}
}
