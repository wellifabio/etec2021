// Desenvolver um programa utilizando "POO Classes" para escrever um n�mero inteiro entre 0 e 100 por extenso, em portugu�s ou ingl�s.
// OBS.: Durante a programa��o deste c�digo tive difilcudade em utilizar os pacotes no padr�o MVC, este sendo o motivo da falta deles.

package projetonumeroextenso;

import java.util.Scanner;

public class ClassMain {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int num;		// declara��o da vari�vel num para capturar o n�mero digitado;
        String Unidade[];	// declara��o do vetor unidade;
        String dezena[];	// declara��o do vetor dezena;
        String centena;		// declara��o do vetor centena;
        String conv;           // declara��o da vari�vel de convers�o;
        int voltar;            // declara��o da vari�vel que realizar� o while;

        Unidade = new String[20];	// atribui a string Unidade 20 posi��es;
        dezena = new String[10];     // atribui a string dezena 10 posi��es;
        centena = "Cem";              // atribui a string centena o valor "cem";
        
        // Cada posi��o do vetor Unidade recebe um nome de acordo com o n�mero;	
        Unidade[0] = "Zero";
        Unidade[1] = "Um";
        Unidade[2] = "Dois";
        Unidade[3] = "Tr�s";
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
 	
        // Cada posi��o do vetor dezena recebe um nome de acordo com o n�mero;
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
        
        // While criado para que usu�rio possa introduzir repetitivamente n�meros sem precisar sair do programa;
        while (voltar != 0) {

            System.out.println("Digite um n�mero entre 0 e 100: ");
            conv = read.nextLine();         // atribui o que o usu�rio digitar a string conv;
            num = Integer.parseInt(conv);   // converte a vari�vel;

            if (num == 100) { // verifica se o n�mero digitado � igual a 100;
                System.out.println("O n�mero digitado foi: \n" +centena);
            }  // se for igual exibe a string centena(cem);

            if (num > 100) { // verifica se o n�mero � maior que 100;
                System.out.println("Erro: O n�mero digitado n�o � v�lido pois � maior que 100.");
            } // se for, exibe a mensagem de erro;

            if (num <= 19) { // verifica se o n�mero � menor ou igual a 19;
                System.out.println("O n�mero digitado foi: \n " +Unidade[num]);
            } // se for, exibe o vetor U na posi��o do n�mero digitado;
            if (num > 19 && num < 100) { // verifica se o n�mero � maior que 19 e menor que 100;
                int dez = Integer.parseInt(conv.substring(0, 1)); // se for, � dividido em substrings 
                int uni = Integer.parseInt(conv.substring(1, 2)); // o primeiro n�mero recebe o nome de dez e o segundo uni
                
                    if (uni == 0) { // verifica se o segundo n�mero � igual a zero;
                    System.out.println("O n�mero digitado foi:\n " + dezena[dez]);// se for, apenas exibe a posi��o do vetor da substring dez;
                    } 
                    else { // se n�o, recebe a posi��o das substrings dez e uni;
                    System.out.println("O n�mero digitado foi:\n " + dezena[dez] + " e " + Unidade[uni]);
                    }
            }
            System.out.println("Digite 1 para continuar digitando ou 0 para sair!"); // permite que usu�rio continue digitando n�meros;
            voltar = read.nextInt();
            read.nextLine();
        }
    }
}