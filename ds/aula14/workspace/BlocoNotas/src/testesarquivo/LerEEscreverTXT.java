package testesarquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LerEEscreverTXT {

	BufferedReader br; // Classe que separa um espa�o na mem�ria para leitura
	BufferedWriter bw; // Classe que separa um espa�o na mem�ria para grava��o
	String arquivo = "./bd/arquivo.txt"; // Caminho dentro projeto ./ onde ser� salvo o arquivo
	int totLinhas = 0;
	
	
	//Salva os dados em um arquivo conforme o caminho especificado no atributo arquivo
	void salvar(String conteudo) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo, false)); // Abre para grava��o
			bw.write(conteudo); // Imprime o conte�do no arquivo
			bw.close(); // Fecha o arquivo
		} catch (IOException e) { // Caso haja erro ao salvar ex: disco cheio
			JOptionPane.showMessageDialog(null, "Erro ao salvar aquivo:" + e);
		}
	}
	//Abre e l� os dados do arquivo no caminho especificado no atributo arquivo
	String abrir() {
		String retorno = "";
		try {
			br = new BufferedReader(new FileReader(arquivo));// Abre arquivo para leitura
			String linha = "";// Linha em branco para leitura por etapas
			totLinhas = 0;
			while ((linha = br.readLine()) != null) {//Enquanto linha diferente de nulo
				retorno += linha + "\n";
				totLinhas ++;
			}
			br.close();// Fecha o arquivo
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo n�o encontrado:" + e);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao abrir aquivo:" + e);
		}
		return retorno;
	}
	
	//Salva os dados em um arquivo conforme no endere�o recebido no atributo patch
	void salvar(String conteudo, String patch) {
		try {
			bw = new BufferedWriter(new FileWriter(patch, false)); // Abre para grava��o
			bw.write(conteudo); // Imprime o conte�do no arquivo
			bw.close(); // Fecha o arquivo
		} catch (IOException e) { // Caso haja erro ao salvar ex: disco cheio
			JOptionPane.showMessageDialog(null, "Erro ao salvar aquivo:" + e);
		}
	}
	
	//Abre os dados em um arquivo conforme no endere�o recebido no atributo patch
	String abrir(String patch) {
		String retorno = "";
		try {
			br = new BufferedReader(new FileReader(patch));// Abre arquivo para leitura
			String linha = "";// Linha em branco para leitura por etapas
			totLinhas = 0;
			while ((linha = br.readLine()) != null) {//Enquanto linha diferente de nulo
				retorno += linha + "\n";
				totLinhas ++;
			}
			br.close();// Fecha o arquivo
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo n�o encontrado:" + e);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao abrir aquivo:" + e);
		}
		return retorno;
	}

	/*
	 * O par�metro boolean(true ou false) em FileWriter representa o Append Append
	 * se estiver false o arquivo ser� sobrescrito Append se estiver true os dados
	 * ser�o adicionados ao arquivo
	 */
}