package clientEx1;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * GUI (Graphics User Interface)
 * Programa��o Desktop
 * Linguagens comuns para este tipo de programa Delph, C#, VB, Java....
 * 
 * */

public class MainClass {

	public static void main(String[] args) {
		
		//Entrada
		JFrame tela = new JFrame();
		tela.setTitle("Tela B�sica");
		ImageIcon img = new ImageIcon("./assets/bird.png");
		tela.setIconImage(img.getImage());
		tela.setBounds(100,100,600,300);
		tela.setVisible(true);
		String entrada1 = JOptionPane.showInputDialog(tela,"Digite seu nome:");
		String entrada2 = JOptionPane.showInputDialog(tela,"Digite seu sobrenome:");
		//Processamento
		String saida = entrada1 + " " + entrada2;
		//Sa�da
		JOptionPane.showMessageDialog(tela, saida);
		tela.dispose();
	}

}
