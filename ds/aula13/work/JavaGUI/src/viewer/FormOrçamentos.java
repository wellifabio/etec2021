package viewer;

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

import controller.ProcessaOr�amentos;
import models.Or�amento;

public class FormOr�amentos extends JFrame implements ActionListener  {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel cabecalho;
	private JTextField id, data, forn, prod, preco;
	private JButton adicionar, sair;
	private JTextArea saida;

	FormOr�amentos() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Registra Viagens");
		setSize(640, 480);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);

		cabecalho = new JLabel(
				"Id               Data                                      Fornecedor                                     Produto                  Pre�o");
		cabecalho.setBounds(20, 25, 600, 25);
		panel.add(cabecalho);

		id = new JTextField();
		id.setBounds(20, 50, 50, 25);
		data = new JTextField();
		data.setBounds(75, 50, 150, 25);
		forn = new JTextField();
		forn.setBounds(230, 50, 150, 25);
		prod = new JTextField();
		prod.setBounds(385, 50, 100, 25);
		preco = new JTextField();
		preco.setBounds(490, 50, 100, 25);

		adicionar = new JButton("Adicionar");
		adicionar.setBounds(385, 80, 100, 25);
		sair = new JButton("Sair");
		sair.setBounds(495, 80, 100, 25);
		saida = new JTextArea(getDados());
		saida.setBounds(20, 115, 580, 310);
		saida.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		panel.add(id);
		panel.add(data);
		panel.add(forn);
		panel.add(prod);
		panel.add(preco);
		panel.add(adicionar);
		panel.add(sair);
		panel.add(saida);

		adicionar.addActionListener(this);
		sair.addActionListener(this);
	}

	private String getDados() {
		String dados = "Id\tData\tFornecedor\tProduto\tPre�o\n\n";
		for (Or�amento o : ProcessaOr�amentos.orcamentos) {
			dados += o.toString();
		}
		dados += "\nMais Barato: " + "R$" + ProcessaOr�amentos.getMaisBarato();
		return dados;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == adicionar) {
			Or�amento orcamento = new Or�amento();
			int cId = 0 , cPreco = 0;
			try {
				cId = Integer.valueOf(id.getText());
				cPreco = Integer.valueOf(preco.getText());
				orcamento.setId(cId);
				orcamento.setData(data.getText());
				orcamento.setFornecedor(forn.getText());
				orcamento.setPreco(cPreco);
				orcamento.setProduto(prod.getText());
				ProcessaOr�amentos.orcamentos.add(orcamento);
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(this, erro);
			}

			saida.setText(getDados());
		} else if (e.getSource() == sair) {
			this.dispose();
		}

	}

	public static void main(String[] args) {

		ProcessaOr�amentos.orcamentos.add(new Or�amento(1, "Maio", "Samsung", "S21", 4000));
		ProcessaOr�amentos.orcamentos.add(new Or�amento(2, "Janeiro", "Apple", "Iphone XR", 5000));
		ProcessaOr�amentos.orcamentos.add(new Or�amento(3, "Junho", "Xiomi", "MI 9", 4000));

		new FormOr�amentos().setVisible(true);
	}

}
