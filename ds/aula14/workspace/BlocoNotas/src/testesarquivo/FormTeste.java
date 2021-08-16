package testesarquivo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormTeste extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static LerEEscreverTXT le;
	private JPanel painel;
	private JButton btLer, btSalvar;
	private JTextArea areaTexto;
	private JTextField infos; //Campo para informações do aquivo
	private JScrollPane rolagem; //Barra de rolagem
	private JFileChooser patch; //Abre janelas para Abrir e Salvar arquivos
	private File file; //Objeto que armazena caminho do arquivo e outras informações

	FormTeste() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Teste \"GUI\"");
		setSize(640, 480);
		painel = new JPanel();
		setContentPane(painel);
		setLocationRelativeTo(null);
		setLayout(null);

		btLer = new JButton("Carregar arquivo");
		btLer.setBounds(10, 10, 150, 30);
		painel.add(btLer);

		btSalvar = new JButton("Salva dados em um arquivo");
		btSalvar.setBounds(170, 10, 200, 30);
		painel.add(btSalvar);

		infos = new JTextField();
		infos.setEnabled(false);
		infos.setBounds(494, 400, 120, 30);
		painel.add(infos);

		areaTexto = new JTextArea("");
		rolagem = new JScrollPane(areaTexto);
		rolagem.setBounds(10, 50, 604, 340);
		painel.add(rolagem);

		btLer.addActionListener(this);
		btSalvar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btLer) {
			patch = new JFileChooser(); //Cria uma nova instância
			if (patch.showOpenDialog(this) == 0) { //Abre a janela e se retornar 0 é porque foi escolhido um arquivo
				file = patch.getSelectedFile(); //Atribui os dados do arquivo aberto para o objeto file
				areaTexto.setText(le.abrir(file.getAbsolutePath()));
				infos.setText("linhas:" + le.totLinhas);
			}
		}
		if (e.getSource() == btSalvar) { //Abre a janela e se retornar 0 é porque foi escolhido um arquivo
			patch = new JFileChooser();
			if (patch.showSaveDialog(this) == 0) {
				file = patch.getSelectedFile();
				le.salvar(areaTexto.getText(),file.getAbsolutePath());
			}
		}
	}

	public static void main(String[] args) {
		le = new LerEEscreverTXT();
		new FormTeste().setVisible(true);
	}

}
