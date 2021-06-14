package clientEx2;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainForm extends JFrame{

	private static final long serialVersionUID = 1L;
	private ImageIcon img;
	private JPanel panel;
	private JTextField nome, sobrenome;
	
	public MainForm(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Tela Principal");
		img = new ImageIcon("./assets/bird.png");
		setIconImage(img.getImage());
		setBounds(100,100,640,480);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);
		
		nome = new JTextField();
		nome.setBounds(50,30,200,30);
		panel.add(nome);
		
		sobrenome = new JTextField();
		sobrenome.setBounds(50,80,200,30);
		panel.add(sobrenome);
		
	}

}
