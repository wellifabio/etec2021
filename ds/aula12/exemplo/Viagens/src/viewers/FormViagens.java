package viewers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.ProcessaViagens;
import models.Viagem;

public class FormViagens extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel cabecalho;
	private JTextField id, orig, dest, dist, vel;
	private JButton adicionar, sair;
	private JTextArea saida;

	FormViagens() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Registra Viagens");
		setSize(640, 480);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);

		cabecalho = new JLabel(
				"Id               Origem                                      Destino                                     Distância                  Velociadade");
		cabecalho.setBounds(20, 25, 600, 25);
		panel.add(cabecalho);

		// Campos de Entrada
		id = new JTextField();
		id.setBounds(20, 50, 50, 25);
		orig = new JTextField();
		orig.setBounds(75, 50, 150, 25);
		dest = new JTextField();
		dest.setBounds(230, 50, 150, 25);
		dist = new JTextField();
		dist.setBounds(385, 50, 100, 25);
		vel = new JTextField();
		vel.setBounds(490, 50, 100, 25);

		// Botões e Campos de Saída
		adicionar = new JButton("Adicionar");
		adicionar.setBounds(385, 80, 100, 25);
		sair = new JButton("Sair");
		sair.setBounds(495, 80, 100, 25);
		saida = new JTextArea(getDados());
		saida.setBounds(20, 115, 580, 310);
		saida.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		// Objetos adiconados ao painel
		panel.add(id);
		panel.add(orig);
		panel.add(dest);
		panel.add(dist);
		panel.add(vel);
		panel.add(adicionar);
		panel.add(sair);
		panel.add(saida);

		adicionar.addActionListener(this);
		sair.addActionListener(this);
	}

	private String getDados() {
		String dados = "Id\tOrigem\tDestino\tDistância\tVelocidade\tTempo\n\n";
		for (Viagem v : ProcessaViagens.viagens) {
			dados += v.toString();
		}
		dados += "\nTotal de tempos: " + String.format("%.2f horas", ProcessaViagens.getTotalTempos());
		return dados;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == adicionar) {
			Viagem viagem = new Viagem();
			int cId = 0, cDist = 0, cVel = 0;
			try {
				cId = Integer.valueOf(id.getText());
				cDist = Integer.valueOf(dist.getText());
				cVel = Integer.valueOf(vel.getText());
				viagem.setId(cId);
				viagem.setOrigem(orig.getText());
				viagem.setDestino(dest.getText());
				viagem.setDistancia(cDist);
				viagem.setVelocidade(cVel);
				ProcessaViagens.viagens.add(viagem);
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(this, erro);
			}

			saida.setText(getDados());
		} else if (e.getSource() == sair) {
			this.dispose();
		}

	}

	public static void main(String[] args) {

		ProcessaViagens.viagens.add(new Viagem(1, "Jaguariúna", "Osasco", 150, 110));
		ProcessaViagens.viagens.add(new Viagem(2, "Jaguariúna", "São Paulo", 130, 120));
		ProcessaViagens.viagens.add(new Viagem(3, "Jaguariúna", "Serra Negra", 80, 80));
		ProcessaViagens.viagens.add(new Viagem(4, "Jaguariúna", "Pedreira", 25, 90));
		ProcessaViagens.viagens.add(new Viagem(5, "Jaguariúna", "Campinas", 30, 100));
		ProcessaViagens.viagens.add(new Viagem(6, "Campinas", "Maceió", 2500, 600));
		ProcessaViagens.viagens.add(new Viagem(7, "Campinas", "Porto Seguro", 1500, 600));

		new FormViagens().setVisible(true);
	}

}
