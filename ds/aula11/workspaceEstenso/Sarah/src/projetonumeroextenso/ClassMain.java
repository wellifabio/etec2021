// Desenvolver um programa utilizando "POO Classes" para escrever um número inteiro entre 0 e 100 por extenso, em português ou inglês.
// OBS.: Durante a programação deste código tive difilcudade em utilizar os pacotes no padrão MVC, este sendo o motivo da falta deles.

package projetonumeroextenso;

import java.util.Scanner;

public class ClassMain {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int num;		// declaração da variável num para capturar o número digitado;
        String Unidade[];	// declaração do vetor unidade;
        String dezena[];	// declaração do vetor dezena;
        String centena;		// declaração do vetor centena;
        String conv;           // declaração da variável de conversão;
        int voltar;            // declaração da variável que realizará o while;

        Unidade = new String[20];	// atribui a string Unidade 20 posições;
        dezena = new String[10];     // atribui a string dezena 10 posições;
        centena = "Cem";              // atribui a string centena o valor "cem";
        
        // Cada posição do vetor Unidade recebe um nome de acordo com o número;	
        Unidade[0] = "Zero";
        Unidade[1] = "Um";
        Unidade[2] = "Dois";
        Unidade[3] = "Três";
        Unidade[4] = "Quatro";
        Unidade[5] = "Cinco";
        Unidade[6] = "Seis";
        Unidade[7] = "Sete";
        Unidade[8] = "Oito";
        Unidade[9] = "Nove";
        Unidade[10] = "Dez";
        Unidade[11] = "Onze";
        Unidade[12] = "Doze";
        Unidade[13] = "Treze";
        Unidade[14] = "Quatorze";
        Unidade[15] = "Quinze";
        Unidade[16] = "Dezesseis";
        Unidade[17] = "Dezessete";
        Unidade[18] = "Dezoito";
        Unidade[19] = "Dezenove";
 	
        // Cada posição do vetor dezena recebe um nome de acordo com o número;
        dezena[2] = "Vinte";
        dezena[3] = "Trinta";
        dezena[4] = "Quarenta";
        dezena[5] = "Cinquenta";
        dezena[6] = "Sessenta";
        dezena[7] = "Setenta";
        dezena[8] = "Oitenta";
        dezena[9] = "Noventa";
	
        System.out.println("Digite 1 para digitar ou 0 para sair!");
        voltar = read.nextInt();
        read.nextLine();
        
        // While criado para que usuário possa introduzir repetitivamente números sem precisar sair do programa;
        while (voltar != 0) {

            System.out.println("Digite um número entre 0 e 100: ");
            conv = read.nextLine();         // atribui o que o usuário digitar a string conv;
            num = Integer.parseInt(conv);   // converte a variável;

            if (num == 100) { // verifica se o número digitado é igual a 100;
                System.out.println("O número digitado foi: \n" +centena);
            }  // se for igual exibe a string centena(cem);

            if (num > 100) { // verifica se o número é maior que 100;
                System.out.println("Erro: O número digitado não é válido pois é maior que 100.");
            } // se for, exibe a mensagem de erro;

            if (num <= 19) { // verifica se o número é menor ou igual a 19;
                System.out.println("O número digitado foi: \n " +Unidade[num]);
            } // se for, exibe o vetor U na posição do número digitado;
            if (num > 19 && num < 100) { // verifica se o número é maior que 19 e menor que 100;
                int dez = Integer.parseInt(conv.substring(0, 1)); // se for, é dividido em substrings 
                int uni = Integer.parseInt(conv.substring(1, 2)); // o primeiro número recebe o nome de dez e o segundo uni
                
                    if (uni == 0) { // verifica se o segundo número é igual a zero;
                    System.out.println("O número digitado foi:\n " + dezena[dez]);// se for, apenas exibe a posição do vetor da substring dez;
                    } 
                    else { // se não, recebe a posição das substrings dez e uni;
                    System.out.println("O número digitado foi:\n " + dezena[dez] + " e " + Unidade[uni]);
                    }
            }
            System.out.println("Digite 1 para continuar digitando ou 0 para sair!"); // permite que usuário continue digitando números;
            voltar = read.nextInt();
            read.nextLine();
        }
    }
}