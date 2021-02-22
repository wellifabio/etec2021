import java.util.Scanner;

//Exemplo de POO "Classe, Atributo e Método
class Divisao {
    
	//Atributo scan da classe Scanner para ler a partir do teclado
  private static Scanner scan = new Scanner(System.in);
  
  //Método que fáz a divisão e retorna uma frase
  public static String divisao(int a, int b){
      if(b != 0){
        float result = (float) a / b;
        return "O resultado de a / b = "+result;
      } else {
        return "Não podemos dividir por \"0\"";
      }
  }
  
  //Método principal executável
  public static void main(String args[]) {
    System.out.println("Digite A:");
    int a = scan.nextInt();
    System.out.println("Digite B:");
    int b = scan.nextInt();
    System.out.println(divisao(a,b));
  }
}