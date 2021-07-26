package viewers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.ProcessaOrcamentos;
import models.Orcamento;

public class FormOrcamentos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel p;
	private JLabel txtId, txtData, txtForn, txtProd, txtPreco;
	private JTextField id, data, fornecedor, produto, preco;
	private JButton btnAdd, btnSair;
	private JTextArea saida;

	FormOrcamentos() {
		setTitle("Registro de Orçamentos");
		setSize(600, 700);
		p = new JPanel();
		setContentPane(p);
		setLayout(null);

		txtId = new JLabel("Id: ");
		txtId.setBounds(40, 30, 200, 30);
		txtData = new JLabel("Data: ");
		txtData.setBounds(160, 30, 100, 30);
		txtForn = new JLabel("Fornecedor: ");
		txtForn.setBounds(310, 30, 100, 30);
		txtProd = new JLabel("Produto: ");
		txtProd.setBounds(40, 85, 200, 30);
		txtPreco = new JLabel("Preço: ");
		txtPreco.setBounds(265, 85, 100, 30);

		id = new JTextField();
		id.setBounds(60, 32, 80, 25);
		data = new JTextField();
		data.setBounds(195, 32, 100, 25);
		fornecedor = new JTextField();
		fornecedor.setBounds(385, 32, 150, 25);
		produto = new JTextField();
		produto.setBounds(95, 87, 150, 25);
		preco = new JTextField();
		preco.setBounds(310, 87, 150, 25);

		btnAdd = new JButton("Adicionar");
		btnAdd.setBounds(100, 140, 150, 30);
		btnAdd.addActionListener(this);
		btnSair = new JButton("Sair");
		btnSair.setBounds(300, 140, 150, 30);
		btnSair.addActionListener(this);

		saida = new JTextArea(getDados());
		saida.setBounds(40, 195, 500, 300);

		// utilizando vetor para adicionar componentes
		JLabel[] vet = { txtId, txtData, txtForn, txtProd, txtPreco };
		JTextField[] vet2 = { id, data, fornecedor, produto, preco };

		for (JLabel l : vet) {
			p.add(l);
		}

		for (JTextField f : vet2) {
			p.add(f);
		}

		p.add(saida);
		p.add(btnAdd);
		p.add(btnSair);
	}

	public String getDados() {
		String retorno = "Id\tData\tFornecedor\tProduto\tPreço\n\n";
		for (Orcamento o : ProcessaOrcamentos.orcamentos) {
			retorno += o.toString();
		}
		retorno += "\nInformações do menor orçamento: \n\n" + ProcessaOrcamentos.getMaisBarato();
		return retorno;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			Boolean confirm = true;
			// Confirmando se o ID digitado já não existe
			for (Orcamento o : ProcessaOrcamentos.orcamentos) {
				if (o.getId() == Integer.valueOf(id.getText())) {
					confirm = false;
				}
			}

			// Caso o id ainda não exista, os dados digitados serão computados
			if (confirm) {
				Orcamento o = new Orcamento();
				o.setId(Integer.valueOf(id.getText()));
				o.setData(data.getText());
				o.setFornecedor(fornecedor.getText());
				o.setProduto(produto.getText());
				o.setPreco(Integer.valueOf(preco.getText()));
				ProcessaOrcamentos.orcamentos.add(o);
				saida.setText(getDados());
				// Caso o id já exista, os valores não serão computados e uma mensagem de erro
				// será mostrada
			} else {
				saida.setText(getDados() + "\nERRO! Número de ID já existente!");
			}

		}

		if (e.getSource() == btnSair) {
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		ProcessaOrcamentos.orcamentos.add(new Orcamento(1, "25/03/2021", "Empresa 1", "Casa", 500));
		ProcessaOrcamentos.orcamentos.add(new Orcamento(2, "12/04/2021", "Empresa 2", "Casa", 600));
		ProcessaOrcamentos.orcamentos.add(new Orcamento(3, "21/05/2021", "Empresa 3", "Casa", 450));

		new FormOrcamentos().setVisible(true);
	}

}