package testesarquivo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FormTeste extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private static LerEEscreverTXT le;
	private JPanel painel;
	private JButton btLer, btSalvar;
	private JTextArea areaTexto;

	FormTeste(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Teste \"GUI\"");
		setSize(800, 600);
		painel = new JPanel();
		setContentPane(painel);
		setLocationRelativeTo(null);
		setLayout(null);
		
		btLer =  new JButton("Carregar arquivo");
		btLer.setBounds(10,10,150,30);
		painel.add(btLer);
		
		btSalvar =  new JButton("Salva dados em um arquivo");
		btSalvar.setBounds(170,10,200,30);
		painel.add(btSalvar);
		
		areaTexto = new JTextArea("");
		areaTexto.setBounds(10,50,600,400);
		painel.add(areaTexto);
		
		btLer.addActionListener(this);
		btSalvar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btLer) {
			areaTexto.setText(le.abrir());
		}
		if(e.getSource() == btSalvar) {
			le.salvar(areaTexto.getText());
		}
	}
	
	public static void main(String[] args) {	
		le = new LerEEscreverTXT();
		new FormTeste().setVisible(true);
	}

}
