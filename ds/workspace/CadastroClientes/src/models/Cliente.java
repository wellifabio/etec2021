package models;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import models.utils.CPF;
import models.utils.Nome;
import models.utils.Telefone;

/*
 * Este projeto será um CRUD exemplo com arquivo texto
 * (Banco de dados local) formatado como CSV
 * Posteriormente será conectado a um SGBD (MySQL) 
 *
 * */

public class Cliente {

	// Atrinutos simples
	private String cpf;
	private String nome;
	private ArrayList<String> telefones = new ArrayList<>(); // Vetor ou lista

	// Construtores
	public Cliente() {
		String[] nomes = { "João", "Maria", "Ana", "José" };
		String[] sobrenomes = { "Silva", "da Silva", "Souza", "de Souza", "Mello" };
		this.cpf = new CPF().getFormat();
		this.nome = new Nome(nomes, sobrenomes).getAleatorio();
		for (int i = 0; i < new Random().nextInt(3); i++)
			this.telefones.add(new Telefone().getFormat());
	}

	public Cliente(String linhaDoArquivo) {
		String[] vetor = linhaDoArquivo.split(";"); 
		this.cpf = vetor[0];
		this.nome = vetor[1];
		if(vetor.length > 2) {
			String[] tels = vetor[2].split(",");
			if(tels.length > 1)
				for(String t: tels)
					telefones.add(t);
		}
	}

	public Cliente(String cpf, String nome, ArrayList<String> telefones) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefones = telefones;
	}

	// Getters && Setters
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(ArrayList<String> telefones) {
		this.telefones = telefones;
	}

	//Chave	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}

	//Metodos para manipular String
	@Override
	public String toString() {
		String tels = "";
		for (String t : this.telefones)
			tels += t + ",";
		if(tels.length()>1)//Remove a ultima virgula
			tels = tels.substring(0, tels.length()-1);
		return cpf + "\t" + nome + "\t" + tels + "\n";
	}
	
	public String toCSV() {
		String tels = "";
		for (String t : this.telefones)
			tels += t + ",";
		if(tels.length()>1)//Remove a ultima virgula
			tels = tels.substring(0, tels.length()-1);
		return cpf + ";" + nome + ";" + tels + "\r\n";
	}

}
