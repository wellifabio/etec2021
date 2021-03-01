package classes;

class Pessoa{
	
	int id;
	String primeiroNome;
	String sobrenome;
	float peso;
	float altura;
	
	public String calcularIMC(){
		
		float imc = (float) this.peso / (this.altura * this.altura);
		String retorno = "";
		
		if(imc < (float)18.5){
			retorno = String.format("Seu IMC é %.2f você está abaixo do peso",imc);
		}else if(imc < (float) 25){
			retorno = String.format("Seu IMC é %.2f seu peso está Nomal",imc);
		}else if(imc < (float) 30){
			retorno = String.format("Seu IMC é %.2f você está com Sobrepeso",imc);
		}else if(imc < (float) 35){
			retorno = String.format("Seu IMC é %.2f você está com Obesidade Grau I",imc);
		}else if(imc < (float) 40){
			retorno = String.format("Seu IMC é %.2f você está com Obesidade Grau II",imc);
		}else{
			retorno = String.format("Seu IMC é %.2f você está com Obesidade Grau III ou Mórbida",imc);
		}
		
		return retorno;
	}
}