package models.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.Cliente;

public class ClienteDAO {

	private BufferedWriter bw;
	private BufferedReader br;
	private String patch = "./db/clientes.csv";
	
	public ArrayList<Cliente> abrir(){
		ArrayList<Cliente> clientes = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(patch));
			String linha = "";
			while((linha = br.readLine()) != null) {
				clientes.add(new Cliente(linha));
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Erro arquivo CSV não encontrado = "+e);
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo CSV = "+e);
		}
		return clientes;
	}
	
	public void salvar(ArrayList<Cliente> clientes){
		try {
			bw = new BufferedWriter(new FileWriter(patch,false));
			for(Cliente cli: clientes) {
				bw.write(cli.toCSV());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Erro ao salvar dados no arquivo CSV = "+e);
		}
		//OBS: Tratamento de Erros (Throws ou try Catch)
		//Trows = ignora o erro
		//trye = ignora o erro  e retorna qual foi o erro
	}

}
