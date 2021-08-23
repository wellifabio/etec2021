package controlers;

import java.util.ArrayList;

import models.Cliente;
import models.dao.ClienteDAO;

public class ClienteProcess {

	public static ArrayList<Cliente> clientes;
	public static ClienteDAO cd = new ClienteDAO();
	
	public static void abrir() {
		clientes = cd.abrir();
	}
	
	public static void salvar() {
		cd.salvar(clientes);
	}
	
	public static void gerarTestes(int n) {
		clientes = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			clientes.add(new Cliente());
		}
	}

}
